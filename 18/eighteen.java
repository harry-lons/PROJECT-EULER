/*
    PROJECT EULER #18
    https://projecteuler.net/problem=18

    Status: SOLVED , Solution: 1074

    The problem statement says that this one can be solved with brute force, but problem 67 is the same challenge
    with more rows, and that one cannot be done by brute force. I will solve this one with brute force, then figure
    out Q67 when I get there.
 */


public class eighteen {
    static int[][] r = {{75},{95,64},{17,47,82},{18,35,87,10},{20,04,82,47,65},{19,01,23,75,03,34},
    {88,02,77,73,07,63,67},{99,65,04,28,06,16,70,92},{41,41,26,56,83,40,80,70,33},{41,48,72,33,47,32,37,16,94,29},
    {53,71,44,65,25,43,91,52,97,51,14},{70,11,33,28,77,73,17,78,39,68,17,57},{91,71,52,38,17,14,91,43,58,50,27,29,48},
    {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},{04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}};
    
    // static int[][] r = {{3},{7,4},{2,4,6},{8,5,9,3}};  // TEST EXAMPLE
    static int i = 0,j = 0,maxSum = 0;
    public static void main(String[] args){
        maxPathSum(r,0,0,0);
        // add back the first element since it doesn't get added in the algorithm
        System.out.println(maxSum + r[0][0]);
    }
    //recursive method to find 
    static int maxPathSum(int[][] r,int i,int j,int s){
        int sum = s;
        // System.out.println("i,j,s = " + i + "," + j + "," + s);
        if(i == r.length - 1){
            //we are in the last row
            return r[i][j];
        }
        int jPath = maxPathSum(r,i+1,j,s);
        int j1Path = maxPathSum(r,i+1,j+1,s);
        if(jPath >= j1Path){
            if(sum + jPath > maxSum){ 
                maxSum = sum + jPath ;
                // System.out.println("new maxSum: " + maxSum);
            }
            return sum + r[i][j] + jPath;
        }
        else{
            if(sum + j1Path > maxSum){ 
                maxSum = sum + j1Path ;
                // System.out.println("new maxSum: " + maxSum);
            
            }
            return sum + r[i][j] + j1Path;
        }
    }
}

