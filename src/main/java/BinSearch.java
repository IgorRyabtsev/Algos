import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 01.03.17.
 */
public class BinSearch {
    int lowerBound(List<Integer> list, int x) {
        int l = 0, r = list.size(); // [l..r] --> [l..r)
        while (l != r) {
            int m = (l + r) >> 1; // round down
            if (list.get(m) >= x)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        new BinSearch().run();
    }

    private void run() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 25; i += 2) {
            list.add(i);
        }

        assert(lowerBound(list,-1) == 0);
        assert(lowerBound(list, 12) == 6);
        assert(lowerBound(list, 12+1) == 7); // upperBound
    }
}
