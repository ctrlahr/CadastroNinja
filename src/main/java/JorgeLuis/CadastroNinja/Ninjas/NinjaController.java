package JorgeLuis.CadastroNinja.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

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
    @GetMapping("/todos")
    public String mostrarTodosNinjas() {
        return "Todos os ninjas";
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