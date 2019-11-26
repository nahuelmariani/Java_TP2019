package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.Date;

import entities.Reserva;

public class DataReserva {

	
	//ALTA RESERVA
	public void add(Reserva r) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into reserva(fecha_hora_desde, fecha_hora_hasta,id_instalacion,id_usuario) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			stmt.setTimestamp(1, new java.sql.Timestamp(r.getFecha_hora_desde().getTime()));
			System.out.println("fecha util:" + r.getFecha_hora_desde().getTime()); //Imprime los milisegundos desde 1-1-1970
			System.out.println("fecha sql:" + new java.sql.Timestamp(r.getFecha_hora_desde().getTime()));
			stmt.setTimestamp(2, new java.sql.Timestamp(r.getFecha_hora_hasta().getTime()));
			System.out.println("id inst: "+r.getInst().getId_instalacion());
			stmt.setInt(3, r.getInst().getId_instalacion());
			stmt.setInt(4, r.getPer().getId());
			/*
			stmt.setDate(1, (java.sql.Date) r.getFecha_hora_desde());
			stmt.setDate(2, (java.sql.Date) r.getFecha_hora_hasta());
			*/
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
          if(keyResultSet!=null && keyResultSet.next()){
              r.setId_reserva(keyResultSet.getInt(1));
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
	
	
	
	//BAJA RESERVA
	/*public void delete(int idInstalacion) {
		PreparedStatement stmt= null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement("update from instalacion where id_instalacion=?");
			
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
  } */
	

	
	
	
}
