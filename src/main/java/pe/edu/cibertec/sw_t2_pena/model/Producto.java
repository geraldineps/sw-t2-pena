package pe.edu.cibertec.sw_t2_pena.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;
    private String nombreproducto;
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;
    private String marca;
    private Double precio;
    private Integer stock;

}
