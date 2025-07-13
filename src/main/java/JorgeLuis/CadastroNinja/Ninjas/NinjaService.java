package JorgeLuis.CadastroNinja.Ninjas;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

@Service
public class NinjaService {

    private NinjasRepository ninjaRepository;

    public NinjaService(NinjasRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //    Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }


//    Listar ninja por Id
    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

//    Cadastrar um ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

//    Atualizar informações de um ninja

//    Forma que eu fiz:
/*    public NinjaModel alterarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }*/


//    Como o fiasco fez
    public NinjaModel alterarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }

        return null;
    }


//    Deletar um ninja
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }



}
