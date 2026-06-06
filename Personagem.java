public class Personagem {
    private int saude,posicaox, posicaoy;

    public Personagem(int saude, int posicaox, int posicaoy) {
        this.saude = saude;
        this.posicaox = posicaox;
        this.posicaoy = posicaoy;
    }

    // Getters and Setters

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getPosicaox() {
        return posicaox;
    }

    public void setPosicaox(int posicaox) {
        this.posicaox = posicaox;
    }

    public int getPosicaoy() {
        return posicaoy;
    }

    public void setPosicaoy(int posicaoy) {
        this.posicaoy = posicaoy;
    }
}
