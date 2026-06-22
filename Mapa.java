import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class Mapa {
    private final int tamanho;
    private final Celula[][] grade;

    public Mapa(int tamanho) {
        this.tamanho = tamanho;
        this.grade = new Celula[tamanho][tamanho];
        
        for(int i = 0; i < tamanho; i++){
            for(int j = 0; j < tamanho; j++){
                this.grade[i][j] = new Celula();
            }
        }
    }
    public void gerarParedesAleatorias(){
        int numerodeParedes = ThreadLocalRandom.current().nextInt(50,101);
        int paredesColocadas = 0;
        while(paredesColocadas < numerodeParedes){
            int x = ThreadLocalRandom.current().nextInt(0, tamanho);
            int y = ThreadLocalRandom.current().nextInt(0, tamanho);
            if(!grade[x][y].isParede()){
                grade[x][y].setParede(true);
                paredesColocadas++;
            }
        }
    }
    public void gerarDinossauros(){
        int numerodeVelociraptors = 2;
        int numeroTroodonte = 6;
        int numeroCompsognato = 1;
        int dinossauroCompsognato = 0;
        int dinossaurosVelociraptor = 0;
        int dinossaurosTroodonte = 0;


        while(dinossaurosVelociraptor < numerodeVelociraptors){
            int x = ThreadLocalRandom.current().nextInt(0, tamanho);
            int y = ThreadLocalRandom.current().nextInt(0, tamanho);
            if (grade[x][y].getDinossauro() == null && !grade[x][y].isParede()) {
                Velociraptor velociraptor = new Velociraptor(x, y);
                grade[x][y].setDinossauro(velociraptor);
                dinossaurosVelociraptor++;
            }
            
        }
        while (dinossaurosTroodonte < numeroTroodonte) {
            int x = ThreadLocalRandom.current().nextInt(0, tamanho);
            int y = ThreadLocalRandom.current().nextInt(0, tamanho);
            if (grade[x][y].getDinossauro() == null && !grade[x][y].isParede()) {
                Troodonte troodonte = new Troodonte(x, y);
                grade[x][y].setDinossauro(troodonte);
                dinossaurosTroodonte++;
            }
        }
        while (dinossauroCompsognato < numeroCompsognato) {
            int x = ThreadLocalRandom.current().nextInt(0, tamanho);
            int y = ThreadLocalRandom.current().nextInt(0, tamanho);
            if(grade[x][y].getDinossauro() == null && !grade[x][y].isParede()) {
                Compsognato compsognato = new Compsognato(x, y);
                grade[x][y].setDinossauro(compsognato);
                dinossauroCompsognato++;
           }
        }
    }
    public void ImprimirMapa(){
        IO.println("     ___ MAPA DO PARQUE ___");
        for(int i = 0; i < tamanho; i++){
            for(int j = 0; j < tamanho; j++){
                if(grade[i][j].isParede()){
                    IO.print(" [#] ");
                } else if(grade[i][j].getJogador() != null){
                    IO.print(" [P] ");
                } else if(grade[i][j].getDinossauro() != null){
                    Dinossauro dino = grade[i][j].getDinossauro();
                    if (dino instanceof Velociraptor) {
                        IO.print(" [V] ");
                    }
                    else if (dino instanceof Troodonte) {
                        IO.print(" [T] ");
                    }
                    else if (dino instanceof TiranossauroRex){
                        IO.print(" [R] ");
                    }
                    else if (dino instanceof Compsognato){
                        IO.print(" [C] ");
                    }
                } else if(grade[i][j].getCaixa() != null){
                    IO.print(" [X] ");
                } else {
                    IO.print(" [ ] ");
                }
            }
            IO.println();
            IO.println();
        }
    }
    public void gerarCaixa(){
        int totalCaixa = 4;
        int caixasColocadas = 0;
        int x, y;

        while(caixasColocadas < totalCaixa){

            
            Compsognato compsognato = new Compsognato(-1, -1);
            CaixaSuprimentos Caixa = new CaixaSuprimentos(new KitMedico(), null);
            CaixaSuprimentos bastao = new CaixaSuprimentos(new BastaoEletrico(), null);
            CaixaSuprimentos arma1 = new CaixaSuprimentos(new ArmaDeDardos(), null);
            CaixaSuprimentos arma2 = new CaixaSuprimentos(new ArmaDeDardos(), compsognato);

            ArrayList<CaixaSuprimentos> estoqueDeCaixa = new ArrayList<>();
            estoqueDeCaixa.add(Caixa);
            estoqueDeCaixa.add(bastao);
            estoqueDeCaixa.add(arma1);
            estoqueDeCaixa.add(arma2);
            while (caixasColocadas < totalCaixa){
                x = ThreadLocalRandom.current().nextInt(0, tamanho);
                y = ThreadLocalRandom.current().nextInt(0, tamanho);
                if(!grade[x][y].isParede() && grade[x][y].getDinossauro() == null && grade[x][y].getCaixa() == null){
                    CaixaSuprimentos caixaDaVez = estoqueDeCaixa.get(caixasColocadas);
                    if(caixaDaVez.getDinossauroSurpresa() != null){
                        caixaDaVez.getDinossauroSurpresa().setPosicaox(x);
                        caixaDaVez.getDinossauroSurpresa().setPosicaoy(y);
                    }
                    grade[x][y].setCaixa(caixaDaVez);
                    caixasColocadas++;
                }
            }  
        }
    }
    public Jogador gerarPersonagem(){
        int personagemColocado = 0;
        Jogador jogador = null;
        while(personagemColocado < 1){
            int x = ThreadLocalRandom.current().nextInt(0, tamanho);
            int y = ThreadLocalRandom.current().nextInt(0, tamanho);
            jogador = new Jogador(5, x, y);
            if(!grade[x][y].isParede() && grade[x][y].getDinossauro() == null && grade[x][y].getCaixa() == null){
                grade[x][y].setJogador(jogador);
                personagemColocado++;
            }
        }
        return jogador;
    }
    public void gerarTiranossauroRex(Jogador jogador, int tamanhoDoMapa){
        //tamanho do mapa - 1 = resultado - posiçãoJogador = resultado2
        int tamanhoMaximo = tamanhoDoMapa - 1; 
        int posicaoTx = tamanhoMaximo - jogador.getPosicaox();
        int posicaoTy = tamanhoMaximo - jogador.getPosicaoy();
        int metadeMapa = tamanhoMaximo/2;
        int maxX, minX, minY, maxY;
        if (jogador.getPosicaox() < metadeMapa) {
            minX = metadeMapa;
            maxX = tamanhoDoMapa;
        }else{
            minX = 0;
            maxX = metadeMapa;
        }
        if (jogador.getPosicaoy() < metadeMapa) {
            minY = metadeMapa;
            maxY = tamanhoDoMapa;
        }else{
            minY = 0;
            maxY = metadeMapa;
        }
        //enquanto este local tiver uma parede, ou tiver um dinossauro ou tiver uma caixa eu mudo de posição
        while(grade[posicaoTx][posicaoTy].isParede() || grade[posicaoTx][posicaoTy].getDinossauro() != null || grade[posicaoTx][posicaoTy].getCaixa() != null){
           posicaoTx = ThreadLocalRandom.current().nextInt(minX, maxX);
           posicaoTy = ThreadLocalRandom.current().nextInt(minY, maxY);
        }
        TiranossauroRex tiranossauroRex = new TiranossauroRex(posicaoTx, posicaoTy);
        grade[posicaoTx][posicaoTy].setDinossauro(tiranossauroRex);
    }
    public void movimentoPersonagem(Jogador jogador){
        
    }
}
