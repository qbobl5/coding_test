package com.datee.datemaze.member.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long memberNo; // 회원 번호
    private String memberCode; // 회원 코드
    private String memberImg; // 프로필 이미지
    private String memberName; // 닉네임
    private Date memberBirth; // 생일
    private Integer memberMbti; // mbti
}
