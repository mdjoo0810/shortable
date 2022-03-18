package me.mdjoo0810.shortable.member.domain.usecase;

import me.mdjoo0810.shortable.common.CommonFixture;
import me.mdjoo0810.shortable.member.domain.entity.MemberFixture;
import me.mdjoo0810.shortable.member.domain.entity.MemberInfo;
import me.mdjoo0810.shortable.member.domain.entity.MemberStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MemberManagerTest {

    @Test
    void register_anonymous_valid() {
        MemberStore mockStore = mock(MemberStore.class);
        when(mockStore.store(any())).thenReturn(MemberFixture.get());
        MemberManager manager = new MemberManager(mockStore);

        ReflectionTestUtils.setField(manager, "DOMAIN_URL", CommonFixture.getDomainURL());

        String randomString = "anonymous";

        MemberInfo memberInfo = manager.registerAnonymous(randomString);
        assertEquals("GUEST", memberInfo.getName());
        assertEquals(randomString + "@" + CommonFixture.getDomainURL(), memberInfo.getEmail());
    }

}