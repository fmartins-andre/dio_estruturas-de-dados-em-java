package one.digitalinnovation.listaCircular;

public class Main {
    public static void main(String[] args) {
        ListaCircular<String> minhaLista = new ListaCircular<>();
        minhaLista.add("no 1");
        System.out.println(minhaLista);

        minhaLista.remove(0);
        System.out.println(minhaLista);

        minhaLista.add("no 2");
        minhaLista.add("no 3");
        minhaLista.add("no 4");
        minhaLista.add("no 5");
        System.out.println(minhaLista);

        System.out.println("Índice 3: \"" + minhaLista.get(3) + "\"");
        System.out.println("Índice 7: \"" + minhaLista.get(7) + "\"");

        System.out.println("----- PERCORRENDO NÓS -----");
        for (int i = 0; i < 20; i++) {
            System.out.println("Índice " + i + ": \"" + minhaLista.get(i) + "\"");
        }

    }
}
