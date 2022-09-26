package code.Java;


import java.util.*;

public class palindrome {
    // This check Wether the given string is a palindrome or not.
       boolean Palindromechecking (String a)
       {
           // to avoid any mistake cause by small and capital Letter.
           a = a.toUpperCase();
           // This is checking if two position from either side have different character
           // If yes than returning false 
           for (int i = 0; i < a.length()/2; i++) {
               if (a.charAt(i) != a.charAt(a.length()- i- 1)) {
                   return false;
               }
           }
           return true;
       }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        palindrome b = new palindrome();
        System.out.print("\n\nEnter the String  :     ");
        String str = sc.nextLine();
        System.out.print("\n\nResult  :   "+b.Palindromechecking(str));
        System.out.println();
        System.out.println();
        sc.close();
    }
}
// Hariom Kaushal
// 202051080