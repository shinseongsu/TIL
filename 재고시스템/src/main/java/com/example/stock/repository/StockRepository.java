package com.example.stock.repository;

import com.example.stock.domain.Stock;
import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)       //  장점 - 충돌이 자주 일어나면 옵티머스 보다 더 좋을 수 도 있다.
                                                        //      - 락을 통해 update를 작업해 일관성이 유지 됩니다.
                                                        // 단점 -  성능이 느려진다.
    @Query("select s from Stock s where s.id = :id")
    Stock findByIdWithPesseimisticLock(Long id);


    @Lock(value = LockModeType.OPTIMISTIC)              // 장점 - Perssimistic lock 보다는 빠르다
                                                        // 단점 - 실패하였을 경우 재시도하는 로직을 작성해야 한다.
    @Query("select s from Stock s where s.id = :id")
    Stock findByIdWithOptitimisticLock(Long id);

}
