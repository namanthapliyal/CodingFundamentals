package CodingFundamentals.Algorithms.Union;

public class Union {

    // O(N*N) for N unions on N objects so slow algo
    public class QuickFind {
        // Array DS which represents each index as object and if the index has same id
        // it means they are connected.
        private int[] id;

        // Constructor for initializing the Union find.
        public QuickFind(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        // connected if both have same id value.
        public boolean connected(int p, int q) {
            return id[p] == id[q];
        }

        // Connects object p to q
        void union(int p, int q) {
            int idp = id[p];
            int idq = id[q];
            if (idp == idq) {
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (id[i] == idp) {
                    id[i] = idq;
                }
            }
        }
    }

    public class QuickUnion {
        private int[] id;

        public QuickUnion(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        int findRoot(int p) {
            while(id[p]!=p){
                p=id[p];
            }
            return p;
        }

        void union(int p, int q) {
            int rootp = findRoot(p);
            int rootq = findRoot(q);
            id[rootp] = rootq;
        }

        boolean connected(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        void printArr() {
            for(int i: id){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        Union q = new Union();
        QuickUnion qu = q.new QuickUnion(10);
        qu.union(1, 2);
        qu.union(2, 3);
        qu.union(7,8);
        qu.printArr();
    }
}
