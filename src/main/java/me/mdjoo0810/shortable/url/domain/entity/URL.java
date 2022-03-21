package me.mdjoo0810.shortable.url.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.mdjoo0810.shortable.member.domain.entity.Member;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@NoArgsConstructor
public class URL {

    @Id
    @Column(length = 64)
    private String hash;

    private String originalURL;

    private int redirectCount;

    private ZonedDateTime createdAt;
    private ZonedDateTime expirationAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    public URL(String hash, String originalURL, Member member, ZonedDateTime expirationAt) {
        this.hash = hash;
        this.originalURL = originalURL;
        this.member = member;
        this.createdAt = ZonedDateTime.now();
        this.expirationAt = expirationAt;
    }

    public void redirect() {
        this.redirectCount++;
    };
}
