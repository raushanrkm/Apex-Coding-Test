package com.apex.coding.test.controller;

import com.apex.coding.test.dbbean.Schedule;
import com.apex.coding.test.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apex")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;


    @RequestMapping(value="/")
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/displayAllSchedule", method = RequestMethod.GET)
    @ResponseBody public Iterable<Schedule> displayAllSchedule(){
        return this.scheduleService.getAllSchedule();

    }

    @RequestMapping(value = "/saveSchedule", method =RequestMethod.POST)
    @ResponseBody
   public Schedule saveSchedule(@RequestBody Schedule schedule)
    {
        System.out.println(schedule);
       this.scheduleService.saveSchedule(schedule);
       return schedule;
   }

   @RequestMapping(value = "/findByDescription", method = RequestMethod.GET)
   @ResponseBody public List<Schedule> findByDescription(@RequestParam String description){
        return this.scheduleService.getScheduleByDescription(description);
        }




}
