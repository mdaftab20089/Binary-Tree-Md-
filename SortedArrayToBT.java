class ArrayToBinaryTree {
    public static class Node{
        Node left,right;
        int data;
        public Node(int data) {
            this.data=data;
        }
    }
    public void Display() {
        Display(head);
    }
    public void Display(Node root) {
        int[] arr={-10,-3,0,5,9};
        root=BST(arr);
        System.out.println(root.data);
    }
    public Node head;
    public Node BST(int[] arr) {
        return helper(arr, 0, arr.length-1);
    }
    public Node helper(int[] arr,int start,int end) {
           if(start>end) return null;
           int mid=start+(end-start)/2;
           Node root=new Node(mid);
           root.left=helper(arr, start, mid-1);
           root.right=helper(arr, mid+1, end);
           return root;
    }
    

     
}


class SortedArrayToBT {
    public static void main(String[] args) {
        ArrayToBinaryTree b=new ArrayToBinaryTree();
        //int[] arr={-10,-3,0,5,9};
        b.Display();
        
    }
    
}
