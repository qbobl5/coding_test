package com.datee.datemaze.schedule.entity;

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
@Table(name = "schedule")
@DynamicInsert
@DynamicUpdate
/* 개인 일정 entity */
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sch_no")
    private Long schNo; // 일정 번호

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member; // 회원

    @Column(name = "cal_no")
    @NotNull
    private Long calNo; // 캘린더 번호

    @Column(name = "sch_date")
    @NotNull
    private Date schDate; // 일정 날짜

    @Column(name = "sch_title")
    @NotNull
    private String schTitle; // 일정 제목
}
