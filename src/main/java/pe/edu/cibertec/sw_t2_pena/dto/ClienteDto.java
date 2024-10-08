package pe.edu.cibertec.sw_t2_pena.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClienteDto {

    private Integer idcliente;
    private String nombrecli;
    private String apellidoscli;
    private String correo;
    private String direccion;
    private String telefono;
    private String dni;
}