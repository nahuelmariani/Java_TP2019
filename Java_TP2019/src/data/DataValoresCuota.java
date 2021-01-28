package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.*;

public class DataValoresCuota {
	
	public ArrayList<Valores_Cuota> getAll(){
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Valores_Cuota> vcs = new ArrayList<>();
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idValoresCuota, fecha, valor from valores_cuota order by fecha desc");

			if(rs!=null) {
				while(rs.next()) {
					Valores_Cuota vc = new Valores_Cuota();
					vc.setIdValoresCuota(rs.getInt("idValoresCuota"));
					vc.setFecha(rs.getTimestamp("fecha"));
					vc.setValor(rs.getDouble("valor"));
					vcs.add(vc);
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
		
		
		return vcs;
	}
	
	public void add(Valores_Cuota vc) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into valores_cuota(fecha, valor) values(?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			stmt.setTimestamp(1, new java.sql.Timestamp(vc.getFecha().getTime()));
			stmt.setDouble(2, vc.getValor());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
          if(keyResultSet!=null && keyResultSet.next()){
              vc.setIdValoresCuota(keyResultSet.getInt(1));
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
	
	
	public Double getUltValor() {
		Valores_Cuota vc = null;
	    Statement stmt = null;
	    PreparedStatement stmt1 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs1= stmt.executeQuery("select max(fecha) fecha1 from valores_cuota where fecha <= current_date()");
			if(rs1!=null && rs1.next()) {
				vc = new Valores_Cuota();
			    //vc.setFecha(rs1.getDate("fecha1"));
			    vc.setFecha(rs1.getTimestamp("fecha1"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs1!=null) {rs1.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			
			stmt1=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select valor from valores_cuota where fecha = ?"
					);
			stmt1.setTimestamp(1, new java.sql.Timestamp(vc.getFecha().getTime()));
			rs2=stmt1.executeQuery();
			if(rs2!=null && rs2.next()) {
				vc.setValor(rs2.getDouble("valor"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs2!=null) {rs2.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vc.getValor();
	}
}
