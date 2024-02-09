/*
    PROJECT EULER #20
    https://projecteuler.net/problem=20

    Status: SOLVED, Solution = 648

    Using a similar approach to Q16, but this time I wrote the whole 
    thing in rust from scratch
*/

#![ allow(nonstandard_style)]

fn main() {
    println!("{}",get_fact_digits(100));
}
fn get_fact_digits(n:i32) -> i32{
    let mut digits = vec![1];
    for i in 1..n+1{
        let mut carryIn = 0;
        //.iter().enumerate() makes j a 2-tuple (index, value) for each value in digits
        // .rev() allows us to traverse digits in reverse order
        for (idx,mut value) in digits.iter_mut().enumerate().rev(){
            // digit * i
            let mut ivalue = *value * i;
            ivalue += carryIn;
            // get carryout
            carryIn = ivalue / 10;
            // set current digit
            *value = ivalue % 10;
            
        }
        while carryIn != 0{
            digits.insert(0,carryIn % 10);
            carryIn /= 10;
        }
        /*  Print statements for debugging
        println!("{} factorial is: ",i);
        for i in digits.iter(){
            print!(" {}",*i);
        }
        println!();
        */
    }
    // return the sum of digits
    digits.iter().sum()
}

