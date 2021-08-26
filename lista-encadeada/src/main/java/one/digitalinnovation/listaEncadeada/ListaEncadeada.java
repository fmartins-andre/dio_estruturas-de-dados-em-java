package one.digitalinnovation.listaEncadeada;

public class ListaEncadeada<T> {
    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        No<T> noAuxiliar = this.referenciaEntrada;

        for (int i = 0; i < this.size(); i++) {
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]-->";
            noAuxiliar = noAuxiliar.getProximoNo();

        }
        strRetorno += "null";

        return strRetorno;
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);

        if (this.isEmpty()) {
            this.referenciaEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = this.referenciaEntrada;
        for (int i = 0; i < this.size()-1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        noAuxiliar.setProximoNo(novoNo);
    }

    private void validaIndice (int indice ) {
        if (indice > this.size()) {
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + indice +
                    " desta lista. Esta lista só vai até o índice " + (this.size() -1) +".");
        }
    }

    private No<T> getNo(int indice) {

        this.validaIndice(indice);

        No<T> noAuxiliar = this.referenciaEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i <= indice; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noRetorno;
    }

    public T get(int indice) {
        return this.getNo(indice).getConteudo();
    }

    public T remove(int indice) {
        No<T> noRemover = this.getNo(indice);

        if (indice == 0 ) {
            this.referenciaEntrada = noRemover.getProximoNo();
        } else {
            No<T> noAnterior = this.getNo((indice -1));
            noAnterior.setProximoNo(noRemover.getProximoNo());
        }

        return noRemover.getConteudo();
    }

    public int size() {
        int tamanhoLista = 0;

        No<T> referenciaAux = this.referenciaEntrada;
        while (true) {
            if (referenciaAux != null) {
                tamanhoLista++;
                if (referenciaAux.getProximoNo() != null) {
                    referenciaAux = referenciaAux.getProximoNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return tamanhoLista;
    }

    public boolean isEmpty() {
        return this.referenciaEntrada == null;
    }
}
