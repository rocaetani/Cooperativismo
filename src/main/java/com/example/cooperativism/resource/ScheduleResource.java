package com.example.cooperativism.resource;

import com.example.cooperativism.domain.Schedule;
import com.example.cooperativism.service.ScheduleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.temporal.TemporalAmount;


@RestController
@RequestMapping(value="/Schedule")
public class ScheduleResource {

    @Autowired
    private ScheduleService scheduleService;


    @RequestMapping(method = RequestMethod.GET, value="/Create")
    public ResponseEntity<?> createSchedule(@RequestParam(value="topic") String topic){
        Schedule schedule = scheduleService.createSchedule(topic);

        return ResponseEntity.ok().body(schedule);
    }

    @RequestMapping(method = RequestMethod.GET, value="/StartVoting")
    public ResponseEntity<?> startVoting(@RequestParam(value="id") int id, @RequestParam(value="timeMinutes") long minutes){
        Schedule schedule = scheduleService.startVoting(id, minutes);

        return ResponseEntity.ok().body(schedule);
    }







}

