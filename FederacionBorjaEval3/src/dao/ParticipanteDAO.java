package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import entidades.Participante;
import utils.ConexBD;

public class ParticipanteDAO implements operacionesCRUD<Participante> {
	Connection conex;

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

	@Override
	public Participante buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
