package br.com.zupedu.proposta.proposta.model.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Parcelas {
    @Id
    private String id;
    private Integer quantidade;
    private BigDecimal valor;

    public Parcelas() {
    }

    public Parcelas(String id, Integer quantidade, BigDecimal valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
