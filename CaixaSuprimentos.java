public class CaixaSuprimentos {
    private final Itens itemGuardado;
    private final Dinossauro dinossauroSurpresa;
    
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
