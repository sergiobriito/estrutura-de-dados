public class DesafioListaEncadeada {

    public static void main(String[] args) {
        ListaEncadeada<Integer> ListaEncadeada = new ListaEncadeada<>();

        //Exercicio 01
        ListaEncadeada.adiciona(10);
        ListaEncadeada.adiciona(20);
        ListaEncadeada.adiciona(30);
        ListaEncadeada.adiciona(40);
        ListaEncadeada.adiciona(50);
        System.out.println(ListaEncadeada);

        //Exercicio 02
        ListaEncadeada.inverter();
        System.out.println(ListaEncadeada);

        //Exercicio 03
        ListaEncadeada<Integer> lista1 = new ListaEncadeada<>();
        lista1.adiciona(1);
        lista1.adiciona(3);
        lista1.adiciona(5);

        ListaEncadeada<Integer> lista2 = new ListaEncadeada<>();
        lista2.adiciona(2);
        lista2.adiciona(4);
        lista2.adiciona(6);

        ListaEncadeada<Integer> listaFundida = ListaEncadeada.fundeListas(lista1, lista2);

        System.out.println(listaFundida); 

    }
    
}
