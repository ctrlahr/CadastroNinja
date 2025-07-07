package JorgeLuis.CadastroNinja.Missoes;
import org.hibernate.Remove;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/boasvindas")
    public String boasVindasMissoes() {
        return "Boas vindas a o cadastro de missões";
    }


    //    CRUD das missões
//     Adicionar missão (CREATE)
    @PostMapping("/criar")
    public String adicionarMissao() {
        return "Missão adicionada";
    }


//    Mostrar todas as missões (READ)
    @GetMapping("/listar")
    public String mostrarTodasMissoes() {
        return "Todas as missões";
    }


//    Procurar missão por id (READ)
    @GetMapping("/MissaoID")
    public String mostrarMissaoId() {
        return "Missão Id";
    }


//    Alterar dados da missão (UPDATE)
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão futuramente alterada";
    }


//    Remover missão (REMOVE)
    @DeleteMapping("/deletarID")
    public String deletarMissao() {
        return "Missão futuramente deletadad";
    }


}