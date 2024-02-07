/*
    PROJECT EULER #15
    https://projecteuler.net/problem=15

    Status: SOLVED , Solution : 137846528820

    I don't think there is an efficient algorithm to compute this. I solved it mathematically by noting 
    that in an n x n grid, there are (2n choose n) paths, using the combinatorial choose function. Thus
    just compute (40 choose 20) for a 20 x 20 grid, which is 137846528820.

    However, this algorithm will find the answer. Test on smaller n.
 */

public class fifteen {
    // s = current count of solutions
    static int s = 0;
    public static void main(String[] args){

        int[][] grid = new int[21][21];
        step(grid,0,0);
        System.out.println(s);
    }
    /*  The step method will be the recursive method for finding solutions from a point in the graph
        grid: our grid
        i = current row
        j = current column
        s = current count of solutions
    */
    static void step(int[][] grid,int i, int j){
        System.out.println("i = " + i + " j = " + j + " s = " + s);
        // if we are at the end, we have found a successful path. increment s and return
        if(i == 20 && j == 20) { s += 1; return; }
        else if(downValid(grid,i)){
            step(grid,i+1,j);
        }
        if(rightValid(grid,j)){
            step(grid,i,j+1);
        }
        return;
    }
    static boolean downValid(int[][] grid,int i){
        if(i+1 > 20) return false;
        return true;
    }
    static boolean rightValid(int[][] grid,int j){
        if(j+1 > 20) return false;
        return true;
    }
}
