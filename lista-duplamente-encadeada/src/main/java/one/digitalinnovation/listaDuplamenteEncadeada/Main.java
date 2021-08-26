package one.digitalinnovation.listaDuplamenteEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String> minhaLista = new ListaDuplamenteEncadeada<>();

        minhaLista.add("no 1");
        minhaLista.add("no 2");
        minhaLista.add("no 3");
        minhaLista.add("no 4");
        System.out.println(minhaLista);

        minhaLista.add(1, "teste 2");
        System.out.println(minhaLista);

        minhaLista.remove(10);
        System.out.println(minhaLista);

        minhaLista.add(10, "teste 10");
        System.out.println(minhaLista);
    }
}
