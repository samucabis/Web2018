package com.br.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.br.ufc.model.Produto;
import com.br.ufc.repository.ProdutoRepository;
import com.br.ufc.util.AulaFileUtils;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void adicionarProduto(Produto produto, MultipartFile imagem) {
		String caminho = "images/" + produto.getNome() + ".png";
		AulaFileUtils.salvarImagem(caminho,imagem);
		
		produtoRepository.save(produto);
	}
	

	public List<Produto> retornarTodasOsProdutos() {
		
		return produtoRepository.findAll();
	}
	
	public Produto buscarPorId(Long id) {
		return produtoRepository.getOne(id);
	}


	public void removerProduto(Long id) {
		produtoRepository.deleteById(id);
		
	}
	

}
