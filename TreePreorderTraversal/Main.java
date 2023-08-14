package TreePreorderTraversal;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static void preOrder(Node root) {
		if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
