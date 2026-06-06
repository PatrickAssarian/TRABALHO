import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int percepcao, dificuldade;
        Scanner scanner = new Scanner(System.in);
        IO.println("SEJA BEM VINDO À SOBREVIVÊNCIA JURÁSSICA!\naperte enter para começar...");
        scanner.nextLine();
        IO.println("MENU\n1 - Jogar\n2 - Sair");
        int escolha = scanner.nextInt();
        if (escolha == 1) {
            IO.println("Dificuldade\n1 - Fácil\n2 - Médio\n3 - Difícil");
            dificuldade = scanner.nextInt();
            if (dificuldade == 1) {
                percepcao = 3;
            } else if (dificuldade == 2) {
                percepcao = 2;
            } else if(dificuldade == 3) {
                percepcao = 1;
            }
        } else if (escolha == 2) {
            IO.println("Obrigado por jogar! Até a próxima!");
    
        }
        scanner.close();
    }
}