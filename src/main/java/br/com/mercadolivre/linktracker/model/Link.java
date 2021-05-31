package br.com.mercadolivre.linktracker.model;

import lombok.Data;

@Data
public class Link {
    private String url;
    private Integer count = 0;

}
