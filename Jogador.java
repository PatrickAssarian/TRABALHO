public class Jogador extends Personagem {
    private int percepcao;
    public Jogador(int percepcao, int saude, int posicaox, int posicaoy) {
        super(5, posicaox, posicaoy);
        this.percepcao = percepcao;
    }

    public int getPercepcao() {
        return this.percepcao;
    }
    public void setPercepcao(int percepcao) {
        this.percepcao = percepcao;
    }
}
