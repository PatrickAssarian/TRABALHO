```mermaid
classDiagram
    %% Relações de Herança
    Personagem <|-- Jogador
    Personagem <|-- Dinossauro
    Dinossauro <|-- TiranossauroRex
    Dinossauro <|-- Velociraptor
    Dinossauro <|-- Troodonte
    Dinossauro <|-- Compsognato
    
    Itens <|-- KitMedico
    Itens <|-- ArmaDeDardos
    Itens <|-- BastaoEletrico

    %% Relações de Composição e Agregação
    Mapa *-- Celula : compõe
    Celula o-- Jogador : agrega
    Celula o-- Dinossauro : agrega
    Celula o-- CaixaSuprimentos : agrega
    CaixaSuprimentos o-- Itens : contém
    CaixaSuprimentos o-- Compsognato : contém surpresa

    class Main {
        + main(String[] args)
    }

    class Personagem {
        - int saude
        - int posicaox
        - int posicaoy
        + getSaude() int
        + setSaude(int)
        + getPosicaox() int
        + setPosicaox(int)
        + getPosicaoy() int
        + setPosicaoy(int)
    }

    class Jogador {
        - int percepcao
        - int kitsMedicos
        - int municao
        - boolean temArma
        - boolean temBastao
        + getPercepcao() int
        + getKitsMedicos() int
        + setKitsMedicos(int)
        + getMunicao() int
        + setMunicao(int)
        + isTemArma() boolean
        + setTemArma(boolean)
        + isTemBastao() boolean
        + setTemBastao(boolean)
    }

    class Mapa {
        - int tamanho
        - Celula[][] grade
        - boolean modoDebug
        + gerarParedesAleatorias()
        + gerarDinossauros()
        + ImprimirMapa(Jogador)
        + gerarCaixa()
        + gerarPersonagem(int) Jogador
        + gerarTiranossauroRex(Jogador, int)
        + movimentoPersonagem(Jogador, Scanner)
        + exibirStatusJogador(Jogador)
        + iniciarCombate(Jogador, Dinossauro, Scanner) boolean
        + movimentarDinossauros(Jogador, Scanner)
    }

    class Celula {
        - boolean parede
        - Dinossauro dinossauro
        - Jogador jogador
        - CaixaSuprimentos caixa
        + isParede() boolean
        + setParede(boolean)
        + getDinossauro() Dinossauro
        + setDinossauro(Dinossauro)
        + getJogador() Jogador
        + setJogador(Jogador)
        + getCaixa() CaixaSuprimentos
        + setCaixa(CaixaSuprimentos)
    }

    class CaixaSuprimentos {
        - Itens itemGuardado
        - Compsognato dinossauroSurpresa
        + getItemGuardado() Itens
        + getDinossauroSurpresa() Compsognato
    }
    ```