package com.example.camundabpmerror.delegate;

import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CancelOrderAction implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("Executing action {} for process instance {}",
                execution.getCurrentActivityName(), execution.getProcessInstanceId());
    }
}
