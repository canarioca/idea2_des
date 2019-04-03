package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.UsuariosPlantillas;
import com.sorin.idea.exceptions.UsuariosPlantillasDaoException;
import com.sorin.idea.jdbc.UsuariosPlantillasDaoImpl;
import com.sorin.idea.servicios.ServicioUsuariosPlantillas;

public class ServicioUsuariosPlantillasImpl implements ServicioUsuariosPlantillas{

	@Override
	public List<UsuariosPlantillas> obtenerListadoUsuarioPlantillas(String usuario) throws UsuariosPlantillasDaoException {
		UsuariosPlantillasDaoImpl usuariosPlantillasDaoImpl = new UsuariosPlantillasDaoImpl();
		return Arrays.asList( usuariosPlantillasDaoImpl.findWhereIdUsuariosEquals( usuario ) );
	}
	
	@Override
	public void guardarUsuarioPlantilla( String usuario, int idPlantilla ) throws UsuariosPlantillasDaoException {
		UsuariosPlantillasDaoImpl usuariosPlantillasDaoImpl = new UsuariosPlantillasDaoImpl();
		UsuariosPlantillas usuariosPlantillas = new UsuariosPlantillas();
		usuariosPlantillas.setIdPlantilla( idPlantilla );
		usuariosPlantillas.setIdUsuarios( usuario );
		usuariosPlantillasDaoImpl.insert( usuariosPlantillas );
	}
}
