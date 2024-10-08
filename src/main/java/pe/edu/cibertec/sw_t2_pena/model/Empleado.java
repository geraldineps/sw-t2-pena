package pe.edu.cibertec.sw_t2_pena.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idempleado;
    private String nombreemp;
    private String apellidosemp;
    private String correoemp;
    private String direccionemp;
    private String telefonoemp;
    private String dniemp;
}
