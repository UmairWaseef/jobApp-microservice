package com.umrproj.firstjobapp.job.impl;

import com.umrproj.firstjobapp.job.Job;
import com.umrproj.firstjobapp.job.JobRepository;
import com.umrproj.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //private List<Job> jobs= new ArrayList<>();


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {

       return  jobRepository.findById(id).orElse(null);

//        for (Job job:
//        jobs) {
//            if (job.getId().equals(id)) {
//                return job;
//            }
//        }
//        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }


//        Iterator<Job> iterator = jobs.iterator();
//        while ((iterator.hasNext())){
//            Job job = iterator.next();
//            if (job.getId().equals(id)) {
//            iterator.remove();
//            return true;}
//        }
//            return false;
        }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;

//        for (Job job: jobs) {
//            if(job.getId().equals(id)){
//                job.setTitle(upadatedJob.getTitle());
//                job.setDescription(upadatedJob.getDescription());
//                job.setMinSalary(upadatedJob.getMinSalary());
//                job.setMaxSalary(upadatedJob.getMaxSalary());
//                job.setLocation(upadatedJob.getLocation());
//                return true;
//
//            }
//
//        }
//        return false;
    }
}
