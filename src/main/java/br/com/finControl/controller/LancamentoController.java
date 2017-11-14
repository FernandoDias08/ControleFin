package br.com.finControl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.finControl.controller.page.PageWrapper;
import br.com.finControl.model.Lancamento;
import br.com.finControl.model.enu.TipoLancamento;
import br.com.finControl.repository.Lancamentos;
import br.com.finControl.repository.filter.LancamentoFilter;
import br.com.finControl.service.CadastroLancamentoService;
import br.com.finControl.service.exception.EntidadeJaCadastradaException;

@Controller
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private CadastroLancamentoService cadastroLancamentoService;
	

	
	@Autowired
	private Lancamentos lancamentos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Lancamento lancamento) {
		
		ModelAndView mv = new ModelAndView("lancamento/CadastroLancamento");

		mv.addObject("todosTipos", TipoLancamento.values());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Lancamento lancamento, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novo(lancamento);
		}
		
		try {
			
			cadastroLancamentoService.salvar(lancamento);
			attributes.addFlashAttribute("mensagem", "Lancamento salvo com sucesso!");
			
		} catch (EntidadeJaCadastradaException e) {
			result.rejectValue("id", null, e.getMessage());
			return novo(lancamento);
		}

		return new ModelAndView ("redirect:/lancamentos/novo");
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") LancamentoFilter filtro, @PageableDefault(size = 6) Pageable pageable,
            HttpServletRequest httpServletRequest) {

		ModelAndView mv = new ModelAndView("lancamento/PesquisaLancamentos");
		
		PageWrapper<Lancamento> paginaWrapper = new PageWrapper<>(lancamentos.filtrar(filtro, pageable), httpServletRequest);
        mv.addObject("pagina", paginaWrapper);

		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Lancamento lancamento) {
		
		ModelAndView mv = novo(lancamento);
		mv.addObject(lancamento);
		return mv;
	}
	
	
}
