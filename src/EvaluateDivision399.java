import java.util.*;

public class EvaluateDivision399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = values.length;
        List<Double> valueList = new ArrayList<>();
        for (double d : values) {
            valueList.add(d);
        }
        for (int i = 0; i < len; i++) {
            List<String> temp = equations.get(i);
            List<String> newStr = new ArrayList<>();
            newStr.add(temp.get(1));
            newStr.add(temp.get(0));
            equations.add(newStr);
            valueList.add(1 / valueList.get(i));
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < equations.size(); i++) {
                List<String> target = equations.get(i);
                for (int j = i; j < equations.size(); j++) {
                    List<String> temp = equations.get(j);
                    if (target.get(1).equals(temp.get(0))) {
                        List<String> newStr = Arrays.asList(target.get(0), temp.get(1));
                        equations.add(newStr);
                        valueList.add(valueList.get(i) / valueList.get(j));
                        flag = true;
                    }
                }
            }
        }

        List<Double> resList = new ArrayList<>();
        for (List<String> query : queries) {
            int index = equations.indexOf(query);
            if (index == -1)
                resList.add(-1.0);
            else
                resList.add(valueList.get(index));
        }
        double[] resArr = new double[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }

    /*
    将整个问题建模成一张图：给定图中的一些点（变量），以及某些边的权值（两个变量的比值），
    试对任意两点（两个变量）求出其路径长（两个变量的比值）。

    因此，我们首先需要遍历 equations数组，找出其中所有不同的字符串，并通过哈希表将每个不同的字符串映射成整数。

    对于任何一个查询，从起点出发，通过广度优先搜索，不断更新起点与当前点之间的路径长度，直到搜索到终点为止。
     */

    private class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }


    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();

        int n = equations.size();
        for (List<String> equation : equations) {
            if (!variables.containsKey(equation.get(0))) {
                variables.put(equation.get(0), nvars++);
            }
            if (!variables.containsKey(equation.get(1))) {
                variables.put(equation.get(1), nvars++);
            }
        }

        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    //广度优先搜索从ia到ib的路径长度
                    Queue<Integer> points = new LinkedList<>();
                    points.offer(ia);
                    double[] ratios = new double[nvars];
                    Arrays.fill(ratios, -1.0);  //将到其他节点的距离初始化为-1
                    ratios[ia] = 1.0;

                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();      //从队首取出一个节点
                        for (Pair pair : edges[x]) {    //依次更新x可达节点的值ratios
                            int y = pair.index;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * pair.value;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];    //最终结果即到ib的距离值
                }
            }
            ret[i] = result;
        }
        return ret;
    }

    public double[] calcEquation3(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            //根据条件构建构建并查集的关系
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);   //判断两个节点之间是否相连
            }
        }
        return res;
    }

    private class UnionFind {

        private int[] parent;

        //指向的父结点的权值
        private double[] weight;


        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;  //更新并查集，将x的父节点指向y
            weight[rootX] = weight[y] * value / weight[x];  //更新x到y的weight值
        }

        /**
         * 查找根节点
         *
         * @param x 要查找的节点
         * @return 根结点的 id
         */
        public int find(int x) {
            if (x != parent[x]) {   //初始化时，并查集的根节点的parent是自己
                int origin = parent[x];
                parent[x] = find(parent[x]);    //沿路径递归查找x的根节点，同时修改parent指向
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }



    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> pair1 = Arrays.asList("a", "b");
        List<String> pair2 = Arrays.asList("b", "c");
        equations.add(pair1);
        equations.add(pair2);
        double[] values = {2.0, 3.0};
        List<String> query = Arrays.asList("a", "c");
        List<String> query2 = Arrays.asList("b", "a");
        List<String> query3 = Arrays.asList("a", "e");
        List<List<String>> queries = new ArrayList<>();
        queries.add(query);
        queries.add(query2);
        queries.add(query3);

        EvaluateDivision399 e = new EvaluateDivision399();
        double[] res = e.calcEquation2(equations, values, queries);
        System.out.println(res[1]);

    }
}
