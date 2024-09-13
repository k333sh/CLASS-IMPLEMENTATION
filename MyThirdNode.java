/*OYEWUSI ITEOLUWAKISI COMP1020
 * NODE CLASS USED  FOR QUESTION 3
 */
public class MyThirdNode {
    private String data; // The data in this Node
    private MyThirdNode link; // The link to the next Node
    
    //constructor 
    public MyThirdNode(String d, MyThirdNode n) {
        data = d;// set data
        link = n;// set link 
    }
    
    public String getData() {
        return data; // return string 
    }

    public void setData(String d) {
        data = d; //set String d
    }

    public MyThirdNode getNext() {
        return link; // get Link 
    }

    public void setNext(MyThirdNode n) {
        link = n; //set link directly 
    }
    public String toString(){
        return String.valueOf(data);  // string to return, although its already a string 
    }

}
