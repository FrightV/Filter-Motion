package com.filtermotion.scheduler;

import com.filtermotion.service.PriceMonitorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrecoScheduler {

    private final PriceMonitorService monitorService;

    public PrecoScheduler(PriceMonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @Scheduled(fixedRate = 21600000)
    public void atualizarPrecos() {

        System.out.println("Atualizando preços dos produtos...");

        monitorService.atualizarPrecos();
    }
}