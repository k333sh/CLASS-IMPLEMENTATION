/*OYEWUSI ITEOLUWAKISI COMP1020
 * NODE CLASS USED FOR QUESTION 2
 */
public class MyNodeObj {
    private RowCol data; // The data in this Node
    private MyNodeObj link; // The link to the next Node

    public MyNodeObj(RowCol d, MyNodeObj n) {
        data = d;//set data
        link = n; // set link 
    }

    public RowCol getData() {
        return data; // get RowCol
    }

    public void setData(RowCol d) {
        data = d; //set RowCol
    }

    public MyNodeObj getNext() {
        return link; //get what Node points to 
    }

    public void setNext(MyNodeObj n) {
        link = n; //set the link 
    }
    public String toString(){
        return String.valueOf(data); // String output 
    }

  }
  

