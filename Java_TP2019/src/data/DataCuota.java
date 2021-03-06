package data;
import entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class DataCuota {
	public void add(Cuota c) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							" insert into cuota(mes, anio, idPersona) values (?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			stmt.setInt(1, c.getMes());
			stmt.setInt(2,  c.getAnio());
		    //stmt.setDouble(3, c.getImporte());
			stmt.setInt(3, c.getPer().getId());
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

	//AL LLAMAR A LA TABLA VALORES_CUOTA ERA CORRECTO PONER EL
	//METODO EN DATAVALORESCUOTA.JAVA
	
	/*public Double getUltValor() {
		Valores_Cuota vc = null;
	    Statement stmt = null;
	    PreparedStatement stmt1 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs1= stmt.executeQuery("select max(fecha) fecha1 from valores_cuota");
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
			System.out.println(vc.getFecha());
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
	}*/
	
	public void actualizar(Cuota cuota, Persona soc) {
		// TODO Auto-generated method stub
		PreparedStatement stmt= null;
		Date objDate = new Date();	
			try {
				stmt=FactoryConexion.getInstancia().getConn().
						prepareStatement("update cuota set fecha_pago=?, importe=? where idPersona=? and mes=? and anio=?");
				
				stmt.setTimestamp(1, new java.sql.Timestamp(objDate.getTime()));
				stmt.setDouble(2,cuota.getImporte());
				stmt.setInt(3, soc.getId());
				stmt.setInt(4, cuota.getMes());
				stmt.setInt(5, cuota.getAnio());
				
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
	
	public Cuota buscarCuota(Cuota cuota, Persona soc) {
		Cuota c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idcuota, mes, anio, importe, fecha_pago idPersona from cuota where fecha_pago is NULL and mes=? and anio=? and idPersona=?"
					);
			stmt.setInt(1, cuota.getMes());
			stmt.setInt(2, cuota.getAnio());
			stmt.setInt(3, soc.getId());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				Persona p = new Persona();
				c=new Cuota();
				c.setId_cuota(rs.getInt("idcuota"));
				c.setMes(rs.getInt("mes"));
				c.setAnio(rs.getInt("anio"));
				c.setImporte(rs.getDouble("importe"));
				
				c.setPer(p);
				
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
		
		return c;
	}
	
	public ArrayList<Cuota> getByAnio(int anio) {
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 ArrayList<Cuota> cuo = new ArrayList<>();
		 
		 try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select c.idcuota, c.mes, c.anio, c.importe, c.fecha_pago, c.idPersona,"
					+ " p.nombre, p.apellido, p.tipo_doc, p.nro_doc from cuota c right join persona p on c.idPersona=p.id"
					+ " where c.anio=? and p.rol=?"
					);
		
			stmt.setInt(1, anio);
			stmt.setString(2, "Socio");
			rs=stmt.executeQuery();
			if(rs!=null) {
			    while(rs.next()) {
					Persona p = new Persona();
					Cuota c = new Cuota();
					Documento d = new Documento();
					c.setId_cuota(rs.getInt("c.idcuota"));
					c.setMes(rs.getInt("c.mes"));
					c.setAnio(rs.getInt("c.anio"));
					c.setImporte(rs.getDouble("c.importe"));
					p.setId(rs.getInt("c.idPersona"));
					p.setNombre(rs.getString("p.nombre"));
					p.setApellido(rs.getString("p.apellido"));
					d.setTipo(rs.getString("p.tipo_doc"));
					d.setNro(rs.getString("p.nro_doc"));
					p.setDocumento(d);
					c.setPer(p);
					cuo.add(c);	
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
		
		return cuo;
	}
	
	public ArrayList<Cuota> getByAnioPer(int anio, Persona per) {
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 ArrayList<Cuota> cuo = new ArrayList<>();
		 
		 try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select c.idcuota, c.mes, c.anio, c.fecha_pago, c.idPersona,"
					+ " p.nombre, p.apellido, p.tipo_doc, p.nro_doc from cuota c right join persona p on c.idPersona=p.id"
					+ " where c.anio=? and p.tipo_doc=? and p.nro_doc=?"
					);
		
			stmt.setInt(1, anio);
			stmt.setString(2, per.getDocumento().getTipo());
			stmt.setString(3, per.getDocumento().getNro());
			rs=stmt.executeQuery();
			if(rs!=null) {
			    while(rs.next()) {
					Persona p = new Persona();
					Cuota c = new Cuota();
					Documento d = new Documento();
					c.setId_cuota(rs.getInt("c.idcuota"));
					c.setMes(rs.getInt("c.mes"));
					c.setAnio(rs.getInt("c.anio"));
					c.setFecha_pago(rs.getTimestamp("c.fecha_pago"));
					//c.setImporte(rs.getDouble("c.importe"));
					p.setId(rs.getInt("c.idPersona"));
					p.setNombre(rs.getString("p.nombre"));
					p.setApellido(rs.getString("p.apellido"));
					d.setTipo(rs.getString("p.tipo_doc"));
					d.setNro(rs.getString("p.nro_doc"));
					p.setDocumento(d);
					c.setPer(p);
					cuo.add(c);	
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
		
		return cuo;
	}
	public ArrayList<Cuota> validarCuota(Persona soc) {
		 Cuota c = null;
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 ArrayList<Cuota> cuo = new ArrayList<>();
		//obtengo mes y anio actual:
		 Calendar fecha = Calendar.getInstance();
		 int mes = fecha.get(Calendar.MONTH) + 1;
		 int anio = fecha.get(Calendar.YEAR);
		 System.out.println(mes);
		 System.out.println(anio);
		 
		 try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idcuota, mes, anio, importe, fecha_pago, idPersona from cuota where fecha_pago is NULL and mes<? and anio=? and idPersona=?"
					);
		
			
			stmt.setInt(1, mes);
			stmt.setInt(2, anio);
			stmt.setInt(3, soc.getId());
			
			rs=stmt.executeQuery();
			if(rs!=null) {
			    while(rs.next()) {
					Persona p = new Persona();
					c=new Cuota();
					c.setId_cuota(rs.getInt("idcuota"));
					c.setMes(rs.getInt("mes"));
					c.setAnio(rs.getInt("anio"));
					c.setImporte(rs.getDouble("importe"));
					
					c.setPer(p);
					cuo.add(c);
					
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
		
		return cuo;
	}


}

