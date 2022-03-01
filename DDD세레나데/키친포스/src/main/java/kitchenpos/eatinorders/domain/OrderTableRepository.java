package kitchenpos.eatinorders.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderTableRepository {
    OrderTable save(OrderTable orderTable);

    Optional<OrderTable> finaById(UUID id);

    List<OrderTable> findAll();
}
