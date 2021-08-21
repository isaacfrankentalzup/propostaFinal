package br.com.zupedu.proposta.proposta.model.biometria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Biometria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fingerPrint;
    private LocalDateTime criadaEm = LocalDateTime.now();

    public Biometria() {
    }

    public Biometria(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public Long getId() {
        return id;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }
}
