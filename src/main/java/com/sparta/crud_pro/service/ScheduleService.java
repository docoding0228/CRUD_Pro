package com.sparta.crud_pro.service;


import com.sparta.crud_pro.dto.ScheduleRequestDto;
import com.sparta.crud_pro.dto.ScheduleResponseDto;
import com.sparta.crud_pro.entity.Schedule;
import com.sparta.crud_pro.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule);
    }
}