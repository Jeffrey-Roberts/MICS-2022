import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Long> arr = new ArrayList<Long>();

        long x = scan.nextLong();
        long y = scan.nextLong();

        for (long i = x; i <= y; i++) {
            if (isPrime(i)) arr.add(i);
        }

        for (int i = 0; i < arr.size() - 1; i ++) {
            if (arr.get(i+1) - arr.get(i) == 2) System.out.println("(" + arr.get(i) + ", " + arr.get(i+1) + ")");
        }


    }

    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n%2 == 0 || n%3 ==0) return false;

        long sqrtN = (long) Math.sqrt(n) +1;
        for (long i = 6L; i <= sqrtN; i+= 6) {
            if (n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
}