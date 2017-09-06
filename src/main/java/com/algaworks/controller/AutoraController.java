package com.algaworks.controller;

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

import com.algaworks.model.Autora;
import com.algaworks.repository.Autoras;


@Controller
@RequestMapping("/autoras")
public class AutoraController {
	
	@Autowired
	private Autoras autoras;
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaAutoras");
		mv.addObject("autoras",autoras.findAll());
		return mv;
	}
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("FrmAutoras");
		mv.addObject(new Autora());
		return mv;
		
	}
	
	@PostMapping("")

	public ModelAndView salvar(@Validated Autora autora, Errors erros, RedirectAttributes redirectAttributes){
		ModelAndView mv = new ModelAndView("FrmAutoras");
		mv.addObject("autoras", autoras.findAll());
		if(erros.hasErrors()){
			return mv;
		}
		try{
			this.autoras.save(autora);
			return new ModelAndView("redirect:autoras");
		}catch(Exception e){return mv;}
		
	}
	
	

	@RequestMapping(value ="/excluir/{idAutora}")
	public String excluirAutoraByPathVariable(@PathVariable Long idAutora, HttpServletRequest request, 
					HttpServletResponse response) {
		
		this.autoras.delete(idAutora);
		return "redirect:/autoras";
	
	}
	
	@RequestMapping(value ="/alterar/{idAutora}")
	public ModelAndView alterarAutoraByPathVariable(@PathVariable Long idAutora, HttpServletRequest request, 
			HttpServletResponse response) {
	ModelAndView mv = new ModelAndView("FrmAutora");
	mv.addObject("autoras", autoras.findAll());
	Autora autora = autoras.findOne(idAutora);
	mv.addObject(autora);
	return mv;
	}
	//Excluir
		@RequestMapping(value="{idAutora}", method = RequestMethod.DELETE)
		public String excluir(@PathVariable Long idAutora, RedirectAttributes attributes) {
			autoras.delete(idAutora);
			attributes.addFlashAttribute("mensagem", "Autoras excluídas com sucesso!");
			return "redirect:/autoras";
		}
	

}
