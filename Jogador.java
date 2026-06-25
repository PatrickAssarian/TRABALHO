public class Jogador extends Personagem {
    private int percepcao;
    private boolean temArma;
    private int  municao;
    private int kitsMedicos;
    private boolean temBastao;
    public Jogador(int percepcao, int saude, int posicaox, int posicaoy) {
        super(5, posicaox, posicaoy);
        this.percepcao = percepcao;
        this.temArma = false;
        this.municao = 0;
        this.kitsMedicos = 0;
        this.temBastao = false;
    }

    public int getPercepcao() {
        return this.percepcao;
    }
    public void setPercepcao(int percepcao) {
        this.percepcao = percepcao;
    }
    public boolean isTemArma() { 
        return temArma;
    }
    public void setTemArma(boolean temArma) { 
        this.temArma = temArma; 
    }
    public int getMunicao() { 
        return municao; 
    }
    public void setMunicao(int municao) { 
        this.municao = municao; 
    }
    public int getKitsMedicos() { 
        return kitsMedicos; 
    }
    public void setKitsMedicos(int kitsMedicos) { 
        this.kitsMedicos = kitsMedicos; 
    }
    public boolean isTemBastao() { 
        return temBastao; 
    }
    public void setTemBastao(boolean temBastao) { 
        this.temBastao = temBastao; 
    }
    public void exibirStatusJogador(Jogador jogador) {
        IO.println("\n--- STATUS DO SOBREVIVENTE ---");
        IO.println("Vida: " + jogador.getSaude());
    
        if (jogador.isTemArma()) {
           IO.println("Arma de Dardos: [ EQUIPADA ]");
          IO.println("Munição: " + jogador.getMunicao() + " dardo(s)");
        } else {
            IO.println("Arma: [ VAZIO ]");
        }
    IO.println("------------------------------\n");
    }
}
