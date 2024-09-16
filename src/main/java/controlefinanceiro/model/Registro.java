package controlefinanceiro.model;

import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name="registro")
public class Registro {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "reg_id", nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "reg_cod_dominio", updatable = false, nullable = false)
	private Dominio dominio;
	
	@Column(name = "reg_descricao", length = 100, nullable = false)
	private String descricao;
	
	@Column(name = "reg_complemento", length = 200, nullable = true)
	private String complemento;
	
	@ManyToOne
	@JoinColumn(name = "reg_situacao", nullable = false, updatable = false)
	private Registro situacao;

	@Version
	@Column(name = "reg_versao", nullable = false)
	private ZonedDateTime versao;
	
	public Registro() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dominio getDominio() {
		return dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Registro getSituacao() {
		return situacao;
	}

	public void setSituacao(Registro situacao) {
		this.situacao = situacao;
	}

	public ZonedDateTime getVersao() {
		return versao;
	}

	public void setVersao(ZonedDateTime versao) {
		this.versao = versao;
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
		Registro other = (Registro) obj;
		return Objects.equals(id, other.id);
	}
	
}
