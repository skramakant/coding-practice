package org.example;


import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class CloneGraph {

    Node[] visited;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        visited = new Node[101];
        return dfs(node);
    }

    public Node dfs(Node node) {
        if (visited[node.val] != null) {
            return visited[node.val];
        }
        Node res = new Node(node.val);
        visited[node.val] = res;
        for (Node temp : node.neighbors) {
            res.neighbors.add(dfs(temp));
        }
        return res;
    }
}
