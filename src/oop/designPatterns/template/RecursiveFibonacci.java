package template;

public class RecursiveFibonacci implements Fibonacci {

    private long[] memory;

    @Override
    public long fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }

        if (memory == null) {
            memory = new long[n];
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        return memory[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

}
