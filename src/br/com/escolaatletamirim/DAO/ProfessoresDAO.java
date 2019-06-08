package br.com.escolaatletamirim.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.escolaatletamirim.factory.ConexaoFactory;
import br.com.escolinhaatletamirim.domain.Professores;

public class ProfessoresDAO {

	public void salvar(Professores p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Professores ");
		sql.append("(cpf,");
		sql.append("nome,");
		sql.append("telefone,");
		sql.append("datanascimento,");
		sql.append("dataadmissao)");
		sql.append("VALUES (?,?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, p.getCpf());
		comando.setString(2, p.getNome());
		comando.setInt(3, p.getTelefone());
		comando.setInt(4, p.getDatanascimento());
		comando.setInt(5, p.getDataadmissao());

		comando.executeUpdate();

	}

	public void excluir(Professores p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM Professores ");
		sql.append("WHERE idProfessores = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, p.getCodigo());

		comando.executeUpdate();
	}

	public void editar(Professores p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE Professores ");
		sql.append("SET cpf = ? ");
		sql.append("WHERE idProfessores = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, p.getCpf());
		comando.setLong(2, p.getCodigo());
		comando.executeUpdate();
	}

	public Professores buscaPorCodigo(Professores p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo,cpf ");
		sql.append("FROM professores ");
		sql.append("WHERE idProfessores = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(5, p.getCodigo());

		ResultSet resultado = comando.executeQuery();
		Professores retorno = null;

		if (resultado.next()) {
			retorno = new Professores();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setCpf(resultado.getInt("cpf"));
		}

		return retorno;
	}

	public ArrayList<Professores> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idProfessores, cpf, nome, telefone, datanascimento, dataadmissao ");
		sql.append("FROM professores ");
		sql.append("ORDER BY cpf ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		ArrayList<Professores> lista = new ArrayList<Professores>();

		while (resultado.next()) {
			Professores p = new Professores();
			p.setCodigo(resultado.getLong("idProfessores"));
			p.setCpf(resultado.getInt("cpf"));
			p.setNome(resultado.getString("nome"));
			p.setTelefone(resultado.getInt("telefone"));
			p.setDatanascimento(resultado.getInt("datanascimento"));
			p.setDataadmissao(resultado.getInt("dataadmissao"));

			lista.add(p);
		}

		return lista;
	}

	public static void main(String[] args) {

		/*
		 * Professores p1 = new Professores(); p1.setCpf(222222222);
		 * p1.setNome("Norte"); p1.setTelefone(44444544); p1.setDatanascimento(20);
		 * p1.setDataadmissao(19);
		 * 
		 * ProfessoresDAO pdao = new ProfessoresDAO();
		 */

		/*
		 * try { pdao.salvar(p1);
		 * 
		 * System.out.println("Salvo Graças a Deus");
		 * 
		 * } catch (SQLException e) { System.out.println("Aff"); e.printStackTrace(); }
		 */

		/*
		 * Professores p1 = new Professores(); p1.setCodigo(14);
		 * 
		 * ProfessoresDAO pdao = new ProfessoresDAO();
		 * 
		 * try { pdao.excluir(p1); System.out.println("deletao"); } catch (SQLException
		 * e) { System.out.println("!deletado"); e.printStackTrace(); }
		 */

		/*
		 * Professores p1 = new Professores(); p1.setCodigo(5); p1.setCpf(333333);
		 * 
		 * ProfessoresDAO pdao = new ProfessoresDAO();
		 * 
		 * try { pdao.editar(p1); System.out.println("editado"); } catch (SQLException
		 * e) { System.out.println("deu ruim"); e.printStackTrace(); }
		 */

		/*
		 * Professores p1 = new Professores(); p1.setCodigo(1111111);
		 * 
		 * Professores p2 = new Professores(); p2.setNome("Fabio");
		 * 
		 * ProfessoresDAO pdao = new ProfessoresDAO();
		 * 
		 * try { pdao.salvar(p1); pdao.salvar(p2);
		 * System.out.println("Salvo Graças a Deus");
		 * 
		 * } catch (SQLException e) { System.out.println("Aff"); e.printStackTrace(); }
		 */

		ProfessoresDAO pdao = new ProfessoresDAO();

		try {

			ArrayList<Professores> lista = pdao.listar();

			for (Professores p : lista) {
				System.out.println("Resultado " + p);
			}

		} catch (SQLException e) {
			System.out.println("Aff");
			e.printStackTrace();
		}

	}

}
