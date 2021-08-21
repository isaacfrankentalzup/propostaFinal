package br.com.zupedu.proposta.proposta.controller;

import br.com.zupedu.proposta.proposta.feign.CartaoFeign;
import br.com.zupedu.proposta.proposta.model.avisos.Avisos;
import br.com.zupedu.proposta.proposta.model.avisos.AvisosRequest;
import br.com.zupedu.proposta.proposta.model.biometria.Biometria;
import br.com.zupedu.proposta.proposta.model.cartao.Bloqueios;
import br.com.zupedu.proposta.proposta.model.cartao.Cartao;
import br.com.zupedu.proposta.proposta.model.cartao.Carteiras;
import br.com.zupedu.proposta.proposta.model.carteiras.CarteiraRequest;
import br.com.zupedu.proposta.proposta.model.carteiras.CarteiraResponse;
import br.com.zupedu.proposta.proposta.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("${api.cartoes}")
public class CartaoController {

    private CartaoRepository cartaoRepository;
    private BloqueioRepository bloqueioRepository;
    private CarteiraRepository carteiraRepository;

    private BiometriaRepository biometriaRepository;
    private CartaoFeign cartaoFeign;

    private AvisosRepository avisosRepository;


    public CartaoController(CartaoRepository cartaoRepository,
                            BloqueioRepository bloqueioRepository,
                            BiometriaRepository biometriaRepository,
                            CartaoFeign cartaoFeign,
                            AvisosRepository avisosRepository,
                            CarteiraRepository carteiraRepository) {
        this.cartaoRepository = cartaoRepository;
        this.bloqueioRepository = bloqueioRepository;
        this.biometriaRepository = biometriaRepository;
        this.cartaoFeign = cartaoFeign;
        this.avisosRepository = avisosRepository;
        this.carteiraRepository = carteiraRepository;
    }

    @PostMapping("/{idCartao}")
    public void salvaBiometria(@PathVariable String idCartao){
        //tenho o possível numero do cartao - VERIFICAR A EXISTENCIA DESTE CARTAO

        Optional<Cartao> temCartao = cartaoRepository.findById(idCartao);

        if(temCartao.isPresent()){

            //gerar um fingerprint com base64
            Long numeroAleatorio = new Random().nextLong();
            byte[] finger = numeroAleatorio.toString().getBytes();
            String fingerprint = Base64.getEncoder().encodeToString(finger);

            //crio uma nova biometria utilizar o finger gerando anteriormente
            Biometria novaBiometria = new Biometria(fingerprint);

            //salvar no banco a minha biometria
            Biometria biometriaSalva = biometriaRepository.save(novaBiometria);

            //atualizar meu cartao com a novabiometria
            temCartao.get().setBiometrias(biometriaSalva);

            //atualizar no banco o meu cartao com a novabiometria
            cartaoRepository.save(temCartao.get());


        }
    }

    @GetMapping
    public List<Cartao> findAll(){
        return cartaoRepository.findAll();

    }

    @PostMapping("/bloqueio/{cartaoid}")
    public ResponseEntity<?> bloqueioCartao(@PathVariable String cartaoid){

        if(cartaoid.isBlank()){
            return ResponseEntity.badRequest().build(); //400
        }

        Optional<Cartao> temCartao = cartaoRepository.findById(cartaoid);

        if(temCartao.isEmpty()){
            return ResponseEntity.notFound().build(); //404
        }

        Cartao cartaoEncontrado = temCartao.get();

        String sistemaResponsavel = "Meu Sistema";


        String resultado = cartaoFeign.bloqueiaCartao(cartaoid,sistemaResponsavel);

        if(resultado.equals("BLOQUEADO")) {
            Bloqueios novoBloqueio = new Bloqueios(
                    cartaoEncontrado.getId(),
                    "MeuSistema",
                    false);

            Bloqueios bloqueioSalvo = bloqueioRepository.save(novoBloqueio);
            cartaoEncontrado.addBloqueio(bloqueioSalvo);
            cartaoRepository.save(cartaoEncontrado);
            return ResponseEntity.ok().build(); //200
        }

        return ResponseEntity.unprocessableEntity().build(); //422

    }

    @PostMapping("avisos/{cartaoid}")
    public ResponseEntity<?> avisoCartao(@PathVariable String cartaoid,
                                         @RequestBody AvisosRequest avisosRequest,
                                         HttpServletRequest request){

        Optional<Cartao> temCartao = cartaoRepository.findById(cartaoid);

        if(temCartao.isEmpty()){
            return ResponseEntity.notFound().build(); //404
        }

        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");


        String resultado = cartaoFeign.avisoCartao(cartaoid,avisosRequest);

        System.out.println(resultado);

            //criar um aviso
            Avisos novoAvisos =
                    new Avisos(avisosRequest.getValidoAte(),
                            avisosRequest.getDestino(),
                            ip,
                            userAgent);


            //salvar um novo aviso
            Avisos avisoSalvo = avisosRepository.save(novoAvisos);

            //recupero o cartao de dentro do optional
            Cartao cartaoAtual = temCartao.get();

            //atualizo o aviso dentro do cartao
            cartaoAtual.addAvisos(avisoSalvo);

            //salvo o cartao - update
            cartaoRepository.save(cartaoAtual);

            return ResponseEntity.ok().build(); //200

    }


    @PostMapping("carteira/{cartaoid}")
    public ResponseEntity<?> associacaoPayPal(@PathVariable String cartaoid,
                                 @RequestBody CarteiraResponse carteiraResponse ){

        if(cartaoid.isBlank()){
            return ResponseEntity.badRequest().build(); //400 = badrequest
        }

        Optional<Cartao> temCartao = cartaoRepository.findById(cartaoid);

        if(temCartao.isEmpty()){
            return ResponseEntity.notFound().build(); //404
        }

        Cartao cartaoAtual = temCartao.get();


        CarteiraRequest carteiraRequest = cartaoFeign.associaCartaoPayPal(cartaoAtual.getId(), carteiraResponse);

        Carteiras novaCarteira =
                new Carteiras(carteiraRequest.getId(),carteiraResponse.getEmail(),carteiraResponse.getCarteira());

        Carteiras carteiraSalva =  carteiraRepository.save(novaCarteira);

        cartaoAtual.addCarteira(carteiraSalva);

        cartaoRepository.save(cartaoAtual);

        return ResponseEntity.ok().build();

    }


}
