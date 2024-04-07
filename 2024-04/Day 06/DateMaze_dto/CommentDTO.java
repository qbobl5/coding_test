package com.datee.datemaze.dateSchedule.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long commentNo; // 댓글 번호
    private Long memberNo; // 회원 번호
    private String memberName; // 회원 닉네임
    private String commentContent; // 댓글 내용
    private Date commentDate; // 댓글 작성일
}
