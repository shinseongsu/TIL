package com.zerobase.api.test

import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class TestService(
    private val userInfoRepository: UserInfoRepository
) {

    fun testGetService(userKey: String) = userInfoRepository.findByUserKey(userKey).toDto()

    fun UserInfo.toDto() = TestDto.UserInfoDto(userKey, userRegistraionNumber, userName, userIncomeAmount)

}