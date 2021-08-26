package one.digitalinnovation.pilha;

public class Pilha {
    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public No top() {
        return this.refNoEntradaPilha;
    }

    public void push(No novoNo) {
        No refAuxiliar = this.refNoEntradaPilha;
        this.refNoEntradaPilha = novoNo;
        this.refNoEntradaPilha.setRefNo(refAuxiliar);
    }

    @Override
    public String toString() {
        String stringRetorno = "\n\n==========";
        stringRetorno += "\n   Pilha";
        stringRetorno += "\n----------\n";
        No noAuxiliar = this.refNoEntradaPilha;

        while (true) {
            if (noAuxiliar != null) {
                stringRetorno += "[No{dado=" + noAuxiliar.getDado() +"}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            } else {
                break;
            }
        }
        stringRetorno += "==========\n\n";
        return stringRetorno;
    }

    public No pop() {
        if (!this.isEmpty()) {
            No noPoped = this.top();
            this.refNoEntradaPilha = this.refNoEntradaPilha.getRefNo();
            return noPoped;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.refNoEntradaPilha == null;
    }
}
