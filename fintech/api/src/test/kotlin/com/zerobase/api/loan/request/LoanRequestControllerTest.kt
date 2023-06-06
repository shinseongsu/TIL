package com.zerobase.api.loan.request

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.zerobase.api.loan.GenerateKey
import com.zerobase.api.loan.encrypt.EncryptComponent
import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@WebMvcTest(LoanRequestController::class)
internal class LoanRequestControllerTest {

    private lateinit var mockMvc: MockMvc
    private lateinit var loanRequestController: LoanRequestController
    private lateinit var generateKey: GenerateKey
    private lateinit var encryptComponent: EncryptComponent

    private val userInfoRepository: UserInfoRepository = mockk()

    private lateinit var mapper: ObjectMapper

    @MockBean
    private lateinit var loanRequestServiceImpl: LoanRequestServiceImpl

    companion object {
        private const val baseUrl = "/fintech/api/v1"
    }

    @BeforeEach
    fun init() {
        generateKey = GenerateKey()
        encryptComponent = EncryptComponent()
        loanRequestServiceImpl = LoanRequestServiceImpl(generateKey, userInfoRepository, encryptComponent)
        loanRequestController = LoanRequestController(loanRequestServiceImpl)

        mockMvc = MockMvcBuilders.standaloneSetup(loanRequestController).build()

        mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
    }

    @Test
    @DisplayName("유저 요청이 들어오면 정상 응답을 주어야 한다.")
    fun testNormalCase() {
        // given
        val loanRequestInfoDto: LoanRequestDto.LoanRequestInfoDto =
            LoanRequestDto.LoanRequestInfoDto(
                userName = "TEST",
                userIncomeAmount = 10000,
                userRegistrationNumber = "000101-1234567"
            )

        every { userInfoRepository.save(any()) } returns UserInfo("", "", "", 1)

        // when
        // then

        mockMvc.post(
            "$baseUrl/request"
        ) {
            contentType = MediaType.APPLICATION_JSON
            accept= MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(loanRequestInfoDto)
        }.andExpect {
            status { isOk() }
        }

    }
}