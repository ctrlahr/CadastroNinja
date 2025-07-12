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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }


//    Mostar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }


//    Procurar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id) {
        return ninjaService.listarNinjaPorId(id);
    }


//    Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar")
    public NinjaModel alterarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.alterarNinja(ninja);
    }


//    Deletar um ninja (REMOVE)
    @DeleteMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
        return "Ninja deletado com sucesso!!";
    }
}