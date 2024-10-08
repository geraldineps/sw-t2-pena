package pe.edu.cibertec.sw_t2_pena.service;

import pe.edu.cibertec.sw_t2_pena.dto.ClienteDto;

import java.util.List;

public interface IClienteService {

    List<ClienteDto> findByNombrecliAndApellidoscli (String nombrecli, String apellidoscli);

    List<ClienteDto> findByCorreoContainingOrderByCorreoAsc(String correo);

    void registrarCliente (ClienteDto clienteDto);
}