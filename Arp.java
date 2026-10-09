import java.util.*;

public class Arp {
    public static void main(String[] args) {
        Map<String, String> arpTable = new LinkedHashMap<>();
        arpTable.put("192.168.1.1", "AA:BB:CC:DD:EE:01");
        arpTable.put("192.168.1.2", "AA:BB:CC:DD:EE:02");
        arpTable.put("192.168.1.3", "AA:BB:CC:DD:EE:03");
        arpTable.put("192.168.1.4", "AA:BB:CC:DD:EE:04");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP Address: ");
        String ip = sc.next();

        System.out.println("\nARP Request:");
        System.out.println("Who has IP address " + ip + "?");

        String mac = arpTable.get(ip);
        System.out.println();
        if (mac == null) {
            System.out.println("No ARP reply received. Host not found.");
        } else {
            System.out.println("ARP Reply:");
            System.out.println("IP Address  : " + ip);
            System.out.println("MAC Address : " + mac);
        }
    }
}
