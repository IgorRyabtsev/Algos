import java.io.IOException;
import java.util.Scanner;

/**
 * Created by igor on 01.03.17.
 */
public class Floyd {
    public static void main(String[] args) throws IOException {
        new Floyd().run();
    }

    private void run() throws IOException {
        int N = 0;

        MyReader in = new MyReader(System.in);
        MyWriter out = new MyWriter(System.out);

        N = in.nextInt();
        int[][] d = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                int n;
                n = in.nextInt();
                d[i][j] = n;
            }
        }

        //Floyd
        for (int k=0; k<N; ++k) {
            for (int i=0; i<N; ++i) {
                for (int j=0; j<N; ++j) {
                    d[i][j] =  Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                out.print(d[i][j] + " ");
            }
            out.print("\n");
        }
        out.close();
    }
}
