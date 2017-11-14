package br.com.finControl.repository.helper.lancamento;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.finControl.model.Lancamento;
import br.com.finControl.repository.filter.LancamentoFilter;
import br.com.finControl.repository.paginacao.PaginacaoUtil;

public class LancamentosImpl implements LancamentosQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public Page<Lancamento> filtrar(LancamentoFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Lancamento.class);
		
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}

	private Long total(LancamentoFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Lancamento.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}
	
	private void adicionarFiltro(LancamentoFilter filtro, Criteria criteria) {
		
		if(filtro != null){
			
//			if(!StringUtils.isEmpty(filtro.getValor())){
//				criteria.add(Restrictions.("valor", filtro.getValor() , MatchMode.ANYWHERE));
//			}
			
			if(!StringUtils.isEmpty(filtro.getDescricao())){
				criteria.add(Restrictions.like("descricao", filtro.getDescricao() , MatchMode.ANYWHERE));
			}
					
			
		}
		
	}

	
}
