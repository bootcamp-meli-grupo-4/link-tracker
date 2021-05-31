package br.com.mercadolivre.linktracker.controller;

import br.com.mercadolivre.linktracker.service.InvalidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invalidate")
public class InvalidateController {

    private InvalidateService invalidateService;

    public InvalidateController(InvalidateService invalidateService) {
        this.invalidateService = invalidateService;
    }

    @PostMapping("/{linkId}")
    public ResponseEntity invalidateLink(@PathVariable Integer linkId){
        this.invalidateService.invalidateLink(linkId);
        return ResponseEntity.ok().body("Invalidated link");
    }
}
