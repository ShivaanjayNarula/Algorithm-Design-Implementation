import java.util.*;

class PreorderTreeNode {
    int val;
    PreorderTreeNode left;
    PreorderTreeNode right;
    PreorderTreeNode() {}
    PreorderTreeNode(int val) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Preorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PreorderTreeNode root = buildPreorderTree(sc);
        List<Integer> ans = preorderHelper(root);
        System.out.println(ans);
    }

    public static PreorderTreeNode buildPreorderTree(Scanner sc) {
        String[] values = sc.nextLine().split(" ");
        if (values.length == 0 || values[0].equals("-1")) {
            return null;
        }
        PreorderTreeNode root = new PreorderTreeNode(Integer.parseInt(values[0]));
        Queue<PreorderTreeNode> queue = new LinkedList<>(); // Correct type
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            PreorderTreeNode current = queue.poll();
            if (!values[i].equals("-1")) {
                current.left = new PreorderTreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && !values[i].equals("-1")) {
                current.right = new PreorderTreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static List<Integer> preorderHelper(PreorderTreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        ans.addAll(preorderHelper(root.left));
        ans.addAll(preorderHelper(root.right));
        return ans;
    }
}
