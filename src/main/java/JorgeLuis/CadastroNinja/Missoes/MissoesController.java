package JorgeLuis.CadastroNinja.Missoes;
import JorgeLuis.CadastroNinja.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesService missoesService;

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
    public ResponseEntity<String> adicionarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO missaoCriada =  missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + missaoCriada.getNome() + " Id: " + missaoCriada.getId() + " criado com sucesso!!");
    }


//    Mostrar todas as missões (READ)
    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes() {
        return missoesService.listarMissoes();
    }


//    Procurar missão por "id" (READ)
    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id) {
        return missoesService.missaoPorId(id);
    }


//    Alterar dados da missão ("UPDATE")
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao) {
        return missoesService.alterarMissao(id, missao);
    }

//    Remover missão (REMOVE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        MissoesDTO missao = missoesService.missaoPorId(id);
        if (missoesService.missaoPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão " + id + " Não encontrada");
        } else if (missoesService.missaoPorId(id).getNinjas() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A Missão " + missao.getNome() + " Id: " + id + " está sendo feita por um ninja, impossível deletar!");
        } else {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão " + missao.getNome() + " Id " + id + " Deletada com sucesso!");
        }
    }


}