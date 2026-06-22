import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int percepcao = 0, dificuldade, opcaoSwitch = 0;
        boolean jogoRodando = true;
        Scanner scanner = new Scanner(System.in);
        IO.println("SEJA BEM VINDO À SOBREVIVÊNCIA JURÁSSICA!\naperte enter para começar...");
        scanner.nextLine();

        IO.println("MENU\n1 - Jogar\n2 - Sair");
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            
            while(opcaoSwitch != 1){
                IO.println("Dificuldade\n1 - Fácil\n2 - Médio\n3 - Difícil");
                dificuldade = scanner.nextInt();
                switch (dificuldade) {
                    case 1 -> {
                        percepcao = 3;
                        IO.println("Você ganhou 3 pontos de percepção!");
                        opcaoSwitch = 1;
                    }
                    case 2 ->{
                        percepcao = 2;
                        IO.println("Você ganhou 2 pontos de percepção!");
                        opcaoSwitch = 1;
                    } 
                    case 3 ->{
                        percepcao = 1;                      
                        IO.println("Você ganhou 1 ponto de percepção!");
                        opcaoSwitch = 1;
                    } 
                    default -> {
                        IO.println("OPÇÃO INVÁLIDA!, digite a dificuldade novamente!"); 
                    }
                }
            }
            Mapa mapa = new Mapa(20);
            mapa.gerarParedesAleatorias();
            mapa.gerarDinossauros();
            mapa.gerarCaixa();
            Jogador jogador = mapa.gerarPersonagem(percepcao);
            mapa.gerarTiranossauroRex(jogador,20);
            while (jogoRodando) {        
                mapa.ImprimirMapa();
                    
            }
            
            
        } else if (escolha == 2) {
            IO.println("Obrigado por jogar! Até a próxima!");
        }
        scanner.close();
    }
}