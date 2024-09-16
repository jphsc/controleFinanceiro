package controlefinanceiro.enumeradores;

public class Enum {
	
	public enum Booleano {
		SIM(1, "Sim"),
		NAO(0, "Não");
		
		private String descricao;
		private Integer codigo;

		public String getDescricao() {
			return this.descricao;
		}

		public Integer getCodigo() {
			return this.codigo;
		}
		
		private Booleano(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}
	}
	
	public enum FormaAquisicao{
		CARTAODECREDITO(2, "Cartão de Crédito"),
		CARTAODEDEBITO(3, "Cartão de Débito"),
		ESPECIE(4, "Espécie");

		private String descricao;
		private Integer codigo;

		public String getDescricao() {
			return this.descricao;
		}

		public Integer getCodigo() {
			return this.codigo;
		}
		
		private FormaAquisicao(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}
	}
	
	public enum TipoDespesa{
		PROPRIA(5, "Própria"),
		COMPARTILHADA(6, "Compartilhada"),
		OUTROS(7, "Outros");

		private String descricao;
		private Integer codigo;

		public String getDescricao() {
			return this.descricao;
		}

		public Integer getCodigo() {
			return this.codigo;
		}
		
		private TipoDespesa(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}
	}
	
	public enum ClassificacaoDespesa{
		CASA(8,"Casa"),
		VESTUARIO(9, "Vestuário"),
		EDUCACAO(10, "Educação"),
		SAUDE(11, "Saúde"),
		LAZER(12, "Lazer"),
		OUTROSMEU(13, "Outros meu"),
		OUTROS(14, "Outros"),
		MERCADO(15, "Mercado"),
		ALIMENTACAO(16, "Alimentação");

		private String descricao;
		private Integer codigo;

		public String getDescricao() {
			return this.descricao;
		}

		public Integer getCodigo() {
			return this.codigo;
		}
		
		private ClassificacaoDespesa(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}
	}
	
	public enum TipoRecorrencia{
		MENSAL(17, "Mensal"),
		UNICO(18, "Único"),
		PARCELADO(19, "Parcelado");

		private String descricao;
		private Integer codigo;

		public String getDescricao() {
			return this.descricao;
		}

		public Integer getCodigo() {
			return this.codigo;
		}
		
		private TipoRecorrencia(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}
	}
}
