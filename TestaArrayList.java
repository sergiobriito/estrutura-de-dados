import java.util.ArrayList;
import java.util.Arrays;

public class TestaArrayList {
    public static void main(String[] args) {
        ArrayList<Contato> array = new ArrayList<>(Arrays.asList(
            new Contato("Contato 3","3333-3333","contato3@email.com"),
		    new Contato("Contato 2","2222-2222","contato2@email.com"),
		    new Contato("Contato 1","1111-1111","contato1@email.com")
        ));
        array.add( new Contato("Contato 4","3333-3333","contato3@email.com"));
        System.out.println(array.size());
        System.out.println("array = " + array);
        System.out.println();
        System.out.println(array.get(2));
        System.out.println(array.contains(new Contato("Contato 200","2000-2222","contato200@email.com")));
        System.out.println(array.contains(new Contato("Contato 2","2222-2222","contato2@email.com")));
        array.add(0, new Contato("Contato 5","3333-3333","contato3@email.com"));
        System.out.println(array.size());
        array.ensureCapacity(array.size()*2);
        System.out.println("Size 2x: " + array.size()*2);
        array.remove(2);
        System.out.println("array = " + array);
    }
}
