package br.com.zupedu.proposta.proposta.model.cartao;

import br.com.zupedu.proposta.proposta.model.avisos.Avisos;
import br.com.zupedu.proposta.proposta.model.biometria.Biometria;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cartao {
    @Id
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private BigDecimal limite;
    private String idProposta;
    @OneToMany
    private List<Bloqueios> bloqueios;
    @OneToMany
    private List<Avisos> avisos;
    @OneToMany
    private List<Carteiras> carteiras;
    @OneToMany
    private List<Parcelas> parcelas;
    @OneToOne(cascade = CascadeType.ALL)
    private Renegociacao renegociacao;
    @OneToOne(cascade = CascadeType.ALL)
    private Vencimento vencimento;

    @OneToMany
    private List<Biometria> biometrias = new ArrayList<>();

    @Deprecated //usado pelo hibernate
    public Cartao() {
    }

    public Cartao(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite, String idProposta,
                  List<Bloqueios> bloqueios, List<Avisos> avisos, List<Carteiras> carteiras, List<Parcelas> parcelas,
                  Renegociacao renegociacao, Vencimento vencimento) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
        this.idProposta = idProposta;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
    }

    public String getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public List<Bloqueios> getBloqueios() {
        return bloqueios;
    }

    public List<Avisos> getAvisos() {
        return avisos;
    }

    public List<Carteiras> getCarteiras() {
        return carteiras;
    }

    public List<Parcelas> getParcelas() {
        return parcelas;
    }

    public Renegociacao getRenegociacao() {
        return renegociacao;
    }

    public Vencimento getVencimentos() {
        return vencimento;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public void AdicionarBloqueios(Bloqueios bloqueios) {
        this.bloqueios.add(bloqueios);
    }

    public List<Biometria> getBiometrias() {
        return biometrias;
    }

    public void setBiometrias(Biometria biometrias) {
        this.biometrias.add(biometrias);
    }

    public void addBloqueio(Bloqueios novoBloqueio){
        this.bloqueios.add(novoBloqueio);
    }

    public void addAvisos(Avisos avisos){
        this.avisos.add(avisos);
    }

    public void addCarteira(Carteiras carteira){

        this.carteiras.add(carteira);

    }
}


