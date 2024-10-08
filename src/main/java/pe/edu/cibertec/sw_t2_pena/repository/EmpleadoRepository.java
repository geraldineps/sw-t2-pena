package pe.edu.cibertec.sw_t2_pena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_t2_pena.model.Empleado;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {

    //Buscar Empleados por Nombre o Apellido - JPQL
    @Query(value = "SELECT e FROM Empleado e WHERE e.nombreemp=:nombreemp OR e.apellidosemp=:apellidosemp")
    List<Empleado> buscarEmpleadosXNombreOApellido(
            @Param("nombreemp") String nombreemp,
            @Param("apellidosemp") String apellidosemp
    );

    //Buscar Empleados por DNI diferente A - JPQL
    @Query(value = "SELECT e FROM Empleado e WHERE e.dniemp NOT LIKE %:dniemp%")
    List<Empleado> buscarEmpleadosXDNIDiferenteA(
            @Param("dniemp") String dniemp
    );


}