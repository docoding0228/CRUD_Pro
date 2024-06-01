package com.sparta.crud_pro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.crud_pro.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String charge;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.charge = schedule.getCharge();
        this.createdAt = schedule.getCreatedAt();
    }
}

