package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entidades.Participante;
import utils.ConexBD;

public class ParticipanteDAO implements operacionesCRUD<Participante> {
	Connection conex;

	public ParticipanteDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean InsertarConID(Participante e) {
		return false;

	}

	@Override
	public long InsertarSinID(Participante elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Participante buscarPorID(long idelemento) {
		// TODO Auto-generated method stub
		return null;
	}

}
