public class Jogador extends Personagem {
    private int saude;

    public Jogador(int saude, int posicaox, int posicaoy) {
        super(5, posicaox, posicaoy);
        this.saude = saude;
    }

    public int getPercepcao() {
        return saude;
    }
    public void setPercepcao(int percepcao) {
        this.saude = percepcao;
    }
}
