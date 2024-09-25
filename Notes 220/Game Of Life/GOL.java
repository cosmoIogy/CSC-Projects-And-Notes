import java.io.*;

class GOL{
public static void main(String[] args) {
    boolean[][] petriDish = readFile();
    printBoard(petriDish);
}

public static boolean[][] playGame(boolean[][] old){
    boolean [][] noob = new boolean[old.length][old.length];

    for(int row = 1; row < old.length -1; row++){
        for(int col = 1; col < old[row].length - 1; col++){
            int neighbors = countNeighbors(old, row, col);

            if(old[row][col]){
                noob[row][col] = (neighbors == 2 || neighbors == 3);
            }
            else{
                noob[row][col] = (neighbors == 3);
            }
        }
    }
    return noob;
}

//a function to ocunt the number of neighbors around a specific row r and column c in the 2D array og
public static int countNeighbors(boolean[][] og, int r, int c){
    int neigh = 0;
    for (int i = -1; i < 2; i++){
        for (int j = -1; j < 2; j++){
            if (og[r+i][c+j] && (i == 0) && (j == 0))
                neigh++;
        }
    }
    return neigh;
}


public static void printBoard(boolean[][] brd){
    for(int row = 0; row < brd.length; row++){
        for (int col = 0; col < brd[row].length; col++){
            System.out.println(brd[row][col] ? "*" : " ");
            //System.out.println(brd[row][col] + ", "); 
        }
        System.out.println();
    }
}
    //a function to read a line and populate 
    public static void readLine(boolean[][] brd, int row, String line){
        brd[row][i] = (line.charAt(i) == '*') ? true : false;
        }

public static boolean[][] readFile(){

    boolean [][] board = null;
    int i = 0, size;

    try{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    String line; //declare a string where the input will be stored

    while(true){
        line = br.readLine();
        if (i==0){
            size = line.length();
            board = new boolean[size][size];
        }
        //System.out.println(line);
        readline(board, i, line);
        }
        i++;
    }
    catch (IOException e){
        //do something
        System.out.println("error");
        }
    }
}
