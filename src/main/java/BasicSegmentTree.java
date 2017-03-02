import java.util.Arrays;
import java.util.Scanner;

public class BasicSegmentTree {
    int tree[];

    void buildDown(int[] a, int i, int l, int r) {
        if (r == l) {
            return;
        }

        if (r - l == 1) {
            tree[i] = a[l];
        } else {
            int m = (l + r) / 2;
            buildDown(a, 2 * i, l, m);
            buildDown(a, 2 * i + 1, m, r);
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    // [left, right)
    int get(int v, int l, int r, int tl, int tr) {
        if (tl >= r || tr <= l) {
            return 0;
        }

        if (tl >= l && tr <= r) {
            return tree[v];
        }

        int mid = (tl + tr) / 2;

        // можно какую-нб ассоциативную BiFunction
        return get(2*v, l, r, tl, mid) + get(2*v+1, l, r, mid, tr);
    }

    // [left, right)
    int assign(int x, int v, int l, int r, int tl, int tr) {
        if (tl >= r || tr <= l) {
            return tree[v];
        }

        if (tl == tr - 1) {
            return tree[v] = x;
        }

        int mid = (tl + tr) / 2;

        return tree[v] = assign(x, 2*v, l, r, tl, mid) + assign(x, 2*v+1, l, r, mid, tr);
    }

    int assign(int i, int x, int n) {
        return assign(x, 1, i-1, i, 0, n);
    }

    int get(int l, int r, int n) {
        return get(1, l-1, r, 0, n);
    }

    void solve() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        tree = new int[4*n];
        Arrays.fill(tree, 0);

        for (int i = 0; i < k; i++) {
            String req = sc.next();
            String l = sc.next();
            String r = sc.next();
            if (req.equals("A")) {
                assign(Integer.parseInt(l), Integer.parseInt(r),n);
            } else {
                System.out.println(get(Integer.parseInt(l), Integer.parseInt(r),n));
            }
        }
    }

    public static void main(String[] args) {
        new BasicSegmentTree().solve();
    }
}