package org.si.controller;

import java.util.List;

import org.si.entities.Client;
import org.si.exception.InvalidFeildException;
import org.si.service.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;


@RestController
@RequestMapping(value = "/client")
public class ClientRestController {

	@Autowired
	ClientMetier clientMetier;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> addClient(@RequestBody Client client) {
		if(client == null) {
			throw new InvalidFeildException("the client is null");	
		}
		if (client.getName().isEmpty()) {
			throw new InvalidFeildException("the Name is Empty");
		}
		Client clientPersist = clientMetier.addClient(client);
		return new ResponseEntity<Client>(clientPersist, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getAllClient() {
		return new ResponseEntity<List<Client>>(clientMetier.getAllClients(), HttpStatus.ACCEPTED);
	}
}
