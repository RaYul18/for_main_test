package com.codestates.member.entity;

import com.codestates.audit.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 25, nullable = false, updatable = false, unique = true)
    private String memberEmail;

    @Column(length = 16, nullable = false)
    private String memberName;

    @Column
    private String picture;

    @Column(length = 100, nullable = false)
    private String memberPwd;

    //    @Enumerated(EnumType.STRING)
//    private MemberGender memberGender = MemberGender.PRIVATE;
    @Column
    private String memberGender;

    @Column
    private String memberAge;

    @Enumerated(EnumType.STRING)
    private MemberState memberState = MemberState.ACTIVE;

    //diseaseId 와 medicineId 나중에 추가

    public Member update (String memberEmail, String memberName, String picture, String memberGender, String memberAge) {
        this.memberEmail = memberEmail;
        this.memberName = memberName;
        this.picture = picture;
        this.memberGender = memberGender;
        this.memberAge = memberAge;

        return this;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public enum MemberGender {
        FEMALE("여성"),
        MALE("남성"),
        PRIVATE("비밀")
        ;
        @Getter
        private String gender;

        MemberGender(String gender) {
            this.gender = gender;
        }
    }

    public enum MemberState {
        ACTIVE("활동중"),
        INACTIVE("휴면"),
        WITHDRAW("탈퇴")
        ;
        @Getter
        private String state;

        MemberState(String state) {
            this.state = state;
        }
    }

}