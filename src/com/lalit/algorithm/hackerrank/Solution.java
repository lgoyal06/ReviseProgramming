package com.lalit.algorithm.hackerrank;

import java.math.*;


class Result {

    /*
     * Complete the 'zeros' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int zeros(int n) {
        // Write your code here
        BigInteger factorial = factorial(n);
        int zeroCount =0;
        boolean foundNonZero=false;
        while(!foundNonZero) {
            if (factorial.mod(new BigInteger("10")).equals(new BigInteger("0"))) {
                ++zeroCount;
                factorial = factorial.divide(new BigInteger("10"));
            } else {
                foundNonZero = true;
            }
        }
        return zeroCount;
    }

    public static BigInteger factorial(int n) {
        if (n == 1) {
            return new BigInteger("1");
        } else {
            return new BigInteger(String.valueOf(n)).multiply(factorial(n-1));
        }
    }

    public static void main(String ...s){
        System.out.println(Result.zeros(23));

    }
}