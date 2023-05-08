package com.hong.test;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;

public class FlowableExample {
    public static void main(String[] args) {
        // 创建流程引擎配置
        ProcessEngineConfiguration config = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration()
                .setDatabaseSchemaUpdate("true")
                .setJdbcUrl("jdbc:mysql://192.168.153.128:3306/mytest?useUnicode=true&characterEncoding=utf-8&useSSL=false")
                .setJdbcUsername("root")
                .setJdbcPassword("jia")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        // 创建流程引擎
        ProcessEngine processEngine = config.buildProcessEngine();

        // 部署流程定义
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("myProcess.bpmn20.xml")
                .deploy();

        // 启动流程实例
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());

        // 执行任务
        System.out.println("流程实例 " + processInstance.getId() + " 已经启动");
    }
}
