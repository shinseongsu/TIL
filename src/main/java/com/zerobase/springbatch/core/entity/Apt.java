package com.zerobase.springbatch.core.entity;

import com.zerobase.springbatch.core.dto.AptDealDto;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@Table(name = "apt")
@EntityListeners(AuditingEntityListener.class)
public class Apt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aptId;

    @Column(nullable = false)
    private String aptName;

    @Column(nullable = false)
    private String jibun;

    @Column(nullable = false)
    private String dong;

    @Column(nullable = false)
    private String guLawdCd;

    @Column(nullable = false)
    private Integer builtYear;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static Apt from(AptDealDto dto) {
        Apt apt = new Apt();
        apt.setAptName(dto.getAptName().trim());
        apt.setJibun(dto.getJibun().trim());
        apt.setDong(dto.getDong().trim());
        apt.setGuLawdCd(dto.getRegionalCode().trim());
        apt.setBuiltYear(dto.getBuiltYear());
        return apt;
    }

}
