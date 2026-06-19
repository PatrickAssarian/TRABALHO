import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class Mapa {
    private int tamanho;
    private Celula[][] grade;

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
        int numeroTiranossauroRex = 1;
        int numeroCompsognato = 1;
        int dinossauroCompsogonato = 0;
        int dinossaurosVelociraptor = 0;
        int dinossaurosTroodonte = 0;
        int dinossaurosTiranossauroRex = 0;

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
        while (dinossaurosTiranossauroRex < numeroTiranossauroRex) {
            int x = ThreadLocalRandom.current().nextInt(0, tamanho);
            int y = ThreadLocalRandom.current().nextInt(0, tamanho);
            if (grade[x][y].getDinossauro() == null && !grade[x][y].isParede()) {
                TiranossauroRex tiranossauroRex = new TiranossauroRex(x, y);
                grade[x][y].setDinossauro(tiranossauroRex);
                dinossaurosTiranossauroRex++;
            }
        }
        while (dinossauroCompsogonato < numeroCompsognato) {
            int x = ThreadLocalRandom.current().nextInt(0, tamanho);
            int y = ThreadLocalRandom.current().nextInt(0, tamanho);
            if (grade[x][y].getDinossauro() == null && !grade[x][y].isParede()) {
                Compsognato compsognato = new Compsognato(x, y);
                grade[x][y].setDinossauro(compsognato);
                dinossaurosTiranossauroRex++;
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
                    IO.print(" [J] ");
                } else if(grade[i][j].getDinossauro() != null){
                    Dinossauro dino = grade[i][j].getDinossauro();
                    if (dino instanceof Velociraptor) {
                        IO.print(" [V] ");
                    }
                    else if (dino instanceof Troodonte) {
                        IO.print(" [T] ");
                    }
                    else if (dino instanceof TiranossauroRex) {
                        IO.print(" [R] ");
                    }
                } else if(grade[i][j].getCaixa() != null){
                    IO.print(" [C] ");
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
            x = ThreadLocalRandom.current().nextInt(0, tamanho);
            y = ThreadLocalRandom.current().nextInt(0, tamanho);
            
            Compsognato compsognato = new Compsognato(x, y);
            CaixaSuprimentos Caixa = new CaixaSuprimentos(new KitMedico(), null);
            CaixaSuprimentos bastao = new CaixaSuprimentos(new BastaoEletrico(), null);
            CaixaSuprimentos arma1 = new CaixaSuprimentos(new ArmaDeDardos(), null);
            CaixaSuprimentos arma2 = new CaixaSuprimentos(new ArmaDeDardos(), compsognato);

            ArrayList<CaixaSuprimentos> estoqueDeCaixa = new ArrayList<>();
            estoqueDeCaixa.add(Caixa);
            estoqueDeCaixa.add(bastao);
            estoqueDeCaixa.add(arma1);
            estoqueDeCaixa.add(arma2);

            if(!grade[x][y].isParede() && grade[x][y].getDinossauro() == null && grade[x][y].getCaixa() == null){
                while (caixasColocadas < 4) {
                    
                }
            }
            
        }

    }
}
