import java.util.*;

class InorderTreeNode {
    int val;
    InorderTreeNode left;
    InorderTreeNode right;
    InorderTreeNode() {}
    InorderTreeNode(int val) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Inorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InorderTreeNode root = buildInorderTree(sc);
        List<Integer> ans = inorderHelper(root);
        System.out.println(ans);
    }

    public static InorderTreeNode buildInorderTree(Scanner sc) {
        String[] values = sc.nextLine().split(" ");
        if (values.length == 0 || values[0].equals("-1")) {
            return null;
        }
        InorderTreeNode root = new InorderTreeNode(Integer.parseInt(values[0]));
        Queue<InorderTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            InorderTreeNode current = queue.poll();
            if (!values[i].equals("-1")) {
                current.left = new InorderTreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && !values[i].equals("-1")) {
                current.right = new InorderTreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static List<Integer> inorderHelper(InorderTreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.addAll(inorderHelper(root.left));
        ans.add(root.val);
        ans.addAll(inorderHelper(root.right));
        return ans;
    }
}
