package com.zerobase.springbatch.core.repository;

import com.zerobase.springbatch.core.entity.AptNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AptNotificationRepository extends JpaRepository<AptNotification, Long> {

    Page<AptNotification> findByEnabledIsTrue(Pageable pageable);

}
