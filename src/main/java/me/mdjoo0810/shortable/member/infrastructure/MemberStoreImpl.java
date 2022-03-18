package me.mdjoo0810.shortable.member.infrastructure;

import lombok.RequiredArgsConstructor;
import me.mdjoo0810.shortable.member.domain.entity.Member;
import me.mdjoo0810.shortable.member.domain.entity.MemberStore;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberStoreImpl implements MemberStore {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member store(Member initMember) {
        return memberJpaRepository.save(initMember);
    }
}
