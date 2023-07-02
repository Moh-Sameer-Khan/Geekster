package com.geekster.JobSearchPortal.service;

import com.geekster.JobSearchPortal.model.Job;
import com.geekster.JobSearchPortal.model.Type;
import com.geekster.JobSearchPortal.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobRepo iJobRepo;

    public Iterable<Job> getAllJobs() {
        return iJobRepo.findAll();
    }

    public String addJobsList(List<Job> job) {
        iJobRepo.saveAll(job);
        return "Jobs Added Successfully";
    }

    public String addJob(Job job) {
        iJobRepo.save(job);
        return "Job Added Successfully";
    }

    public String getCountJobs() {
        return "Total Jobs is " + iJobRepo.count();

    }

    public List<Job> getAllJobsByJobType(Type type) {
        return iJobRepo.findByJobType(type);
    }

    public List<Job> getAllJobsByGreaterOrEqualSalaryAndJobType(Double jobSalary, Type type) {
        return iJobRepo.findByJobSalaryGreaterThanEqualAndJobType(jobSalary, type);
    }

    public List<Job> getAllJobsByCompanyNameAndTypeEqual(String companyName, Type type) {
        return iJobRepo.findByCompanyNameAndJobType(companyName, type);
    }

    public List<Job> getAllJobsByLocationAndSortedSalaryDesc(String location) {
        return iJobRepo.findByJobLocationOrderByJobSalaryDesc(location);
    }


//    Custom Query
    public Job getJobsById(Long id) {
        return iJobRepo.getJobsById(id);
    }

    public List<Job> getAllJobsByLocation(String location) {
        return iJobRepo.getAllJobsByLocation(location);
    }
}
