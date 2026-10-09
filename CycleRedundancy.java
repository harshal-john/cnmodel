import java.util.Scanner;

public class CycleRedundancy {
    // Modulo-2 division; returns remainder (divisor.length()-1 bits)
    static String mod2div(String dividend, String divisor) {
        int n = divisor.length();
        char[] rem = dividend.substring(0, n).toCharArray();
        int pos = n;
        while (true) {
            if (rem[0] == '1') {
                for (int i = 0; i < n; i++)
                    rem[i] = (rem[i] == divisor.charAt(i)) ? '0' : '1';
            }
            if (pos >= dividend.length()) break;
            System.arraycopy(rem, 1, rem, 0, n - 1);
            rem[n - 1] = dividend.charAt(pos++);
        }
        return new String(rem, 1, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Data Bits: ");
        String data = sc.next();
        System.out.print("Enter Divisor: ");
        String divisor = sc.next();

        int k = divisor.length() - 1;
        String padded = data + "0".repeat(k);
        String crc = mod2div(padded, divisor);
        System.out.println("CRC Remainder: " + crc);
        System.out.println("Transmitted Data: " + data + crc);

        System.out.print("\nEnter Received Data: ");
        String received = sc.next();
        String check = mod2div(received, divisor);
        if (check.contains("1"))
            System.out.println("Error Detected!");
        else
            System.out.println("No Error Detected.");
    }
}
