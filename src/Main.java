import java.util.Arrays;

public class Main {
    private final int[] integers;
    private int[] sizes = null;

    public static void main(String[] args) {
        int[] integers = new int[args.length];

        int key = 0;
        for (String value : args) {
            integers[key] = Integer.parseInt(value);
        }

        Main main = new Main(integers);
    }

    public Main(int[] integers) {
        this.integers = integers;
        this.sizes = new int[integers.length];
        Arrays.fill(this.sizes, 1);
    }

    public boolean connected(int a, int b) {
        return findRoot(a) == findRoot(b);
    }

    public int[] union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if (rootA == rootB) {
            return this.integers;
        }

        if (this.sizes[rootA] < this.sizes[rootB]) {
            this.integers[rootA] = rootB;
            this.sizes[rootB] += this.sizes[rootA];
        } else {
            this.integers[rootB] = rootA;
            this.sizes[rootA] += this.sizes[rootB];
        }

        return this.integers;
    }

    private int findRoot(int i) {
        while (i != this.integers[i]) {
            i = this.integers[i];
        }
        return i;
    }
}
