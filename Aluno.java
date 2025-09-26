import java.util.UUID;

public class Aluno {

    private String endereco;
    private int idade;
    private String nome;
    private UUID uuid;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndreco(String endereco){
        this.endereco = endereco;
    }

}
