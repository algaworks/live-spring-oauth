package com.algaworks.estoque.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.estoque.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutosResource {
	
	private static final List<Produto> PRODUTOS = Arrays.asList(
			new Produto(1L, "Notebook"),
			new Produto(2L, "Bola Nike de Campo"),
			new Produto(3L, "Celular"));
	
	@PreAuthorize("hasAuthority('ROLE_PRODUTOS_PESQUISA')")
	@GetMapping
	public List<Produto> listar() {
		return PRODUTOS;
	}
}
