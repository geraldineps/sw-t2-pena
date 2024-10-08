package pe.edu.cibertec.sw_t2_pena.service.implementacion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.sw_t2_pena.dto.ProductoDto;
import pe.edu.cibertec.sw_t2_pena.model.Categoria;
import pe.edu.cibertec.sw_t2_pena.model.Producto;
import pe.edu.cibertec.sw_t2_pena.repository.ProductoRepository;
import pe.edu.cibertec.sw_t2_pena.service.IProductoService;
import pe.edu.cibertec.sw_t2_pena.util.convert.ProductoConvert;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoConvert productoConvert;

    @Override
    public List<ProductoDto> findByCategoria(Categoria categoria) {
        List<ProductoDto> productoDtos = new ArrayList<>();
        for (Producto producto : productoRepository.findByCategoria(categoria)){
            productoDtos.add(productoConvert.convertirProductoAProductoDto(producto));
        }
        return productoDtos;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public List<ProductoDto> findByStockBetween(int stockinicial, int stockfinal) {
        List<ProductoDto> productoDtos = new ArrayList<>();
        for(Producto producto : productoRepository.findByStockBetween(stockinicial,stockfinal)){
            productoDtos.add(productoConvert.convertirProductoAProductoDto(producto));
        }
        return productoDtos;
    }

    @Override
    public List<ProductoDto> buscarProductosXMarcaYCategoria(String marca, Categoria categoria) {
        List<ProductoDto> productoDtos = new ArrayList<>();
        for(Producto producto : productoRepository.buscarProductosXMarcaYCategoria(marca, categoria)){
            productoDtos.add(productoConvert.convertirProductoAProductoDto(producto));
        }
        return productoDtos;
    }

    @Override
    public List<ProductoDto> buscarProductosXPrecioMayorA(Double precio) {
        List<ProductoDto> productoDtos = new ArrayList<>();
        for(Producto producto : productoRepository.buscarProductosXPrecioMayorA(precio)){
            productoDtos.add(productoConvert.convertirProductoAProductoDto(producto));
        }
        return productoDtos;
    }

    @Override
    public List<ProductoDto> buscarProductosXMarcaYPrecio(String marca, Double precio) {
        List<ProductoDto> productoDtos = new ArrayList<>();
        for(Producto producto : productoRepository.buscarProductosXMarcaYPrecio(marca,precio)){
            productoDtos.add(productoConvert.convertirProductoAProductoDto(producto));
        }
        return productoDtos;
    }

    @Override
    public List<ProductoDto> buscarProductosXNombre(String nombre) {
        List<ProductoDto> productoDtos = new ArrayList<>();
        for(Producto producto : productoRepository.buscarProductosXNombre(nombre)){
            productoDtos.add(productoConvert.convertirProductoAProductoDto(producto));
        }
        return productoDtos;
    }

    @Override
    public void registrarProductoNuevo(ProductoDto productoDto) {
        productoRepository.registrarNuevoProducto(
                productoDto.getNombreproducto(),
                productoDto.getIdcategoria(),
                productoDto.getMarca(),
                productoDto.getPrecio(),
                productoDto.getStock()
        );
    }

    @Override
    public void actualizarStock(ProductoDto productoDto) {
        productoRepository.ActualizarStock(
                productoDto.getIdproducto(),
                productoDto.getStock()
        );
    }
}
