public class CaixaSuprimentos {
    private Itens itemGuardado;
    private Dinossauro dinossauroSurpresa;
    
    public CaixaSuprimentos(Itens itemGuardado, Dinossauro dinossauroSurpresa) {
        this.itemGuardado = itemGuardado;
        this.dinossauroSurpresa = dinossauroSurpresa;
    }
    public Itens getItemGuardado() {
        return itemGuardado;
    }
    public Dinossauro getDinossauroSurpresa() {
        return dinossauroSurpresa;
    }
}
