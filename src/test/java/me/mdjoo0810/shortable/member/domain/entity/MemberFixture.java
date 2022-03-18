package me.mdjoo0810.shortable.member.domain.entity;

import org.springframework.test.util.ReflectionTestUtils;

import java.time.ZonedDateTime;

public class MemberFixture {

    public static Member get() {
        Member member = new Member();
        ReflectionTestUtils.setField(member, "id", 1L);
        ReflectionTestUtils.setField(member, "name", "GUEST");
        ReflectionTestUtils.setField(member, "email", "anonymous@shortable.me");
        ReflectionTestUtils.setField(member, "createdAt", ZonedDateTime.now());
        return member;
    }

}
