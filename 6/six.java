/* 
PROJECT EULER #6 : Sum Square Difference
https://projecteuler.net/problem=6

Status: SOLVED , solution = 25164150
*/
public class six {
    public static void main(String[] args){
        int sumOfSquares = 0; int squareOfSums = 0;
        for(int a = 1; a<=100; a++){
            sumOfSquares += Math.pow(a,2);
        }
        for(int a = 1; a<=100; a++){
            squareOfSums += a;
        }
        squareOfSums = (int) Math.pow(squareOfSums,2);
        System.out.println(squareOfSums - sumOfSquares);
    }
}
