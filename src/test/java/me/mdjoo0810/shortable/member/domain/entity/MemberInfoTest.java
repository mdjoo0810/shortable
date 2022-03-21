package me.mdjoo0810.shortable.member.domain.entity;

import me.mdjoo0810.shortable.common.CommonFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberInfoTest {

    @Test
    void transfer_test() {
        Member anonymous = Member.anonymous("anonymous@" + CommonFixture.getDomainURL());
        MemberInfo memberInfo = new MemberInfo(anonymous);
        assertEquals("anonymous@shortable.link", memberInfo.getEmail());
        assertEquals("GUEST", memberInfo.getName());
    }

}