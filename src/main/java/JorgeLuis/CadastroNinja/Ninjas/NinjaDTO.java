package JorgeLuis.CadastroNinja.Ninjas;
import JorgeLuis.CadastroNinja.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String img_url;
    private int idade;
    private MissoesModel missoes;
    private String rank;

}
