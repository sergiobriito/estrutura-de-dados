import java.util.ArrayList;
import java.util.Arrays;

public class TestaArrayList {
    public static void main(String[] args) {
        ArrayList<Contato> array = new ArrayList<>(Arrays.asList(
            new Contato("Contato 3","3333-3333","contato3@email.com"),
		    new Contato("Contato 2","2222-2222","contato2@email.com"),
		    new Contato("Contato 1","1111-1111","contato1@email.com")
        ));
        // Adicionar elemento ao final
        array.add(new Contato("Contato 4","3333-3333","contato3@email.com"));

        // Verificar a quantidade de elementos
        System.out.println(array.size());

        // Imprimir elementos do vetor
        System.out.println("array = " + array);
        System.out.println();

        // Obter elemento de uma posição do vetor
        System.out.println(array.get(2));

        // Verificar se elemento existe no vetor
        System.out.println(array.contains(new Contato("Contato 200","2000-2222","contato200@email.com")));
        System.out.println(array.contains(new Contato("Contato 2","2222-2222","contato2@email.com")));
        
        // Adicionar elemento em qualquer posição do vetor
        array.add(0, new Contato("Contato 5","3333-3333","contato3@email.com"));

        // Duplicar o tamanho do vetor
        System.out.println(array.size());
        array.ensureCapacity(array.size()*2);
        System.out.println("Size 2x: " + array.size()*2);

        // Remover elemento do vetor
        array.remove(2);
        System.out.println("array = " + array);

        /// Pesquisar por nome
        Contato encontradoPorNome = buscaPorNome(array, "Contato 3");
        System.out.println("Contato: " + encontradoPorNome);

        // Pesquisar por e-mail
        Contato encontradoPorEmail = buscaPorEmail(array, "contato3@email.com");
        System.out.println("Contato: " + encontradoPorEmail);

        // Pesquisar por telefone
        Contato encontradoPorTelefone = buscaPorTelefone(array, "1111-1111");
        System.out.println("Contato: " + encontradoPorTelefone);
    
    }

    public static Contato buscaPorNome(ArrayList<Contato> array, String nome) {
        for (Contato contato : array) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public static Contato buscaPorEmail(ArrayList<Contato> array, String email) {
        for (Contato contato : array) {
            if (contato.getEmail().equalsIgnoreCase(email)) {
                return contato;
            }
        }
        return null;
    }

    public static Contato buscaPorTelefone(ArrayList<Contato> array, String telefone) {
        for (Contato contato : array) {
            if (contato.getTelefone().equals(telefone)) {
                return contato;
            }
        }
        return null;
    }
}
