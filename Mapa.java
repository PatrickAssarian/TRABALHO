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
}
