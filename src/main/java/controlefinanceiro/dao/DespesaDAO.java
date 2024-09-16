package controlefinanceiro.dao;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import controlefinanceiro.enumeradores.Enum.Booleano;
import controlefinanceiro.enumeradores.Enum.ClassificacaoDespesa;
import controlefinanceiro.enumeradores.Enum.FormaAquisicao;
import controlefinanceiro.enumeradores.Enum.TipoDespesa;
import controlefinanceiro.enumeradores.Enum.TipoRecorrencia;
import controlefinanceiro.model.Despesa;

public class DespesaDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistirControleFinanceiro"); // atributo name do persistence.xml
	
	public static Despesa despesaBuilder(Map<String, String> despesaRequest) {
		Despesa despesa = new Despesa();
		
		for(Entry<String, String> entry: despesaRequest.entrySet()) {
			String parametro = entry.getKey().toString().substring(4, entry.getKey().length());
			String valorParametro = entry.getValue();
			
			if(parametro.equals("descricao")) {
				despesa.setDescricao(valorParametro);
				
			} else if (parametro.equals("valor")) {
				despesa.setValor(Float.valueOf(valorParametro));
				
			} else if (parametro.equals("dataEfetivacao")) {
				despesa.setDataEfetivacao(LocalDate.parse(valorParametro));
				
			} else if (parametro.equals("DebitoProprio")) {
				despesa.setDebitoProprio(Booleano.valueOf(Booleano.class, valorParametro));
				
			} else if (parametro.equals("FormaAquisicao")) {
				despesa.setFormaAquisicao(FormaAquisicao.valueOf(FormaAquisicao.class, valorParametro));
				
			} else if (parametro.equals("TipoDespesa")) {
				despesa.setTipoDespesa(TipoDespesa.valueOf(valorParametro));
				
			} else if (parametro.equals("ClassificacaoDespesa")) {
				despesa.setClassificacaoDespesa(ClassificacaoDespesa.valueOf(valorParametro));
				
			} else if (parametro.equals("TipoRecorrencia")) {
				despesa.setTipoRecorrencia(TipoRecorrencia.valueOf(formatEnum(valorParametro)));
				
			} else if (parametro.equals("parcelado")) {
				despesa.setParcelado(Booleano.valueOf(Booleano.class, valorParametro));

			} else if (parametro.equals("numParcela")) {
				despesa.setNumParcela(Integer.parseInt(valorParametro));
				
			} else if (parametro.equals("id")) {
				despesa.setId(Integer.parseInt(valorParametro));
				
			} else if (parametro.equals("criacao")) {
				despesa.setCriacao(null);
				
			} else if (parametro.equals("alteracao")) {
				despesa.setAlteracao(null);
			}
		}
		
		return despesa;
	}
	
	public static String formatEnum(String str) {
	    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(nfdNormalizedString).replaceAll("").replace(" ", "").toUpperCase();
	}
	
	public static void salvarDespesa(Despesa despesa) {
		
		EntityManager em = emf.createEntityManager();
		/*Salvando com transição*/
		em.getTransaction().begin();
		em.persist(despesa);
		em.getTransaction().commit();
		em.close();
	}

	public static List<Despesa> listAllDespesa(){
		EntityManager em = emf.createEntityManager();
		TypedQuery<Despesa> query = em.createQuery("FROM Despesa", Despesa.class);
        List<Despesa> despesas = query.getResultList();
        em.close();
        return despesas;
	}
	
	public static Despesa findDespesaById(Integer id) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Despesa> query = em.createQuery("FROM Despesa where des_id = :id", Despesa.class).setParameter("id", id);
		Despesa despesa = query.getSingleResult();
		em.close();
		return despesa;
	}
}
