package com.datee.datemaze.couple.entity;

import com.datee.datemaze.calendar.entity.Calendar;
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
@Table(name = "couple")
@DynamicInsert
@DynamicUpdate
/* 커플 entity */
public class Couple extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "couple_no")
    private Long coupleNo; // 커플 번호

    @Column(name = "couple_name")
    private String coupleName; // 커플명

    @ManyToOne
    @JoinColumn(name = "member1_no")
    private Member member1; // 회원1

    @ManyToOne
    @JoinColumn(name = "member2_no")
    private Member member2; // 회원2

    @OneToOne(mappedBy = "couple", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cal_no")
    private Calendar calendar; // 캘린더 번호

    @Column(name = "couple_date")
    @NotNull
    private Date coupleDate; // 커플 시작일
}
