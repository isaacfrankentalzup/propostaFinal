package br.com.zupedu.proposta.proposta.repository;

import br.com.zupedu.proposta.proposta.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    Boolean existsByDocumento(String documento);
}
