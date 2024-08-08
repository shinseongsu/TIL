package guru.springframework.springaiintro.service.dto;

import java.util.List;

public record Question(
        String 질문,
        List<String> 선택지,
        String 답,
        String 설명
){ }
