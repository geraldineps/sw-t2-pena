package pe.edu.cibertec.sw_t2_pena.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_t2_pena.model.Categoria;
import pe.edu.cibertec.sw_t2_pena.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    //Buscar Productos por categoria - JPA
    List<Producto> findByCategoria(Categoria categoria);

    //Buscar con Between productos en stock - JPA
    List<Producto> findByStockBetween(int stockinicial, int stockfinal);

    //Buscar producto por Marca y Categoria - JPQL
    @Query(value = "SELECT p FROM Producto p WHERE p.marca = :marca and p.categoria = :categoria")
    List<Producto> buscarProductosXMarcaYCategoria(
            @Param("marca") String marca,
            @Param("categoria") Categoria categoria
    );

    //Buscar producto por Precio mayor a un valor - JPQL
    @Query(value = "SELECT p FROM Producto p WHERE p.precio > :precio")
    List<Producto> buscarProductosXPrecioMayorA(
            @Param("precio") Double precio
    );

    //Buscar productos por marca y precio mayor a un valor - SQL NATIVO
    @Query(value = "SELECT * FROM Producto p WHERE p.marca = :marca AND p.precio > :precio", nativeQuery = true)
    List<Producto> buscarProductosXMarcaYPrecio(
            @Param("marca") String marca,
            @Param("precio") Double precio
    );

    //Buscar productos por nombre - SQL NATIVO
    @Query(value = "SELECT * FROM Producto p WHERE p.nombreproducto LIKE %:nombre%", nativeQuery = true)
    List<Producto> buscarProductosXNombre(@Param("nombre") String nombre);


    //Transacción para insertar un producto nuevo
    @Transactional
    @Modifying
    @Procedure(procedureName = "InsertarProducto")
    void registrarNuevoProducto(
            @Param("nombreProducto") String nombreProducto,
            @Param("idCategoria") int idCategoria,
            @Param("marca") String marca,
            @Param("precio") Double precio,
            @Param("stock") int stock
    );


    //Transacción para actualizar stock
    @Transactional
    @Modifying
    @Procedure(procedureName = "ActualizarStockProducto")
    void ActualizarStock(
            @Param("idProducto") int idProducto,
            @Param("nuevoStock") int nuevoStock
    );

}
