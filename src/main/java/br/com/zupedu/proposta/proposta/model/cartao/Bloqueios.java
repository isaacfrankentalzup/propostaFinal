package br.com.zupedu.proposta.proposta.model.cartao;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Bloqueios {
    @Id
    private String id;
    private LocalDateTime bloqueadoEm = LocalDateTime.now();
    private String sistemaResponsavel;
    private Boolean ativo;

    @Deprecated //usado apenas pelo hibernate
    public Bloqueios() {
    }

    public Bloqueios(String id, String sistemaResponsavel, Boolean ativo) {
        this.id = id;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getBloqueadoEm() {
        return bloqueadoEm;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
