package kitchenpos.deliveryorders.infra;

import java.math.BigDecimal;
import java.util.UUID;

public interface KitcheneridersClient {
    void requestDelivery(UUID orderId, BigDecimal amount, String deliveryAddress);
}
