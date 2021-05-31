package br.com.mercadolivre.linktracker.repository;

import br.com.mercadolivre.linktracker.dto.LinkDto;
import br.com.mercadolivre.linktracker.exception.LinkDoesNotExistingException;
import br.com.mercadolivre.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository {
    private Map<Integer, Link> entities = new HashMap<>();
    private Integer id = 0;

    public Integer save(LinkDto linkDto){
        Link link = new Link();
        link.setUrl(linkDto.getUrl());
        Integer id = nextId();
        this.entities.put(id, link);
        return id;
    }

    private Integer nextId(){
        return this.id += 1;
    }

    public Link findById(Integer linkId) {
        Link link = this.entities.getOrDefault(linkId, null);
        if (link == null) throw new LinkDoesNotExistingException();
        return link;
    }

    public void delete(Integer linkId) {
        Link link = this.entities.remove(linkId);
        if (link == null) throw new LinkDoesNotExistingException();
    }
}
