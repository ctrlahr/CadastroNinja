package JorgeLuis.CadastroNinja.Missoes;
import JorgeLuis.CadastroNinja.Ninjas.NinjaMapper;
import JorgeLuis.CadastroNinja.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //    Método para retornar todas as missões
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> ninjas = missoesRepository.findAll();
        return ninjas.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

//    Método para retornar missão por id específico
    public MissoesDTO missaoPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

//    Método criar missão
    public MissoesDTO criarMissao(MissoesDTO missaoDTO) {
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

//    Método modificar missão
    public MissoesDTO alterarMissao(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel ninjaSalvo = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoAtualizada);
        }
        return null;
    }

//    Método deletar missão
    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

    

}

