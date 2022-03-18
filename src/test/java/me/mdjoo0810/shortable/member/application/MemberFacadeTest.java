package me.mdjoo0810.shortable.member.application;

import me.mdjoo0810.shortable.member.domain.entity.MemberInfo;
import me.mdjoo0810.shortable.member.domain.entity.MemberInfoFixture;
import me.mdjoo0810.shortable.member.domain.usecase.Members;
import me.mdjoo0810.shortable.utils.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MemberFacadeTest {

    @Test
    void register() {
        StringUtils stringUtils = new StringUtils();
        Members mockMembers = mock(Members.class);
        when(mockMembers.registerAnonymous(any())).thenReturn(MemberInfoFixture.get());
        MemberFacade memberFacade = new MemberFacade(stringUtils, mockMembers);

        MemberInfo memberInfo = memberFacade.registerAnonymous();

        assertEquals("GUEST", memberInfo.getName());
    }

}