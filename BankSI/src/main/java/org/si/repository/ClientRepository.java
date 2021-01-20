package org.si.repository;

import java.util.List;

import org.si.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
	//List<Client> findByNameCountains(String mc);
}
