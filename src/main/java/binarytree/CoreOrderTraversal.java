package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序、中序、后序算法迭代解法中的核心代码
 * @author ZhaoTengchao
 * @date 2021/7/12 下午3:04
 **/
public class CoreOrderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> coreOrderTraversal(TreeNode root) {
        // 创建接收结构的集合
        List<Integer> list = new ArrayList<>();
        // 逻辑处理
        coreOrder(list, root);
        // 返回结果集
        return list;
    }

    // 核心代码主要就是这些，前、中、后序都是在这个代码的基础上做了一些微调
    public void coreOrder(List<Integer> list, TreeNode root) {
        // 临界值判断
        if (root == null) {
            return;
        }
        // 创建接收中间值的栈
        Stack<TreeNode> stack = new Stack<>();
        // 循环遍历
        while (root != null || !stack.empty()) {
            // 遍历左侧子树
            while (root != null) {
                // 在这里返回当前节点的结果值即为前序遍历
                // 做压栈处理
                stack.push(root);
                // 左子节点传递
                root = root.left;
            }
            // 做弹栈处理
            root = stack.pop();
            // 在这里直接返回当前节点的结果值即为中序遍历
            // 在这里对当前节点的右侧节点的临界值做下判断或者判断下当前节点的右节点是否等于上次遍历的节点(root.right == null || root.right == prev)
            // ，满足条件的结果值即为后序遍历(注意当不满足这个条件时因为没有取值操作，需要将当前节点重新压回栈中)
            // 右子节点传递
            root = root.right;
        }
    }
}