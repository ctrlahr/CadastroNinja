package JorgeLuis.CadastroNinja.Ninjas;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
