import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class Node extends RecursiveAction {
    private final int[] inputArray;
    private final int[] outputArray;
    private final int[] range;
    private int sum;
    private int fromLeft;
    private Node[] children;

    public Node(int[] inputArray, int[] outputArray, int[] range, int sum, int fromLeft, Node[] children) {
        this.inputArray = inputArray;
        this.outputArray = outputArray;
        this.range = range;
        this.sum = sum;
        this.fromLeft = fromLeft;
        this.children = children;
    }

    @Override
    protected void compute() {
        if (range[0] >= range[1]-1){
            if (sum == Integer.MAX_VALUE){
                sum = inputArray[range[0]];
            } else {
                outputArray[range[0]] = sum + fromLeft;
            }
        } else {
            int[] leftRange = {range[0], (range[0] + range[1])/2};
            int[] rightRange = {(range[0] + range[1])/2, range[1]};
            Node left = new Node(inputArray, outputArray, leftRange, Integer.MAX_VALUE, Integer.MAX_VALUE, new Node[2]);
            Node right = new Node(inputArray, outputArray, rightRange, Integer.MAX_VALUE, Integer.MAX_VALUE, new Node[2]);

            left.fork();
            right.compute();
            left.join();

            this.sum = left.sum + right.sum;
            this.children = new Node[]{left, right};
        }

    }

    @Override
    public String toString() {
        return String.format("Range: %s, Sum: %d, From Left: %d", Arrays.toString(range), sum, fromLeft);
    }

    public Node[] getChildren() {
        return children;
    }

    public int[] getRange() {
        return range;
    }

    public int getSum() {
        return sum;
    }

    public int getFromLeft() {
        return fromLeft;
    }

    public void setFromLeft(int fromLeft) {
        this.fromLeft = fromLeft;
    }
}
