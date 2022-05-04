package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

import entidades.Manager;
import entidades.Metal;
import entidades.Participante;
import entidades.Responsable;
import utils.ConexBD;
import utils.Datos;

public class MetalDAO implements operacionesCRUD<Metal> {
	Connection conex;

	public MetalDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean InsertarConID(Metal m) {

		boolean ret = false;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into responsables(id, fecha, asignada) values (?,?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setLong(1, m.getId());
			java.sql.Date fechaSQL = java.sql.Date.valueOf(m.getFecha());
			pstmt.setDate(2, fechaSQL);
			pstmt.setBoolean(3, m.asignada);

			int resultadoInsercion = pstmt.executeUpdate();
			ret = (resultadoInsercion == 1);

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public long InsertarSinID(Metal m) {
		long ret = -1;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into metales(fecha,asignada) values (?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setLong(1, m.getId());
			java.sql.Date fechaSQL = java.sql.Date.valueOf(m.getFecha());
			pstmt.setDate(2, fechaSQL);
			pstmt.setBoolean(3, m.asignada);

			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id FROM metales WHERE (fecha=? AND asignada=? )";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr);

				pstmt2.setLong(1, m.getId());
				java.sql.Date fechaSQL2 = java.sql.Date.valueOf(m.getFecha());
				pstmt2.setDate(2, fechaSQL2);
				pstmt2.setBoolean(3, m.asignada);
				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long id = result.getLong("id");
					if (id != -1)
						ret = id;
				}
				result.close();
				pstmt2.close();
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
			return -1;
		}

		return ret;
	}

	@Override
	public Metal buscarPorID(long id) {
		return null;
//		Metal ret = null;
//		Connection conex = ConexBD.establecerConexion();
//		String consultaInsertStr = "select * FROM managers WHERE id=?";
//		try {
//			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
//			pstmt.setLong(1, id);
//			ResultSet result = pstmt.executeQuery();
//			while (result.next()) {
//				long idBD = result.getLong("id");
//				long idPersona = result.getLong("idpersona");
//				Time fecha = result.getTime("fecha");
//				Boolean asignada = result.getBoolean("asignada");
//				ret = new Metal();
//				ret.setId(idBD);
//				/*
//				 * ESTA PARTE LA TENGO MAL Y NOSE PORQUE YO CREO QUE SE TIENE QUE HACER ASI
//				 * ret.setFecha(fecha);
//				 */
//				ret.setPersona(Datos.buscarPersonaPorId(idPersona));
//			}
//		} catch (SQLException e) {
//			System.out.println("Se ha producido una SQLException:" + e.getMessage());
//			e.printStackTrace();
//		} catch (Exception e) {
//			System.out.println("Se ha producido una Exception:" + e.getMessage());
//			e.printStackTrace();
//		}
//		return ret;
//	}

}
}

