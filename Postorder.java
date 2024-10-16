import java.util.*;

class PostorderTreeNode {
    int val;
    PostorderTreeNode left;
    PostorderTreeNode right;
    PostorderTreeNode() {}
    PostorderTreeNode(int val) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Postorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PostorderTreeNode root = buildPostorderTree(sc);
        List<Integer> ans = postorderHelper(root);
        System.out.println(ans);
    }

    public static PostorderTreeNode buildPostorderTree(Scanner sc) {
        String[] values = sc.nextLine().split(" ");
        if (values.length == 0 || values[0].equals("-1")) {
            return null;
        }
        PostorderTreeNode root = new PostorderTreeNode(Integer.parseInt(values[0]));
        Queue<PostorderTreeNode> queue = new LinkedList<>(); // Queue for level-order input
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            PostorderTreeNode current = queue.poll();
            if (!values[i].equals("-1")) {
                current.left = new PostorderTreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && !values[i].equals("-1")) {
                current.right = new PostorderTreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static List<Integer> postorderHelper(PostorderTreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.addAll(postorderHelper(root.left));
        ans.addAll(postorderHelper(root.right));
        ans.add(root.val); // Postorder: left, right, root
        return ans;
    }
}
