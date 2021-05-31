package br.com.mercadolivre.linktracker.service;

import br.com.mercadolivre.linktracker.dto.LinkDto;
import br.com.mercadolivre.linktracker.model.Link;
import br.com.mercadolivre.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Integer createLink(LinkDto linkDto) {
        return this.linkRepository.save(linkDto);

    }

    public String getLinkUrl(Integer linkId) {
       Link link = this.linkRepository.findById(linkId);
       link.setCount(link.getCount()+1);
       return link.getUrl();
    }
}
