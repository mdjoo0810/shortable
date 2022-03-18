package me.mdjoo0810.shortable.member.application;

import lombok.RequiredArgsConstructor;
import me.mdjoo0810.shortable.member.domain.entity.MemberInfo;
import me.mdjoo0810.shortable.member.domain.usecase.Members;
import me.mdjoo0810.shortable.utils.KeyManager;
import me.mdjoo0810.shortable.utils.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFacade {

    private final StringUtils stringUtils;
    private final Members members;

    public MemberInfo registerAnonymous() {
        String randomString = stringUtils.randomString(12);
        return members.registerAnonymous(randomString);
    }

}
