package JorgeLuis.CadastroNinja.Missoes;
import org.hibernate.Remove;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //    Rotas
    @GetMapping("/boasvindas")
    public String boasVindasMissoes() {
        return "Boas vindas a o cadastro de missões";
    }


    //    CRUD das missões
//     Adicionar missão (CREATE)
    @PostMapping("/criar")
    public MissoesModel adicionarMissao(@RequestBody MissoesModel missao) {
        return missoesService.criarMissao(missao);
    }


//    Mostrar todas as missões (READ)
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }


//    Procurar missão por id (READ)
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id) {
        return missoesService.missaoPorId(id);
    }


//    Alterar dados da missão (UPDATE)
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão futuramente alterada";
    }

//    Remover missão (REMOVE)
    @DeleteMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissao(id);
        return "Missão deletada com sucesso!";
    }


}