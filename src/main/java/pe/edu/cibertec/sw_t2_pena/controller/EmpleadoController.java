package pe.edu.cibertec.sw_t2_pena.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.sw_t2_pena.dto.EmpleadoDto;
import pe.edu.cibertec.sw_t2_pena.dto.GenericResponseDto;
import pe.edu.cibertec.sw_t2_pena.service.IEmpleadoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {

    private final IEmpleadoService empleadoService;

    @GetMapping("/buscarPorNombreOApellido")
    public ResponseEntity<GenericResponseDto<List<EmpleadoDto>>> obtenerEmpleadoONomYApe(
            @RequestParam("nombreemp") String nombreemp,
            @RequestParam("apellidosemp") String apellidosemp
    ){
        List<EmpleadoDto> empleadoDtoList = empleadoService.buscarEmpleadosXNombreOApellido(nombreemp,apellidosemp);
        if (empleadoDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<EmpleadoDto>>builder()
                    .correcto(false)
                    .mensaje("No existe empleados")
                    .build(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<EmpleadoDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de empleados")
                    .respuesta(empleadoDtoList).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/buscarPorDNI")
    public ResponseEntity<GenericResponseDto<List<EmpleadoDto>>> obtenerEmpleadoXDNI(
            @RequestParam("dniemp") String dniemp
    ){
        List<EmpleadoDto> empleadoDtoList = empleadoService.buscarEmpleadosXDNIDiferenteA(dniemp);
        if (empleadoDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<EmpleadoDto>>builder()
                    .correcto(false)
                    .mensaje("No existe empleados")
                    .build(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<EmpleadoDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de empleados por DNI")
                    .respuesta(empleadoDtoList).build(), HttpStatus.OK);
        }
    }
}