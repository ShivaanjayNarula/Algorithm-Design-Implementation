import java.util.*;
class LevelOrderTreeNode {
    int val;
    LevelOrderTreeNode left;
    LevelOrderTreeNode right;
    LevelOrderTreeNode() {}
    LevelOrderTreeNode(int val) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Levelorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LevelOrderTreeNode root = buildLevelOrderTree(sc);
        List<Integer> ans = new ArrayList<>();
        int height = findHeight(root);
        for (int i = 1; i <= height; i++) {
            getLevelNodes(root, i, ans);
        }
        System.out.println(ans);
    }
    
    public static LevelOrderTreeNode buildLevelOrderTree(Scanner sc) {
        String[] values = sc.nextLine().split(" ");
        if (values.length == 0 || values[0].equals("-1")) {
            return null;
        }
        LevelOrderTreeNode root = new LevelOrderTreeNode(Integer.parseInt(values[0]));
        Queue<LevelOrderTreeNode> queue = new LinkedList<>(); // For building tree, use a queue
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            LevelOrderTreeNode current = queue.poll();
            if (!values[i].equals("-1")) {
                current.left = new LevelOrderTreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && !values[i].equals("-1")) {
                current.right = new LevelOrderTreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static int findHeight(LevelOrderTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void getLevelNodes(LevelOrderTreeNode root, int level, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            ans.add(root.val);
        } else if (level > 1) {
            getLevelNodes(root.left, level - 1, ans);
            getLevelNodes(root.right, level - 1, ans);
        }
    }
}
