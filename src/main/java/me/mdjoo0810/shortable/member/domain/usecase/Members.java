package me.mdjoo0810.shortable.member.domain.usecase;

import me.mdjoo0810.shortable.member.domain.entity.MemberInfo;

public interface Members {

    MemberInfo registerAnonymous(String randomName);

}
