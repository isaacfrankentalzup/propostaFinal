package br.com.zupedu.proposta.proposta.repository;

import br.com.zupedu.proposta.proposta.model.cartao.Carteiras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteiras, String> {
}
