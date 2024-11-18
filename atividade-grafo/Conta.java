import java.util.LinkedList;

class Conta {
    private String nomeUsuario;
    private LinkedList<Conta> seguidores;
    private LinkedList<Conta> seguindo;

    public Conta(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.seguidores = new LinkedList<>();
        this.seguindo = new LinkedList<>();
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public LinkedList<Conta> getSeguidores() {
        return seguidores;
    }

    public LinkedList<Conta> getSeguindo() {
        return seguindo;
    }

    public void adicionarSeguidor(Conta conta) {
        if (!seguidores.contains(conta)) {
            seguidores.add(conta);
        }
    }

    public void adicionarSeguindo(Conta conta) {
        if (!seguindo.contains(conta)) {
            seguindo.add(conta);
        }
    }

    public void removerSeguidor(Conta conta) {
        seguidores.remove(conta);
    }

    public void removerSeguindo(Conta conta) {
        seguindo.remove(conta);
    }
}