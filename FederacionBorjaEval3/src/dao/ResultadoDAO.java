package dao;

import java.sql.Connection;

import entidades.Participante;

public class ResultadoDAO implements operacionesCRUD<Participante> {
	Connection conex;

	public ResultadoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean InsertarConID(Participante elemento) {
		// TODO Auto-generated method stub
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
