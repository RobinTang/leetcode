import java.util.*;

public class App {
    static class Node {
        List<Node> childs = new LinkedList<>();
        int value;

        Node(int v) {
            this.value = v;
        }
    }

    static Node exists(Node n, int value) {
        if (n == null) {
            return null;
        }
        if (n.value == value) {
            return n;
        }
        if (!n.childs.isEmpty()) {
            for(Node nn:n.childs) {
                return exists(nn, value);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] deps = new int[n][2];
        for (int i = 0; i < n; i++) {
            deps[i][0] = input.nextInt();
            deps[i][1] = input.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(deps[i][0] + " " + deps[i][1]);
        }

        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node parent = null;
            for (Node node : nodeList) {
                parent = exists(node, deps[i][1]);
            }
            if (parent == null) {
                parent = new Node(deps[i][1]);
                nodeList.add(parent);
            }

            Node cur = null;
            for (Node node : nodeList) {
                cur = exists(node, deps[i][0]);
            }
            if (parent != null) {
                if (cur == null) {
                    parent.childs.add(new Node(deps[i][0]));
                } else {
                    if (exists(parent, cur.value) != null) {
                        return;
                    }
                    parent.childs.add(cur);
                }
            }

        }
        System.out.println("suc");
    }
}
