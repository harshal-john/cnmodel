import java.util.Scanner;

public class Distance {
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

        int[][] dist = new int[n][n];
        int[][] next = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                dist[i][j] = cost[i][j];
                next[i][j] = (i == j || cost[i][j] >= INF) ? -1 : j;
            }

        int iterations = 0;
        boolean changed;
        do {
            changed = false;
            iterations++;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int k = 0; k < n; k++)
                        if (i != k && cost[i][k] < INF
                                && dist[i][j] > cost[i][k] + dist[k][j]) {
                            dist[i][j] = cost[i][k] + dist[k][j];
                            next[i][j] = k;
                            changed = true;
                        }
        } while (changed);

        System.out.println("\nNetwork stabilized after " + iterations + " iterations.");
        for (int i = 0; i < n; i++) {
            System.out.println("\nRouting Table for Router " + (char) ('A' + i) + ":");
            System.out.printf("%-16s%-16s%s%n", "Destination", "Distance", "Next Hop");
            for (int j = 0; j < n; j++) {
                String hop = next[i][j] == -1 ? "-" : String.valueOf((char) ('A' + next[i][j]));
                String d = dist[i][j] >= INF ? "INF" : String.valueOf(dist[i][j]);
                System.out.printf("%-16s%-16s%s%n", (char) ('A' + j), d, hop);
            }
        }
    }
}
