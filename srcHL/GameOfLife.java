public class GameOfLife {
    private Board boardRead;
    private Board boardWrite;

    public GameOfLife(int n, int opcao){
        boardRead = new Board(n);
        boardWrite = new Board(n);
        if(opcao == 1){
            boardRead.setBoardRandom();
        }else{
            boardRead.ressurrectCell(1,2);
            boardRead.ressurrectCell(2,3);
            boardRead.ressurrectCell(3,1);
            boardRead.ressurrectCell(3,2);
            boardRead.ressurrectCell(3,3);
            boardRead.ressurrectCell(12,31);
            boardRead.ressurrectCell(12,32);
            boardRead.ressurrectCell(11,32);
            boardRead.ressurrectCell(13,32);
            boardRead.ressurrectCell(11,33);
        }
    }

    public Board getBoardRead() {
        return boardRead;
    }

    public void setBoardRead(Board boardRead) {
        this.boardRead = boardRead;
    }

    public Board getBoardWrite() {
        return boardWrite;
    }

    public void setBoardWrite(Board boardWrite) {
        this.boardWrite = boardWrite;
    }

    public void killCell(int n, int m){
        this.boardWrite.killCell(n, m);
    }

    public void ressurrectCell(int n, int m){
        this.boardWrite.ressurrectCell(n,m);
    }

    public void stayAlive(int n, int m) {
        this.getBoardWrite().ressurrectCell(n,m);
    }

    public void stayDead(int n, int m) {
        this.getBoardWrite().killCell(n,m);
    }

    public void setupForNextGeneration(){
        this.setBoardRead(this.getBoardWrite());
        this.setBoardWrite(new Board(this.boardRead.size()));
    }

}
