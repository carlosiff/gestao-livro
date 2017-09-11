package com.algaworks.gestaolivro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.gestaolivro.model.Livro;
import com.algaworks.gestaolivro.repository.Livros;

@Controller
@RequestMapping("/livros")
public class LivrosController {
	
	@Autowired
	private Livros livros;
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("LisLivro");
		mv.addObject("livros",livros.findAll());
		return mv;
	}
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("FrmLivros");
		mv.addObject(new Livro());
		return mv;
		
	}
	
	@PostMapping("")

	public ModelAndView salvar(@Validated Livro livro, Errors erros, RedirectAttributes redirectAttributes){
		ModelAndView mv = new ModelAndView("FrmLivros");
		mv.addObject("livros", livros.findAll());
		if(erros.hasErrors()){
			return mv;
		}
		try{
			this.livros.save(livro);
			return new ModelAndView("redirect:livros");
		}catch(Exception e){return mv;}
		
	}
	
	

	@RequestMapping(value ="/excluir/{idLivro}")
	public String excluirLivroByPathVariable(@PathVariable Long idLivro, HttpServletRequest request, 
					HttpServletResponse response) {
		
		this.livros.delete(idLivro);
		return "redirect:/livros";
	
	}
	
	@RequestMapping(value ="/alterar/{idLivro}")
	public ModelAndView alterarLivroByPathVariable(@PathVariable Long idLivro, HttpServletRequest request, 
			HttpServletResponse response) {
	ModelAndView mv = new ModelAndView("FrmLivros");
	mv.addObject("livros", livros.findAll());
	Livro livro = livros.findOne(idLivro);
	mv.addObject(livro);
	return mv;
	}
	//Excluir
		@RequestMapping(value="{idLivro}", method = RequestMethod.DELETE)
		public String excluir(@PathVariable Long idLivro, RedirectAttributes attributes) {
			livros.delete(idLivro);
			attributes.addFlashAttribute("mensagem", "Livro excluído com sucesso!");
			return "redirect:/livros";
		}

}
