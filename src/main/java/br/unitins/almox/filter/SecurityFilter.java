package br.unitins.almox.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unitins.almox.model.Perfil;
import br.unitins.almox.model.Usuario;


@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/faces/admin/*"} )
public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String endereco = servletRequest.getRequestURI();
		System.out.println(servletRequest.getServerName());
		System.out.println(servletRequest.getServletPath());
		System.out.println(servletRequest.getServletContext());
		
		System.out.println(endereco);
		
		// retorna uma sessao corrente (false - nao cria uma nova estrutura de sessao)
		HttpSession session =  servletRequest.getSession(false);
		Usuario usuarioLogado = null;
		if (session != null)
			usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		// se nao estiver logado, redirecionar para a pagina de login
		if (usuarioLogado == null) {
			((HttpServletResponse)response).sendRedirect("/Almox/faces/login2.xhtml");
		} else {
			if (usuarioLogado.getPerfil().getPaginasComPermissao().contains(endereco)) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse)response).sendRedirect("/Almox/faces/semacesso.xhtml");
			}
		}
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		System.out.println("Filtro SecurityFilter iniciailzado.");
	}

}