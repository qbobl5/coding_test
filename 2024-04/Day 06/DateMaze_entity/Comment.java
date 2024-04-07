package com.datee.datemaze.dateSchedule.entity;

import com.datee.datemaze.member.entity.Member;
import com.datee.datemaze.util.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
@DynamicInsert
@DynamicUpdate
/* 댓글 entity */
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private Long commentNo; // 댓글 번호

    @Column(name = "dsch_no")
    @NotNull
    private Long dschNo; // 커플 일정 번호

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member; // 회원

    @Column(name = "comment_content")
    @NotNull
    private String commentContent; // 댓글 내용

    @Column(name = "comment_date")
    private Date commentDate; // 댓글 작성일
}
