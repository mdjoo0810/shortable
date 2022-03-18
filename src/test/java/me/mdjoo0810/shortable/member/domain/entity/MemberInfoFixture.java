package me.mdjoo0810.shortable.member.domain.entity;

public class MemberInfoFixture {

    public static MemberInfo get() {
        return new MemberInfo(MemberFixture.get());
    }

}
