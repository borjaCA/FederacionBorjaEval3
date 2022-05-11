package dao;

import java.sql.Connection;
import java.util.Collection;

import entidades.Participante;

public class ResultadoDAO implements operacionesCRUD<Participante> {
	Connection conex;

	public ResultadoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Participante elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Participante elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Participante buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Participante> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Participante elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Participante elemento) {
		// TODO Auto-generated method stub
		return false;
	}
}