package pe.edu.cibertec.sw_t2_pena.service.implementacion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_t2_pena.dto.EmpleadoDto;
import pe.edu.cibertec.sw_t2_pena.model.Empleado;
import pe.edu.cibertec.sw_t2_pena.repository.EmpleadoRepository;
import pe.edu.cibertec.sw_t2_pena.service.IEmpleadoService;
import pe.edu.cibertec.sw_t2_pena.util.convert.EmpleadoConvert;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmpleadoService implements IEmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoConvert empleadoConvert;


    @Override
    public List<EmpleadoDto> buscarEmpleadosXNombreOApellido(String nombreemp, String apellidosemp) {
        List<EmpleadoDto> empleadoDtos = new ArrayList<>();
        for (Empleado empleado : empleadoRepository.buscarEmpleadosXNombreOApellido(nombreemp,apellidosemp)){
            empleadoDtos.add(empleadoConvert.ConvertirEmpleadoAEmpleadoDto(empleado));
        }
        return empleadoDtos;
    }

    @Override
    public List<EmpleadoDto> buscarEmpleadosXDNIDiferenteA(String dniemp) {
        List<EmpleadoDto> empleadoDtos = new ArrayList<>();
        for (Empleado empleado : empleadoRepository.buscarEmpleadosXDNIDiferenteA(dniemp)){
            empleadoDtos.add(empleadoConvert.ConvertirEmpleadoAEmpleadoDto(empleado));
        }
        return empleadoDtos;
    }
}
