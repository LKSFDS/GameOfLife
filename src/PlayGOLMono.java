import java.io.IOException;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

public class PlayGOLMono {
    private GameOfLife gameOfLife;
    private RunGame[] runGame;
    private Thread[] gameThread;

    public PlayGOLMono(int boardSize, int numThread, int opcao) throws IOException {
        this.gameOfLife = new GameOfLife(boardSize, opcao);
        this.runGame = new RunGame[numThread];
        if(numThread == 1){
            this.runGame[0] = new RunGame(0,0, boardSize,gameOfLife);
        }

        else if(numThread == 2){
            this.runGame[0] = new RunGame(0,0,(boardSize/numThread), gameOfLife);
            this.runGame[1] = new RunGame(0,(boardSize/numThread),boardSize, gameOfLife);
        }

        else if(numThread == 4){
            this.runGame[0] = new RunGame(0,0,(boardSize/numThread), gameOfLife);
            this.runGame[1] = new RunGame(0,(boardSize/numThread),2*(boardSize/numThread), gameOfLife);
            this.runGame[2] = new RunGame(0,2*(boardSize/numThread),3*(boardSize/numThread), gameOfLife);
            this.runGame[3] = new RunGame(0,3*(boardSize/numThread),boardSize, gameOfLife);
        }

        else if(numThread == 8){
            this.runGame[0] = new RunGame(0,0,(boardSize/numThread), gameOfLife);
            this.runGame[1] = new RunGame(0,(boardSize/numThread),2*(boardSize/numThread), gameOfLife);
            this.runGame[2] = new RunGame(0,2*(boardSize/numThread),3*(boardSize/numThread), gameOfLife);
            this.runGame[3] = new RunGame(0,3*(boardSize/numThread),4*(boardSize/numThread), gameOfLife);
            this.runGame[4] = new RunGame(0,4*(boardSize/numThread),5*(boardSize/numThread), gameOfLife);
            this.runGame[5] = new RunGame(0,5*(boardSize/numThread),6*(boardSize/numThread), gameOfLife);
            this.runGame[6] = new RunGame(0,6*(boardSize/numThread),7*(boardSize/numThread), gameOfLife);
            this.runGame[7] = new RunGame(0,7*(boardSize/numThread),boardSize, gameOfLife);
        }

        this.gameThread = new Thread[numThread];
    }

    public static void main(String[] args) {
        int mSize, numGen, nThread, opcao;

        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Digite 1 para um tabuleiro aleatório ou digite 2 para o tabuleiro GRP");
            opcao = Integer.parseInt(input.nextLine());

            System.out.println("Informe o tamanho do tabuleiro: ");
            mSize = Integer.parseInt(input.nextLine());

            System.out.println("Informe o numero de geracoes: ");
            numGen = Integer.parseInt(input.nextLine());

            System.out.println("Informe o numero de Threads: ");
            nThread = Integer.parseInt(input.nextLine());



            PlayGOLMono playGOL = new PlayGOLMono(mSize, nThread, opcao);
            /*System.out.println("Tabuleiro inicial (Gen = 0)");
            playGOL.gameOfLife.getBoardRead().printBoard();*/
            //long start = System.currentTimeMillis();
            for(int i = 0; i < numGen; i++) {
                /*int cont = 0;
                for(int l = 0; l<mSize ; l++){
                    for(int m = 0; m<mSize; m++){
                        if(playGOL.gameOfLife.getBoardRead().isAlive(l, m)){
                            cont++;
                        }
                    }
                }
                System.out.println("O número de células vivas no final é: "+cont);
                long start = System.currentTimeMillis();*/
                for(int k = 0; k < nThread; k++) {
                    playGOL.gameThread[k] = new Thread(playGOL.runGame[k]);
                    //playGOL.gameThread[k].start();
                }

                for (int j = 0; j < nThread; j++) {
                    playGOL.gameThread[j].start();
                }

                for (int j = 0; j < nThread; j++) {
                    playGOL.gameThread[j].join();
                }

                //System.out.println("Geracao: "+(i+1));
                //playGOL.gameOfLife.getBoardWrite().printBoard();
                playGOL.gameOfLife.setupForNextGeneration();
                //long end = System.currentTimeMillis();
                //System.out.println("Duracao: " + (end-start) + " milissegundos.");
            }
           // long end = System.currentTimeMillis();
           // System.out.println("Duracao: " + (end-start) + " milissegundos.");
            int cont = 0;
            for(int i = 0; i<mSize ; i++){
                for(int j = 0; j<mSize; j++){
                    if(playGOL.gameOfLife.getBoardRead().isAlive(i, j)){
                        cont++;
                    }
                }
            }
            System.out.println("O número de células vivas no final é: "+cont);
        }
        catch(IOException e){
            System.out.println("Valor de vertice invalido.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
