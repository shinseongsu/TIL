package com.example.portfolio.support

import com.example.portfolio.domain.constant.SkillType
import com.example.portfolio.domain.entity.Achievement
import com.example.portfolio.domain.entity.Experience
import com.example.portfolio.domain.entity.ExperienceDetail
import com.example.portfolio.domain.entity.Introduction
import com.example.portfolio.domain.entity.Link
import com.example.portfolio.domain.entity.Project
import com.example.portfolio.domain.entity.ProjectDetail
import com.example.portfolio.domain.entity.ProjectSkill
import com.example.portfolio.domain.entity.Skill
import com.example.portfolio.domain.repository.AchievementRepository
import com.example.portfolio.domain.repository.ExperienceRepository
import com.example.portfolio.domain.repository.IntroductionRepository
import com.example.portfolio.domain.repository.LinkRepository
import com.example.portfolio.domain.repository.ProjectRepository
import com.example.portfolio.domain.repository.SkillRepository
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {

    @PostConstruct
    fun initializeData() {

        println("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "2022 Catkao 해커톤 최우수상",
                description = "고양이 쇼핑몰 검색 서비스의 아키텍처, 데이터 모델링",
                host = "캣카오",
                achievedDate = LocalDate.of(2022, 8, 1),
                isActive = true
            ),
            Achievement(
                title = "정보처리기사",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2020, 2, 1),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "주도적으로 문제를 찾고, 해결하는 고양이입니다.", isActive = true),
            Introduction(content = "기술을 위한 기술이 아닌, 비즈니스 문제를 풀기 위한 기술을 추구합니다.", isActive = true),
            Introduction(content = "기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/shinseongsu", isActive = true),
            Link(name = "Linkedin", content = "https://www.linkedin.com/in/shinseongsu", isActive = true)
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "캣홀릭대학교(CaHolic Univ.)",
            description = "컴퓨터공학 전공",
            startYear = 2018,
            startMonth = 9,
            endYear = 2022,
            endMonth = 8,
            isActive = true
        )

        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "HPA 4.3/4.5", isActive = true),
                ExperienceDetail(content = "소프트웨어 연구 학회 활동", isActive = true)
            )
        )

        val experience2 = Experience(
            title = "주식회사 캣카오(CaHolic Univ.)",
            description = "소셜서비스팀 백엔드 개발자",
            startYear = 2022,
            startMonth = 9,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "유기묘 위치 공유 서비스 개발", isActive = true),
                ExperienceDetail(content = "신입 교육 프로그램 우수상 수상", isActive = true)
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        val java = Skill(name = "java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "python", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.LANGUAGE.name, isActive = true)
        val django = Skill(name = "Django", type = SkillType.LANGUAGE.name, isActive = true)
        val mysql = Skill(name = "Mysql", type = SkillType.LANGUAGE.name, isActive = true)
        val redis = Skill(name = "redis", type = SkillType.LANGUAGE.name, isActive = true)
        val kafka = Skill(name = "Kafka", type = SkillType.LANGUAGE.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, python, spring, django, mysql, redis, kafka))

        val project1 = Project(
            name = "유기묘 발견 정보 공유 서비스",
            description = "유기묘 위치의 실시간 공유, 임시보호까지 연결해주는 서비스, 구글 맵스를 연동하여 유기묘 위치 정보를 표시",
            startYear = 2022,
            startMonth = 9,
            endYear  = 2022,
            endMonth = 12,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "구글 맵스를 활요한 유기묘 발견 지역 정보 제공 API 개발", url = null, isActive = true),
                ProjectDetail(content = "Redis 적용하여 인기 게시글의 조회 속도 1.5초 -> 0.5초로 개선", url = null, isActive = true),
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = redis),
            )
        )
        val project2 = Project(
            name = "반려동물 홈 카메라 움직임 감지 분석 모듈",
            description = "카메라에서 서버로 전달되는 신호를 분석하여 움직임이 감지될 경우 클라이언트에게 알림 발송 작업.",
            startYear = 2022,
            startMonth = 12,
            endYear  = null,
            endMonth = null,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "PIL(Pillow) 활용하여 이미지 분석 기능 개발", url = null, isActive = true),
                ProjectDetail(content = "알림 발송을 비동기 처리하여 이미지 분석 - 알림 발송 기능간 의존도 감소", url = null, isActive = true),
                ProjectDetail(content = "Github Repository", url = "https://github.com", isActive = true),
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = python),
                ProjectSkill(project = project2, skill = django),
                ProjectSkill(project = project2, skill = kafka)
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))

    }

}