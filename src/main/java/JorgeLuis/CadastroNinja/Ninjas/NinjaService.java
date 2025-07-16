package JorgeLuis.CadastroNinja.Ninjas;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjasRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjasRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //    Listar todos os ninjas
    public List<NinjaDTO> listarNinjas() {

        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());

    }

//    Listar ninja por Id
    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

//    Cadastrar um ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

//    Atualizar informações de um ninja

//    Forma que eu fiz:
/*    public NinjaModel alterarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }*/


//    Como o fiasco fez
    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }


//    Deletar um ninja
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }



}
