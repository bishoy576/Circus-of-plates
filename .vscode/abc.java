import java.util.Scanner;

public class abc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k, n, ptr1, ptr2, max = 1, num;
        n = (long) scanner.nextInt();
        k = (long) scanner.nextInt();
        String str = scanner.nextLine().strip();
        ptr1 = 0;
        ptr2 = k + ptr1 - 1;
        while (ptr2 < n) {
            num = str.substring((int) ptr1, (int) ptr2 + 1).chars().distinct().count();
            if (num > max) {
                max = num;
            }
            ptr1++;
            ptr2++;
        }

        System.out.print(max);

    }
}
