package pe.edu.cibertec.sw_t2_pena.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_t2_pena.dto.ClienteDto;
import pe.edu.cibertec.sw_t2_pena.dto.GenericResponseDto;
import pe.edu.cibertec.sw_t2_pena.service.IClienteService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    private final IClienteService clienteService;

    @GetMapping("/buscarPorNombreYApellido")
    public ResponseEntity<GenericResponseDto<List<ClienteDto>>> obtenerClientesXNomYApe(
            @RequestParam("nombrecli") String nombrecli,
            @RequestParam("apellidoscli") String apellidoscli
    ){
        List<ClienteDto> clienteDtoList = clienteService.findByNombrecliAndApellidoscli(nombrecli,apellidoscli);
        if (clienteDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ClienteDto>>builder()
                    .correcto(false)
                    .mensaje("No existe clientes")
                    .build(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ClienteDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de clientes")
                    .respuesta(clienteDtoList).build(), HttpStatus.OK);
        }
    }


    @GetMapping("/buscarPorCorreo")
    public ResponseEntity<GenericResponseDto<List<ClienteDto>>> obtenerClientesXCorreo(
            @RequestParam("correo") String correo
    ){
        List<ClienteDto> clienteDtoList = clienteService.findByCorreoContainingOrderByCorreoAsc(correo);
        if (clienteDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ClienteDto>>builder()
                    .correcto(false)
                    .mensaje("No existe cliente")
                    .build(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ClienteDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de clientes por correo ordenados de forma ascendente")
                    .respuesta(clienteDtoList).build(), HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<GenericResponseDto<String>> RegistrarCliente (
            @RequestBody ClienteDto clienteDto
    ){
        try {
            clienteService.registrarCliente(clienteDto);
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(true).mensaje("Cliente registrado correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(false).mensaje("Cliente no registrado")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}

