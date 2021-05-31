package br.com.mercadolivre.linktracker.controller;

import br.com.mercadolivre.linktracker.dto.LinkDto;
import br.com.mercadolivre.linktracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;

@RestController
@RequestMapping("/link")
public class LinkController {

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping()
    public ResponseEntity<Void> createLink(@RequestBody LinkDto link){
        URI uri = URI.create(String.format("link/%d", this.linkService.createLink(link)));
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{linkId}")
    public RedirectView redirectLink(@PathVariable Integer linkId){
        String url = this.linkService.getLinkUrl(linkId);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);

        return redirectView;

    }

}
