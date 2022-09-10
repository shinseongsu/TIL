package com.zerobase.springbatch.core.service;

import com.zerobase.springbatch.core.entity.Lawd;
import com.zerobase.springbatch.core.repository.LawdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class LawdService {
    private final LawdRepository lawdRepository;

    @Transactional
    public void upsert(Lawd lawd) {
        Lawd saved = lawdRepository.findByLawdCd(lawd.getLawdCd())
            .orElseGet(Lawd::new);

        saved.setLawdCd(lawd.getLawdCd());
        saved.setLawdDong(lawd.getLawdDong());
        saved.setExist(lawd.getExist());
        lawdRepository.save(saved);
    }


}
