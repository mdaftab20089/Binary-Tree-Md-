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
   }



class Zig {
    public static void main(String[] args) {
        CBT3 c=new CBT3();
        c.populate();
        c.display();
    }
    
}
