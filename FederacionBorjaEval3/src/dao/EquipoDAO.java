package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Equipo;
import entidades.Manager;
import entidades.DatosPersona;
import utils.ConexBD;
import utils.Datos;

public class EquipoDAO implements operacionesCRUD<Equipo> {
	Connection conex;

	public EquipoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Equipo a) {

		return false;
	}

	@Override
	public long insertarSinID(Equipo e) {
		return -1;
	}

	/// Examen 10 ejercicio 10
	@Override
	public Equipo buscarPorID(long id) {

		return null;
	}

	@Override
	public Collection<Equipo> buscarTodos() {
		List<Equipo> todos = new ArrayList<>();
		String consultaInsertStr = "select * FROM equipos";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Equipo equipo;
				long idBD = result.getLong("id");
				long idManager = result.getLong("idmanager");
				int anioincripcion = result.getInt("anioincripcion");
				String nombre = result.getString("nombre");
				equipo = new Equipo();
				equipo.setId(idBD);
				ManagerDAO m = new ManagerDAO();
				Manager m1 = m.buscarPorID(idManager);
				equipo.setManager(m1);
				equipo.setAnioinscripcion(anioincripcion);
				equipo.setNombre(nombre);
				todos.add(equipo);
			}
			if (conex != null)
				conex.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return todos;
	}

	@Override
	public boolean modificar(Equipo elemento) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

	@Override
	public boolean eliminar(Equipo elemento) {
		// TODO Esbozo de método generado automáticamente
		return false;
	}

}
