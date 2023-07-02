package com.geekster.JobSearchPortal.repository;


import com.geekster.JobSearchPortal.model.Job;
import com.geekster.JobSearchPortal.model.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job, Long>{

//    Use Custom Finder ************
    List<Job> findByJobType(Type jobType);
    List<Job> findByJobSalaryGreaterThanEqualAndJobType(Double jobSalary, Type jobType);
    List<Job> findByCompanyNameAndJobType(String companyName, Type jobType);
    List<Job> findByJobLocationOrderByJobSalaryDesc(String jobLocation);

//    Using Custom Query ********************
//    1
    @Query(value = "select * from Job where job_Id = :id", nativeQuery = true)
    Job getJobsById(Long id);

//    2
    @Query(value = "select * from Job where location = :location", nativeQuery = true)
    List<Job> getAllJobsByLocation(@Param("location") String location);

}
