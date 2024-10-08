package pe.edu.cibertec.sw_t2_pena.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.sw_t2_pena.dto.ProductoDto;
import pe.edu.cibertec.sw_t2_pena.model.Producto;

@Component
public class ProductoConvert {
    public ProductoDto convertirProductoAProductoDto (Producto producto){
        return ProductoDto.builder()
                .idproducto(producto.getIdproducto())
                .nombreproducto(producto.getNombreproducto())
                .idcategoria(producto.getCategoria().getIdcategoria())
                .marca(producto.getMarca())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .build();
    }
}
