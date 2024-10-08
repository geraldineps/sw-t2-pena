package pe.edu.cibertec.sw_t2_pena.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductoDto {
    private Integer idproducto;
    private String nombreproducto;
    private Integer idcategoria;
    private String marca;
    private Double precio;
    private Integer stock;
}
