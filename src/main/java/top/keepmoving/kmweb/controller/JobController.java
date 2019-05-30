package top.keepmoving.kmweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.keepmoving.kmweb.common.CommonResponse;
import top.keepmoving.kmweb.common.ResponseUtil;
import top.keepmoving.kmweb.service.JobService;
import top.keepmoving.kmweb.web.quartz.domain.ScheduleJob;
import top.keepmoving.kmweb.web.quartz.exception.ServiceException;

/**
 * <p>@author: Vince
 * <p>@description: spring-boot-demos
 * <p>@since: v1.1
 * <p>@date: 2018-09-22
 **/
@RestController
@RequestMapping(value = "/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public CommonResponse getAllJob() {
        return ResponseUtil.generateResponse(jobService.getAllJob());
    }

    @GetMapping("/{id}")
    public CommonResponse getJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.select(jobId));
    }

    @PutMapping("/update/{id}")
    public CommonResponse updateJob(@PathVariable("id") Long jobId, @RequestBody ScheduleJob newScheduleJob) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.update(jobId, newScheduleJob));
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse deleteJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.delete(jobId));
    }

    @PostMapping("/save")
    public CommonResponse saveJob(@RequestBody ScheduleJob newScheduleJob) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.add(newScheduleJob));
    }


    @GetMapping("/run/{id}")
    public CommonResponse runJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.run(jobId));
    }


    @GetMapping("/pause/{id}")
    public CommonResponse pauseJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.pause(jobId));
    }

    @GetMapping("/resume/{id}")
    public CommonResponse resumeJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.resume(jobId));
    }

}
