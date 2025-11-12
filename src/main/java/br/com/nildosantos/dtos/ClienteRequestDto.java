package br.com.nildosantos.dtos;


public record ClienteRequestDto(
		String nome, 
		String email,
		String cpf,
		String telefone,
		String dataNascimento
		) {

}
