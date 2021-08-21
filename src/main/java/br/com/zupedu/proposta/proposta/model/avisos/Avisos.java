package br.com.zupedu.proposta.proposta.model.avisos;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Avisos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate validoAte;
    private String destino;
    private LocalDateTime instante = LocalDateTime.now();
    private String ip;
    private String userAgent;


    @Deprecated //usado pelo hibernate
    public Avisos() {
    }

    public Avisos(LocalDate validoAte, String destino, String ip, String userAgent) {
        this.validoAte = validoAte;
        this.destino = destino;
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
