import java.util.*;

public class QueueStack {
    public static void main(String[] args) {
//        Stack<Integer> st = new Stack<>();      //新建栈
//        st.push(3);
//        int peek=st.peek();     //获取栈顶元素
//        System.out.println(peek);
//        int pop=st.pop();       //弹出栈顶元素
//        System.out.println(pop);
//        System.out.println(st.empty());     //判断栈是否为空

//        Queue<Integer> queue = new LinkedList<>();    //创建并初始化队列
//        queue.offer(1);     //元素入队
//        queue.offer(3);
//        queue.offer(5);
//        for(int num:queue)      //遍历队列
//            System.out.println(num);
//        int qNum=queue.poll();  //元素出队
//        System.out.println(qNum);
//
//        long round=Math.round(3.1415);      //四舍五入
//        double floor=Math.floor(3.1415);    //向上取整
//        double ceil=Math.ceil(3.1415);      //向下取整
//        double random=Math.random();        //取随机数
//        System.out.println(floor);
        List<Integer> numList=new ArrayList<>();
        numList.add(1);
        numList.add(2);
        System.out.println(numList);
        numList.clear();
        System.out.println(numList);
    }
}
