package LLD_Design.problems.snakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players= new LinkedList<>();
    Player winner = null;
    public Game(){
        intializeGame();
    }

    public void intializeGame(){
        board = new Board(10,5,4);
        dice = new Dice(1);
        addPlayer();

    }

    public void addPlayer(){
        Player p1 = new Player(1,0);
        Player p2= new Player(2,0);
        players.add(p1);
        players.add(p2);
    }

    public void startGame(){
        while(winner==null){
            //check whose turn Now

            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn: "+playerTurn.id + " current position: "+playerTurn.currentPosition);

            //roll the dice
            int diceNum=dice.rollDice();
            //get the new position
            int playerNewPosition = diceNum+playerTurn.currentPosition;
            playerNewPosition= jumpCheck(playerNewPosition);
            playerTurn.currentPosition=playerNewPosition;
            System.out.println("Player turn: "+playerTurn.id + " current position: "+playerTurn.currentPosition);
            //check for winning condition
            if(playerNewPosition>=board.cells.length * board.cells.length){
                winner= playerTurn;
            }
        }
        System.out.println("winner is "+winner) ;
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition> board.cells.length * board.cells.length-1){
            return playerNewPosition;
        }
        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump!=null && cell.jump.start==playerNewPosition){
            String jumpBy = cell.jump.start> cell.jump.end ?"snake":"ladder";
            System.out.println("jump done by : "+ jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }

    private Player findPlayerTurn() {

        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }
}
