/* 
PROJECT EULER #9 : Special Pythagorean Triplet
https://projecteuler.net/problem=9

Status: SOLVED , solution = 31875000
*/
public class nine {
    public static void main(String[] args){
        System.out.println(findPythagTrip(1000));
    }
    public static String findPythagTrip(int sumABC){
        
        for(int a=1;a<sumABC; a++){
            for(int b=1;b<sumABC;b++){
                for(int c=1;c<sumABC;c++){
                    if(a+b+c == sumABC && Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2)){
                        return "a = " + a + " b = " + b + " c = " + c + " product = "+ a*b*c;
                    }
                }
            }
        }
        return "none found";
    }
}
