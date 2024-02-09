/*
    Project Euler Q16
    https://projecteuler.net/problem=16

    Status: SOLVED , Solution = 1366

    Most complicated rust program I've written so far!
 */

#![ allow(nonstandard_style)]

fn main() {
    println!("{}",get_2_exp_dig_sum(1000));
}

fn get_2_exp_dig_sum(exp:i32) -> i32 {
    // Use a vec to store the digits of the large number, starting with 2^1 = 2
    let mut v = vec![2];
    let mut digiSum = 0;

    // Outer loop: loop from 1 to 1000 - this is the exponent, since 
    // 2^1000 = 2*2* ... * 2 1000 times
    for _i in 1..exp{
        let mut carryOver = 0;
        let mut j = v.len()-1;
        while j >= 0 {
            let mut twox = 2 * v[j];
            // increment if carryOver
            if carryOver == 1 { twox += 1; }
            // set current digit
            v[j] = twox % 10;

            // set carryOver correctly for the next loop
            if twox >= 10 { carryOver = 1; }
            else { carryOver = 0; }
            // break when we have done all the digits (we don't want to make j:usize negative)
            if j == 0 { break; }
            j -= 1;
        }
        // add a 1 at the beginning if we carried out 1 from the digit at index 0
        if carryOver == 1 { v.insert(0,1); }
        // pass adress of v into sumDigits, as v is an object
        digiSum = sumDigits(&v);
    }
    digiSum
}

pub fn sumDigits(v: &[i32]) -> i32{
    v.iter().sum()
}
