fn main(){
    println!("{}",count_mults_under(1000,3,5));
}

fn count_mults_under(n:i32,d1:i32,d2:i32) -> i32{
    let mut sum: i32 = 0;
    let mut i: i32 = 1;
    while i<n {
        if i % d1 == 0 || i % d2 == 0 {
            sum += i;
        }
        i+=1;
    }
    sum
}
