package com.camila.empleados.repositories;
import com.camila.empleados.models.EmpleadosModel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepo extends CrudRepository<EmpleadosModel, Long>{
	//ENCONTRAR MANAGER POR ID
		List<EmpleadosModel> findByManagerId(Long managerId);
		
		//MOSTRAR EL ID DEL EMPLEADO PARA BUSCAR SU GERENTE
		Optional<EmpleadosModel> findById(Long EmpleadoId);
		
}
