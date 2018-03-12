package com.apex.coding.test.repository;

import com.apex.coding.test.dbbean.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScheduleRepo extends CrudRepository<Schedule, Long> {
    public List<Schedule> findByDescription(@Param("description") String description);

}
