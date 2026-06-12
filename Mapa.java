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
        
    }
}
