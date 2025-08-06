package com.dsa.questions.potd;
// Day - 05/08/25

import com.dsa.questions.potd.utils.QNode;

public class CopyListWithRandomPointer {
    public static QNode copyRandomList(QNode head) {
        if (head == null){
            return null;
        }

        QNode temp = head;
        while(temp != null){
            QNode newNode = new QNode(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        QNode oldList = head;
        QNode newList = head.next;
        QNode newHead = newList;

        while (oldList != null) {
            oldList.next = oldList.next.next;
            if (newList.next != null) {
                newList.next = newList.next.next;
            }
            oldList = oldList.next;
            newList = newList.next;
        }
        return newHead;
    }

    public static void main(String [] args){
        QNode node1 = new QNode(7);
        QNode node2 = new QNode(13);
        QNode node3 = new QNode(11);
        QNode node4 = new QNode(10);
        QNode node5 = new QNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        QNode ans = copyRandomList(node1);


    }

}
