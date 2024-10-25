import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] serialIn = new int[] {6, 4, 16, 10, 16, 14, 2, 8};
        int[] serialOut = new int[8];


        int[] parallelIn = new int[] {6, 4, 16, 10, 16, 14, 2, 8};
        int[] parallelOut = new int[8];

        prefixSumSerial(serialIn, serialOut);

        System.out.println(Arrays.toString(serialOut));

        BinaryTree bt = new BinaryTree(parallelIn, parallelOut);
        bt.inOrderDFS();
        bt.sum();

        System.out.println(Arrays.toString(parallelOut));

    }

    public static void prefixSumSerial(int[] inArray, int[] outArray) {
        if (inArray == null || inArray.length == 0 || outArray == null || outArray.length == 0) {
            return;
        }
        outArray[0] = inArray[0];
        for (int i = 1; i < inArray.length; i++) {
            outArray[i] = outArray[i-1] + inArray[i];
        }
    }
}
