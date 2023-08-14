package TreeHuffmanDecoding;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void decode(String s, Node root) {
        Node curr = root;
        for(char ch : s.toCharArray()){
            curr = (ch == '0') ? curr.left : curr.right;
            if(curr.left == null && curr.right == null){
                System.out.print(curr.data);
                curr = root;
            }
        }
       
    }

}
