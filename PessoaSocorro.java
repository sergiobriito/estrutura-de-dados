public class PessoaSocorro implements Comparable<PessoaSocorro>{
    String nome;
    SenhaProSoc senha;
    
    public PessoaSocorro(String nome, SenhaProSoc senha){
        this.nome = nome;
        this.senha = senha;
    };

    public int getSenha(){
        return this.senha == SenhaProSoc.VERMELHO ? 1 : this.senha == SenhaProSoc.AMARELO ? 2 : 3;
    };

    @Override
    public int compareTo(PessoaSocorro outraPessoa) {
        return Integer.compare(this.getSenha(), outraPessoa.getSenha());

    }
}

