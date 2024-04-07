package com.datee.datemaze.member.entity;

import com.datee.datemaze.util.BaseEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
@DynamicInsert
@DynamicUpdate
/* 회원 Entity */
public class Member extends BaseEntity {
    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo; // 회원 번호

    @Column(name = "member_kakao")
    private String memberKakao; // 카카오 연동

    @Column(name = "member_mail")
    private String memberMail; // 이메일

    @Column(name = "member_pwd")
    @NotNull
    private String memberPwd; // 비밀번호

    @Column(name = "member_code")
    @NotNull
    private String memberCode; // 회원 코드

    @Column(name = "member_img")
    private String memberImg; // 프로필 이미지

    @Column(name = "member_name")
    @NotNull
    private String memberName; // 닉네임

    @Column(name = "member_birth")
    @NotNull
    private Date memberBirth; // 생일

    @Column(name = "member_mbti")
    @NotNull
    private Integer memberMbti; // mbti

    @Column(name = "couple_status")
    @NotNull
    @ColumnDefault(value = "0")
    private Integer coupleStatus; // 커플 연동 상태 (연동O:1, 연동X:0)

    @Column(name = "member_status")
    @NotNull
    @ColumnDefault(value = "1")
    private Integer memberStatus; // 회원 상태 (활성화:1, 탈퇴:0)
}
