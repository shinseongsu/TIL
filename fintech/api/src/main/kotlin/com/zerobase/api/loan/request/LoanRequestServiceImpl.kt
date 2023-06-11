package com.zerobase.api.loan.request

import com.zerobase.api.loan.GenerateKey
import com.zerobase.api.loan.encrypt.EncryptComponent
import com.zerobase.domain.repository.UserInfoRepository
import com.zerobase.kafka.enum.KafkaTopic
import com.zerobase.kafka.producer.LoanRequestSender
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent,
    private val loanRequestSender: LoanRequestSender
) : LoanRequestService {
    override fun loanRequestMain(loanRequestInputDto: LoanRequestDto.LoanRequestInfoDto): LoanRequestDto.LoanRequestResponseDto {
        val userKey = generateKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber =
            encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        val userInfoDto = loanRequestInputDto.toUserInfoDto(userKey)

        saveUserInfo(userInfoDto)
        loanRequestReview(userInfoDto)

        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
        userInfoRepository.save(userInfoDto.toEntity())

    override fun loanRequestReview(userInfoDto: UserInfoDto) {
        loanRequestSender.sendMessage(
            KafkaTopic.LOAN_REQUEST,
            userInfoDto.toLoanRequestKafkaDto()
        )
    }
}