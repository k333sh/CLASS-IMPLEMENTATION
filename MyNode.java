/*OYEWUSI ITEOLUWAKISI COMP1020
 * NODE CLASS USED IN MYLINKEDLIST FOR QUESTION 1
 */

public class MyNode {
    private Item data; // The data in this Node
    private MyNode link; // The link to the next Node

    public MyNode(Item d, MyNode n) {
        data = d; //set data
        link = n; // set what node points to 
    }

    public Item getData() {
        return data; // return Item 
    }

    public void setData(Item d) {
        data = d; // set the item d
    }

    public MyNode getNext() {
        return link;// get Link 
    }

    public void setNext(MyNode n) {
        link = n; //set Node pointer 
    }
    public String toString(){
        return String.valueOf(data); //get Sting value 
    }

}


