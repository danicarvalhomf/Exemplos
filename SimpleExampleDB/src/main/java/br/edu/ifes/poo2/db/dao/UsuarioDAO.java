package br.edu.ifes.poo2.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifes.poo2.db.model.Usuario;

public class UsuarioDAO extends DAOGeneric implements DAO<Usuario> {

	public Usuario create() {
		
		return new Usuario();
	}
	//CRIANDO A TABELA USUARIO
	public void criarTabela() throws ClassNotFoundException, SQLException
	{
		this.openConnection();
		
		String sql = "CREATE TABLE USUARIO " +
					 " (ID INTEGER GENERATED BY DEFAULT AS IDENTITY "+
                     " (START WITH 1, INCREMENT BY 1) NOT NULL," +
					 " NOME varchar(255) NOT NULL," +
					 " SENHA varchar(255) NOT NULL," +
					 " PRIMARY KEY (ID) )";
		
		this.execute(sql);
		
		this.closeConnection();
	}

	public void insert(Usuario obj) throws SQLException, ClassNotFoundException {
		
		this.openConnection();
		
		String sql = "INSERT INTO USUARIO (NOME, SENHA) VALUES ('"+obj.getNome()+"','"+obj.getSenha()+"')"; 
		
		int id = this.executeUpdate(sql);
		
		obj.setId(id);
		
		this.closeConnection();
		
	}

	public void update(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	public Usuario findbyID(Long id) throws ClassNotFoundException, SQLException {
		//Query para buscar o usuario
		this.openConnection();
		
		String sql = "SELECT * FROM USUARIO WHERE ID ="+id;
		
		Usuario usuario = new Usuario();
		
		ResultSet rs = this.executeQuery(sql);
		
		while (rs.next())
		{
			usuario.setId(rs.getInt("ID"));
			
			usuario.setNome(rs.getString("NOME"));
			
			usuario.setSenha(rs.getString("SENHA"));
		}
		
		
		this.closeConnection();
		
		return usuario;
	}
	public List<Usuario> findAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
