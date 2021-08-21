package br.com.zupedu.proposta.proposta.repository;

import br.com.zupedu.proposta.proposta.model.biometria.Biometria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiometriaRepository extends JpaRepository<Biometria, Long> {
}
