//package com.hong.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.io.InputStream;
//
//@org.springframework.stereotype.Service
//public class MyProcessService {
//
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private TaskService taskService;
//
//    public void startProcess() {
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
//        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
//        taskService.complete(task.getId());
//    }
//
//    @PostConstruct
//    public void init() {
//        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("processes/myProcess.bpmn20.xml");
//        Deployment deployment = repositoryService.createDeployment().addInputStream("myProcess.bpmn20.xml", inputStream).deploy();
//    }
//}
