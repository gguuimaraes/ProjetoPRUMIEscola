package entidade;

/**
 *
 * @author gguui
 */
public class EDiscente extends EPessoa {
    private String nomePai;
    private String nomeMae;

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    @Override
    public String toString() {
        return "EPessoa{" 
                + "matricula=" + matricula
                + ", CPF=" + CPF 
                + ", nome=" + nome 
                + ", dataNascimento=" + dataNascimento 
                + ", telefone=" + telefone 
                + ", celular=" + celular 
                + ", email=" + email 
                + ", endereco=" + endereco
                + ", sexo=" + sexo 
                + ", nomePai=" + nomePai
                + ", nomeMae=" + nomeMae
                + '}';
    }
    
    
}
