package data;
import entities.*;

import java.sql.*;
import java.util.ArrayList;

public class DataActividad {
	
	public ArrayList<Actividad> getAll(){
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Actividad> act = new ArrayList<>();
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id_actividad, nom_actividad, desc_actividad, cupo, importe_adicional from actividad");
	
			if(rs!=null) {
				while(rs.next()) {
					Actividad a = new Actividad();
				    a.setId_actividad(rs.getInt("id_actividad"));
				    a.setNom_actividad(rs.getString("nom_actividad"));
					a.setDesc_actividad(rs.getString("desc_actividad"));
					a.setImporte_adicional(rs.getDouble("importe_adicional"));
					a.setCupo(rs.getInt("cupo"));
			
					
					act.add(a);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return act;
	}

public Actividad getById(int idActividad) {
	Actividad a= null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	try {
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
				"select id_actividad, nom_actividad, desc_actividad, importe_adicional from actividad where id_actividad=?"
				);
		stmt.setInt(1, idActividad);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			a=new Actividad();
			a.setId_actividad(rs.getInt("id_actividad"));
			a.setNom_actividad(rs.getString("nom_actividad"));
			a.setDesc_actividad(rs.getString("desc_actividad"));
			a.setImporte_adicional(rs.getDouble("importe_adicional"));
		
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return a;
}

//ALTA ACTIVIDAD
	public void add(Actividad a) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into actividad(nom_actividad, desc_actividad, importe_adicional) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			stmt.setString(1, a.getNom_actividad());
			stmt.setString(2, a.getDesc_actividad());
			stmt.setDouble(3, a.getImporte_adicional());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
        if(keyResultSet!=null && keyResultSet.next()){
            a.setId_actividad(keyResultSet.getInt(1));
        }

			
		}  catch (SQLException e) {
        e.printStackTrace();
		} finally {
        try {
            if(keyResultSet!=null)keyResultSet.close();
            if(stmt!=null)stmt.close();
            FactoryConexion.getInstancia().releaseConn();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
}
	
	//MODIFICAR ACTIVIDAD
	public void update(Actividad a, int idActividad) {
		PreparedStatement stmt= null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement("update actividad set nom_actividad=?, desc_actividad=?, importe_adicional=? where id_actividad=?");
			
			stmt.setString(1,a.getNom_actividad());
			stmt.setString(2,a.getDesc_actividad());
			stmt.setDouble(3,a.getImporte_adicional());
			stmt.setInt(4, idActividad);
			stmt.executeUpdate();
			
		}  catch (SQLException e) {
          e.printStackTrace();
		} finally {
          try {
              if(stmt!=null)stmt.close();
              FactoryConexion.getInstancia().releaseConn();
          } catch (SQLException e) {
          	e.printStackTrace();
          }
		}
  }
	
	//BAJA ACTIVIDAD
	public void delete(int idActividad) {
		PreparedStatement stmt= null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement("delete from actividad where id_actividad=?");
			
			stmt.setInt(1, idActividad);
			stmt.executeUpdate();
		}  catch (SQLException e) {
          e.printStackTrace();
		} finally {
          try {
              if(stmt!=null)stmt.close();
              FactoryConexion.getInstancia().releaseConn();
          } catch (SQLException e) {
          	e.printStackTrace();
          }
		}
  }
	

}

	
