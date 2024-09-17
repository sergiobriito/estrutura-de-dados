import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TestaArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contato> array = new ArrayList<>();

        while (true){
            System.out.println("ArrayList - Contatos");
            System.out.println("Selecione uma opcao: ");
            System.out.println(" 1 - Adicionar contato \n 2 - Verificar quantidade de contatos \n 3 - Imprimir contatos \n 4 - Obter contato de uma posição específica \n 5 -  Verificar se existe o contato \n 6 - Adicionar contato em qualquer posição \n 7 - Duplicar tamanho do vetor \n 8 - Remover contato \n 9 - Pesquisar por nome \n 10 -  Pesquisar por e-mail \n 11 - Pesquisar por telefone \n 12 - Ordernar por Nome \n 13 - Ordernar por Email \n 14 - Ordernar por Telefone \n 0 - Sair");
            String input = sc.next();

            if (input.equals("0")){
                break;
            }else if (input.equals("14")){
                ordernarContatosPorTel(array);
                System.out.println("array = " + array);
            }else if (input.equals("13")){
                ordernarContatosPorEmail(array);
                System.out.println("array = " + array);
            }else if (input.equals("12")){
                ordernarContatosPorNome(array);
                System.out.println("array = " + array);
            }else if (input.equals("11")){
                System.out.println("Digite o telefone: ");
                String tel = sc.next();
                Contato encontradoPorTelefone = buscaPorTelefone(array, tel);
                System.out.println("Contato: " + encontradoPorTelefone);
            }else if (input.equals("10")){
                System.out.println("Digite o email: ");
                String email = sc.next();
                Contato encontradoPorEmail = buscaPorEmail(array, email);
                System.out.println("Contato: " + encontradoPorEmail);
            }else if (input.equals("9")){
                System.out.println("Digite o nome: ");
                String nome = sc.next();
                Contato encontradoPorNome = buscaPorNome(array, nome);
                System.out.println("Contato: " + encontradoPorNome);
            }else if (input.equals("8")){
                System.out.println("Digite o idx: ");
                int idx = sc.nextInt();
                array.remove(idx);
                System.out.println("array = " + array);
            }else if (input.equals("7")){
                System.out.println(array.size());
                array.ensureCapacity(array.size()*2);
                System.out.println("Size 2x: " + array.size()*2);
            }else if (input.equals("6")){
                System.out.println("Digite a posicao: ");
                int idx = sc.nextInt();
                System.out.println("Digite o nome: ");
                String nome = sc.next();
                System.out.println("Digite o telefone: ");
                String telefone = sc.next();
                System.out.println("Digite o email: ");
                String email = sc.next();
                array.add(idx, new Contato(nome,telefone,email));
                System.out.println("array = " + array);
            }else if (input.equals("5")){
                System.out.println("Digite o nome: ");
                String nome = sc.next();
                System.out.println("Digite o telefone: ");
                String telefone = sc.next();
                System.out.println("Digite o email: ");
                String email = sc.next();
                System.out.println(array.contains(new Contato(nome,telefone,email)));
            }else if (input.equals("4")){
                System.out.println("Digite o idx: ");
                int idx = sc.nextInt();
                System.out.println(array.get(idx));
            }else if (input.equals("3")){
                System.out.println("array = " + array);
                System.out.println();
            }else if (input.equals("2")){
                System.out.println(array.size());
            }else if (input.equals("1")){
                System.out.println("Digite o nome: ");
                String nome = sc.next();
                System.out.println("Digite o telefone: ");
                String telefone = sc.next();
                System.out.println("Digite o email: ");
                String email = sc.next();
                array.add(new Contato(nome,telefone,email));
                System.out.println("array = " + array);
            };
        };

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

    public static void ordernarContatosPorNome(ArrayList<Contato> array) {
        array.sort(Comparator.comparing(Contato::getNome));
    };

    public static void ordernarContatosPorEmail(ArrayList<Contato> array) {
        array.sort(Comparator.comparing(Contato::getEmail));
    };

    public static void ordernarContatosPorTel(ArrayList<Contato> array) {
        array.sort(Comparator.comparing(Contato::getTelefone));
    };

}
