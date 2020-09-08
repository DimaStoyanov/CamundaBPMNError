package com.example.camundabpmerror.delegate;

import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CallThirdPartyAction implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("Executing action {} for process instance {}",
                execution.getCurrentActivityName(), execution.getProcessInstanceId());

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        try {
            processEngine.getRuntimeService().startProcessInstanceByKey("script_process");
        } catch (Exception e) {
            throw new BpmnError("ThirdPartyError");
        }
    }
}
