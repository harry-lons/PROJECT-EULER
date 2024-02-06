/* 
PROJECT EULER #7 : 10001st prime
https://projecteuler.net/problem=7

Status: SOLVED , solution = 104743
*/
public class seven {
    public static void main(String[] args){
        int numPrimes = 1; int curr = 2;
        while(numPrimes<10001){
            for(int i = 2; i<curr; i++){
                if(curr%i == 0){
                    break;
                }
                if(i == curr-1){
                    numPrimes++;
                }
            }
            curr++;
        }
        System.out.println("the 10001st prime number is " + (curr-1));
    }
}
