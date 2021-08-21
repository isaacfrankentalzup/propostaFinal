package br.com.zupedu.proposta.proposta.model.avisos;

import java.time.LocalDate;

public class AvisosRequest {
    private LocalDate validoAte;
    private String destino;

    public AvisosRequest(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
