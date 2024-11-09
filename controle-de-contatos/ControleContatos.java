import java.io.*;
import java.util.*;

public class ControleContatos {
    private TreeMap<String, Contato> contatosNomeTelefone;
    private TreeMap<String, Contato> contatosTelefoneNome;
    private HashSet<String> nomes;
    private HashSet<String> telefones;
    private String caminhoArquivo = "contatos.txt";

    public ControleContatos() {
        this.contatosNomeTelefone = new TreeMap<>();
        this.contatosTelefoneNome = new TreeMap<>();
        this.nomes = new HashSet<>();
        this.telefones = new HashSet<>();
        carregarContatos();
    }

    public Optional<String> buscarPorNome(String nome) {
        Contato contato = contatosNomeTelefone.get(nome);
        return Optional.ofNullable(contato != null ? contato.getTelefone() : null);
    }

    public Optional<String> buscarPorTelefone(String telefone) {
        Contato contato = contatosTelefoneNome.get(telefone);
        return Optional.ofNullable(contato != null ? contato.getNome() : null);
    }

    public String adicionarContato(Contato contato) {
        if (telefones.contains(contato.getTelefone())) {
            return "Telefone já cadastrado na lista de contatos";
        }

        String nome = contato.getNome();
        int i = 0;

        while (nomes.contains(nome)) {
            nome = contato.getNome() + "_" + (++i);
        }

        contato.setNome(nome);
        contatosNomeTelefone.put(nome, contato);
        contatosTelefoneNome.put(contato.getTelefone(), contato);
        nomes.add(nome);
        telefones.add(contato.getTelefone());

        salvarContatosNoArquivo();

        return "Contato adicionado com o nome: " + nome;
    }

    public String removerContato(String telefone) {
        Contato contato = contatosTelefoneNome.remove(telefone);
        if (contato == null) {
            return "Telefone não está cadastrado na lista de contatos";
        }
        contatosNomeTelefone.remove(contato.getNome());
        nomes.remove(contato.getNome());
        telefones.remove(telefone);

        salvarContatosNoArquivo();

        return "Contato removido com sucesso";
    }

    public void listarContatos() {
        contatosNomeTelefone.forEach((nome, contato) -> 
            System.out.println("Nome: " + nome + " | Telefone: " + contato.getTelefone() + " | Email: " + contato.getEmail())
        );
    }

    private void salvarContatosNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Contato contato : contatosNomeTelefone.values()) {
                writer.write(contato.getNome() + "," + contato.getTelefone() + "," + contato.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void carregarContatos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {
                    Contato contato = new Contato(dados[0], dados[1], dados[2]);
                    contatosNomeTelefone.put(contato.getNome(), contato);
                    contatosTelefoneNome.put(contato.getTelefone(), contato);
                    nomes.add(contato.getNome());
                    telefones.add(contato.getTelefone());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
