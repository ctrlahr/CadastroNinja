package JorgeLuis.CadastroNinja.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
       NinjaDTO novoNinja = ninjaService.criarNinja(ninja);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + novoNinja.getNome() + " Id: " + novoNinja.getId() + " criado com sucesso!!");
    }


//    Mostar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }


//    Procurar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<String> listarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            NinjaDTO ninjaid = ninjaService.listarNinjaPorId(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Ninja: " + ninjaid.getNome() + "\nId: " + ninjaid.getId() + "\nEmail: " + ninjaid.getEmail() + "\nImagem: " + ninjaid.getImg_url() + "\nIdade: " + ninjaid.getIdade() + "\nRank: " + ninjaid.getRank());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja " + id + " nao encontrado");
        }
    }


//    Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.alterarNinja(id, ninja);
    }


//    Deletar um ninja (REMOVE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninjaService.listarNinjaPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ninja " + id + " nao encontrado");
        } else {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja " + ninja.getNome() + " do id " + id + " Deletado com sucesso!");
        }
    }
}