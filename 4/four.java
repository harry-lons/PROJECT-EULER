/* 
PROJECT EULER #4 : Largest Palindrome Product
https://projecteuler.net/problem=4

Status: SOLVED , solution = 906609
*/
public class four {
    public static void main(String[] args) {
        int largestPalindrome = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                int product = i * j;
                if (isPalindrome(product) && product > largestPalindrome) {
                    largestPalindrome = product;
                }
            }
        }
        System.out.println("The largest palindrome made from the product of two 3-digit numbers is " + largestPalindrome);
    }

    public static boolean isPalindrome(int n) {
        int originalNumber = n;
        int reversedNumber = 0;
        while (n > 0) {
            int digit = n % 10;
            reversedNumber = reversedNumber * 10 + digit;
            n /= 10;
        }
        return originalNumber == reversedNumber;
    }
}
