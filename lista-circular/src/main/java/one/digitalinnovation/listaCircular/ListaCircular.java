package one.digitalinnovation.listaCircular;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    @Override
    public String toString() {
        String strRetorno = "ListaCircular{";

        No<T> noAuxiliar = this.cauda;

        for (int i = 0; i < this.tamanhoLista; i++) {
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]-->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += this.isEmpty() ? "[]}" : " <<CIRCULAR>> [No{conteudo=" + noAuxiliar.getConteudo() + "}]...}";
        return strRetorno;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);

        if (this.tamanhoLista == 0) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
        } else {
            novoNo.setNoProximo(this.cauda);
            this.cauda = novoNo;
        }
        this.cabeca.setNoProximo(this.cauda);
        this.tamanhoLista++;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void remove(int index) {
        if (index >= this.tamanhoLista) throw new IndexOutOfBoundsException("Índice maior que a lista.");

        No<T> noAuxiliar = this.cauda;
        if (index==0){
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);
        } else if (index == 1) {
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        } else {
            for (int i = 0 ; i < index -1; i++) {
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
        }

        this.tamanhoLista--;
    }

    private No<T> getNo(int index) {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("A lista está vazia");
        if (index == 0) return this.cauda;

        No<T> noAuxiliar = this.cauda;
        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        return noAuxiliar;
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0;
    }

    public int size() {
        return this.tamanhoLista;
    }


}
