package me.mdjoo0810.shortable.member.infrastructure;

import lombok.RequiredArgsConstructor;
import me.mdjoo0810.shortable.member.domain.entity.Member;
import me.mdjoo0810.shortable.member.domain.entity.MemberReader;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberReaderImpl implements MemberReader {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberJpaRepository.findByEmail(email);
    }

    @Override
    public boolean existByEmail(String email) {
        return memberJpaRepository.existsByEmail(email);
    }
}
