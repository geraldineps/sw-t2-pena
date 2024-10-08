package pe.edu.cibertec.sw_t2_pena.service;

import pe.edu.cibertec.sw_t2_pena.dto.EmpleadoDto;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoDto> buscarEmpleadosXNombreOApellido(String nombreemp, String apellidosemp);

    List<EmpleadoDto> buscarEmpleadosXDNIDiferenteA(String dniemp);
}