package kitchenpos.deliveryorders.infra;

import java.math.BigDecimal;
import java.util.UUID;

public class DefaultKitcheneriderClient implements KitcheneridersClient {

    @Override
    public void requestDelivery(UUID orderId, BigDecimal amount, String deliveryAddress) {

    }
}
