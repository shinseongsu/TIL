package guru.springframework.springaiintro.service;

import guru.springframework.springaiintro.service.dto.Question;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OpenAiServiceImpl implements OpenAIService {

    private final ChatClient chatClient;

    public OpenAiServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();;
    }

    @Override
    public String getAnswer(String question) {
        System.out.println(chatClient.prompt()
                .user(question)
                .call()
                .entity(Question.class));

        return chatClient.prompt()
                .user(question)
                .call()
                .content();
    }
}
