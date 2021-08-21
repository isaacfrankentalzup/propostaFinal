package br.com.zupedu.proposta.proposta.model.carteiras;

public class CarteiraResponse {
    private String email;
    private String carteira;

    public CarteiraResponse(String email, String carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public String getEmail() {
        return email;
    }

    public String getCarteira() {
        return carteira;
    }
}
