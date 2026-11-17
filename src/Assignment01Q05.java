public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }
        int n = m.length;

        int[] distance = new int[n];
        for (int v = 0; v < n; v++) {
            distance[v] = -1;
        }

        int[] queue = new int[n];
        int head = 0;
        int tail = 0;

        queue[tail++] = i;
        distance[i] = 0;
        while (head < tail) {
            int v = queue[head++];

            for (int u = 0; u < n; u++) {
                if (m[v][u] == 1 && distance[u] == -1) {
                    distance[u] = distance[v] + 1;

                    if (u == j) {
                        return distance[u];
                    }

                    queue[tail++] = u;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 } }, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }, 0, 2)); // 2
    }

}