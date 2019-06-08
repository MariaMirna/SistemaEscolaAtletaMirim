package br.com.escolaatletamirim.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.faces.bean.ViewScoped;

import br.com.escolaatletamirim.DAO.ProfessoresDAO;
import br.com.escolinhaatletamirim.domain.Professores;

@ManagedBean(name = "MBProfessores")
@ViewScoped
public class ProfessoresBean {

	private Professores professores;
	private ListDataModel<Professores> itens;

	public Professores getProfessores() {
		return professores;
	}

	public void setProfessores(Professores professores) {
		this.professores = professores;
	}

	public ListDataModel<Professores> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Professores> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			ProfessoresDAO pdao = new ProfessoresDAO();
			ArrayList<Professores> lista = pdao.listar();
			itens = new ListDataModel<Professores>(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararNovo() {
		professores = new Professores();
	}

	public void novo() {

		try {
			ProfessoresDAO pdao = new ProfessoresDAO();
			pdao.salvar(professores);
	
			ArrayList<Professores> lista = pdao.listar();
			itens = new ListDataModel<Professores>(lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
