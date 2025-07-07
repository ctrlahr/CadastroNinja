package JorgeLuis.CadastroNinja.Ninjas;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

//    Injeção de dependência do service para realizar as queries do JPA
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

//    Rotas
    @GetMapping("/boasvindas")
    public String boasVindasNinja() {
        return "Boas vindas a o cadastro de ninjas";
    }

//    Criação do CRUD
//    Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Um ninja vai ser criado, no futuro :)";
    }


//    Mostar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }


//    Procurar ninja por id (READ)
    @GetMapping("ninjaID")
    public String MostrarNinjaPorId() {
        return "Ninja por Id";
    }


//    Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Ninja futuramente alterado :)";
    }


//    Deletar um ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja futuramente deletado por id :)";
    }



}