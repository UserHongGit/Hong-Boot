//package com.hong.controller;
//
//import com.hong.service.MyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class MyController {
//
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private IdentityService identityService;
//
//    @Autowired
//    private MyService myService;
//
//    @GetMapping("/start")
//    public String startProcess() {
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
//        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
//        //identityService.setAuthenticated
//        return "ok";
//    }
