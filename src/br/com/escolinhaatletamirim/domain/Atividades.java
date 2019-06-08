package br.com.escolinhaatletamirim.domain;

public class Atividades {
	private long codigo;
	private int atividades;
	private Professores professores;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getAtividades() {
		return atividades;
	}

	public void setAtividades(int atividades) {
		this.atividades = atividades;
	}

	public Professores getProfessores() {
		return professores;
	}

	public void setProfessores(Professores professores) {
		this.professores = professores;
	}

}
