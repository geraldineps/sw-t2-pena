package pe.edu.cibertec.sw_t2_pena.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_t2_pena.dto.GenericResponseDto;
import pe.edu.cibertec.sw_t2_pena.dto.ProductoDto;
import pe.edu.cibertec.sw_t2_pena.model.Categoria;
import pe.edu.cibertec.sw_t2_pena.service.IProductoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {


    private final IProductoService productoService;

    @GetMapping("/buscarPorCategoria")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> obtenerProductosXCategoria(
            @RequestParam("categoria") Categoria categoria
    ){
        List<ProductoDto> productoDtoList = productoService.findByCategoria(categoria);
        if (productoDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No existe productos en esta categoria")
                    .build(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de productos por Categoria")
                    .respuesta(productoDtoList).build(), HttpStatus.OK);
        }
    }


    @GetMapping("/buscarPorStock")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> obtenerProductosXStock(
            @RequestParam("stockinicial") Integer stockinicial,
            @RequestParam("stockfinal") Integer stockfinal
    ){
        List<ProductoDto> productoDtoList = productoService.findByStockBetween(stockinicial,stockfinal);
        if (productoDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No existe productos")
                    .build(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de productos por stock")
                    .respuesta(productoDtoList).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/buscarPorMarcaYCategoria")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> obtenerProductosXMarcaYCate(
            @RequestParam("marca") String marca,
            @RequestParam("categoria") Categoria categoria
    ){
        List<ProductoDto> productoDtoList = productoService.buscarProductosXMarcaYCategoria(marca, categoria);

        if (productoDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No existe productos de esta marca y categoría")
                    .build(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de productos por Marca y Categoria")
                    .respuesta(productoDtoList).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/buscarPorPrecio")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> obtenerProductosXPrecio(
            @RequestParam("precio") Double precio
    ){
        List<ProductoDto> productoDtoList = productoService.buscarProductosXPrecioMayorA(precio);
        if (productoDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No existe productos con un precio mayor a este valor")
                    .build(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de productos por precio")
                    .respuesta(productoDtoList).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/buscarPorMarcaYPrecio")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> obtenerProductosXMarcaYPrecio(
            @RequestParam("marca") String marca,
            @RequestParam("precio") Double precio
    ){
        List<ProductoDto> productoDtoList = productoService.buscarProductosXMarcaYPrecio(marca,precio);
        if (productoDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No existe productos de esta marca y precio")
                    .build(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de productos por marca y precio mayor a este valor")
                    .respuesta(productoDtoList).build(), HttpStatus.OK);
        }
    }

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<GenericResponseDto<List<ProductoDto>>> obtenerProductosXNombre(
            @RequestParam("nombre") String nombre
    ){
        List<ProductoDto> productoDtoList = productoService.buscarProductosXNombre(nombre);
        if (productoDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<ProductoDto>>builder()
                    .correcto(false)
                    .mensaje("No existe productos con este nombre")
                    .build(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<ProductoDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de productos por nombre")
                    .respuesta(productoDtoList).build(), HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<GenericResponseDto<String>> registrarProducto (
            @RequestBody ProductoDto productoDto
    ){
        try {
            productoService.registrarProductoNuevo(productoDto);
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(true).mensaje("Producto registrado correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(false).mensaje("Cliente no registrado")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<GenericResponseDto<String>> actualizarStock (
            @RequestBody ProductoDto productoDto
    ){
        try {
            productoService.actualizarStock(productoDto);
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(true).mensaje("Stock actualizado correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(false).mensaje("Stock no actualizado")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
