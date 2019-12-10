package data;
import entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.Date;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DataReserva {
	public ArrayList<Reserva> getAll(int id){

		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Reserva> res = new ArrayList<>();
		
		try {
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
				"select id_reserva, i.nom_instalacion, fecha_reserva, fecha_hora_desde, fecha_hora_hasta, fecha_cancelacion from reserva r "
				+ "inner join instalacion i on i.id_instalacion=r.id_instalacion where id_usuario=?"
				);
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				Reserva r = new Reserva();
				Instalacion i = new Instalacion();
			    r.setId_reserva(rs.getInt("id_reserva"));	 
			    
			    i = r.getInst();		 
			    i.setNom_instalacion(rs.getString(r.getInst().getNom_instalacion()));
			    r.setFecha_reserva(rs.getTimestamp("fecha_reserva"));
			    r.setFecha_hora_desde(rs.getTimestamp("fecha_hora_desde"));
			    r.setFecha_hora_hasta(rs.getTimestamp("fecha_hora_hasta"));
			    r.setFecha_cancelacion(rs.getTimestamp("fecha_cancelacion"));
				res.add(r);
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
	
		
		return res;
	}
	
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
	public void cancelar(int id) {
		PreparedStatement stmt= null;
		Date objDate = new Date();
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement("update reserva set fecha_cancelacion=? where id_reserva=?");
			
			
			
		
			stmt.setTimestamp(1, new java.sql.Timestamp(objDate.getTime()));
			stmt.setInt(2, id);
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
