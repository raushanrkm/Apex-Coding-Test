package com.apex.coding.test.service;
import com.apex.coding.test.dbbean.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ScheduleService {

     public Iterable<Schedule> getAllSchedule();
     public List<Schedule> getScheduleByDescription(String desc);
     void saveSchedule (Schedule schedule);
}
