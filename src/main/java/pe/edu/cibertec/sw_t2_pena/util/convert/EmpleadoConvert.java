package pe.edu.cibertec.sw_t2_pena.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.sw_t2_pena.dto.EmpleadoDto;
import pe.edu.cibertec.sw_t2_pena.model.Empleado;

@Component
public class EmpleadoConvert {

    public EmpleadoDto ConvertirEmpleadoAEmpleadoDto (Empleado empleado){
        return EmpleadoDto.builder()
                .idempleado(empleado.getIdempleado())
                .nombreemp(empleado.getNombreemp())
                .apellidosemp(empleado.getApellidosemp())
                .correoemp(empleado.getCorreoemp())
                .direccionemp(empleado.getDireccionemp())
                .telefonoemp(empleado.getTelefonoemp())
                .dniemp(empleado.getDniemp())
                .build();
    }
}