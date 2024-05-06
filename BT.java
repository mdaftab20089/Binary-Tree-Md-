/*Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced
 binary search tree.

Example 1:

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs. */

import java.util.*;

class CBT {
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
        display(this.head," ");
    }
    private void display(Node node, String indent) {
        if (node == null) {
          return;
        }
        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
      }
    }


class BT {
    public static void main(String[] args) {
        CBT b=new CBT();
        b.populate();
        b.display();

    }
}

