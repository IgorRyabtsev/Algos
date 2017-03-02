

import java.util.ArrayList;
import java.util.*;
import java.io.*;


    public class Main{

        class Pair<F, S> {

            public F first;
            public S second;
            public Pair(F f, S s) {
                this.first = f;
                this.second = s;
            }
        }

        private static final Integer INF = 100000000;

        public static void main(String[] argv) throws IOException{
            new Main().run();
        }
        PrintWriter pw;
        Scanner sc;
        public void run() throws IOException{
            sc = new Scanner(new File("input.txt"));
            pw = new PrintWriter(new File("output.txt"));


            int n;
            n = sc.nextInt();
            int s = 0 ; // стартовая вершина
            int f = 0;
            s = sc.nextInt();
            s--;
            f = sc.nextInt();
            f--;
            ArrayList < ArrayList <Pair<Integer,Integer>> > g = new  ArrayList < ArrayList <Pair<Integer,Integer>>>();

            for (int i=0; i<n; i++) {
                g.add(new ArrayList <Pair<Integer,Integer>>());
                for (int j=0; j<n; j++) {
                    g.get(i).add(new Pair((Integer) 0,(Integer)0));
                    g.get(i).get(j).first = j;

                    int next = sc.nextInt();
                    if (next == -1 ) next = INF ;
                    g.get(i).get(j).second = next;


                }
            }


            ArrayList<Integer> d = new ArrayList<Integer>(n);
            ArrayList<Integer> p = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
                d.add(INF);
                p.add(0);
            }

            d.set(s,0);

            boolean[] u = new boolean[n];
            for (int i=0; i<n; ++i) {
                int v = -1;
                for (int j=0; j<n; ++j)
                    if (!u[j] && (v == -1 || d.get(j) < d.get(v)))
                        v = j;
                if (d.get(v) == INF)
                    break;
                u[v] = true;

                for (int  j=0; j<g.size(); ++j) {
                    int to = g.get(v).get(j).first,
                            len = g.get(v).get(j).second;
                    if (d.get(v) + len < d.get(to)) {
                        d.set(to,d.get(v) + len);
                        p.set(to, v) ;
                    }
                }
            }
            if (d.get(f) >= INF) d.set(f,-1);
            pw.print(d.get(f));
            pw.close();
        }


    }

