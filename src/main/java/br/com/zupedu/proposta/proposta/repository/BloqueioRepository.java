package br.com.zupedu.proposta.proposta.repository;

import br.com.zupedu.proposta.proposta.model.cartao.Bloqueios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloqueioRepository extends JpaRepository<Bloqueios,String> {
}
