package br.com.backendjr.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CLienteRepository extends JpaRepository<Cliente, Long> {
}
