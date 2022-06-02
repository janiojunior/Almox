package br.unitins.almox.report;

import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;

import br.unitins.almox.application.JDBCUtil;

@WebServlet("/relatoriocidades.xhtml")
public class CidadeReport extends ReportServlet{

	@Override
	public String getArquivoJasper() {
		return "Cidades.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		param.put("ESTADO", String.class);
		return param;
	}

	@Override
	public Connection getConnection() {
		return JDBCUtil.getConnection();
	}

}
