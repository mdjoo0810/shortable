package me.mdjoo0810.shortable.member.domain.entity;

import me.mdjoo0810.shortable.utils.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void create_no_constructor() {
        Member member = new Member();
    }

    @Test
    void create_random_member() {
        StringUtils utils = new StringUtils();
        String randomString = utils.randomString(12);
        Member anonymous = Member.anonymous(randomString);
        assertNull(anonymous.getId());
        assertEquals(randomString, anonymous.getEmail().substring(0, 12));
        assertNotNull(anonymous.getName());
        assertNotNull(anonymous.getCreatedAt());
    }

}