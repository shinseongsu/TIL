package com.example.fastcampusmysql.domain.member;

import com.example.fastcampusmysql.domain.util.MemberFixtureFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberTest {

    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChangeName() {
        var member = MemberFixtureFactory.create();
        var toChangeName = "pnu";

        member.changeNickname(toChangeName);

        assertEquals(toChangeName, member.getNickname());
    }

    @DisplayName("회원은 닉네임은 10자를 초과할 수 없다.")
    @Test
    public void testNicknameMaxLength() {
        var member = MemberFixtureFactory.create();
        var overMaxLengthName = "pnununununu";

        assertThrows(IllegalArgumentException.class,
                () -> member.changeNickname(overMaxLengthName));
    }

}
