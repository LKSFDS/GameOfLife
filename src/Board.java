import java.util.Random;

public class Board {
    public int[][] board;
    private Random generator;

    public Board(int n){
        this.board = new int[n][n];
        this.generator = new Random();
    }

    public void setBoardRandom() {
        this.board = initRandom();
    }

    public void initZeros(){
        if(this.board != null){
            for(int[] row: this.board){
                for(int cell: row){
                    cell = 0;
                }
            }
        }
    }

    public int[][] initRandom(){
        int[][] matriz = new int[this.board.length][this.board.length];
        if(this.board != null){
            for(int i = 0; i < this.board.length; i++){
                for(int j = 0; j < this.board.length; j++){
                    matriz[i][j] = Math.abs(generator.nextInt()%2);
                }
            }
        }
        return matriz;
    }

    public boolean isAlive(int lin, int col){
        if(this.board[lin][col] == 0) return false;
        return true;
    }

    public int size(){
        return this.board.length;
    }

    public int getCell(int n, int m){
        return this.board[n][m];
    }

    public void killCell(int n, int m){
        this.board[n][m] = 0;
    }

    public void ressurrectCell(int n, int m){
        this.board[n][m] = 1;
    }

    public void printBoard(){
        int num = this.board.length;
        for(int[] row: this.board){
            for(int cell: row){
                System.out.printf("%d ", cell);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void invert(){
        for(int i = 0; i < this.board.length; i ++){
            for(int j = 0; j < this.board.length; j++){
                if(this.isAlive(i, j)) killCell(i,j);
                else ressurrectCell(i,j);
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public static void main(String[] args) {
        Board board = new Board(5);
        board.setBoardRandom();
        board.printBoard();
        board.invert();
        board.printBoard();
    }
}
