package me.mdjoo0810.shortable.member.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mdjoo0810.shortable.member.domain.entity.Member;
import me.mdjoo0810.shortable.member.domain.entity.MemberInfo;
import me.mdjoo0810.shortable.member.domain.entity.MemberStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberManager implements Members{

    @Value("${domain-url}")
    private String DOMAIN_URL;

    private final MemberStore memberStore;

    @Override
    @Transactional
    public MemberInfo registerAnonymous(String randomName) {

        Member anonymous = Member.anonymous(randomName + "@" + DOMAIN_URL);
        Member store = memberStore.store(anonymous);
        log.info("NEW_GUEST_MEMBER : {}", store.getEmail());
        return new MemberInfo(store);
    }

}
