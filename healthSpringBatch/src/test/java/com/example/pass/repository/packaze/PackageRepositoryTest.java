package com.example.pass.repository.packaze;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class PackageRepositoryTest {

    @Autowired
    private PackageRepository packageRepository;

    @Test
    void test_save() {
        PackageEntity packageEntity = new PackageEntity();
        packageEntity.setPackageName("바디 챌리지 PT 12주");
        packageEntity.setPeriod(84);


    }

}