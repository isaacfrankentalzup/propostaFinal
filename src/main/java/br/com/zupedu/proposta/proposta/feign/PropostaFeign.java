package br.com.zupedu.proposta.proposta.feign;


import br.com.zupedu.proposta.proposta.model.analise.DadosAnaliseRequest;
import br.com.zupedu.proposta.proposta.model.analise.DadosAnaliseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${proposta.analise}", name = "solicitacao")
public interface PropostaFeign {
    @PostMapping
    public DadosAnaliseResponse dadosParaAnalise(DadosAnaliseRequest dadosAnaliseRequest);

}
