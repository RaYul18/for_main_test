package com.codestates.member.dto;

import com.codestates.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberPatchDto {
    private long memberId;
    private String memberName;
    private String memberPwd;
    private String memberGender;
    private String memberAge;
    private Member.MemberState memberState;

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}
