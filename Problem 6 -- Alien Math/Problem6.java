import java.util.*;

class AlienMath {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < x; i++)  calculate(scan.nextLine());
    }

    public static void calculate(String str) {
        String[] strArr = str.split(" ");
        String str1 = strArr[0];
        String str2 = strArr[1];

        String solution = "";

        boolean remainder = false;
        int x = 0;
        int y = 0;
        String a = "";
        String b = "";

        for (int i = str2.length()-1; i >= 0; i--) {
            if (str1.length() >= str2.length()) {
                a = str1.substring(i + str1.length() - str2.length(), i + str1.length() - str2.length() + 1);
                b = str2.substring(i, i + 1);
            }
            else {
                b = str1.substring(i + str1.length() - str2.length(), i + str1.length() - str2.length() + 1);
                a = str2.substring(i, i + 1);
            }

            if (a.matches("[0-9]")) x = Integer.parseInt(a);
            else x = a.charAt(0) - 55;
            if (b.matches("[0-9]")) y = Integer.parseInt(b);
            else y = b.charAt(0) - 55;

            if (!remainder) {
                if (x + y < 10) solution = solution + (x+y);
                else if (x + y >= 30) {
                    if (x + y - 30 >= 10) solution = solution + (char)(x+y+55 - 30);
                    else solution = solution + (x + y - 30);
                }
                else solution = solution + (char)(x+y+55);

                if (x + y >= 30) remainder = true;
                else remainder = false;
            }
            else {
                if (x + y + 1 < 10) solution = solution + (x+y+1);
                else if (x + y + 1 >= 30) {
                    if (x + y + 1 - 30 >= 10) solution = solution + (char)(x+y+55+1 - 30);
                    else solution = solution + (x + y + 1 - 30);
                }
                else solution = solution + (char)(x+y+1+55);

                if (x + y + 1 >= 30) remainder = true;
                else remainder = false;
            }
            System.out.println(solution);

        }
        if (str1.length() != str2.length()) {
            for (int i = str1.length()-str2.length()-1; i >= 0; i--) {
                a = str1.substring(i, i+1);
                if (a.matches("[0-9]")) x = Integer.parseInt(a);
                else x = a.charAt(0) - 55;

                if (remainder) {
                    if (x + 1 < 10) solution = solution + (x+1);
                    else if (x + 1 >= 30) {
                        if (x + 1 - 30 >= 10) solution = solution + (char)(x+1+55 - 30);
                        else solution = solution + (x + 1 - 30);
                    }
                    else solution = solution + (char)(x+1+55);

                    if (x + 1 >= 30) remainder = true;
                    else remainder = false;
                }
                else {
                    if (x < 10) solution = solution + (x);
                    else if (x >= 30) {
                        if (x + 30 >= 10) solution = solution + (char)(x+55 - 30);
                        else solution = solution + (x - 30);
                    }
                    else solution = solution + (char)(x+55);

                    if (x >= 30) remainder = true;
                    else remainder = false;
                }
            }
        }
        else if (remainder) solution = solution + 1;
        System.out.println(solution);
    }
}