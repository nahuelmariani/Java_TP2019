package data;
import entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DataCuota {
	public void add(Cuota c) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into cuota(mes, anio, importe, idPersona) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			stmt.setInt(1, c.getMes());
			stmt.setInt(2,  c.getAnio());
			stmt.setDouble(3,  c.getImporte());
		    stmt.setInt(4,  c.getP().getId());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
          if(keyResultSet!=null && keyResultSet.next()){
              c.setId_cuota(keyResultSet.getInt(1));
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

	public void actualizar(int mes, Persona soc) {
		// TODO Auto-generated method stub
		PreparedStatement stmt= null;
		Date objDate = new Date();	
			try {
				stmt=FactoryConexion.getInstancia().getConn().
						prepareStatement("update cuota set fecha_pago=? where idPersona=? and mes=?");
				
				stmt.setTimestamp(1, new java.sql.Timestamp(objDate.getTime()));
				stmt.setInt(2, soc.getId());
				stmt.setInt(3, mes);
				
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

