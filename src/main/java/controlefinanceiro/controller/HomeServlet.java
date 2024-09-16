package controlefinanceiro.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlefinanceiro.dao.DespesaDAO;
import controlefinanceiro.enumeradores.Enum.Booleano;
import controlefinanceiro.enumeradores.Enum.ClassificacaoDespesa;
import controlefinanceiro.enumeradores.Enum.FormaAquisicao;
import controlefinanceiro.enumeradores.Enum.TipoDespesa;
import controlefinanceiro.enumeradores.Enum.TipoRecorrencia;
import controlefinanceiro.model.Despesa;

@WebServlet(urlPatterns = {"/home", "/listarDespesas", "/cadastrarEditarDespesas", "/cadastrarDespesa", "/editarDespesa"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Metodo executado: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		String action = request.getServletPath();
		
		request.setAttribute("classificacaoDespesa", ClassificacaoDespesa.values());
		request.setAttribute("booleano", Booleano.values());
		request.setAttribute("tipoRecorrencia", TipoRecorrencia.values());
		request.setAttribute("tipoDespesa", TipoDespesa.values());
		request.setAttribute("formaAquisicao", FormaAquisicao.values());
		
		if(action.equals("/listarDespesas")) {
			
			List<Despesa> despesas = DespesaDAO.listAllDespesa();
			request.setAttribute("despesas", despesas);
			request.getRequestDispatcher("listarDespesas.jsp").forward(request, response);
			
		} else if(action.equals("/cadastrarEditarDespesas")) {

			request.getRequestDispatcher("cadastrarEditarDespesas.jsp").forward(request, response);
			
		} else if(action.equals("/cadastrarDespesa")) {
			cadastrarDespesa(request, response);
			
		} else {
			response.sendRedirect("index.jsp");}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);

		String action = request.getServletPath();
		
		if(action.equals("/editarDespesas")) {
			editarDespesa(request, response);
		}
	}

	public String editarDespesa(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> t = request.getParameterNames();
		System.out.println(t);
		return "x";
	}

	public void cadastrarDespesa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Map<String, String[]> dadosCadastro = request.getParameterMap();
		List<String> res = new ArrayList<String>();
		Map<String, String> despesaRequest = new HashMap<String, String>();
		
		Set<Map.Entry<String, String[]>> entrySet = dadosCadastro.entrySet();
		
		for(Entry<String, String[]> entry: entrySet) {
			String paramName = entry.getKey();
	        String[] paramValues = entry.getValue();
	        
	    	for(String value: paramValues) {

	    		res.add(String.format("%s - %s", paramName, value));
	    		
	    		despesaRequest.put(paramName, value);
	    	}
	    }

		Despesa despesa = DespesaDAO.despesaBuilder(despesaRequest);
		
		despesa.setCriacao(LocalDateTime.now().atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")));
		DespesaDAO.salvarDespesa(despesa);
		
		response.sendRedirect("index.jsp");
	}
}
