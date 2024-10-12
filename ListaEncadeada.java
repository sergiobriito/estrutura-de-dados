public class ListaEncadeada<T> {
    private No<T> inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void adiciona(T elemento) {
        No<T> novoNo = new No<>(elemento);
        
        if (this.inicio == null) {
            this.inicio = novoNo;
        } else {
            No<T> atual = this.inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
        this.tamanho++;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void inverter(){
        No<T> curr = inicio;
        No<T> prev = null;

        while (curr != null){
            No<T> tmp = curr.getProximo();
            curr.setProximo(prev);
            prev = curr;
            curr = tmp;
        };

        inicio = prev;
    };

    public static <T extends Comparable<T>> ListaEncadeada<T> fundeListas(ListaEncadeada<T> lista1, ListaEncadeada<T> lista2) {
        No<T> atual1 = lista1.inicio;
        No<T> atual2 = lista2.inicio;
        ListaEncadeada<T> listaResultado = new ListaEncadeada<>();
        No<T> atualResultado = null;
        while (atual1 != null && atual2 != null) {
            No<T> menorNo;
            if (atual1.getElemento().compareTo(atual2.getElemento()) <= 0) {
                menorNo = atual1;
                atual1 = atual1.getProximo();
            } else {
                menorNo = atual2;
                atual2 = atual2.getProximo();
            }

            if (listaResultado.inicio == null) {
                listaResultado.inicio = menorNo;
                atualResultado = menorNo;
            } else {
                atualResultado.setProximo(menorNo);
                atualResultado = menorNo;
            }
        }
        if (atual1 != null) {
            atualResultado.setProximo(atual1);
        } else if (atual2 != null) {
            atualResultado.setProximo(atual2);
        }

        return listaResultado;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        No<T> atual = this.inicio;
        while (atual != null) {
            builder.append(atual.getElemento());
            if (atual.getProximo() != null) {
                builder.append(", ");
            }
            atual = atual.getProximo();
        }
        builder.append("]");
        return builder.toString();
    }
}
