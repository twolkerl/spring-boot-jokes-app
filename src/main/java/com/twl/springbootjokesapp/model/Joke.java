package com.twl.springbootjokesapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "jokes")
public class Joke {

    @Id
    private String id;
    private String text;
    //TODO incluir atributo 'tipo' para identificar se é um registro criado pelo usuário ou gerado automaticamente
}
