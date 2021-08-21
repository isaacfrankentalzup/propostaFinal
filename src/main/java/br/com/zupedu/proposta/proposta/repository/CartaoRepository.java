package br.com.zupedu.proposta.proposta.repository;

import br.com.zupedu.proposta.proposta.model.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
