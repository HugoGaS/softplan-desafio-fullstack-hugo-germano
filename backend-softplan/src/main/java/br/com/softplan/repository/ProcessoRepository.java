package br.com.softplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softplan.model.entity.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

}
