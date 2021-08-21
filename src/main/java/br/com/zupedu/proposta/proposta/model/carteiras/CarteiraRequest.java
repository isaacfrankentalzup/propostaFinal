package br.com.zupedu.proposta.proposta.model.carteiras;

public class CarteiraRequest {
    private String id;
    private String resultado;

    public CarteiraRequest(String id, String resultado) {
        this.id = id;
        this.resultado = resultado;
    }

    public String getId() {
        return id;
    }

    public String getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return "PayPalRequest{" +
                "id='" + id + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
