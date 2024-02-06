/* 
PROJECT EULER #5 : Smallest Multiple
https://projecteuler.net/problem=5

Status: SOLVED , solution = 232792560
*/

public class five {
    public static void main(String[] args){
        boolean found = false; int test = 0;
        while(found == false){
            test++;
            for(int i = 1; i<21; i++){
                if(test%i !=0){break;}
                if(i == 20){found = true;}
            }
        }
        System.out.println("the smallest positive number that is evenly divisible by all of the numbers from 1 to 20 is " + test);
    }
}