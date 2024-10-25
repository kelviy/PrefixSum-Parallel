import java.util.concurrent.RecursiveAction;

public class ParallelSum extends RecursiveAction {
    private Node node;
    private int[] outArray;

    public ParallelSum(Node node, int fromLeft, int[] outArray) {
        this.node = node;
        node.setFromLeft(fromLeft);
        this.outArray = outArray;
    }

    @Override
    protected void compute() {
        if (node.getChildren()[0] == null) {
            assert (node.getChildren()[1] == null);

            outArray[node.getRange()[0]] = node.getSum() + node.getFromLeft();
            return;
        } else {
            ParallelSum left = new ParallelSum(node.getChildren()[0], node.getFromLeft(), outArray);
            ParallelSum right = new ParallelSum(node.getChildren()[1], node.getFromLeft() + node.getChildren()[0].getSum(),  outArray);

            left.fork();
            right.compute();
            left.join();
        }
    }
}
