public class Main{
    public static void main(String[] args) {
        RedeSocial redeSocial = new RedeSocial();

        redeSocial.criarConta("Alice");
        redeSocial.criarConta("Bob");
        redeSocial.criarConta("Carol");
        redeSocial.criarConta("David");

        redeSocial.seguir("Alice", "Bob");
        redeSocial.seguir("Alice", "Carol");
        redeSocial.seguir("Bob", "Alice");
        redeSocial.seguir("Bob", "David");
        redeSocial.seguir("Carol", "Alice");
        redeSocial.seguir("Carol", "David");
        redeSocial.seguir("David", "Carol");

        redeSocial.exibirContas();


        redeSocial.deixarDeSeguir("Alice", "Bob");
        redeSocial.removerConta("David");

        redeSocial.exibirContas();
        
    }
};