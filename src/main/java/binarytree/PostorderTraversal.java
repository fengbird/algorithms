package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ZhaoTengchao
 * @description 后序遍历-迭代解法,遍历流程：先遍历左子节点，再遍历右子节点，两边的都遍历完后再获取当前节点的值
 * @date 2021/7/9 下午4:42
 **/
public class PostorderTraversal {
    public static void main(String[] args) {
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        TreeNode node = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, node);
        List<Integer> integers = postorderTraversal.postorderTraversal(root);
        System.out.println(integers);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // 创建接收结果的集合
        List<Integer> list = new ArrayList<>();
        // 逻辑处理
        postorder(list, root);
        // 返回结果
        return list;
    }

    public void postorder(List<Integer> list, TreeNode root) {
        // 临界值处理
        if (root == null) {
            return;
        }
        // 创建栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        // 遍历条件：被遍历到的节点不为null或当前栈内不为空
        while (root != null || !stack.empty()) {
            // 如果当前节点不为null，则循环遍历至当前节点下最后一个左子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 取当前的栈顶元素
            root = stack.pop();
            // 如果当前节点的右子节点为null或当前节点的右子节点等于上次循环遍历到的元素
            if (root.right == null || root.right == prev) {
                // 将当前节点值放入集合
                list.add(root.val);
                // 将当前节点赋值给prev元素
                prev = root;
                // 将root值置为null
                root = null;
            } else {
                // 否则，重新将当前节点对象放回栈
                stack.push(root);
                // 此时当前节点的左子节点已没有数据，故将节点设置为右子节点进行新的遍历(发生在弹出之后)
                root = root.right;
            }
        }
    }
}
