package controlefinanceiro.model;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "dominio")
public class Dominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dom_id")
	private Integer id;
	
	@Column(name = "dom_descricao", length = 200)
	private String descricao;
	
	@OneToMany(mappedBy = "dominio")
	@Column(name = "dom_situacao")
	private List<Registro> situacao;

	@Version
	@Column(name = "dom_versao")
	private ZonedDateTime versao;
	
	public Dominio() {}

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

	public List<Registro> getSituacao() {
		return situacao;
	}

	public void setSituacao(List<Registro> situacao) {
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
		Dominio other = (Dominio) obj;
		return Objects.equals(id, other.id);
	}
}
