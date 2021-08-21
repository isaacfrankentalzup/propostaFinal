package br.com.zupedu.proposta.proposta.model.novocartao;

public class NovoCartaoDTO {
    private String documento;
    private String nome;
    private String idProposta;

    public NovoCartaoDTO(String documento, String nome, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
