package com.br.ufc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.br.ufc.model.Produto;
import com.br.ufc.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	List<Produto> produtos = new ArrayList<Produto>();
	double valor = 0;
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/listar")
	public ModelAndView listarProdutos() {
		List<Produto> produtos = produtoService.retornarTodasOsProdutos();
		ModelAndView mv = new ModelAndView("todos-produtos");
		
		mv.addObject("todasOsProdutos", produtos);
		
		return mv;
	}
	
	
	@RequestMapping("/formulario")
	public ModelAndView formularioProduto() {
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("produto", new Produto());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProduto(Produto produto , @RequestParam(value= "imagem") MultipartFile imagem) {
		produtoService.adicionarProduto(produto, imagem);
		
		ModelAndView mv = new ModelAndView("redirect:/index");
		
		return mv;
	}
	@RequestMapping("/addcart/{id}")
	public ModelAndView addCart(@PathVariable Long id) {
		Produto produto = produtoService.buscarPorId(id);
		//List<Pessoa> pessoas = new ArrayList<Pessoa>();
		produtos.add(produto);
		valor = produto.getValor() + valor;
		ModelAndView mv = new ModelAndView("cart");
		mv.addObject("listaTemporaria", produtos);
		mv.addObject("valorTotal", valor);
		return mv;
	}
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("redirect:/index");
		return mv;
	}
	
	
	@RequestMapping("{id}")
	public ModelAndView atualizarPessoa(@PathVariable Long id) {
		Produto produto = produtoService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("produto", produtos);
		
		return mv;
	}
	
}
