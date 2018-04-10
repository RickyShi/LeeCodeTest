package repo_2014.binaryTreeTraversal;


	import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

	public class BFSDFS {
	    static class TreeNode{
	        int value;
	        TreeNode left;
	        TreeNode right;

	        public TreeNode(int value){
	            this.value=value;
	        }
	    }

	    TreeNode root;

	    public BFSDFS(int[] array){
	        root=makeBinaryTreeByArray(array,1);
	    }

	    /**
	     * 采用递归的方式创建一颗二叉树
	     * 传入的是二叉树的数组表示法
	     * 构造后是二叉树的二叉链表表示法
	     */
	    public static TreeNode makeBinaryTreeByArray(int[] array,int index){
	        if(index<array.length){
	            int value=array[index];
	            if(value!=0){
	                TreeNode t=new TreeNode(value);
	                array[index]=0;
	                t.left=makeBinaryTreeByArray(array,index*2);
	                t.right=makeBinaryTreeByArray(array,index*2+1);
	                return t;
	            }
	        }
	        return null;
	    }

	    /**
	     * 深度优先遍历，相当于先根遍历
	     * 采用非递归实现
	     * 需要辅助数据结构：栈
	     */
	    public void depthOrderTraversal(){
	        if(root==null){
	            System.out.println("empty tree");
	            return;
	        }
	        ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
	        stack.push(root);
	        while(stack.isEmpty()==false){
	            TreeNode node=stack.pop();
	            System.out.print(node.value+"    ");
	            if(node.right!=null){
	                stack.push(node.right);
	            }
	            if(node.left!=null){
	                stack.push(node.left);
	            }
	        }
	        System.out.print("\n");
	    }

	    /**
	     * 广度优先遍历
	     * 采用非递归实现
	     * 需要辅助数据结构：队列
	     */
	    public void levelOrderTraversal(){
	        if(root==null){
	            System.out.println("empty tree");
	            return;
	        }
	        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
	        queue.add(root);
	        while(queue.isEmpty()==false){
	            TreeNode node=queue.remove();
	            System.out.print(node.value+"    ");
	            if(node.left!=null){
	                queue.add(node.left);
	            }
	            if(node.right!=null){
	                queue.add(node.right);
	            }
	        }
	        System.out.print("\n");
	    }

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return list;
		}
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			list.add(treeNode.value);
			if (treeNode.right != null) {
				stack.push(treeNode.right);
			}

			if (treeNode.left != null) {
				stack.push(treeNode.left);
			}
		}
		return list;
	}
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return list;
		}
		// 用一个boolean变量flag
		// flag = false表示顶点刚被push进去，需要首先处理左子树；
		// flag=true表示左子树都已经处理完了，可以处理右子树。
		// 栈中保存的元素都是栈底那个元素的左子树。
		boolean flag = true;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.peek();
			if (flag) {
				// push left subtree left nodes
				if (treeNode.left != null) {
					stack.push(treeNode.left);
					treeNode = treeNode.left;
				} else {
					flag = false;
				}
				// deal with root and right of the sub tree
			} else {
				list.add(stack.pop().value);
				if (treeNode.right != null) {
					stack.push(treeNode.right);
					flag = true;
				}
			}

		}
		return list;
	}

	    /**
	     *                  13
	     *                 /  \
	     *               65    5
	     *              /  \    \
	     *             97  25   37
	     *            /    /\   /
	     *           22   4 28 32
	     */
	    public static void main(String[] args) {
	        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
	        BFSDFS tree=new BFSDFS(arr);
	        tree.depthOrderTraversal();
	        tree.levelOrderTraversal();
		List<Integer> inOrderList = inorderTraversal(tree.root);
		Iterator<Integer> itr = inOrderList.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + "    ");
		}
		System.out.print("\n");
		List<Integer> preOrderList = preorderTraversal(tree.root);
		Iterator<Integer> itr2 = preOrderList.iterator();
		while (itr2.hasNext()) {
			System.out.print(itr2.next() + "    ");
		}
		System.out.print("\n");

	    }


}
