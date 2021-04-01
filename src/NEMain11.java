//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//
//
//public class Main {
//    static class TreeNode3 {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int x) {
//            val = x;
//        }
//
//    }
//
//    static TreeNode getNode(String s){
//        if (s.equals("null"))
//            return null;
//        else {
//            int value=Integer.parseInt(s);
//            return new TreeNode(value);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        String str=scanner.nextLine();
//        String subs=str.substring(1,str.length()-1);
//        if (subs.length()==0) {
//            System.out.println("[]");
//            return;
//        }
//
//        String[] nums=subs.split(",");
//
//        Queue<TreeNode> queue=new LinkedList<>();
//        TreeNode root=new TreeNode(Integer.parseInt(nums[0]));
//        queue.offer(root);
//        int index=1;
//
//        while (!queue.isEmpty()){
//            int queueLen=queue.size();
//            for (int i = 0; i < queueLen; i++) {
//                TreeNode parent=queue.poll();
//                if (parent!=null){
//                    parent.left=getNode(nums[index++]);
//                    parent.right=getNode(nums[index++]);
//                    queue.offer(parent.left);
//                    queue.offer(parent.right);
//                }
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//
//        }
//    }
//
//
//}