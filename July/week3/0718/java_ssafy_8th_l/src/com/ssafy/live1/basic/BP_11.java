package com.ssafy.live1.basic;

public class BP_11 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        // TODO: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
         int b3 = b1 + b2; // 연산자를하면 int로 내부적으로 된다.

        int i1 = 10;
        long l1 = 20;
        // TODO: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
        long i2 = i1 + l1; // 내부적으로 long이 된다.

        // TODO: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
         double f1 = 10.0; 
         double f2 = f1 + 20.0; // 내부적으로 double이 된다.
         
         
    }

}
