package JorgeLuis.CadastroNinja.Missoes;
import JorgeLuis.CadastroNinja.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

//    Método para retornar todas as missões
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

//    Método para retornar missão por id específico
    public MissoesModel missaoPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

//    Método criar missão
    public MissoesModel criarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }
}
