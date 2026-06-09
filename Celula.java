public class Celula {
    private Dinossauro dinossauro;
    private Jogador jogador;
    private CaixaSuprimentos caixa;
    private boolean parede;

    public Celula(){
        this.dinossauro = null;
        this.jogador = null;
        this.caixa = null;
        this.parede = false;
    }

    public Dinossauro getDinossauro() {
        return dinossauro;
    }
    public void setDinossauro(Dinossauro dinossauro) {
        this.dinossauro = dinossauro;
    }
    public Jogador getJogador() {
        return jogador;
    }
    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    public CaixaSuprimentos getCaixa() {
        return caixa;
    }
    public void setCaixa(CaixaSuprimentos caixa) {
        this.caixa = caixa;
    }
    public boolean isParede() {
        return parede;
    }
    public void setParede(boolean parede) {
        this.parede = parede;
    }
}
