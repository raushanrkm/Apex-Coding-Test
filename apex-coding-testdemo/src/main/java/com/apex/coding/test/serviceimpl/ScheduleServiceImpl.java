package com.apex.coding.test.serviceimpl;

import com.apex.coding.test.dbbean.Schedule;
import com.apex.coding.test.repository.ScheduleRepo;
import com.apex.coding.test.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private  ScheduleRepo scheduleRepo;

    @Override
    public Iterable<Schedule> getAllSchedule(){
        return scheduleRepo.findAll();
    }

    @Override
    public List<Schedule> getScheduleByDescription(String description) {
        return scheduleRepo.findByDescriptionContaining(description);
    }

    @Override
    public void saveSchedule(Schedule schedule) {
        scheduleRepo.save(schedule);
    }
}
