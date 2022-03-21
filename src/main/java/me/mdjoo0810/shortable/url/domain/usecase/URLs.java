package me.mdjoo0810.shortable.url.domain.usecase;

import me.mdjoo0810.shortable.member.domain.entity.Member;
import me.mdjoo0810.shortable.url.domain.entity.URLInfo;

public interface URLs {

    URLInfo makeShorten(String email, String originalUrl);

    URLInfo getURLInfo(String code);

}
