import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ninetySixTwo{ 
    public static void main(String[] args)throws FileNotFoundException{ 
        // Import file, set array
        File sudokuFile = new File("p096_sudoku.txt");
        int[][][] puzzles = setArr(sudokuFile);
        printPuzzles(puzzles);
        System.out.println(calcSum(puzzles));
        printPuzzles(puzzles);
    }

    // Set the array of puzzles
    public static int[][][] setArr(File sudokuFile)throws FileNotFoundException{
        Scanner prob = new Scanner(sudokuFile);
        int[][][] arr = new int[50][9][9];
        // Loop through initializing in order
        for(int i = 0; i<50; i++){
            prob.nextLine();
            for(int j = 0; j<9; j++){
                String temp = prob.nextLine();
                for(int k = 0; k<9; k++){
                    arr[i][j][k] = Integer.parseInt(temp.substring(k,k+1));
                }
            }
        }
        prob.close();
        return arr;
    }
    public static boolean solveOne(int[][] puzzle) {
        // Find a 0 element
        int row = -1, col = -1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (puzzle[i][j] == 0) {
                    row = i;
                    col = j;
                    break;
                }
            }
            if (row != -1) {
                break;
            }
        }
        // Puzzle solved if no 0 element is found
        if (row == -1) {
            return true;
        }
        // Try all possible numbers in the 0 element
        for (int num = 1; num <= 9; num++) {
            if (isValidMove(puzzle, row, col, num)) {
                puzzle[row][col] = num;
                if (solveOne(puzzle)) {
                    return true;
                }
                // Backtrack if the recursive call returns false
                puzzle[row][col] = 0;
            }
        }
        // Return false if no valid number is found
        return false;
    }

    public static boolean isValidMove(int[][] puzzle, int row, int col, int num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (puzzle[row][i] == num || puzzle[i][col] == num) {
                return false;
            }
        }
        // Check box
        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (puzzle[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int calcSum(int[][][] puzzles){
        int sum = 0;
        // sum 3-digit value of each puzzle
        for(int i = 0; i<50; i++){
            solveOne(puzzles[i]);
            sum += puzzles[i][0][0]*100 + puzzles[i][0][1]*10+puzzles[i][0][2];
            
        }
        return sum;
    }

    // Print out all the puzzles for testing
    public static void printPuzzles(int[][][] puz){
        for(int i = 0; i< puz.length; i++){
            for(int j = 0; j<puz[i].length; j++){
                for(int k = 0; k<puz[i][j].length; k++){
                    System.out.print(puz[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }



}