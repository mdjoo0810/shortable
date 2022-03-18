package me.mdjoo0810.shortable.member.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "members")
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private ZonedDateTime createdAt;

    public Member() {

    }

    public static Member anonymous(String randomEmail) {
        return Member.builder()
                .name("GUEST")
                .email(randomEmail)
                .build();
    }

    @Builder
    public Member(String name, String email) {
        this.name = name;
        this.email = email;
        this.createdAt = ZonedDateTime.now();
    }

}
