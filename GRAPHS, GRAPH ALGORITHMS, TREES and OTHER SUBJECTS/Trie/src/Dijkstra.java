public class Dijkstra {

    public static int INFINITY = 1000;

    public static void main(String args[]) {

        int N = 5;

        // int[][] cost	= new int[N][N];

        int[][] cost = {
                {1000, 5, 3, 1000, 2},
                {1000, 1000, 2, 9, 1000},
                {1000, 5, 1000, 4, 1000},
                {1000, 1000, 1000, 1000, 1000},
                {1000, 6, 10, 7, 1000}};

        int distances[] = new int[N];

        Distance(N, cost, distances);

        for (int i = 0; i < distances.length; ++i)
            System.out.println(distances[i]);
    }


    public static void Distance(int N, int[][] cost, int[] D) {

        int w, v, min;

        boolean visited[] = new boolean[N];

        D[0] = 0;
        for (v = 1; v < N; v++) {
            visited[v] = false;
            D[v] = cost[0][v];
        }
        ;

        for (int i = 1; i < N; ++i) {
            min = INFINITY;
            for (w = 1; w < N; w++)
                if (!visited[w])
                    if (D[w] < min) {
                        v = w;
                        min = D[w];
                    }

            visited[v] = true;

            for (w = 1; w < N; w++)
                if (!visited[w])
                    if (min + cost[v][w] < D[w])
                        D[w] = min + cost[v][w];
        }

    }

}

