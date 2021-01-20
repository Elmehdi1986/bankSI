package org.si.service;

import java.util.List;

import org.si.entities.Client;

public interface ClientMetier {

	public Client addClient(Client client);

	public void removeClient(Long id);

	public List<Client> getAllClients();

	public List<Client> getClientByMc(String mc);
}
