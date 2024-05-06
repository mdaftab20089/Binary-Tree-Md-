import java.util.*;
class CBT3 {
    public static class Node {
           Node left ;
           Node right;
           int data;
           Node (int data) {
               this.data=data;
           }
   }
   Scanner S=new Scanner(System.in);
   public Node head;
   public void populate () {
          System.out.println("enter the root of Bt");
          int  x=S.nextInt();
          head=new Node(x);
          populate(head);
   }
   public void populate(Node node) {
       System.out.println("do you want to enter the left of "+node.data);
       boolean x=S.nextBoolean();
       if(x) {
           System.out.println("enter the left of "+node.data);
           int val=S.nextInt();
           node.left=new Node(val);
           populate(node.left);
       }
       System.out.println("do you want to enter the right of "+node.data);
       boolean y=S.nextBoolean();
       if(y) {
           System.out.println("enter the right of "+node.data);
           int val=S.nextInt();
           node.right=new Node(val);
           populate(node.right);
       }
   }
   public void display() {
       List<List<Integer>> list=new ArrayList<>();
       list=ZigZag(head);
       for(List<Integer> x:list) System.out.print(x);


   }
   public List<List<Integer>> ZigZag(Node root) {
    List<List<Integer>> list=new ArrayList<>();
    if(root == null) {
        return list;
    }
    Deque<Node> q=new LinkedList<>();
    q.offer(root);
    boolean reverse=false;
    while(!q.isEmpty()) {
        int levelSize=q.size();
        List<Integer> curr=new ArrayList<>();
        for(int i=0; i<levelSize; i++) {
            if(!reverse) {
            Node temp=q.pollFirst();
            curr.add(temp.data);
            if(temp.left!=null) {
                q.offerLast(temp.left);
            }
            if(temp.right!=null) {
                q.offerLast(temp.right);
            }
        } else {
            Node temp=q.pollLast();
            curr.add(temp.data);
            if(temp.left!=null) {
                q.offerFirst(temp.left);
            }
            if(temp.right!=null) {
                q.offerFirst(temp.right);
            }
        }
        }
        reverse=!reverse;
        list.add(curr);
    }

    return list;
   }
   public boolean isSymmetric(Node root) {
    if(root == null ) {
        return true;
    }
    return helper(root,root.left,root.right);
}
public boolean helper(Node root,Node x, Node y) {
    if(root==null) return true;
    if(x==null && y==null) {
        return true;
    }
     if(x==null || y==null) {
        return false;
    }
    if(x.data!=y.data) {
        return false;
    }
    else
    return (helper(root,x.left,y.right) && helper(root,x.right,y.left));
}
    public int diameter=0;
    public int Diameter(Node root) {
        if(root == null) return 0;
        height(root);
        return diameter-1;
    }
    public int height(Node root) {
        if(root==null) return 0;
        int leftheight=height(root.left);
        int righthight=height(root.right);
        int dia=leftheight+righthight+1;
        diameter=Math.max(diameter,dia);
        return Math.max(leftheight,righthight)+1;
    }
    public boolean MirrorImages(Node root) {
        if(root==null) return false;
        return Image(root.left,root.right);
    }
    boolean Image(Node x,Node y) {
        if(x==null && y==null) return true;
        if(x==null || y==null) return false;
        if(x.data!=y.data) {
            return false;
        }
        else return(Image(x.left, y.right) && Image(x.right, y.left));

    }
    public Node InvertBinaryTree(Node root) {
        if(root==null) return null;
        Node temp;
        if(root!=null) {
            InvertBinaryTree(root.left);
            InvertBinaryTree(root.right);
            temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        return root;
    }

}



class Zig {
    public static void main(String[] args) {
        CBT3 c=new CBT3();
        c.populate();
        c.display();
    }
    
}
