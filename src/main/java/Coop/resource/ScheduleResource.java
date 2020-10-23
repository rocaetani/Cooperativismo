package Coop.resource;

import Coop.domain.Associate;
import Coop.domain.Schedule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping(value="/Schedule")
public class ScheduleResource {

    //Apagar
    private int scheduleCounter;

    public ScheduleResource(){
        this.scheduleCounter = 0;
    }

    @RequestMapping(method = RequestMethod.GET, value="/Create")
    public Schedule createSchedule(@RequestParam(value="topic") String topic){
        Schedule schedule = new Schedule(topic, this.scheduleCounter + "");
        this.scheduleCounter += 1;
        return schedule;
    }


}

