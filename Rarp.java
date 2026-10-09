import java.util.*;

public class Rarp {
    public static void main(String[] args) {
        Map<String, String> rarpTable = new LinkedHashMap<>();
        rarpTable.put("AA:BB:CC:DD:EE:01", "192.168.1.1");
        rarpTable.put("AA:BB:CC:DD:EE:02", "192.168.1.2");
        rarpTable.put("AA:BB:CC:DD:EE:03", "192.168.1.3");
        rarpTable.put("AA:BB:CC:DD:EE:04", "192.168.1.4");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter MAC Address: ");
        String mac = sc.next().toUpperCase();

        System.out.println("\nRARP Request:");
        System.out.println("Who is " + mac + "? Please give me my IP address.");

        String ip = rarpTable.get(mac);
        System.out.println();
        if (ip == null) {
            System.out.println("No RARP reply received. MAC not found.");
        } else {
            System.out.println("RARP Reply:");
            System.out.println("MAC Address : " + mac);
            System.out.println("IP Address  : " + ip);
        }
    }
}
