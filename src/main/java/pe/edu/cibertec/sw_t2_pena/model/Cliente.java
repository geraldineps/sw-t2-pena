package pe.edu.cibertec.sw_t2_pena.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;
    private String nombrecli;
    private String apellidoscli;
    private String correo;
    private String direccion;
    private String telefono;
    private String dni;
}