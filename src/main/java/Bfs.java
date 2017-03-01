import java.io.IOException;
import java.util.*;

/**
 * Created by igor on 02.03.17.
 */

//сумма расстояний от всех до всех
//вес = 1 всех ребер
public class Bfs {
    public static void main(String[] args) throws IOException {
        new Bfs().run();
    }

    private void run() throws IOException {
//        Scanner sc = new Scanner(System.in);
        MyReader sc = new MyReader(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[--v1].add(--v2);
            graph[v2].add(v1);
        }

        long summ = 0;
        for (int i = 0; i < N; ++i) {
            //bfs
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            boolean[] used = new boolean[N];
            int[] d = new int[N];
            used[i] = true;
            while (!q.isEmpty()) {
                int v = q.poll();
                for (int j = 0; j < graph[v].size(); ++j) {
                    int to = graph[v].get(j);
                    if (!used[to]) {
                        used[to] = true;
                        q.add(to);
                        d[to] = d[v] + 1;
                    }
                }
            }

            for (int k = 0; k < N; ++k) {
                summ +=  d[k];
            }

        }
        System.out.println(summ/2);
    }

}
