package org.si.service;

import java.util.List;

import org.si.entities.Client;
import org.si.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMetierImpl implements ClientMetier {
    @Autowired
	private ClientRepository clientRepository;
	@Override
	public Client addClient(Client client) {
	
		return clientRepository.save(client);
	}

	@Override
	public void removeClient(Long id) {
		
		clientRepository.deleteById(id);
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public List<Client> getClientByMc(String mc) {
		// TODO Auto-generated method stub
		//return clientRepository.findByNameCountains(mc);
		return null;
	}

}
