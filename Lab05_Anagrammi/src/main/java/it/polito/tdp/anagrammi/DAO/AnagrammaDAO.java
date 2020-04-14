package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.DAO.ConnectDB;

public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {
		
		String sql="SELECT * FROM parola WHERE nome=?";
		String result = null;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				result=rs.getString("nome");
			}
			
			conn.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		if(result.equals(null))
			return false;
		return true;
	}
}
