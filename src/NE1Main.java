import java.util.LinkedList;
import java.util.Scanner;

public class NE1Main {
    private static LinkedList<Integer> nodeList = new LinkedList<>();
    private static LinkedList<Integer> resList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();

        str= str.substring(1, str.length() - 1);
        if (str.length() == 0) {
            System.out.println("[]");
            return;
        }

        String[] nums = str.split(",");

        int root = Integer.parseInt(nums[0]);
        nodeList.add(root);

        getSum(nums, 0, target - root);

        if (resList == null) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < resList.size(); i++) {
            System.out.print(resList.get(i));
            if (i < resList.size() - 1)
                System.out.print(",");
        }
        System.out.println("]");
    }

    private static void getSum(String[] nums, int idx, int k) {
        if (k == 0) {
            if (resList == null || nodeList.size() < resList.size())
                resList = new LinkedList<>(nodeList);
            return;
        }
        if (2 * idx + 1 < nums.length&&!nums[2 * idx + 1].equals("null")) {
            int val = Integer.parseInt(nums[2 * idx + 1]);
            nodeList.add(val);
            getSum(nums, 2 * idx + 1, k - val);
            nodeList.removeLast();
        }

        if (2 * idx + 2 < nums.length&&!nums[2 * idx + 2].equals("null")) {
            int val = Integer.parseInt(nums[2 * idx + 2]);
            nodeList.add(val);
            getSum(nums, 2 * idx + 2, k - val);
            nodeList.removeLast();
        }
    }
}
