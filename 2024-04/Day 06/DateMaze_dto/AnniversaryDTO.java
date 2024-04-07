package com.datee.datemaze.calendar.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnniversaryDTO {
    private Long annNo; // 기념일 번호
    private String annName; // 기념일 이름
    private Date annDate; // 기념일 날짜
}
