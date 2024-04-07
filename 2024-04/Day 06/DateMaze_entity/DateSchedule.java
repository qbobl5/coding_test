package com.datee.datemaze.dateSchedule.entity;

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
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "date_schedule")
@DynamicInsert
@DynamicUpdate
/* 커플 일정 entity */
public class DateSchedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dsch_no")
    private Long dschNo; // 커플 일정 번호

    @Column(name = "cal_no")
    @NotNull
    private Long calNo; // 캘린더 번호

    @Column(name = "dsch_date")
    @NotNull
    private Date dschDate; // 커플 일정 날짜

    @Column(name = "dsch_title")
    @NotNull
    private String dschTitle; // 커플 일정 제목

    @Column(name = "dsch_content")
    private String dschContent; // 커플 일정 내용

    @Column(name = "dsch_status")
    @NotNull
    private Integer dschStatus; // 공개 여부 (공개:1, 비공개:0)

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "dsch_no")
    private List<Comment> commentList; // 댓글 목록
}
