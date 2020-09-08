package com.example.camundabpmerror;

import org.assertj.core.api.Assertions;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CamundabpmerrorApplicationTests {

    @Test
    void createOrder() throws Exception {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("iot_create_order");
        Thread.sleep(10_000);
        Assertions.assertThat(processInstance.isEnded()).isTrue();

    }

}
