package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历-Morris(莫里斯)遍历实现
 * @author ZhaoTengchao
 * @date 2021/7/12 下午1:56
 **/
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, node);
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        List<Integer> integers = preorderTraversal.preorderTraversal(root);
        System.out.println(integers);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // 创建接收结果的集合
        List<Integer> list = new ArrayList<>();
        // 逻辑处理
        preorderForMorris(list, root);
        // 返回结果
        return list;
    }

    private void preorderForMorris(List<Integer> list, TreeNode root) {
        // 临界值处理
        if (root == null) {
            return;
        }
        // 声明两个变量
        TreeNode p1 = root, p2;
        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    list.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                list.add(p1.val);
            }
            p1 = p1.right;
        }
    }
}
