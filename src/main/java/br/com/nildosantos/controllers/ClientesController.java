package br.com.nildosantos.controllers;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.nildosantos.entities.Cliente;
import br.com.nildosantos.repositories.ClienteRepository;



@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {

	/*
	 * Método para realizar a consulta de clientes
	 */
	@GetMapping
	public List<Cliente> getAll(@RequestParam String nome) throws Exception {
		
		//criando um objeto da classe de repositório
		var clienteRepository = new ClienteRepository();
		
		//consultar os clientes no banco de dados
		return clienteRepository.consultar(nome);
	}
	
}

