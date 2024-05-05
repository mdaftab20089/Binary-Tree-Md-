import java.util.*;

class CBT2 {
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
      //  display(this.head," ");
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
       // ArrayList<Integer> arr=new ArrayList<>();
        list=LevelOrder(head);
        for(ArrayList arr:list) System.out.println(arr);
    }
    private void display(Node node, String indent) {
        if (node == null) {
          return;
        }
        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
      }
     
      public ArrayList<ArrayList<Integer>> LevelOrder(Node root) {
      ArrayList<ArrayList<Integer>> list=new ArrayList<>();
      if(root == null) {
      return list;
      }
      Queue<Node> q=new LinkedList<Node>();
      q.offer(root);
      while(!q.isEmpty()) {
        int levelSize=q.size();
      ArrayList<Integer> curr=new ArrayList<>();
      for(int i=0; i<levelSize; i++) {
        Node tmp=q.poll();
      if(tmp!=null) curr.add(tmp.data);
      if(tmp.left!=null) q.offer(tmp.left);
      if(tmp.right!=null) q.offer(tmp.right);
      }
      list.add(curr);
      } 
      return list;
      }
    public ArrayList<ArrayList<Integer>> ZigZagTraversal(Node root) {
      ArrayList<ArrayList<Integer>> list =new ArrayList<>();
      if(root == null) {
        return list;
      }
      Deque<Node> dq=new LinkedList<>();
      dq.offer(root);
      boolean rev=false;
      while(!dq.isEmpty()) {
      int levelSize=dq.size();
      ArrayList<Integer> curr=new ArrayList<>();
      for(int i=0; i<levelSize; i++) {
        if(!rev) {
          Node temp=dq.pollFirst();
          curr.add(temp.data);
          if(temp.left!=null) {
            dq.offerLast(temp.left);
          }
          if(temp.right!=null) {
            dq.offerLast(temp.right);
          }
        } else {
          Node temp=dq.pollLast();
          curr.add(temp.data);
          if(temp.right!=null) {
            dq.offerFirst(temp.right);
          }
          if(temp.left!=null) {
            dq.offerFirst(temp.right);
          }
        }

      }
      rev=!rev;
      list.add(curr);
      }
      return list;
    }  
    }


class LevelOrder {
    public static void main(String[] args) {
        CBT2 b=new CBT2();
        b.populate();
        b.display();
    }
}
