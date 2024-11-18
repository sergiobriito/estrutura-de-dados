import java.util.HashMap;

public class RedeSocial {
    private HashMap<String, Conta> contas;

    public RedeSocial() {
        this.contas = new HashMap<>();
    }

    public boolean criarConta(String nomeUsuario) {
        if (contas.containsKey(nomeUsuario)) {
            System.out.println("Conta com esse nome de usuário já existe");
            return false;
        }
        Conta conta = new Conta(nomeUsuario);
        contas.put(nomeUsuario, conta);
        System.out.println("Conta criada com sucesso");
        return true;
    }

    public boolean removerConta(String nomeUsuario) {
        if (!contas.containsKey(nomeUsuario)) {
            System.out.println("Conta com esse nome de usuário não existe");
            return false;
        }

        Conta conta = contas.get(nomeUsuario);
        for (Conta seguidor : conta.getSeguidores()) {
            seguidor.removerSeguindo(conta);
        }
        for (Conta seguindo : conta.getSeguindo()) {
            seguindo.removerSeguidor(conta);
        }

        contas.remove(nomeUsuario);
        System.out.println("Conta removida com sucesso");
        return true;
    }

    public boolean seguir(String seguidorNome, String seguindoNome) {
        if (!contas.containsKey(seguidorNome) || !contas.containsKey(seguindoNome)) {
            System.out.println("Contas não existe");
            return false;
        }

        Conta seguidor = contas.get(seguidorNome);
        Conta seguindo = contas.get(seguindoNome);

        seguidor.adicionarSeguindo(seguindo);
        seguindo.adicionarSeguidor(seguidor);

        System.out.println(seguidorNome + " agora segue " + seguindoNome);
        return true;
    }

    public boolean deixarDeSeguir(String seguidorNome, String seguindoNome) {
        if (!contas.containsKey(seguidorNome) || !contas.containsKey(seguindoNome)) {
            System.out.println("Contas não existe");
            return false;
        }

        Conta seguidor = contas.get(seguidorNome);
        Conta seguindo = contas.get(seguindoNome);

        seguidor.removerSeguindo(seguindo);
        seguindo.removerSeguidor(seguidor);

        System.out.println(seguidorNome + " deixou de seguir " + seguindoNome);
        return true;
    }

    public void exibirContas() {
        System.out.println("-----Contas-----");
        for (HashMap.Entry<String, Conta> contaEntry : contas.entrySet()) {
            Conta conta = contaEntry.getValue();
            System.out.println("----------");
            System.out.println("Nome de usuário: " + conta.getNomeUsuario());
            System.out.println("-----Seguindo-----");
            for (Conta seguindo : conta.getSeguindo()) {
                System.out.println(seguindo.getNomeUsuario());
            }
            System.out.println("-----Seguidores-----");
            for (Conta seguidor : conta.getSeguidores()) {
                System.out.println(seguidor.getNomeUsuario());
            }
            System.out.println("----------");
        }
    }
}