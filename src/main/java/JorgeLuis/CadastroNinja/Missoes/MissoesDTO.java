package JorgeLuis.CadastroNinja.Missoes;
import JorgeLuis.CadastroNinja.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.SpringVersion;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninjas;

}




