package br.fiap.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.modelo.bean.Perfil;
import br.fiap.modelo.conexao.ConnectionFactory;

public class PerfilDAO extends DAO {
	
	public PerfilDAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}
	
	public List<Perfil> listar() {
		List<Perfil> list = new ArrayList<Perfil>();
		
		String sql = "SELECT * FROM TBL_JAVA_PERFIL ORDER BY perfil";
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Perfil perfil = new Perfil();
				perfil.setIdPerfil(rs.getInt("id_perfil"));
				perfil.setPerfil(rs.getString("nome"));
				list.add(perfil);
			}
			
		} catch (SQLException e) {
			System.out.println("ERRO AO LISTAR PERFIL\n " + e);
		}
		
		
		return list;
	}
	
	
	
}
