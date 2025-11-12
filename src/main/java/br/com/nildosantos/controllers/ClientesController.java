package br.com.nildosantos.controllers;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.nildosantos.dtos.ClienteRequestDto;
import br.com.nildosantos.dtos.ClienteResponseDto;
import br.com.nildosantos.entities.Cliente;
import br.com.nildosantos.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {

	//Método para realizar cadastro de clientes
	@PostMapping
	public String post(@RequestBody ClienteRequestDto request) throws Exception {
		//Criando um objeto da classe de entidade
		var cliente = new Cliente();
		
		//Copiando as informaçoes do DTO para a entidade
		cliente.setId(UUID.randomUUID());
		cliente.setNome(request.nome());
		cliente.setEmail(request.email());
		cliente.setCpf(request.cpf());
		cliente.setTelefone(request.telefone());
		cliente.setDataNascimento(new SimpleDateFormat("yyyy-MM-dd").parse(request.dataNascimento()));
		cliente.setDataCadastro(new Date());
		
		//gravar no banco de dados
		var clienteRepository = new ClienteRepository();
		clienteRepository.inserir(cliente);
		
		return "Cliente " + cliente.getNome() + ", cadastrado com sucesso!";
	}
	
	//Método para realizar atualização de clientes
	@PutMapping("{id}")
	public String put(@PathVariable UUID id, @RequestBody ClienteRequestDto request) throws Exception {
		
		// Criando um objeto da classe de entidade
		var cliente = new Cliente();

		// Copiando as informaçoes do DTO para a entidade
		cliente.setId(id);
		cliente.setNome(request.nome());
		cliente.setEmail(request.email());
		cliente.setCpf(request.cpf());
		cliente.setTelefone(request.telefone());
		cliente.setDataNascimento(new SimpleDateFormat("yyyy-MM-dd").parse(request.dataNascimento()));

		// atualizar no banco de dados
		var clienteRepository = new ClienteRepository();
		clienteRepository.atualizar(cliente);

		return "Cliente " + cliente.getNome() + ", atualizado com sucesso!";
	}
	
	/*
	 * Método para realizar a exclusão dos dados de um cliente
	 */
	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) throws Exception {
		
		//Excluir o cliente no banco de dados
		var clienteRepository = new ClienteRepository();
		clienteRepository.excluir(id);
		
		return "Cliente excluído com sucesso.";
	}	
	
	/*
	 * Método para realizar a consulta de clientes
	 */
	@GetMapping
	public List<ClienteResponseDto> getAll(@RequestParam String nome) throws Exception {
		
		//criando um objeto da classe de repositório
		var clienteRepository = new ClienteRepository();
		
		//consultar os clientes no banco de dados
		var clientes = clienteRepository.consultar(nome);
		
		//copiar os dados da lista de clientes para uma lista do dto
		return clientes.stream()
				.map(c -> new ClienteResponseDto( //preenchendo o DTO
							c.getId(), //id do cliente
							c.getNome(), //nome do cliente
							c.getEmail(), //email do cliente
							c.getCpf(), //cpf do cliente
							c.getTelefone(), //telefone do cliente
							c.getDataNascimento() //data de nascimento
						))
				.collect(Collectors.toList()); //lista de ClienteResponseDto
		
		}
	}
