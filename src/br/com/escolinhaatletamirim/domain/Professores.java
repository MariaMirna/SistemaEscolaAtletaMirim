package br.com.escolinhaatletamirim.domain;

public class Professores {
	private long codigo;
	private int cpf;
	private String nome;
	private int telefone;
	private int datanascimento;
	private int dataadmissao;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(int datanascimento) {
		this.datanascimento = datanascimento;
	}

	public int getDataadmissao() {
		return dataadmissao;
	}

	public void setDataadmissao(int dataadmissao) {
		this.dataadmissao = dataadmissao;
	}

	@Override
	public String toString() {
		String saida = codigo + " - " + nome;
		// TODO Auto-generated method stub
		return saida;
	}

}
