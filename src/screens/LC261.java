package screens;

/**
 * Created by Le on 2016/2/2.
 */
public class LC261 {

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++){
            // 如果两个节点已经在同一集合中，说明新的边将产生环路
            if(!uf.union(edges[i][0], edges[i][1])){
                return false;
            }
        }
        return uf.count() == 1;
    }

    public class UnionFind {

        int[] id;
        int cnt;
        int[] weight;

        public UnionFind(int size){
            this.id = new int[size];
            this.weight = new int[size];
            //初始化并查集，每个节点对应自己的集合号
            for(int i = 0; i < this.id.length; i++){
                this.id[i] = i;
                this.weight[i] = 1;
            }
            this.cnt = size;
        }
        public boolean union(int m, int n){
            //如果两个节点不在同一集合中，将两个集合合并为一个
            if(!isConnected(m, n)){
                int src = root(m);
                int dst = root(n);
                if (weight[src] < weight[dst]) {  //小树合并到大树, 作为一棵subtree
                    id[src] = dst;
                    weight[dst] += weight[src];
                } else {
                    id[dst] = src;
                    weight[src] += weight[dst];
                }
                // 合并完集合后，集合数减一
                cnt--;
                return true;
            } else {
                return false;
            }
        }

        /*
        在find方法的执行过程中，不是需要进行一个while循环找到根节点嘛？如果保存所有路过的中间节点到一个数组中，然后在while循环结束之后，将这些中间节点的父节点指向根节点，不就行了么？
        但是这个方法也有问题，因为find操作的频繁性，会造成频繁生成中间节点数组，相应的分配销毁的时间自然就上升了。那么有没有更好的方法呢？
        还是有的，即将节点的父节点指向该节点的爷爷节点，这一点很巧妙，十分方便且有效，相当于在寻找根节点的同时，对路径进行了压缩，使整个树结构扁平化。
         */

        public int root(int node) {
            while (node != id[node]) {
                id[node] = id[id[node]];
                node = id[node];
            }
            return node;
        }

        public boolean isConnected(int m, int n){
            return root(m) == root(n);
        }
        public int count(){
            return cnt;
        }
    }

}
