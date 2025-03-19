package br.com.tokiomarine.seguradora.repositories;

import br.com.tokiomarine.seguradora.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
