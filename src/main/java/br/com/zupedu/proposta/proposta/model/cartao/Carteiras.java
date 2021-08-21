package br.com.zupedu.proposta.proposta.model.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Carteiras {
    @Id
    private String id;
    private String email;
    private LocalDateTime associadaEm = LocalDateTime.now();
    private String emissor;

    @Deprecated //usado pelo hibernate
    public Carteiras() {
    }

    public Carteiras(String id, String email,  String emissor) {
        this.id = id;
        this.email = email;
        this.emissor = emissor;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getAssociadaEm() {
        return associadaEm;
    }

    public String getEmissor() {
        return emissor;
    }
}

/*
 "id": "string",
      "email": "string",
      "associadaEm": "2021-08-13T23:00:27.125Z",
      "emissor": "string"
 */