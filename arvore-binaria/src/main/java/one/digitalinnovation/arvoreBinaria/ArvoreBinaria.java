package one.digitalinnovation.arvoreBinaria;

public class ArvoreBinaria<T extends Comparable<T>> {
    private enum TipoExibir { INORDER, PREORDER, POSORDER};
    private BinNo<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T conteudo) {
        BinNo<T> novoNo = new BinNo<>(conteudo);
        this.raiz = this.inserir(this.raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> noAtual, BinNo<T> novoNo) {
        if (noAtual == null) {
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(noAtual.getConteudo()) < 0 ){
            noAtual.setNoEsq(this.inserir(noAtual.getNoEsq(), novoNo));
        } else {
            noAtual.setNoDir(this.inserir(noAtual.getNoDir(), novoNo));
        }
        return noAtual;
    }

    public void exibirInOrdem() {
        System.out.println("\nExibindo InOrder");
        this.exibir(TipoExibir.INORDER, this.raiz);
    }

    public void exibirPosOrdem() {
        System.out.println("\nExibindo PosOrder");
        this.exibir(TipoExibir.POSORDER, this.raiz);
    }

    public void exibirPreOrdem() {
        System.out.println("\nExibindo PreOrder");
        this.exibir(TipoExibir.PREORDER, this.raiz);
    }

    private void exibir(TipoExibir tipo, BinNo<T> noAtual) {
        if (noAtual != null) {
            if (tipo == TipoExibir.INORDER) {
                this.exibir(tipo, noAtual.getNoEsq());
                System.out.print(noAtual.getConteudo() + ", ");
                this.exibir(tipo, noAtual.getNoDir());
            } else if (tipo == TipoExibir.PREORDER) {
                System.out.print(noAtual.getConteudo() + ", ");
                this.exibir(tipo, noAtual.getNoEsq());
                this.exibir(tipo, noAtual.getNoDir());
            } else {
                this.exibir(tipo, noAtual.getNoEsq());
                this.exibir(tipo, noAtual.getNoDir());
                System.out.print(noAtual.getConteudo() + ", ");
            }
        }
    }

    public void remover(T conteudo) {
        try {
            BinNo<T> noAtual = this.raiz;
            BinNo<T> noPai = null;
            BinNo<T> noFilho = null;
            BinNo<T> noTemp = null;

            while (noAtual != null && !noAtual.getConteudo().equals(conteudo)) {
                noPai = noAtual;
                if (conteudo.compareTo(noAtual.getConteudo()) < 0) {
                    noAtual = noAtual.getNoEsq();
                } else {
                    noAtual = noAtual.getNoDir();
                }
            }

            if (noAtual == null) {
                System.out.println("\nConteudo nao encontrado. Bloco Try.");
            }

            if (noPai == null) {

                if (noAtual.getNoDir() == null ) {
                    this.raiz = noAtual.getNoEsq();
                } else if (noAtual.getNoEsq() == null ) {
                    this.raiz = noAtual.getNoDir();
                } else {

                    for (
                            noTemp = noAtual, noFilho = noAtual.getNoEsq();
                            noFilho.getNoDir() != null;
                            noTemp = noFilho, noFilho = noFilho.getNoEsq()
                    ) {
                        if (noAtual != noFilho.getNoEsq()) {
                            noTemp.setNoDir(noFilho.getNoEsq());
                            noFilho.setNoEsq(this.raiz.getNoEsq());
                        }
                    }
                    noFilho.setNoDir(this.raiz.getNoDir());
                    this.raiz = noFilho;
                }

            } else if (noAtual.getNoDir() == null) {

                if (noPai.getNoEsq() == noAtual) {
                    noPai.setNoEsq(noAtual.getNoEsq());
                } else {
                    noPai.setNoDir(noAtual.getNoEsq());
                }

            } else if (noAtual.getNoEsq() == null) {

                if (noPai.getNoEsq() == noAtual) {
                    noPai.setNoEsq(noAtual.getNoDir());
                } else {
                    noPai.setNoDir(noAtual.getNoDir());
                }

            } else {

                for (
                        noTemp = noAtual, noFilho = noAtual.getNoEsq();
                        noFilho.getNoDir() != null;
                        noTemp = noFilho, noFilho = noFilho.getNoDir()
                ) {
                    if (noFilho != noAtual.getNoEsq()) {
                        noTemp.setNoDir(noFilho.getNoEsq());
                        noFilho.setNoEsq(noAtual.getNoEsq());
                    }
                    noFilho.setNoDir(noAtual.getNoDir());
                    if (noPai.getNoEsq() == noAtual) {
                        noPai.setNoEsq(noFilho);
                    } else {
                        noPai.setNoDir(noFilho);
                    }
                }

            }

        }catch (NullPointerException erro) {
            System.out.println("\nConteudo nao encontrado. Bloco Catch.");
        }
    }
}
