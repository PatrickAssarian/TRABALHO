import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int percepcao, dificuldade, opcaoSwitch = 0;
        Scanner scanner = new Scanner(System.in);
        IO.println("SEJA BEM VINDO À SOBREVIVÊNCIA JURÁSSICA!\naperte enter para começar...");
        scanner.nextLine();
        IO.println("MENU\n1 - Jogar\n2 - Sair");
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            IO.println("Dificuldade\n1 - Fácil\n2 - Médio\n3 - Difícil");
            dificuldade = scanner.nextInt();
            while(opcaoSwitch != 1){
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
                        IO.println("Dificuldade\n1 - Fácil\n2 - Médio\n3 - Difícil");
                        dificuldade = scanner.nextInt();    
                    }
                }
            }
            
        } else if (escolha == 2) {
            IO.println("Obrigado por jogar! Até a próxima!");
        }
        Mapa mapa = new Mapa(10);
        mapa.gerarParedesAleatorias();
        mapa.gerarDinossauros();
        mapa.ImprimirMapa();
        scanner.close();
    }
}