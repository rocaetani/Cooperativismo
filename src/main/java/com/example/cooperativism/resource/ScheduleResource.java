package com.example.cooperativism.resource;

import com.example.cooperativism.domain.Schedule;
import com.example.cooperativism.exception.ResponseException;
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


    @RequestMapping(method = RequestMethod.POST, value="/Create")
    public ResponseEntity<?> createSchedule(@RequestParam(value="topic") String topic){
        try{
            Schedule schedule = scheduleService.createSchedule(topic);

            return ResponseEntity.ok().body(schedule);
        }catch (ResponseException e){
            return ResponseEntity.status(e.getResponseStatus()).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

    @RequestMapping(method = RequestMethod.POST, value="/StartVoting")
    public ResponseEntity<?> startVoting(@RequestParam(value="idSchedule") int idSchedule, @RequestParam(value="timeMinutes") long minutes){
        try{
            scheduleService.startVoting(idSchedule, minutes);

            return ResponseEntity.ok().body("Votação iniciada");
        }catch (ResponseException e){
            return ResponseEntity.status(e.getResponseStatus()).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }
    @RequestMapping(method = RequestMethod.POST, value="/Vote")
    public ResponseEntity<?> vote(@RequestParam(value="idSchedule") int idSchedule,
                                  @RequestParam(value="idAssociate") int idAssociate,
                                  @RequestParam(value="choice") boolean choice){
        try{
            scheduleService.vote(idSchedule,idAssociate,choice);
            return ResponseEntity.ok().body("Voto Realizado");
        }catch (ResponseException e){
            return ResponseEntity.status(e.getResponseStatus()).body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }


    }

    @RequestMapping(method = RequestMethod.GET, value="/findSchedule")
    public ResponseEntity<?> findSchedule(@RequestParam(value="idSchedule") int idSchedule){
        try{
            Schedule schedule = scheduleService.findSchedule(idSchedule);
            return ResponseEntity.ok().body(schedule);
        }catch (ResponseException e){
            return ResponseEntity.status(e.getResponseStatus()).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/getResult")
    public ResponseEntity getResult(@RequestParam(value="idSchedule") int idSchedule){
        try{
            Schedule schedule = scheduleService.findSchedule(idSchedule);
            return ResponseEntity.ok().body("O Resultado da Pauta '" + schedule.getTopic() + "' foi " + scheduleService.getScheduleResult(idSchedule));
        }catch (ResponseException e){
            return ResponseEntity.status(e.getResponseStatus()).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }






}

