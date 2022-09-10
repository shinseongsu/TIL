package com.zerobase.springbatch.core.repository;

import com.zerobase.springbatch.core.entity.Apt;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AptRepository extends JpaRepository<Apt, Long> {

    Optional<Apt> findAptByAptNameAndJibun(String aptName, String jibun);
}
