package br.com.mercadolivre.linktracker.controller;

import br.com.mercadolivre.linktracker.service.MetricsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricController {
    private MetricsService metricsService;

    public MetricController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping("/{linkId}")
    public ResponseEntity statics(@PathVariable Integer linkId){
        Integer count = this.metricsService.getCount(linkId);
        return ResponseEntity.ok().body("Quantidade: "+count);
    }
}
