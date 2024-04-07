package com.datee.datemaze.dateSchedule.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DateScheduleDTO {
    private Long dschNo; // 커플 일정 번호
    private Date dschDate; // 커플 일정 날짜
    private String dschTitle; // 커플 일정 제목
    private String dschContent; // 커플 일정 내용
    private Integer dschStatus; // 공개 여부
    private List<CommentDTO> commentList; // 댓글 목록
}
