package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DesignFileSystem {
    Tri root;

    public DesignFileSystem() {
        root = new Tri();
    }

    public List<String> ls(String path) {
        LinkedList<String> ans = new LinkedList<>();

        Tri node = root.search(path);

        if(node == null) {
            return ans;
        }

        if(node.isFile) {
            ans.add(node.name);
        }

        for(Map.Entry<String, Tri> keyValue : node.children.entrySet()) {
            ans.add(keyValue.getKey());
        }

        return ans;
    }

    public void mkdir(String path) {
        root.insert(path, false);
    }

    public void addContentToFile(String filePath, String content) {
        Tri node = root.insert(filePath, true);
        node.content.append(content);
    }

    public String readContentFromFile(String filePath, String content) {
        Tri node = root.search(filePath);
        return node.content.toString();
    }
}


class Tri {
    String name; // name of file
    StringBuilder content; // content in the file
    boolean isFile; // file or directory
    HashMap<String, Tri> children; // it will have children if it is a directory

    public Tri insert(String path, boolean isFile) {
        Tri node = this;

        String[] paths = path.split("/");

        for(int i=1; i<path.length(); i++) {

            String childPath = paths[i];

            if(!node.children.containsKey(childPath)) {
                node.children.put(childPath, new Tri());
            }

            node = node.children.get(childPath);
        }

        node.isFile = isFile;

        if(isFile) {
            node.name = paths[paths.length -1];
        }

        return node;
    }

    public Tri search(String path) {
        Tri node = this;
        String[] paths = path.split("/");

        for (int i=1; i< paths.length; i++) {
            String childPath = paths[i];

            if(!node.children.containsKey(childPath)) {
                return null;
            }
            node = node.children.get(childPath);
        }

        return node;
    }
}
