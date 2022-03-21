package me.mdjoo0810.shortable.url.domain.entity;

import java.util.Optional;

public interface URLReader {

    Optional<URL> getByCodeLike(String code);

}
