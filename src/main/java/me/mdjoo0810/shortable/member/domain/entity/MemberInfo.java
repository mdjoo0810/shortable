package me.mdjoo0810.shortable.member.domain.entity;

import lombok.Getter;

@Getter
public class MemberInfo {

    private final String name;
    private final String email;

    public MemberInfo(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
    }
}
