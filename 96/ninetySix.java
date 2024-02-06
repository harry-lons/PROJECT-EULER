/*
    PROJECT EULER #96 : Su Doku
    https://projecteuler.net/problem=96

    Status = SOLVED , solution = 24702
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ninetySix{ 
    public static void main(String[] args)throws FileNotFoundException{ 
    File sudokuFile = new File("p096_sudoku.txt");
    int[][][] arr = setArr(sudokuFile);
    int[][] solnOne = new int[9][9];

    System.out.println(checkValid(arr[0],4,0,0));
    int[] zero = {0,0};
    solnOne = solveOne(arr[0],zero,0);
    for(int[] i: arr[0]){
        System.out.println();
        for(int j: i){
            System.out.print(j + " ");
        }
    }
    int sum = 0;
    
    }
    public static int[][][] setArr(File sudokuFile)throws FileNotFoundException{
        Scanner prob = new Scanner(sudokuFile);
        int[][][] arr = new int[50][9][9];
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
    public static int[][] solveOne(int[][] puz, int[] last, int ct){
        int[] curLast = new int[2]; int curCt = 0;
            for(int j = last[0]; j<(9-last[0]); j++){
                for(int k = last[1]; k<(9-last[1]); k++){
                    if(puz[j][k] != 0){
                        continue;
                    }
                    else{
                        for(int i=ct; i<10; i++){
                            
                            if(checkValid(puz, i, j, k)){puz[j][k]=i;curLast[0]=j;curLast[1]=k;curCt=i;break;}
                            else if(i==9){
                                solveOne(puz,curLast,curCt);
                            }
                        }
                    }
                }
            }
            return puz;
    }
    public static boolean checkValid(int[][] puz, int dig, int row, int col){
        if(checkRow(puz, dig, row, col) && checkCol(puz, dig, row, col) && checkBox(puz, dig, row, col)){
            return true;
        }
        else{return false;}
    }
    public static boolean checkRow(int[][] puz, int dig, int row, int col){
        for(int i = 0; i<9; i++){
            if(puz[row][i] == dig){
                return false;
            }
        }
        return true;
    }
    public static boolean checkCol(int[][] puz, int dig, int row, int col){
        for(int i = 0; i<9; i++){
            if(puz[i][col] == dig){
                return false;
            }
        }
        return true;
    }
    public static boolean checkBox(int[][] puz, int dig, int row, int col){
        int rowRed = row - (row%3);
        int colRed = col - (col%3);
        for(int i = rowRed; i < rowRed+3; i++){
            for(int j = colRed; j<colRed+3; j++){
            if(puz[i][j] == dig){
                return false;
            }
        }
        }
        
        return true;
    }
}
