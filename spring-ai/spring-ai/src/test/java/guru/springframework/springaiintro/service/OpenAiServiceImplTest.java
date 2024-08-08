package guru.springframework.springaiintro.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAiServiceImplTest {

    @Autowired
    OpenAIService openAIService;

    @Test
    void getAnswer() {
        String answer = openAIService.getAnswer("코로나 시절에 경제적으로 무엇을 사면 좋을지 질문을 만들어줘 형식은 1. 질문, 2. 선택지 3. 답 4. 설명");
        System.out.println("Got the answer");
        System.out.println(answer);
    }

}
