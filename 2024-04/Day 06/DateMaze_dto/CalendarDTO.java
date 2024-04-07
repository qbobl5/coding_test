package com.datee.datemaze.calendar.dto;

import com.datee.datemaze.dateSchedule.dto.DateScheduleDTO;
import com.datee.datemaze.schedule.dto.ScheduleDTO;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDTO {
    private Long calNo; // 캘린더 번호
    private List<ScheduleDTO> scheduleDTOList; // 개인 일정 목록
    private List<DateScheduleDTO> dateScheduleDTOList; // 커플 일정 목록
    private List<AnniversaryDTO> anniversaryDTOList; // 기념일 목록
}
