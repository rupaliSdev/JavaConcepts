package LLD_Design.snakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    Board(int boardSize,int numSnakes,int numLadders){
        intializeCells(boardSize);
        addSnakesLadder(cells,numSnakes,numLadders);

    }


    private void intializeCells(int boardSize){
        cells = new Cell[boardSize][boardSize];

        for(int row = 0; row < boardSize; row++){
            for(int col = 0; col < boardSize; col++){
                Cell cell = new Cell();
                cells[row][col] = cell;

            }
        }

    }

    private void addSnakesLadder(Cell[][] cells, int numSnakes, int noLadders){
        while (numSnakes > 0){
            int snakeHead= ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail= ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);

            if(snakeHead<=snakeTail){
                continue;
            }
            Jump jump= new Jump();
            jump.start=snakeHead;
            jump.end=snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump=jump;

            numSnakes--;
        }

        while (noLadders > 0){
            int ladderStart= ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd= ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);

            if(ladderEnd<=ladderStart){
                continue;
            }
            Jump jump= new Jump();
            jump.start=ladderStart;
            jump.end=ladderEnd;

            Cell cell = getCell(ladderStart);
            cell.jump=jump;

            numSnakes--;
        }
    }

    Cell getCell(int snakeHead){
        return cells[snakeHead/ cells.length][snakeHead%cells.length];
    }
}
