package com.camila.empleados.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.camila.empleados.repositories.GerenteRepo;
import com.camila.empleados.models.EmpleadosModel;

@Controller
public class MainController {

	//INYECCION DE DEPENDENCIAS
	@Autowired
		private final GerenteRepo gerenteRepo;
		public MainController(GerenteRepo gRe) {
			this.gerenteRepo = gRe;
		}
		
		@GetMapping("/search/{managerId}")
		public String mostrarEmpleados(@PathVariable("managerId") Long managerId,
				Model viewModel) {
			List<EmpleadosModel> mostrarEmpleado = gerenteRepo.findByManagerId(managerId);
			viewModel.addAttribute("empleado", mostrarEmpleado);
			return "";
		}
		
		@GetMapping("/mostrar/{empleadoId}")
		public String mostrarGerente(@PathVariable("empleadoId") Long empleadoId,
				Model viewModel) {
			Optional<EmpleadosModel> mostrarUnEmpleado = gerenteRepo.findById(empleadoId);
			if(mostrarUnEmpleado != null) {
				EmpleadosModel suGerente = mostrarUnEmpleado.get();
				viewModel.addAttribute("mostrarGerente", suGerente);
			}
			return "";
		}
}
