package algo0804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2023_2 {
    static int N = 100000000;
    static boolean[] dp;

public static void eratostenes(int n){
    for(int i = 2; i < (int)Math.sqrt(n) + 1; i++){
        if(dp[i] == true)
            continue;

        if(isPrime(i)) {
            for(int j = i * i; j < (int)Math.sqrt(n) + 1; j += i){
                dp[j] = true;
            }
        }
    }
}

public static boolean isPrime(int n){
    if(n < N && dp[n])
        return false;

    if (n == 1)
        return false;

    if (n == 2)
        return true;

    for(int i = 2 ; i <= (int)Math.sqrt(n) + 1 ; i++){
        if(n % i == 0)
            return false;
    }

    return true;
}

public static void main(String[] args) throws Exception{
	long start= System.currentTimeMillis();
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int temp;
    dp = new boolean[(int)Math.pow(10,n+1) + 1];

    // for(int i = 0 ; i < N; i++) {
    //     dp[i] = true;
    // }
    // System.out.println(Arrays.toString(dp));
    eratostenes(n);

    for(int i = (int)Math.pow(10,n-1); i < (int)Math.pow(10,n);i++){
        boolean flag = true;
        for(temp = i; temp > 0; temp /= 10){
            if(!isPrime(temp)){
                flag = false;
                break;
            }
        }
        
        if(flag)
            sb.append(i + "\n");
    }
    // System.out.println(Arrays.toString(dp));
    System.out.println(sb.toString());
    long end= System.currentTimeMillis();
    System.out.println("시간"+ (end-start)/1000.0);
    
}
}