/*
    Project Euler Q16
    https://projecteuler.net/problem=16

    Status: SOLVED , Solution = 1366
 */

import java.util.ArrayList;
public class sixteen{
    public static void main(String[] args){
        System.out.println(get_2_exp_dig_sum(1000));
    }
    static int get_2_exp_dig_sum(int n){
        // We will use an ArrayList to store the digits of the number
        ArrayList<Integer> digiArr = new ArrayList<Integer>();
        int sum = 0;
        // start with 2^1 = 2
        digiArr.add(2);
        // let i be the current exponent of 2. We will iteratively calculate the digits at each exponent
        for(int i = 1; i < n; i++){
            // carryOver variable to track if we should carry a 1 or 0 to the next digit. 0 by default
            int carryOver = 0;
            for(int j = digiArr.size() - 1; j> -1; j--){
                // let twox represent two times the current digit
                int twox = digiArr.get(j)*2;
                // if we should carryOver, increment twox accordingly
                if(carryOver == 1) { twox = twox + 1; };
                // set the current digit of j to be the last digit of twox
                digiArr.set(j,twox % 10);
                // check for carryOver
                if(twox >= 10){carryOver = 1;}
                else{ carryOver = 0; }
            }
            // if carryOver is 1 after doing all the digits, we should add a digit 1 at the start
            if(carryOver == 1){
                digiArr.add(0,1);
            }
            // update sum
            sum = sumDigits(digiArr);
        }
        return sum;
    }

    // sumDigits helper method
    static int sumDigits(ArrayList<Integer> digiArr){
        int sum = 0;
        for(Integer i : digiArr){
            sum += i;
        }
        return sum;
    }
}