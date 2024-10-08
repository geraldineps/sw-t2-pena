package pe.edu.cibertec.sw_t2_pena.service.implementacion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_t2_pena.dto.ClienteDto;
import pe.edu.cibertec.sw_t2_pena.model.Cliente;
import pe.edu.cibertec.sw_t2_pena.repository.ClienteRepository;
import pe.edu.cibertec.sw_t2_pena.service.IClienteService;
import pe.edu.cibertec.sw_t2_pena.util.convert.ClienteConvert;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteConvert clienteConvert;

    @Override
    public List<ClienteDto> findByNombrecliAndApellidoscli(String nombrecli, String apellidoscli) {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        for (Cliente cliente : clienteRepository.findByNombrecliAndApellidoscli(nombrecli,apellidoscli)){
            clienteDtos.add(clienteConvert.ConvertirClienteAClienteDto(cliente));
        }
        return clienteDtos;
    }


    @Override
    public List<ClienteDto> findByCorreoContainingOrderByCorreoAsc(String correo) {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        for(Cliente cliente : clienteRepository.findByCorreoContainingOrderByCorreoAsc(correo)){
            clienteDtos.add(clienteConvert.ConvertirClienteAClienteDto(cliente));
        }
        return clienteDtos;
    }

    @Override
    public void registrarCliente(ClienteDto clienteDto) {
        clienteRepository.registrarNuevoCliente(
                clienteDto.getNombrecli(),
                clienteDto.getApellidoscli(),
                clienteDto.getCorreo(),
                clienteDto.getDireccion(),
                clienteDto.getTelefono(),
                clienteDto.getDni()
        );
    }
}