package com.neo.svc;

/**
 * @author xianshuangzhang
 * @date 2019/8/26 15:31
 */
public class Links {

    /**
     *
     *
     *
     * 1,2,3,4,5,6,7,8
     * 1,2,5,4,3,8,7,6
     * @param args
     */

    public static void main(String[] args) {
        Node n=Node.nw(1);
        n.next=Node.nw(2);
        n.next.next=Node.nw(3);
        n.next.next.next=Node.nw(4);
        n.next.next.next.next=Node.nw(5);
        n.next.next.next.next.next=Node.nw(6);
        n.next.next.next.next.next.next=Node.nw(7);

        Node c=rev(n);

        while (n!=null){
            System.out.print(n.value);
            n=n.next;
        }
    }

    public static void test(Node n1){
        n1=n1.next.next;
    }

    public static Node [] subLinkList(Node n,int length){

        Node head=n;

        Node nodes[]=new Node[2];
        while(length>0){
            n=n.next;
            length--;
        }
        nodes[0]=head;
        nodes[1]=n;
        return nodes;

    }
    public static Node partReverse(Node n){

        Node head=n;
        int count=0;
        while(count>0){
            n=n.next;
            count--;
        }

        Node head1=n;
        Node tail=null;
        while(true){
            Node[] nodes=subLinkList(n.next, 2);
            if(nodes[1]==null){
                break;
            }
            Node oldTail=nodes[1];
            nodes=reverse2(nodes[0],nodes[1] );
            n.next=nodes[0];
            tail=nodes[1];
            n=tail;
            tail.next=oldTail;
        }

        return head;
    }

    public static Node rev(Node head){
        /**
         *
         *
         * 1,2,3,4,5,6
         */

        Node oldHead=null;
        while(head!=null){
            Node temp=head.next;
            head.next=oldHead;
            oldHead=head;
            head=temp;
        }

        return oldHead;

    }
    public static Node[]  reverse2(Node head,Node end){

        Node newHead=head;
        Node temp=head;
        Node next=head.next;
        while(next.value!=end.value){
            newHead=next;
            next=next.next;
            newHead.next=temp;
            temp=newHead;
        }
//        head.next=null;

        Node nodes[]=new Node[2];
        nodes[0]=newHead;
        nodes[1]=head;
        return nodes;

    }


    public static Node  reverse(Node head){

        if(head==null||head.next==null){
            return head;
        }

        Node temp=head.next;
        head.next=null;
        Node next=temp;
        while(next!=null){
            next=next.next;
            temp.next=head;
            head=temp;
            temp=next;
        }
        return head;
    }

}


class Node{
    public int value;
    public Node next;

    @Override
    public String toString() {
        return "" +
                "v=" + value;
    }

    public static Node nw(int i){
        Node n=new Node();
        n.value=i;
        return n;
    }
}

