package data;
//orig
import entities.*;

import java.sql.*;
import java.util.ArrayList;

public class DataInstalacion {
	
	public ArrayList<Instalacion> getAll(){

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Instalacion> inst = new ArrayList<>();
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id_instalacion, nom_instalacion, desc_instalacion, importe from instalacion");
	
			if(rs!=null) {
				while(rs.next()) {
					Instalacion i = new Instalacion();
				    i.setId_instalacion(rs.getInt("id_instalacion"));
				    i.setNom_instalacion(rs.getString("nom_instalacion"));
					i.setDesc_instalacion(rs.getString("desc_instalacion"));
					i.setImporte(rs.getDouble("importe"));
			
					
					inst.add(i);
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
		
		
		return inst;
	}
	
/*	public Instalacion getByUser(Persona per) {
		DataRol dr = new DataRol();
		Persona p = null;//
		PreparedStatement stmt = null;//
		ResultSet rs = null;//
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado from persona where email=? and password=?"
					);
			stmt.setString(1, per.getEmail());
			stmt.setString(2, per.getPassword());
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				p = new Persona();
				p.setDocumento(new Documento());
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.getDocumento().setTipo(rs.getString("tipo_doc"));
				p.getDocumento().setNro(rs.getString("nro_doc"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("tel"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				//
				dr.setRoles(p);
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
		
		return p;
	} */
	
	public Instalacion getById(int idInstalacion) {
		Instalacion i = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id_instalacion, nom_instalacion, desc_instalacion, importe from instalacion where id_instalacion=?"
					);
			stmt.setInt(1, idInstalacion);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				i=new Instalacion();
				i.setId_instalacion(rs.getInt("id_instalacion"));
				i.setNom_instalacion(rs.getString("nom_instalacion"));
				i.setDesc_instalacion(rs.getString("desc_instalacion"));
				i.setImporte(rs.getDouble("importe"));
			
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
		
		return i;
	}
	
	
	
	
	
	//ALTA INSTALACION
	public void add(Instalacion i) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into instalacion(nom_instalacion, desc_instalacion, importe) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			stmt.setString(1, i.getNom_instalacion());
			stmt.setString(2, i.getDesc_instalacion());
			stmt.setDouble(3, i.getImporte());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
          if(keyResultSet!=null && keyResultSet.next()){
              i.setId_instalacion(keyResultSet.getInt(1));
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
	
	//MODIFICAR
	public void update(Instalacion i, int idInstalacion) {
		PreparedStatement stmt= null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement("update instalacion set nom_instalacion=?, desc_instalacion=?, importe=? where id_instalacion=?");
			
			stmt.setString(1, i.getNom_instalacion());
			stmt.setString(2,i.getDesc_instalacion());
			stmt.setDouble(3,i.getImporte());
			stmt.setInt(4, idInstalacion);
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
	
	//BAJA INSTALACION
	public void delete(int idInstalacion) {
		PreparedStatement stmt= null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement("delete from instalacion where id_instalacion=?");
			
			stmt.setInt(1, idInstalacion);
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
