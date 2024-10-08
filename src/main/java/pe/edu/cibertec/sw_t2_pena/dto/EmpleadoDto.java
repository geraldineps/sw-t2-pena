package pe.edu.cibertec.sw_t2_pena.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmpleadoDto {

    private Integer idempleado;
    private String nombreemp;
    private String apellidosemp;
    private String correoemp;
    private String direccionemp;
    private String telefonoemp;
    private String dniemp;
}
