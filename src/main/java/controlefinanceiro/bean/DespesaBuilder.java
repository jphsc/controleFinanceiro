package controlefinanceiro.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class DespesaBuilder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	private Float valor;
	private LocalDate dataEfetivacao;
	private Integer debitoProprio;
	private Integer parcelado;
	private Integer tipoDespesa;
	private Integer formaAquisicao;
	private Integer tipoRecorrencia;
	private Integer classificacaoDespesa;
	private Integer numParcela;
	private ZonedDateTime criacao;
	private ZonedDateTime alteracao;
	
	public DespesaBuilder() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public LocalDate getDataEfetivacao() {
		return dataEfetivacao;
	}

	public void setDataEfetivacao(LocalDate dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

	public Integer getDebitoProprio() {
		return debitoProprio;
	}

	public void setDebitoProprio(Integer debitoProprio) {
		this.debitoProprio = debitoProprio;
	}

	public Integer getParcelado() {
		return parcelado;
	}

	public void setParcelado(Integer parcelado) {
		this.parcelado = parcelado;
	}

	public Integer getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(Integer tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Integer getFormaAquisicao() {
		return formaAquisicao;
	}

	public void setFormaAquisicao(Integer formaAquisicao) {
		this.formaAquisicao = formaAquisicao;
	}

	public Integer getTipoRecorrencia() {
		return tipoRecorrencia;
	}

	public void setTipoRecorrencia(Integer tipoRecorrencia) {
		this.tipoRecorrencia = tipoRecorrencia;
	}

	public Integer getClassificacaoDespesa() {
		return classificacaoDespesa;
	}

	public void setClassificacaoDespesa(Integer classificacaoDespesa) {
		this.classificacaoDespesa = classificacaoDespesa;
	}

	public Integer getNumParcela() {
		return numParcela;
	}

	public void setNumParcela(Integer numParcela) {
		this.numParcela = numParcela;
	}

	public ZonedDateTime getCriacao() {
		return criacao;
	}

	public void setCriacao(ZonedDateTime criacao) {
		this.criacao = criacao;
	}

	public ZonedDateTime getAlteracao() {
		return alteracao;
	}

	public void setAlteracao(ZonedDateTime alteracao) {
		this.alteracao = alteracao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
//	public DespesaBean getBean(Despesa despesa) {
//
//		
//	}
}
