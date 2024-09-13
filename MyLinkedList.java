/* OYEWUSI ITEOLUWAKISI 7959523 
 * ASSIGNMENT 5 
 * LINKED LIST MADE TO SOLVE QUESTION 1 
 */
public class MyLinkedList {
   MyNode top; // The reference to the first Node
   int nodes;

   public MyLinkedList() {
      top = null; // It's null by default anyway.
      nodes = 0; // start list size at 0
   }

   public void add(Item newItem) {
      MyNode newNode = new MyNode(newItem, top);// create newNode for NewItem
      top = newNode;// top points to new node 
      nodes ++; // add to nodes 
   }
   public String toString() {
      String answer = "<< "; // demarcation
      MyNode current = top; // Start at the first one
      while (current != null) {
         answer += current.getData() + " ";
         current = current.getNext(); // traverse the list
      }
      return answer + ">>";
   }
   
   //method to get pos of Item in list 
   public Item get(int pos) {
      MyNode current = top; // start at the top 
      if(current == null){
       return null;
      }
      while(current!= null && pos > 0){
       // newItem = this.get(pos);
        current = current.getNext();
        pos--;
       }
      return  current.getData();
   }

   public int size() {
      return nodes; // return nodes amount ;
   }

   //sort method 
   public void sort(MyLinkedList x){
     MyLinkedList newSortedList = new MyLinkedList();// newList
     MyNode current = top ; // start from top 
     Item largestItem; // create a largeItem for storing the largest Item
     while( current!= null && !x.isEmpty() ){
      largestItem = FindLargest(x);// find Largest item
      newSortedList.add(largestItem); //add that Item to the sortedList 
      remove(largestItem); // remove from olderList

      current = current.getNext(); // iterate through the list 
     }

     top = newSortedList.top; // move top to the new SortedList
     nodes = newSortedList.nodes; //configure nodes to be nodes for sortedList 

   }

   private boolean isEmpty() {
      return (this.top == null) ;// check what is in top 
   }

   private Item FindLargest(MyLinkedList a){
      if(top == null){
         return null; // if empty return null 
      }
      Item biggest  = top.getData(); // assume the largest to be the  top 
      MyNode current = top; // start at the top node 
      while(current != null){ //iterate while top is not null 
         if(current.getData().compareTo(biggest) > 0 ){
           biggest = current.getData();
         } 
         current = current.getNext();//keep iterating 
      }
      return biggest;// return the largest Item
   }

   public Item remove(Item item) {
     
         // Create two nodes to help us traverse the list
         MyNode previous = null;
         MyNode current = top;
         // While we don't find what we are looking for
         while(current != null && !current.getData().equals(item)) {
             // The previous will be the current
             previous = current;
             // The current will be the next node
             current  = current.getNext();
         }
         if(current == null) {
             return null;
         }
         // If previous is null, that means, we are removing the top
         if(previous == null) {
             top = current.getNext();
         } else {
             // Otherwise, make a direct connection between previous and current and thus  skipping the node we want to remove
             previous.setNext(current.getNext()); 
         }
         nodes--;
         
     return item; // return item 
     
   }

}
