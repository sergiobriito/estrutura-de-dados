public class Pessoa implements Comparable<Pessoa>{
    String nome;
    Senha senha;
    
    public Pessoa(String nome, Senha senha){
        this.nome = nome;
        this.senha = senha;
    };

    public int getSenha(){
        return this.senha == Senha.PRIORIDADE ? 1 : 2;
    };

    @Override
    public int compareTo(Pessoa outraPessoa) {
        return Integer.compare(this.getSenha(), outraPessoa.getSenha());

    }
}
