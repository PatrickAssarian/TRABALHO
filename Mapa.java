import java.util.ArrayList;
import java.util.Scanner;
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
    public Jogador gerarPersonagem(int percepcao){
        int personagemColocado = 0;
        Jogador jogador = null;
        while(personagemColocado < 1){
            int x = ThreadLocalRandom.current().nextInt(0, tamanho);
            int y = ThreadLocalRandom.current().nextInt(0, tamanho);
            jogador = new Jogador(percepcao, 5, x, y);
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
    public void movimentoPersonagem(Jogador jogador, Mapa mapa){
        try (Scanner scanf = new Scanner(System.in)){
            char comando;
            int rodando = 1;

            while (rodando != 0) {
                if (jogador.getKitsMedicos() > 0) {
                    IO.println("Use WASD para mover, C para curar (ou 0 para sair):");
                } else {
                    IO.println("Use WASD para movimentar (ou 0 para sair):");
                }
                comando = scanf.next().charAt(0);
                scanf.nextLine();

                if (comando == '0') {
                    rodando = 0;
                    continue; 
                }

                int proximoX = jogador.getPosicaox();
                int proximoY = jogador.getPosicaoy();

                switch (comando) {
                    case 'w'-> { proximoX = proximoX - 1; }
                    case 's'-> { proximoX = proximoX + 1; }
                    case 'a'-> { proximoY = proximoY - 1; }
                    case 'd'-> { proximoY = proximoY + 1; }
                    case 'c'-> {
                        if (jogador.getKitsMedicos() > 0) {
                            if (jogador.getSaude() < 5) {
                                jogador.setSaude(5);
                                jogador.setKitsMedicos(jogador.getKitsMedicos() - 1);
                                IO.println("Você usou um Kit Médico e restaurou sua vida!");
                            } else {
                                IO.println("Sua vida já está cheia!");
                            }
                        } else {
                            IO.println("Você não possui Kits Médicos no inventário!");
                        }
                    }
                    default-> { IO.println("Comando inválido!"); }
                }

                if (comando != 'c') {
                    if (proximoX >= 0 && proximoX < tamanho && proximoY >= 0 && proximoY < tamanho) {
                        
                       if (!grade[proximoX][proximoY].isParede()) {
                        int xAntigo = jogador.getPosicaox();
                        int yAntigo = jogador.getPosicaoy();
                        
                            if (grade[proximoX][proximoY].getDinossauro() != null) {
                                Dinossauro inimigo = grade[proximoX][proximoY].getDinossauro();
                                boolean vitoria = iniciarCombate(jogador, inimigo, scanf);
                            
                                if (vitoria) {
                                 grade[proximoX][proximoY].setDinossauro(null);
                                
                                    grade[xAntigo][yAntigo].setJogador(null);
                                    jogador.setPosicaox(proximoX);
                                    jogador.setPosicaoy(proximoY);
                                    grade[proximoX][proximoY].setJogador(jogador);
                                }   
                            
                            } else {
                                grade[xAntigo][yAntigo].setJogador(null);
                                
                                if (grade[proximoX][proximoY].getCaixa() != null) {
                                    CaixaSuprimentos caixa = grade[proximoX][proximoY].getCaixa();
                                    
                                    if (caixa.getDinossauroSurpresa() != null) {
                                        IO.println("SURPRESA! Um Compsognato pulou da caixa!");
                                        int dadoPercepcao = ThreadLocalRandom.current().nextInt(1, 4); 
                                        if (dadoPercepcao <= jogador.getPercepcao()) {
                                            IO.println("[ESQUIVA!] Graças à sua percepção, você se esquivou do bote!"); 
                                        } else {
                                            jogador.setSaude(jogador.getSaude() - 1); 
                                            IO.println("[DANO!] Você não reagiu a tempo e perdeu 1 ponto de vida!");
                                        }
                                    } else if (caixa.getItemGuardado() instanceof KitMedico) {
                                        jogador.setKitsMedicos(jogador.getKitsMedicos() + 1);
                                        IO.println("Você encontrou um Kit Médico!");
                                    } else if (caixa.getItemGuardado() instanceof BastaoEletrico) {
                                        jogador.setTemBastao(true);
                                        IO.println("Você encontrou um Bastão Elétrico!");
                                    } else if (caixa.getItemGuardado() instanceof ArmaDeDardos) {
                                        jogador.setTemArma(true);
                                        jogador.setMunicao(jogador.getMunicao() + 1); 
                                        IO.println("Você encontrou uma Arma de Dardos (+1 Munição)!");
                                    }
                                    
                                    grade[proximoX][proximoY].setCaixa(null);
                                }
                                
                                jogador.setPosicaox(proximoX);
                                jogador.setPosicaoy(proximoY);
                                grade[proximoX][proximoY].setJogador(jogador);
                            }
                        }
                    }
                }
                mapa.movimentarDinossauros(jogador, scanf);
                
                if (jogador.getSaude() <= 0) {
                    IO.println("\n GAME OVER! Você não aguentou os ferimentos e morreu!!");
                    rodando = 0;
                }else{
                    mapa.ImprimirMapa();
                    mapa.exibirStatusJogador(jogador);
                }  
            }
        }
    }
    public void exibirStatusJogador(Jogador jogador) {
    IO.println("--- STATUS ---");
    
    // Puxa a vida atual do jogador
    IO.println("Vida: " + jogador.getSaude());
    
    if (jogador.isTemArma()) {
        IO.println("Arma: Equipada");
        IO.println("Munição: " + jogador.getMunicao());
    } else {
        IO.println("Arma: Nenhuma");
    }
    
    IO.println("Kits Médicos: " + jogador.getKitsMedicos());
    
    IO.println("--------------");
}
    public boolean iniciarCombate(Jogador jogador, Dinossauro inimigo, Scanner scanf) {
    IO.println("\nCOMBATE INICIADO! ");
    
        while (jogador.getSaude() > 0 && inimigo.getSaude() > 0) {
            IO.println("\nVida do Jogador: " + jogador.getSaude() + " HP | Vida do Inimigo: " + inimigo.getSaude() + " HP");
            IO.println("Escolha sua ação:");
            IO.println("1 - Atacar");
            IO.println("2 - Fugir");
            
            int acao = scanf.nextInt();
            scanf.nextLine();
            
            if (acao == 2) {
                IO.println("Você conseguiu fugir do combate!");
                return false; 
            }
            
            if (acao == 1) {
                IO.println("Como você deseja desferir o ataque?");
                if (jogador.isTemBastao()) {
                    IO.println("1 - Bastão Elétrico");
                } else {
                    IO.println("1 - Mãos Nuas");
                }
                if (jogador.isTemArma()) {
                    IO.println("2 - Arma de Dardos Tranquilizantes (Munição: " + jogador.getMunicao() + ")");
                }
                
                int tipoAtaque = scanf.nextInt();
                scanf.nextLine();
                
                int danoCausado = 0;
                
                if (tipoAtaque == 2 && jogador.isTemArma()) {
                    if (jogador.getMunicao() > 0) {
                        jogador.setMunicao(jogador.getMunicao() - 1); 
                        
                        if (inimigo instanceof Velociraptor) {
                            IO.println("O Velociraptor é muito ágil! Ele desviou do dardo tranquilizante facilmente!");
                            danoCausado = 0;
                        } else {
                            IO.println(" Tiro certeiro! O dardo aplicou um golpe crítico de 2 pontos de dano!"); 
                            danoCausado = 2;
                        }
                    } else {
                        IO.println("Você tentou puxar o gatilho, mas está sem munição! Acabou atacando sem querer com o que tinha.");
                        tipoAtaque = 1; 
                    }
                }
                
                if (tipoAtaque == 1) {
                    int dadoAtaque = ThreadLocalRandom.current().nextInt(1, 7); 
                    IO.println("Você rolou o dado de ataque e tirou: " + dadoAtaque);
                    
                    if (inimigo instanceof TiranossauroRex && !jogador.isTemBastao()) {
                        IO.println("Seus socos não fazem efeito na pele grossa do T-Rex! Você precisa de uma arma!"); 
                        danoCausado = 0;
                    } else if (jogador.isTemBastao()) {
                        if (dadoAtaque > 5) {
                            IO.println("Choque Crítico! O bastão descarregou alta voltagem (+2 de dano)!");
                            danoCausado = 2;
                        } else if (dadoAtaque == 1) {
                            IO.println("Você errou o balanço do bastão elétrico e não causou dano!");
                            danoCausado = 0;
                        } else {
                            IO.println("O bastão elétrico atingiu o dinossauro (+1 de dano)!");
                            danoCausado = 1;
                        }
                    } else {
                        if (dadoAtaque == 6) {
                            IO.println("Golpe Crítico! Você acertou um ponto fraco com as mãos nuas (+2 de dano)!");
                            danoCausado = 2;
                        } else if (dadoAtaque == 1 || dadoAtaque == 2) {
                            IO.println("Você socou o ar e não causou dano!");
                            danoCausado = 0;
                        } else {
                            IO.println("Soco conectado com sucesso (+1 de dano)!");
                            danoCausado = 1;
                        }
                    }
                }
                
                inimigo.setSaude(inimigo.getSaude() - danoCausado);
                
                if (inimigo.getSaude() > 0) {
                    IO.println("🦖 O dinossauro avança para morder você!");
                    int dadoDefesa = ThreadLocalRandom.current().nextInt(1, 4); // Dado de 3 lados [cite: 107]
                    
                    if (dadoDefesa <= jogador.getPercepcao()) {
                        IO.println("[ESQUIVA!] Seus reflexos baseados na percepção fizeram você desviar do bote!"); // [cite: 108]
                    } else {
                        int danoSofrido = (inimigo instanceof TiranossauroRex) ? 2 : 1;
                        jogador.setSaude(jogador.getSaude() - danoSofrido);
                        IO.println("[DANO!] Você foi atingido e perdeu " + danoSofrido + " ponto(s) de vida!"); // [cite: 109]
                    }
                }
            }
        }
    
        return inimigo.getSaude() <= 0;
    }
    public void movimentarDinossauros(Jogador jogador, Scanner scanf) {//se eu não passar o scanf por parametro, no segundo combate o scanf que eu criar novamente dentro do novo método será destruido autoaticamente, e dará erro
        ArrayList<Dinossauro> dinossaurosParaMover = new ArrayList<>();
        
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                Dinossauro dino = grade[i][j].getDinossauro();
                if (dino != null && !(dino instanceof TiranossauroRex)) {
                    dinossaurosParaMover.add(dino);
                }
            }
        }
        
        for (Dinossauro dino : dinossaurosParaMover) {
            // Pega as posições atuais (Assumindo que Dinossauro herda getPosicaox/y de Personagem)
            int xAtual = dino.getPosicaox();
            int yAtual = dino.getPosicaoy();
            int novoX = xAtual;
            int novoY = yAtual;
            
            int direcao = ThreadLocalRandom.current().nextInt(0, 4);
            switch(direcao) {
                case 0 -> novoX--;
                case 1 -> novoX++;
                case 2 -> novoY--;
                case 3 -> novoY++;
            }
            
            if (novoX >= 0 && novoX < tamanho && novoY >= 0 && novoY < tamanho) {
                
                if (!grade[novoX][novoY].isParede() && grade[novoX][novoY].getDinossauro() == null) {
                    
                    grade[xAtual][yAtual].setDinossauro(null);
                    
                    dino.setPosicaox(novoX);
                    dino.setPosicaoy(novoY);
                    
                    grade[novoX][novoY].setDinossauro(dino);
                    
                    if (novoX == jogador.getPosicaox() && novoY == jogador.getPosicaoy()) {
                        IO.println("\n ALERTA: Um " + dino.getClass().getSimpleName() + " encontrou você!");
                        
                        boolean vitoria = iniciarCombate(jogador, dino, scanf);
                        
                        if (vitoria) {
                            grade[novoX][novoY].setDinossauro(null);
                        } else if (jogador.getSaude() <= 0) {
                            return; 
                        }
                    }
                }
            }
        }
    }
}
