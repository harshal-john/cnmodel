import java.util.Scanner;

public class LinkState {
    static final int INF = 999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes/routers: ");
        int n = sc.nextInt();
        int[][] cost = new int[n][n];
        System.out.println("Enter the cost matrix (Use 999 for infinity):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = sc.nextInt();

        for (int src = 0; src < n; src++) {
            int[] dist = new int[n];
            int[] first = new int[n];     // first hop from src
            boolean[] done = new boolean[n];
            java.util.Arrays.fill(dist, INF);
            dist[src] = 0;
            first[src] = src;

            for (int c = 0; c < n; c++) {
                int u = -1;
                for (int v = 0; v < n; v++)
                    if (!done[v] && (u == -1 || dist[v] < dist[u])) u = v;
                if (u == -1 || dist[u] >= INF) break;
                done[u] = true;
                for (int v = 0; v < n; v++)
                    if (!done[v] && cost[u][v] < INF && dist[u] + cost[u][v] < dist[v]) {
                        dist[v] = dist[u] + cost[u][v];
                        first[v] = (u == src) ? v : first[u];
                    }
            }

            System.out.println("Routing Table for Router " + (char) ('A' + src) + ":");
            System.out.printf("%-16s%-16s%s%n", "Destination", "Distance", "Next Hop");
            for (int j = 0; j < n; j++) {
                String d = dist[j] >= INF ? "INF" : String.valueOf(dist[j]);
                String hop = dist[j] >= INF ? "-" : String.valueOf((char) ('A' + first[j]));
                System.out.printf("%-16s%-16s%s%n", (char) ('A' + j), d, hop);
            }
            System.out.println();
        }
    }
}
