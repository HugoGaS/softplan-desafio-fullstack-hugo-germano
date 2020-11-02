package br.com.softplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softplan.model.entity.Parecer;

public interface ParecerRepository extends JpaRepository<Parecer, Long> {

}
