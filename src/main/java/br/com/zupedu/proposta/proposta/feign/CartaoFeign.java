package br.com.zupedu.proposta.proposta.feign;

import br.com.zupedu.proposta.proposta.model.avisos.AvisosRequest;
import br.com.zupedu.proposta.proposta.model.cartao.Cartao;
import br.com.zupedu.proposta.proposta.model.carteiras.CarteiraRequest;
import br.com.zupedu.proposta.proposta.model.carteiras.CarteiraResponse;
import br.com.zupedu.proposta.proposta.model.novocartao.NovoCartaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${proposta.cartao}", name = "cartao")
public interface CartaoFeign {

    @PostMapping("/api/cartoes/")
    public Cartao getCartao(NovoCartaoDTO novoCartaoDTO);

    @PostMapping("/api/cartoes/{id}/bloqueios")
    public String bloqueiaCartao(@PathVariable String id,String resultado);

    @PostMapping("/api/cartoes/{id}/avisos")
    public String avisoCartao(@PathVariable String id, AvisosRequest avisosRequest);

    @PostMapping("/api/cartoes/{id}/carteiras")
    public CarteiraRequest associaCartaoPayPal(@PathVariable String id, CarteiraResponse carteiraResponse);


}

