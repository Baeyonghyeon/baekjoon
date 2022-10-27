package coplet;

import java.util.ArrayList;

public class TreeDFS {
    public static void main(String[] args) {
        TreeDFS.tree root = new TreeDFS.tree("1");
        TreeDFS.tree rootChild1 = root.addChildNode(new TreeDFS.tree("2"));
        TreeDFS.tree rootChild2 = root.addChildNode(new TreeDFS.tree("3"));
        TreeDFS.tree leaf1 = rootChild1.addChildNode(new TreeDFS.tree("4"));
        TreeDFS.tree leaf2 = rootChild1.addChildNode(new TreeDFS.tree("5"));
        ArrayList<String> output = dfs(root);
        System.out.println(output); // --> ["1", "2", "4", "5", "3"]

        leaf1.addChildNode(new TreeDFS.tree("6"));
        rootChild2.addChildNode(new TreeDFS.tree("7"));
        output = dfs(root);
        System.out.println(output); // --> ["1", "2", "4", "6", "5", "3", "7"]
    }

    public static ArrayList<String> dfs(tree node) {
        ArrayList<String> values = new ArrayList<>();
        values.add(node.getValue());

        if(node.getChildrenNode() != null) {
            for(int i = 0; i < node.getChildrenNode().size(); i++) {
                ArrayList<String> curList = dfs(node.getChildrenNode().get(i));
                values.addAll(curList);
            }
        }
        return values;
    }

    //아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class tree {
        private String value;
        private static ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public static tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}
