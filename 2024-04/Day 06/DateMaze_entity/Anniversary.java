package com.datee.datemaze.calendar.entity;

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
@Table(name = "anniversary")
@DynamicInsert
@DynamicUpdate
/* 기념일 entity */
public class Anniversary extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ann_no")
    private Long annNo; // 기념일 번호

    @Column(name = "cal_no")
    @NotNull
    private Long calNo; // 캘린더 번호

    @Column(name = "ann_name")
    @NotNull
    private String annName; // 기념일 이름

    @Column(name = "ann_date")
    @NotNull
    private Date annDate; // 기념일 날짜
}
