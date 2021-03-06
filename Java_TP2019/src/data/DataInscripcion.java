package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Actividad;
import entities.Inscripcion;
import entities.Instalacion;
import entities.Persona;
import entities.Reserva;


public class DataInscripcion {
	//ALTA INSCRIPCION
	public void add(Inscripcion i) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into inscripcion(id_actividad,id_usuario, confirmada) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
//			stmt.setTimestamp(1, new java.sql.Timestamp(r.getFecha_hora_desde().getTime()));
//			System.out.println("fecha util:" + r.getFecha_hora_desde().getTime()); //Imprime los milisegundos desde 1-1-1970
//			System.out.println("fecha sql:" + new java.sql.Timestamp(r.getFecha_hora_desde().getTime()));
//			stmt.setTimestamp(2, new java.sql.Timestamp(r.getFecha_hora_hasta().getTime()));
			System.out.println("id act: "+i.getAct().getId_actividad());
			stmt.setInt(1, i.getAct().getId_actividad());
			stmt.setInt(2, i.getPer().getId());
			stmt.setBoolean(3, i.getConfirmada());
			/*
			stmt.setDate(1, (java.sql.Date) r.getFecha_hora_desde());
			stmt.setDate(2, (java.sql.Date) r.getFecha_hora_hasta());
			*/
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
          if(keyResultSet!=null && keyResultSet.next()){
              i.setId_inscripcion(keyResultSet.getInt(1));
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
	public void update(Inscripcion i) {
		PreparedStatement stmt= null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement("update inscripcion set confirmada=? where id_actividad=? and id_usuario=?");
			stmt.setBoolean(1, true);
			stmt.setInt(2, i.getAct().getId_actividad());
			stmt.setInt(3, i.getPer().getId());
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
	
	public void delete(Inscripcion i) {
		PreparedStatement stmt= null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement("delete from inscripcion where id_actividad=? and id_usuario=?");
			
			stmt.setInt(1, i.getAct().getId_actividad());
			stmt.setInt(2, i.getPer().getId());
			stmt.executeUpdate();
			System.out.println(i.getAct().getId_actividad() + ", "+ i.getPer().getId());
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
	
	public boolean validarExistencia(Persona p, Actividad a){
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Boolean existe = false;
		//ArrayList<Inscripcion> act = new ArrayList<>();
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from inscripcion where id_actividad=? and id_usuario=?");
			stmt.setInt(1, a.getId_actividad());
			stmt.setInt(2, p.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				existe = true;
				System.out.println("existe");
			} else {
				existe = false;
				System.out.println("no existe");
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
		
		
		return existe;
	}
	
	
	//VER SI ES CORRECTO
	public ArrayList<Persona> verInscriptos(Actividad a){

		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Persona> per = new ArrayList<>();
		
		try {
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
				"select p.nombre, p.apellido, p.id\r\n" + 
				"from persona p\r\n" + 
				"inner join inscripcion i on i.id_usuario = p.id\r\n" + 
				"where i.id_actividad = ? ;"
				);
		stmt.setInt(1, a.getId_actividad());
		rs=stmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				Persona p = new Persona();		
				p.setId(rs.getInt("p.id"));
				p.setNombre(rs.getString("p.nombre"));
				p.setApellido(rs.getString("p.apellido"));
				per.add(p);
			}
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
			
		return per;
	}
	
	public ArrayList<Actividad> getAll(int id){

		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Actividad> act = new ArrayList<>();
		
		try {
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
				"select a.id_actividad, a.nom_actividad, a.importe_adicional, a.desc_actividad\r\n" + 
				"from actividad a\r\n" + 
				"inner join inscripcion i on i.id_actividad = a.id_actividad\r\n" + 
				"where i.id_usuario = ?"
				);
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				
				Actividad a = new Actividad();
				
				a.setId_actividad(rs.getInt("a.id_actividad"));
				a.setNom_actividad(rs.getString("a.nom_actividad"));
			    a.setDesc_actividad(rs.getString("a.desc_actividad"));
			    a.setImporte_adicional(rs.getDouble("importe_adicional"));
			  
			   			    
				act.add(a);
			}
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
		
		return act;
	}
}
