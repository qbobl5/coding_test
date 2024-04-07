package com.datee.datemaze.couple.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoupleDTO {

    private Long coupleNo; // 커플 번호

    private String coupleName; // 커플명

    private Date coupleDate; // 커플 시작일

    private Long member1No; // 회원1 번호

    private String member1Name; // 회원1 닉네임

    private Long member2No; // 회원2 번호

    private String member2Name; // 회원2 닉네임

    private Long calendarNo; // 캘린더 번호
}
