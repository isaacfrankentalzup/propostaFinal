package br.com.zupedu.proposta.proposta.model;

import br.com.zupedu.proposta.proposta.model.analise.PropostaStatus;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Proposta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String documento; //cpf or cnpj
    @Column(nullable = true)
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private BigDecimal salario;
    //campos inseridos depois da proposta criada
    //preciso do SET para alterar o status do(s) atributo(s)
    private PropostaStatus estatus = PropostaStatus.ANALISE;
    private String numeroCartao;

    @Deprecated //apenas para o hibernate
    public Proposta() {
    }

    public Proposta(String documento, String email, String nome,
                    String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public PropostaStatus getEstatus() {
        return estatus;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setEstatus(PropostaStatus estatus) {
        this.estatus = estatus;
    }

    public void setNumeroCartao(String numeroCartao){
        this.numeroCartao = numeroCartao;
    }

}
