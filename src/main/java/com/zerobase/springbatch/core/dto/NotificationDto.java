package com.zerobase.springbatch.core.dto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.util.Pair;

@Builder
@Getter
public class NotificationDto {
    private String email;
    private String guName;
    private Integer count;
    private List<AptDto> aptDeals;

    public String toMessage() {
        DecimalFormat decimalFormat = new DecimalFormat();
        return String.format("%s 아파트 실거래가 알림\n" +
            "총 %d개 거래가 발생했습니다.\n", guName, count)
            +
            aptDeals.stream()
                .map(deal -> String.format("- %s : %s원\n", deal.getName(), decimalFormat.format(deal.getPrice())))
                .collect(Collectors.joining());
    }
}
