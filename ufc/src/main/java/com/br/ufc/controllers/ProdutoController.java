package com.br.ufc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.ufc.model.Produto;
import com.br.ufc.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

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
	public ModelAndView salvarPessoa(Produto produto) {
		produtoService.adicionarProduto(produto);
		
		ModelAndView mv = new ModelAndView("redirect:/index");
		
		return mv;
	}
	@RequestMapping("/addcart/{id}")
	public ModelAndView addCart(@PathVariable Long id) {
		Produto produto = produtoService.buscarPorId(id);
		
		ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
		return mv;
	}
	
	
	@RequestMapping("{id}")
	public ModelAndView atualizarPessoa(@PathVariable Long id) {
		Produto produto = produtoService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("produto", produto);
		
		return mv;
	}
	
}
