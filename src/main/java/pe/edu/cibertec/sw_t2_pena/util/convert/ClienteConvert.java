package pe.edu.cibertec.sw_t2_pena.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.sw_t2_pena.dto.ClienteDto;
import pe.edu.cibertec.sw_t2_pena.model.Cliente;

@Component
public class ClienteConvert {

    public ClienteDto ConvertirClienteAClienteDto (Cliente cliente){
        return ClienteDto.builder()
                .idcliente(cliente.getIdcliente())
                .nombrecli(cliente.getNombrecli())
                .apellidoscli(cliente.getApellidoscli())
                .correo(cliente.getCorreo())
                .direccion(cliente.getDireccion())
                .telefono(cliente.getTelefono())
                .dni(cliente.getTelefono())
                .build();
    }
}