package blind75;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {

    CloneGraphNode[] visited = new CloneGraphNode[101];

    public CloneGraphNode cloneGraph(CloneGraphNode node) {
        if(node == null) {
            return null;
        }
        return dfs(node);
    }

    private CloneGraphNode dfs(CloneGraphNode node) {
        if(visited[node.val] != null) {
            return visited[node.val];
        }
        CloneGraphNode res = new CloneGraphNode(node.val);
        visited[node.val] = res;
        for (CloneGraphNode n: node.neighbors) {
            visited[node.val].neighbors.add(dfs(n));
        }
        return res;
    }

}

class CloneGraphNode {
    public int val;
    public List<CloneGraphNode> neighbors;
    public CloneGraphNode() {
        val = 0;
        neighbors = new ArrayList<CloneGraphNode>();
    }
    public CloneGraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<CloneGraphNode>();
    }
    public CloneGraphNode(int _val, ArrayList<CloneGraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
