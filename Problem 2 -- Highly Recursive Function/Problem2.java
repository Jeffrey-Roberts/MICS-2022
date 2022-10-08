import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int x = scan.nextInt();

        for (int i = 0; i < x; i ++) {
            arr.add(scan.nextInt());
        }
        for (int i = 1; i <= arr.size(); i++) System.out.println("Case " + i + ": H(" + arr.get(i-1) + ") = " + recursive(arr.get(i-1)));
    }

    public static long recursive(long n) {
        if (n < -5) return recursive(n+4) + recursive(n+2);
        else if (n >= -5 && n < 2) return n*2;
        else return recursive(n-8) - recursive(n-4) + recursive(n-3);
    }

}
