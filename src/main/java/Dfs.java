import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by igor on 01.03.17.
 */
public class Dfs {

    //graph
    ArrayList<Integer>[] graph;
    //marked array
    boolean[] marked;

    //dfs
    private void dfs(int v) {
        if (marked[v]) {
            return;
        }
        marked[v] = true;
        for (int x : graph[v])
            dfs(x);
    }

    public static void main(String[] args) {
        new Dfs().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        marked = new boolean[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[--v1].add(--v2);
            graph[v2].add(v1);
        }

        dfs(0);
        for (int i = 0; i < N; ++i) {
            if(!marked[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }


}
