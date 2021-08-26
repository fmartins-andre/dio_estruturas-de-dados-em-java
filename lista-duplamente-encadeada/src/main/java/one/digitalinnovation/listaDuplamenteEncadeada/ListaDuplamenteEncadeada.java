package one.digitalinnovation.listaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada<T> {
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;


    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void add(T element) {
        NoDuplo<T> novoNo = new NoDuplo<>(element);
        novoNo.setNoProximo(null);
        novoNo.setNoPrevio(this.ultimoNo);

        if (this.primeiroNo == null) {
            this.primeiroNo = novoNo;
        }

        if (this.ultimoNo != null) {
            this.ultimoNo.setNoProximo(novoNo);
        }

        this.ultimoNo = novoNo;
        this.tamanhoLista++;
    }

    public void add(int index, T element) {
        NoDuplo<T> noAuxiliar = this.getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(element);
        novoNo.setNoProximo(noAuxiliar);

        if (novoNo.getNoProximo() != null) {
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        } else {
            novoNo.setNoPrevio(this.ultimoNo);
            this.ultimoNo = novoNo;
        }

        if (index == 0) {
            this.primeiroNo = novoNo;
        } else {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }

        this.tamanhoLista++;

    }

    @Override
    public String toString() {
        String strRetorno = "";

        NoDuplo<T> noAuxiliar = this.primeiroNo;

        for (int i= 0; i < this.size(); i++) {
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]-->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += "null";

        return strRetorno;
    }

    public void remove(int index) {

        if (index < 0 ||  index > this.size()) {
//            throw new IndexOutOfBoundsException("Índice inexistente");
            return;
        }

        if (index == 0){
            this.primeiroNo = this.primeiroNo.getNoProximo();

            if (this.primeiroNo != null) {
                this.primeiroNo.setNoPrevio(null);
            }
        } else {
            NoDuplo<T> noAuxiliar = this.getNo(index);
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());

            if (noAuxiliar != this.ultimoNo) {
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            } else {
                this.ultimoNo = noAuxiliar.getNoPrevio();
            }
        }

        this.tamanhoLista--;
    }

    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAuxiliar = this.primeiroNo;

        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();

        }

        return noAuxiliar;
    }

    public int size() {
        return tamanhoLista;
    }
}
