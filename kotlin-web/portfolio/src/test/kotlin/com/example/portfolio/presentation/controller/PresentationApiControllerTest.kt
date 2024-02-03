package com.example.portfolio.presentation.controller

import org.assertj.core.api.Assertions.assertThat
import org.json.JSONArray
import org.json.JSONObject
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import java.nio.charset.StandardCharsets

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("[API 컨트롤러 테스트]")
class PresentationApiControllerTest(
    @Autowired private val mockMvc: MockMvc
) {

    @Test
    @DisplayName("Introductions 조회")
    fun testGetIntroductions() {
        val uri = "/api/v1/introductions"

        val mvcResult = performGet(uri)

        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
        val jsonArray = JSONArray(contentAsString)

        assertThat(jsonArray.length()).isPositive()
    }

    @Test
    @DisplayName("Links 조회")
    fun testGetLinks() {
        val uri = "/api/v1/links"

        val mvcResult = performGet(uri)

        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
        val jsonArray = JSONArray(contentAsString)

        assertThat(jsonArray.length()).isPositive()
    }

    @Test
    @DisplayName("Resume 조회")
    fun testGetResume() {
        val uri = "/api/v1/resume"

        val mvcResult = performGet(uri)

        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
        val jsonObject = JSONObject(contentAsString)

        assertThat(jsonObject.optJSONArray("experiences").length()).isPositive()
        assertThat(jsonObject.optJSONArray("achievements").length()).isPositive()
        assertThat(jsonObject.optJSONArray("skills").length()).isPositive()
    }

    @Test
    @DisplayName("Projects 조회")
    fun testGetProjects() {
        val uri = "/api/v1/projects"

        val mvcResult = performGet(uri)

        val contentAsString = mvcResult.response.getContentAsString(StandardCharsets.UTF_8)
        val jsonArray = JSONArray(contentAsString)

        assertThat(jsonArray.length()).isPositive()
    }

    private fun performGet(uri: String): MvcResult {
        return mockMvc
            .perform(MockMvcRequestBuilders.get(uri))
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
    }

}