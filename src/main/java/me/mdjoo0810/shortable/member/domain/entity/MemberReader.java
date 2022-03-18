package me.mdjoo0810.shortable.member.domain.entity;

import java.util.Optional;

public interface MemberReader {

    Optional<Member> findByEmail(String email);

    boolean existByEmail(String email);

}
