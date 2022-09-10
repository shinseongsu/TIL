package com.zerobase.springbatch.core.repository;

import com.zerobase.springbatch.core.entity.Apt;
import com.zerobase.springbatch.core.entity.AptDeal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

public interface AptDealRepository extends JpaRepository<AptDeal, Long> {

    Optional<AptDeal> findAptDealByAptAndExclusiveAreaAndDealDateAndDealAmountAndFloor(
        Apt apt, Double exclusiveArea, LocalDate dealDate, Long dealAmount, Integer floor);

    @Query("select ad from AptDeal ad join fetch ad.apt where ad.dealCanceled = 0 and ad.dealDate = ?1")
    List<AptDeal> findByDealCanceledIsFalseAndDealDateEquals(LocalDate dealDate);

}
