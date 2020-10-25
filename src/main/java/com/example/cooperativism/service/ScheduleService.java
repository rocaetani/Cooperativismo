package com.example.cooperativism.service;

import com.example.cooperativism.domain.Schedule;
import com.example.cooperativism.domain.Voting;
import com.example.cooperativism.repository.ScheduleRepository;
import com.example.cooperativism.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;


@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;


    public Schedule createSchedule(String topic){
        Schedule schedule = new Schedule(topic);
        scheduleRepository.saveAndFlush(schedule);
        return schedule;
    }



}
