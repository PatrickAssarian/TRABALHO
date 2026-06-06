public class CaixaSuprimentos {
    private int posicaoX, posicaoY;
    private Itens itemGuardado;
    private Dinossauro dinossauroSurpresa;

    public CaixaSuprimentos(int posicaoX, int posicaoY, Itens itemGuardado) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.itemGuardado = itemGuardado;
        this.dinossauroSurpresa = null;//garante que não tem dinossauro surpresa
    }
    public CaixaSuprimentos(int posicaoX, int posicaoY, Dinossauro dinossauroSurpresa) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.dinossauroSurpresa = dinossauroSurpresa;
        this.itemGuardado = null;//garante que não tem item guardado
    }
    public int getPosicaoX() {
        return posicaoX;
    }
    public int getPosicaoY() {
        return posicaoY;
    }
    public Itens getItemGuardado() {
        return itemGuardado;
    }
    public Dinossauro getDinossauroSurpresa() {
        return dinossauroSurpresa;
    }
    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }
    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
}
