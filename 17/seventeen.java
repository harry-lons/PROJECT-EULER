/*
    PROJECT EULER #17
    (https://projecteuler.net/problem=17)

    Status: SOLVED , Solution = 21124

    Messy problem, not fun or interesting
 */

public class seventeen{

    public static void main(String[] args){
        int[] word_lengths = init(1000);
        int sum = 0;
        for(int j : word_lengths){ sum += j;}
        System.out.println();
        System.out.println(sum + 11); // add 11 because I was too lazy to include 1000 in the other method

    }

    // note there would be an out of bounds error for n < 19
    static int[] init(int n){
        int[] ret = new int[n];
        ret[0] = "one".length();
        ret[1] = "two".length();
        ret[2] = "three".length();
        ret[3] = "four".length();
        ret[4] = "five".length();
        ret[5] = "six".length();
        ret[6] = "seven".length();
        ret[7] = "eight".length();
        ret[8] = "nine".length();
        ret[9] = "ten".length();
        ret[10] = "eleven".length();
        ret[11] = "twelve".length();
        ret[12] = "thirteen".length();
        ret[13] = "fourteen".length();
        ret[14] = "fifteen".length();
        ret[15] = "sixteen".length();
        ret[16] = "seventeen".length();
        ret[17] = "eighteen".length();
        ret[18] = "nineteen".length();
        int[] tens = new int[10];
        tens[2] = "twenty".length();
        tens[3] = "thirty".length();
        tens[4] = "forty".length();
        tens[5] = "fifty".length();
        tens[6] = "sixty".length();
        tens[7] = "seventy".length();
        tens[8] = "eighty".length();
        tens[9] = "ninety".length();
        String[] onestr = new String[19];
       onestr[0] = "one";
       onestr[1] = "two" ;
       onestr[2] = "three" ;
       onestr[3] = "four" ;
       onestr[4] = "five" ;
       onestr[5] = "six" ;
       onestr[6] = "seven" ;
       onestr[7] = "eight" ;
       onestr[8] = "nine" ;
       onestr[9] = "ten" ;
       onestr[10] = "eleven" ;
       onestr[11] = "twelve" ;
       onestr[12] = "thirteen" ;
       onestr[13] = "fourteen" ;
       onestr[14] = "fifteen" ;
       onestr[15] = "sixteen" ;
       onestr[16] = "seventeen" ;
       onestr[17] = "eighteen" ;
       onestr[18] = "nineteen" ;
        String[] tenstr = new  String[10];
       tenstr[2] = "twenty" ;
       tenstr[3] = "thirty" ;
       tenstr[4] = "forty" ;
       tenstr[5] = "fifty" ;
       tenstr[6] = "sixty" ;
       tenstr[7] = "seventy" ;
       tenstr[8] = "eighty" ;
       tenstr[9] = "ninety" ;


        for(int i = 19; i < n; i ++){
            // let n be the number we are currently representing
            int j = i + 1;
            // establish variables for the ones, tens, and hundreds places of n
            int oneDig = j % 10; int tenDig = (j / 10) % 10; int hunDig = (j / 100) % 10;

            // Ones:

            int oneSize = 0;
            String oneString = "";
            if( oneDig > 0 ) {
                oneSize = ret[oneDig - 1];
                oneString = " " + onestr[oneDig - 1];
            }

            // Tens:

            int tenSize = 0;
            String tenString = "";
            if(tenDig == 0){
                tenSize = 0;
            }
            else if(tenDig == 1){ 
                // we are in the teens, which have unique behavior. Set oneSize to 0 and use the correct teen value
                oneSize = 0; 
                tenSize = ret[tenDig*10 + oneDig - 1]; 
                tenString = " " + onestr[tenDig*10 + oneDig - 1];
            }
            else{
                tenSize = tens[tenDig]; 
                tenString = " " + tenstr[tenDig];
            }

            // Hundreds: 

            int hunSize = 0;
            String hunString = "";
            if(hunDig > 0) {
                hunString = " and";
                hunSize = ret[hunDig - 1] + 10; // + 7 for "hundred", + 3 for "and"
                // if there are no tens or ones, we don't need "and" (EX: two hundred)
                if(tenSize == 0 && oneSize == 0){hunSize -= 3; hunString = "";}
                hunString = onestr[hunDig - 1] + " hundred" + hunString;
            }
            String concString = hunString + tenString + oneString;
            System.out.println("i = "+i+" j = "+j+" is " + concString + " is size " +hunSize+", "+tenSize+", "+oneSize +" =  "+ (hunSize + tenSize + oneSize) );
            System.out.println(" hunSize, tenSize, oneSize = "+hunSize+", "+tenSize+", "+oneSize);
            ret[i] = hunSize + tenSize + oneSize;
        } 
        return ret;
    }
}