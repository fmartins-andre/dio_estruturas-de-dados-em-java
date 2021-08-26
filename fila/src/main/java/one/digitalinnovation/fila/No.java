package one.digitalinnovation.fila;

public class No<T> {
    private T object;
    private No refNo;

    public No(T object) {
        this.refNo = null;
        this.object = object;
    }

    public No() {
    }

    @Override
    public String toString() {
        return object.toString();
    }

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public No getRefProximoNo() {
        return refNo;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }
}
