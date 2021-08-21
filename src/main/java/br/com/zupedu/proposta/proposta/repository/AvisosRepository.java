package br.com.zupedu.proposta.proposta.repository;

import br.com.zupedu.proposta.proposta.model.avisos.Avisos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisosRepository extends JpaRepository<Avisos,Long> {
}
