package pe.edu.cibertec.sw_t2_pena.service;

import pe.edu.cibertec.sw_t2_pena.dto.ProductoDto;
import pe.edu.cibertec.sw_t2_pena.model.Categoria;

import java.util.List;

public interface IProductoService {

    List<ProductoDto> findByCategoria(Categoria categoria);
    List<ProductoDto> findByStockBetween(int stockinicial, int stockfinal);
    List<ProductoDto> buscarProductosXMarcaYCategoria(String marca, Categoria categoria);
    List<ProductoDto> buscarProductosXPrecioMayorA(Double precio);
    List<ProductoDto> buscarProductosXMarcaYPrecio(String marca, Double precio);
    List<ProductoDto> buscarProductosXNombre(String nombre);

    void registrarProductoNuevo(ProductoDto productoDto);
    void actualizarStock(ProductoDto productoDto);
}
