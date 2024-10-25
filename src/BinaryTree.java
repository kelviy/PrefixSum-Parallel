import java.util.concurrent.ForkJoinPool;

public class BinaryTree {
    private Node root;
    private int[] inputArray;
    private int[] outputArray;
    private ForkJoinPool forkJoinPool;

    public BinaryTree(int[] inputArray, int[] outputArray) {
        int[] range = {0, inputArray.length};
        this.inputArray = inputArray;
        this.outputArray = outputArray;
        root = new Node(inputArray, outputArray, range, Integer.MAX_VALUE, 0, new Node[2]);
        forkJoinPool = new ForkJoinPool();
        intialize();
    }

    public void intialize() {
        forkJoinPool.invoke(root);
    }

    public void sum() {
        forkJoinPool.invoke(new ParallelSum(root, 0, outputArray));
    }

    public void inOrderDFS(){
        inOrderDFS(root);
    }

    private void inOrderDFS(Node node) {
        if (node == null) return;
        System.out.println(node.toString());
        inOrderDFS(node.getChildren()[0]);
        inOrderDFS(node.getChildren()[1]);
    }
}
