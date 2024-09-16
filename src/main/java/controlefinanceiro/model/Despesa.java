package controlefinanceiro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import controlefinanceiro.enumeradores.Enum.Booleano;
import controlefinanceiro.enumeradores.Enum.ClassificacaoDespesa;
import controlefinanceiro.enumeradores.Enum.FormaAquisicao;
import controlefinanceiro.enumeradores.Enum.TipoDespesa;
import controlefinanceiro.enumeradores.Enum.TipoRecorrencia;
import jakarta.persistence.Version;

@Entity
@Table(name = "despesa")
public class Despesa implements Comparable<Despesa>, Serializable  {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "des_id_despesa") private Integer id;
	@Column(name = "des_descricao") private String descricao;
	@Column(name = "des_valor") private Float valor;
	@Column(name = "des_dt_efetivacao") private LocalDate dataEfetivacao;
	@Column(name = "des_debito_proprio") private Integer debitoProprio;
	@Column(name = "des_parcelado") private Integer parcelado;
	@Column(name = "des_tp_despesa") private Integer tipoDespesa;
	@Column(name = "des_forma_aquisicao") private Integer formaAquisicao;
	@Column(name = "des_tp_recorrencia") private Integer tipoRecorrencia;
	@Column(name = "des_classificacao") private Integer classificacaoDespesa;
	@Column(name = "des_parcela") private Integer numParcela;
	@Column(name = "des_dt_hr_criacao") private ZonedDateTime criacao;
	@Column(name = "des_dt_hr_alteracao") @Version private ZonedDateTime alteracao;
	
	public Despesa() {
		
	}

	public Despesa(Integer id, String descricao, Float valor, LocalDate dataEfetivacao, Booleano debitoProprio,
			Booleano parcelado, TipoDespesa tipoDespesa, FormaAquisicao formaAquisicao, TipoRecorrencia tipoRecorrencia,
			ClassificacaoDespesa classificacaoDespesa, Integer numParcela, ZonedDateTime criacao, ZonedDateTime alteracao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataEfetivacao = dataEfetivacao;
		this.debitoProprio = debitoProprio.getCodigo();
		this.parcelado = parcelado.getCodigo();
		this.tipoDespesa = tipoDespesa.getCodigo();
		this.formaAquisicao = formaAquisicao.getCodigo();
		this.tipoRecorrencia = tipoRecorrencia.getCodigo();
		this.classificacaoDespesa = classificacaoDespesa.getCodigo();
		this.numParcela = numParcela;
		this.criacao = criacao;
		this.alteracao = alteracao;
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

	public void setDebitoProprio(Booleano debitoProprio) {
		this.debitoProprio = debitoProprio.getCodigo() ;
	}

	public Integer getParcelado() {
		return parcelado;
	}

	public void setParcelado(Booleano parcelado) {
		this.parcelado = parcelado.getCodigo();
	}

	public Integer getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa.getCodigo();
	}

	public Integer getFormaAquisicao() {
		return formaAquisicao;
	}

	public void setFormaAquisicao(FormaAquisicao formaAquisicao) {
		this.formaAquisicao = formaAquisicao.getCodigo();
	}

	public Integer getTipoRecorrencia() {
		return tipoRecorrencia;
	}

	public void setTipoRecorrencia(TipoRecorrencia tipoRecorrencia) {
		this.tipoRecorrencia = tipoRecorrencia.getCodigo();
	}

	public Integer getClassificacaoDespesa() {
		return classificacaoDespesa;
	}

	public void setClassificacaoDespesa(ClassificacaoDespesa classificacaoDespesa) {
		this.classificacaoDespesa = classificacaoDespesa.getCodigo();
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

	public void setCriacao(ZonedDateTime zonedDateTime) {
		this.criacao = zonedDateTime;
	}

	public ZonedDateTime getAlteracao() {
		return alteracao;
	}

	public void setAlteracao(ZonedDateTime alteracao) {
		this.alteracao = alteracao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Despesa [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", dataEfetivacao=" 
				+ dataEfetivacao + ", debitoProprio=" + debitoProprio + ", parcelado=" + parcelado 
				+ ", tipoDespesa=" + tipoDespesa + ", formaAquisicao=" + formaAquisicao + ", tipoRecorrencia=" 
				+ tipoRecorrencia + ", classificacaoDespesa=" + classificacaoDespesa + ", numParcela=" 
				+ numParcela + ", criacao=" + criacao + ", alteracao=" + alteracao + "]";
	}

	@Override
	public int compareTo(Despesa despesa) {
		if(this.getId() > despesa.getId()) {
			return 1; // se o id do objeto recebido for maior que o id x, fica a direita ou seja (no topo)
		} else if(this.getId() < despesa.getId()) {
			return -1; // se o id do objeto recebido for menor que o id x, fica a esquerda ou seja (em baixo)
		}
		return 0; // se o id do objeto recebido for igual que o id x, na mesma posição
	}
}
