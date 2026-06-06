public class Jogador extends Personagem {
    private int percepcao;

    public Jogador(int percepcao, int posicaox, int posicaoy) {
        super(5, posicaox, posicaoy);
        this.percepcao = percepcao;
    }

    public int getPercepcao() {
        return percepcao;
    }
    public void setPercepcao(int percepcao) {
        this.percepcao = percepcao;
    }
}
