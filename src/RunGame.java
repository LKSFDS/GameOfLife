public class RunGame implements Runnable{
    private int lin;
    private int col;
    private GameOfLife gameOfLife;
    private int end;

    public RunGame(int lin, int col, int end, GameOfLife gameOfLife) {
        this.lin = lin;
        this.col = col;
        this.gameOfLife = gameOfLife;
        this.end = end;
    }

    @Override
    public void run() {
        int num = this.gameOfLife.getBoardRead().size()-1;
        int cont;
        for(int i = lin; i < num; i++){
            for(int j = col; j < end; j++){
                cont = 0;
                if(i == 0 && j == 0){
                    if(this.gameOfLife.getBoardRead().isAlive(0, 1)) cont++; // direita
                    if(this.gameOfLife.getBoardRead().isAlive(1, 0)) cont++; // baixo
                    if(this.gameOfLife.getBoardRead().isAlive(1, 1)) cont++; // diagonal inf direita
                    if(this.gameOfLife.getBoardRead().isAlive(1, num)) cont++; // diagonal inf esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(num, num)) cont++; // diagonal sup esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(num, 1)) cont++; // diagonal sup direita
                    if(this.gameOfLife.getBoardRead().isAlive(num, 0)) cont++; // cima
                    if(this.gameOfLife.getBoardRead().isAlive(0, num)) cont++; // esquerda
                }

                else if(i == 0 && j == num){
                    if(this.gameOfLife.getBoardRead().isAlive(0, num-1)) cont++; // esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(1, num)) cont++; // baixo
                    if(this.gameOfLife.getBoardRead().isAlive(1, num-1)) cont++; // diagonal inf esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(num, num-1)) cont++; // diagonal sup esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(num, num)) cont++; // cima
                    if(this.gameOfLife.getBoardRead().isAlive(num, 0)) cont++; // diagonal sup direita
                    if(this.gameOfLife.getBoardRead().isAlive(0, 0)) cont++; //direita
                    if(this.gameOfLife.getBoardRead().isAlive(1, 0)) cont++; // diagonal inf direita
                }

                else if(i == num && j == 0){
                    if(this.gameOfLife.getBoardRead().isAlive(num-1, 0)) cont++; // cima
                    if(this.gameOfLife.getBoardRead().isAlive(num, 1)) cont++; // direita
                    if(this.gameOfLife.getBoardRead().isAlive(num-1, 1)) cont++; // diagonal sup direita
                    if(this.gameOfLife.getBoardRead().isAlive(num-1, num)) cont++; // diagonal sup esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(num, num)) cont++; // esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(0, num)) cont++; // diagonal inf esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(0, 0)) cont++; // baixo
                    if(this.gameOfLife.getBoardRead().isAlive(0, 1)) cont++; // diagonal inf direita
                }
                else if(i == num && j == num) {
                    if (this.gameOfLife.getBoardRead().isAlive(num, num - 1)) cont++; // cima
                    if (this.gameOfLife.getBoardRead().isAlive(num - 1, num)) cont++; // esquerda
                    if (this.gameOfLife.getBoardRead().isAlive(num - 1, num - 1)) cont++; // diagonal sup esquerda
                    if (this.gameOfLife.getBoardRead().isAlive(num - 1, 0)) cont++; // diagonal sup direita
                    if (this.gameOfLife.getBoardRead().isAlive(num, 0)) cont++; // direita
                    if (this.gameOfLife.getBoardRead().isAlive(0, 0)) cont++; // diagonal inf direita
                    if (this.gameOfLife.getBoardRead().isAlive(0, num)) cont++; // baixo
                    if (this.gameOfLife.getBoardRead().isAlive(0, num - 1)) cont++; // diagonal inf esquerda
                }

                else if(i == 0 && j != 0 && j != num){
                    if(this.gameOfLife.getBoardRead().isAlive(0, j-1)) cont++; // esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(0, j+1)) cont++; // direita
                    if(this.gameOfLife.getBoardRead().isAlive(1, j+1)) cont++; // diagonal direita
                    if(this.gameOfLife.getBoardRead().isAlive(1, j)) cont++; // baixo
                    if(this.gameOfLife.getBoardRead().isAlive(1, j-1)) cont++; // diagonal esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(num, j-1)) cont++; // diagonal sup esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(num, j)) cont++; // cima
                    if(this.gameOfLife.getBoardRead().isAlive(num, j+1)) cont++; // diagonal sup direita
                }

                else if(j == 0 && i !=0 && i != num){
                    if(this.gameOfLife.getBoardRead().isAlive(i-1, 0)) cont++; // cima
                    if(this.gameOfLife.getBoardRead().isAlive(i-1, 1)) cont++; // diagonal cima
                    if(this.gameOfLife.getBoardRead().isAlive(i, 1)) cont++; // direita
                    if(this.gameOfLife.getBoardRead().isAlive(i+1, 1)) cont++; // diagonal baixo
                    if(this.gameOfLife.getBoardRead().isAlive(i+1, 0)) cont++; // baixo
                    if(this.gameOfLife.getBoardRead().isAlive(i-1, num)) cont++; // diagonal sup esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(i, num)) cont++; // esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(i+1, num)) cont++; // diagonal inf esquerda
                }

                else if(j == num && i !=0 && i != num){
                    if(this.gameOfLife.getBoardRead().isAlive(i-1, num)) cont++; // cima
                    if(this.gameOfLife.getBoardRead().isAlive(i-1, num-1)) cont++; // diagonal cima
                    if(this.gameOfLife.getBoardRead().isAlive(i, num-1)) cont++; // esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(i+1, num-1)) cont++; // diagonal baixo
                    if(this.gameOfLife.getBoardRead().isAlive(i+1, num)) cont++; // baixo
                    if(this.gameOfLife.getBoardRead().isAlive(i-1, 0)) cont++; // diagonal sup direita
                    if(this.gameOfLife.getBoardRead().isAlive(i, 0)) cont++; // direita
                    if(this.gameOfLife.getBoardRead().isAlive(i+1, 0)) cont++; // diagonal inf direita
                }

                else if(i == num && j != 0 && j != num){
                    if(this.gameOfLife.getBoardRead().isAlive(num, j-1)) cont++; // esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(num-1, j-1)) cont++; // diagonal esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(num-1, j)) cont++; // cima
                    if(this.gameOfLife.getBoardRead().isAlive(num-1, j+1)) cont++; // diagonal direita
                    if(this.gameOfLife.getBoardRead().isAlive(num, j+1)) cont++; // direita
                    if(this.gameOfLife.getBoardRead().isAlive(0, j-1)) cont++; // diagonal inf esquerda
                    if(this.gameOfLife.getBoardRead().isAlive(0, j)) cont++; // baixo
                    if(this.gameOfLife.getBoardRead().isAlive(0, j+1)) cont++; // diagonal inf direita
                }

                else {
                    if (this.gameOfLife.getBoardRead().isAlive(i - 1, j - 1)) cont++; // diagonal sup esquerda
                    if (this.gameOfLife.getBoardRead().isAlive(i - 1, j)) cont++; // cima
                    if (this.gameOfLife.getBoardRead().isAlive(i - 1, j + 1)) cont++; // diagonal sup direita
                    if (this.gameOfLife.getBoardRead().isAlive(i, j + 1)) cont++; // direita
                    if (this.gameOfLife.getBoardRead().isAlive(i + 1, j + 1)) cont++; // diagonal inf direita
                    if (this.gameOfLife.getBoardRead().isAlive(i + 1, j)) cont++; // baixo
                    if (this.gameOfLife.getBoardRead().isAlive(i + 1, j - 1)) cont++; // diagonal inf esquerda
                    if (this.gameOfLife.getBoardRead().isAlive(i, j - 1)) cont++; // esquerda
                }

                if(this.gameOfLife.getBoardRead().isAlive(i,j)){ // is alive
                    if(cont < 2 || cont > 3){ // and at least 2/3 are dead
                        this.gameOfLife.killCell(i,j);
                    } else {
                        this.gameOfLife.stayAlive(i,j);
                    }
                }
                else{
                    if(cont == 3){
                        this.gameOfLife.ressurrectCell(i,j);
                    } else {
                        this.gameOfLife.stayDead(i,j);
                    }
                }
            }
        }
    }
}
