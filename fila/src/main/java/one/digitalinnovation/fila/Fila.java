package one.digitalinnovation.fila;

public class Fila<T> {
    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public void enqueue(T obj) {
        No<T> novoNo = new No(obj);
        novoNo.setRefNo(refNoEntradaFila);
        this.refNoEntradaFila = novoNo;
    }

    public T first() {
        if (!this.isEmpty()) {
            No primeiroNo = this.refNoEntradaFila;

            while (true) {
                if (primeiroNo.getRefProximoNo() != null) {
                    primeiroNo = primeiroNo.getRefProximoNo();
                } else {
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public T dequeue() {
        if (!this.isEmpty()) {
            No primeiroNo = this.refNoEntradaFila;
            No noAuxiliar = this.refNoEntradaFila;

            while (true) {
                if (primeiroNo.getRefProximoNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefProximoNo();
                } else {
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    @Override
    public String toString() {
        String stringRetorno = "";

        No noAuxiliar = this.refNoEntradaFila;

        if (!this.isEmpty()) {

            while (true) {
                stringRetorno += "[No{objeto=" + noAuxiliar + "}] ---> ";
                if(noAuxiliar.getRefProximoNo() != null) {
                    noAuxiliar = noAuxiliar.getRefProximoNo();
                } else {
                    stringRetorno += "null";
                    break;
                }
            }

        } else {
            stringRetorno = "null";
        }

        return stringRetorno;
    }

    public boolean isEmpty() {
        return this.refNoEntradaFila == null;
    }
}
