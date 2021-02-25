import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule207 {
    //利用拓扑排序判断有向无环图
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];  //储存每个节点的入度
        List<List<Integer>> adjacency = new ArrayList<>();  //用列表储存每个节点的相连节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());

        for (int[] cp : prerequisites) {    //cp[1]->cp[0]
            indegrees[cp[0]]++;     //入度增加
            adjacency.get(cp[1]).add(cp[0]);    //将0节点加入1的相连节点
        }

        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0) queue.add(i);    // 找到入度为0的节点加入队列
        // BFS TopSort.
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre))  //遍历pre相连的节点，将其入度-1
                if (--indegrees[cur] == 0) queue.add(cur);    //若-1之后入度为9，则加入队列
        }
        return numCourses == 0; //若最后队列为空，代表拓扑排序成功
    }


    public static void main(String[] args) {

    }
}
