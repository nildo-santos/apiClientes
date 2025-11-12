package br.com.nildosantos.dtos;

import java.util.Date;
import java.util.UUID;

public record ClienteResponseDto(
		UUID id,
		String nome, 
		String email,
		String cpf,
		String telefone,
		Date dataNascimento
		) {

}
