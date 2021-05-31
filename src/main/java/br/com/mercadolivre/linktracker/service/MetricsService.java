package br.com.mercadolivre.linktracker.service;

import br.com.mercadolivre.linktracker.exception.LinkDoesNotExistingException;
import br.com.mercadolivre.linktracker.model.Link;
import br.com.mercadolivre.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {
    private LinkRepository linkRepository;

    public MetricsService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Integer getCount(Integer linkId){
        Link link = this.linkRepository.findById(linkId);
        return link.getCount();
    }
}
