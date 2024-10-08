package pe.edu.cibertec.sw_t2_pena.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_t2_pena.model.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    //Buscar cliente por nombre - JPA
    List<Cliente> findByNombrecliAndApellidoscli (String nombrecli, String apellidoscli);

    //Buscar cliente por email containing - JPA
    List<Cliente> findByCorreoContainingOrderByCorreoAsc(String correo);

    //Transacción para insertar un cliente nuevo
    @Transactional
    @Modifying
    @Procedure(procedureName = "InsertarCliente")
    void registrarNuevoCliente(
            @Param("nombreCli") String nombreCli,
            @Param("apellidosCli") String apellidosCli,
            @Param("correoCli") String correoCli,
            @Param("direccionCli") String direccionCli,
            @Param("telefonoCli") String telefonoCli,
            @Param("dniCli") String dniCli
    );
}