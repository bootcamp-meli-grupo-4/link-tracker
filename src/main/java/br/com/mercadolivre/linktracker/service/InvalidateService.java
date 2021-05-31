package br.com.mercadolivre.linktracker.service;

import br.com.mercadolivre.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class InvalidateService {

    private LinkRepository linkRepository;

    public InvalidateService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public void invalidateLink(Integer linkId){
        this.linkRepository.delete(linkId);
    }

}
