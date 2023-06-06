import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoLancamentoDado {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> registro = new ArrayList<>();
        boolean continua;
        int[] rodada_atual;
        int opcao, modo, dado, pontos, erros, sequencia_zen, recorde_desafio, recorde_morte_subita,zen;
        opcao = erros = sequencia_zen = recorde_desafio = recorde_morte_subita = 0;
        modo = 1;
        dado = 6;
        do{
            switch (opcao){
                case 0:
                    menu(modo, dado);
                    opcao = input.nextInt();
                    break;
                case 1:
                    zen = pontos = erros = 0;
                    registro.clear();
                    System.out.println("\n\n-------------------------------------------------------------\n\n");
                    System.out.println("NOVO JOGO");
                    do {
                        continua = true;
                        rodada_atual = jogo(dado);
                        if (rodada_atual[1] == -1){
                            continua = false;
                        } else {
                            registro.add(rodada_atual[0]);
                            registro.add(rodada_atual[1]);
                            switch (modo){
                                case 1:
                                    if (rodada_atual[2] > 0){
                                        zen++;
                                    } else {
                                        if (zen > sequencia_zen){
                                            sequencia_zen = zen;
                                        }
                                        zen = 0;
                                    }
                                    break;
                                case 2:
                                    if (rodada_atual[2]==0) {
                                        erros++;
                                        if (erros==3){
                                            continua = false;
                                            System.out.println("\nVocê perdeu! :(\nMas não se preocupe! Você pode iniciar um novo jogo!");
                                            if (pontos > recorde_desafio){
                                                recorde_desafio = pontos;
                                            }
                                        }
                                    } else {
                                        pontos += rodada_atual[2];
                                    }
                                    break;
                                case 3:
                                    if (rodada_atual[2]==0){
                                        continua = false;
                                        System.out.println("\nVocê perdeu! :(\nMas não se preocupe! Você pode iniciar um novo jogo!");
                                        if (pontos > recorde_morte_subita){
                                            recorde_morte_subita = pontos;
                                        }
                                    } else {
                                        pontos += rodada_atual[2];
                                    }
                                    break;
                            }
                        }
                    } while (continua);
                    mostraPlacar(registro,sequencia_zen,recorde_desafio,recorde_morte_subita);
                    opcao = 0;
                    break;
                case 2:
                    comoJogar();
                    opcao = 0;
                    break;
                case 3:
                    modo = alteraModo();
                    opcao = 0;
                    break;
                case 4:
                    dado = alteraDado();
                    opcao = 0;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    opcao = 0;
            }
        } while (opcao != 5);


    }

    public static void menu (int modo_op, int dado){
        String modo;
        if (modo_op == 1){
            modo = "Zen";
        } else if (modo_op == 2){
            modo = "Desafio";
        } else {
            modo = "Morte Súbita";
        }
        System.out.println("\n\n-------------------------------------------------------------\n\n");
        System.out.println("1 - Novo Jogo");
        System.out.println("2 - Como Jogar");
        System.out.printf("3 - Alterar Modo (%s selecionado)\n", modo);
        System.out.printf("4 - Alterar Dado (D%d selecionado)\n", dado);
        System.out.println("5 - Sair");
    }

    public static int[] jogo(int dado){
        Scanner input = new Scanner(System.in);
        Random sorteio = new Random();
        int[] rodada = new int[3];
        //rodada[0] > número sorteado,   rodada[1] > palpite do jogador,   rodada[2] > pontos da rodada

        rodada[0] = sorteio.nextInt(dado) + 1;
        System.out.printf("\nO D%d foi lançado! Faça seu palpite, ou digite -1 para sair: ", dado);
        for (rodada[1] = input.nextInt(); rodada[1] == 0 || rodada[1] < -1 || rodada[1] > dado; rodada[1] = input.nextInt()){
            System.out.printf("Valor inválido. As possibilidades do D%d são números entre 1 e %d. Dê seu palpite, ou digite -1 para sair: ", dado, dado);
        }

        if (rodada[1] != -1){
            if (rodada[0] == rodada[1]){
                System.out.printf("\nVocê acertou! O resultado foi %d\n+10 pontos\n",rodada[0]);
                rodada[2] = 10;
            } else if (Math.abs(rodada[0] - rodada[1]) == 1){
                System.out.printf("\nPassou perto! O resultado foi %d\n+5 pontos\n", rodada[0]);
                rodada[2] = 5;
            } else {
                System.out.printf("\nVocê errou. O resultado foi %d\n", rodada[0]);
            }
        }

        return rodada;
    }

    public static void comoJogar (){
        System.out.println("\n\n-------------------------------------------------------------\n\n");
        System.out.println("COMO JOGAR");
        System.out.println("\nEu vou lançar um dado e você tentará acertar o lado que ele vai cair!");
        System.out.println("\nPONTUAÇÃO");
        System.out.println("+10 caso acerte o resultado do lançamento do dado - Situação: ACERTOU");
        System.out.println("+5 caso seu palpite seja um a mais ou um a menos que o resultado - Situação: PASSOU PERTO");
        System.out.println("Nenhum ponto para palpites com 2 ou mais de diferença do resultado - Situação: ERROU");
        System.out.println("\nMODOS");
        System.out.println(" - Modo Zen: Pode jogar quantas vezes quiser! Os pontos serão contados, mas não há penalidade por errar, você escolhe quando parar!");
        System.out.println(" - Modo Desafio: O jogo termina quando você errar 3 vezes. PASSAR PERTO não conta como erro.");
        System.out.println(" - Modo Morte Súbita: O jogo termina assim que você errar. PASSAR PERTO não conta como erro.");
        System.out.println("\nDADOS");
        System.out.println("Você pode escolher qual dado iremos usar! O número ao lado do D indica o número de lados que um dado possui!");
        System.out.println("Lembre-se: quanto maior o número de lados, maior a dificuldade!");
        System.out.println("Um dado de 6 lados pode cair números entre 1 e 6");
        System.out.println("Um dado de 8 lados pode cair números entre 1 e 8");
        System.out.println("Um dado de 12 lados pode cair números entre 1 e 12");
        System.out.println("Um dado de 20 lados pode cair números entre 1 e 20");
        System.out.println("Um dado de 30 lados pode cair números entre 1 e 30");
        System.out.println("Um dado de 100 lados pode cair números entre 1 e 100");
        System.out.print("\nDigite um número qualquer para voltar ao Menu Inicial");
        new java.util.Scanner(System.in).nextLine();
    }
    public static int alteraModo(){
        Scanner input = new Scanner(System.in);
        int modo;
        System.out.println("\n\n-------------------------------------------------------------\n\n");
        System.out.println("\nALTERAR MODO\n");
        System.out.println("1 - Modo Zen: Pode jogar quantas vezes quiser! Os pontos serão contados, mas não há penalidade por errar, você escolhe quando parar!");
        System.out.println("2 - Modo Desafio: O jogo termina quando você errar 3 vezes. PASSAR PERTO não conta como erro.");
        System.out.println("3 - Modo Morte Súbita: O jogo termina assim que você errar. PASSAR PERTO não conta como erro.");

        System.out.print("Escolha o modo desejado: ");
        for (modo = input.nextInt(); modo < 1 || modo > 3; modo = input.nextInt()){
            System.out.print("Opção inválida! [1 - Zen / 2 - Desafio / 3 - Morte Súbita]: ");
        }

        return modo;
    }

    public static int alteraDado(){
        Scanner input = new Scanner(System.in);
        boolean valido = false;
        int[] dados = {6,8,12,20,30,100};
        int dado;
        System.out.println("\n\n-------------------------------------------------------------\n\n");
        System.out.println("\nALTERAR DADO\n");
        System.out.println("Escolha o número de lados do seu dado [ 6 / 8 / 12 / 20 / 30 / 100 ]: ");
        do {
            dado = input.nextInt();
            for (int n : dados){
                if (dado == n) {
                    valido = true;
                    break;
                }
            } if (!valido){
                System.out.print("Opção inválida (número de lados disponíveis: 6 / 8 / 12 / 20 / 30 / 100): ");
            }
        } while (!valido);

        return dado;
    }

    public static void mostraPlacar (List<Integer> registro, int zen, int desafio, int morte_subita){
        int total_pontos, erros, passou_perto, acertos;
        total_pontos = erros = passou_perto = acertos = 0;
        String resultado, pontos;
        System.out.println("\n\n-------------------------------------------------------------\n\n");
        System.out.println("\nPLACAR:\n");
        System.out.printf("%-20s%-20s%-20s%-20s\n","LANÇAMENTO","PALPITE","RESULTADO","PONTOS");
        for (int i = 0; i < registro.size(); i+=2){
            if (registro.get(i) == registro.get(i+1)){
                resultado = "ACERTOU";
                pontos = "+10";
                total_pontos += 10;
                acertos++;
            } else if (Math.abs(registro.get(i) - registro.get(i+1)) == 1){
                resultado = "PASSOU PERTO";
                pontos = "+5";
                total_pontos += 5;
                passou_perto++;
            } else {
                resultado = "ERROU";
                pontos = " 0";
                erros++;
            }
            System.out.printf("%-20s%-20s%-20s%-20s\n",registro.get(i),registro.get(i+1), resultado, pontos);
        }
        System.out.printf("%-23s%s\n","Total de pontos:", total_pontos);
        System.out.printf("O dado foi lançado %d vezes!   ACERTOS: %d   PASSOU PERTO: %d   ERROS: %d\n", registro.size()/2, acertos, passou_perto, erros);
        System.out.println("\nRECORDES:");
        System.out.printf("%-45s%s\n","Maior sequencia de acertos (modo Zen):", zen);
        System.out.printf("%-45s%s\n","Modo Desafio:", desafio + " pontos");
        System.out.printf("%-45s%s\n","Modo Morte Súbita:", morte_subita + " pontos");
        System.out.print("\nDigite um número qualquer para sair");
        new java.util.Scanner(System.in).nextLine();
    }
}

