//import java.util.ArrayList;

public class A5Q3Starter {

  public final static int NUM_THREADS = 10;
  public final static int NUM_OUTPUTS = 200;

  public static void main(String[] args) {
    StringQueue[] queues = new StringQueueLL[NUM_THREADS];
    int random;
    String output;

    System.out.println("Thread simulator");

    // Each thread has one queue; keep them in an array!
    for (int i = 0; i < NUM_THREADS; i++) {
      queues[i] = new StringQueueLL();
    }

    for (int i = 0; i < NUM_OUTPUTS; i++) {
      random = (int) (Math.random() * (NUM_THREADS + 1));
      if (random == NUM_THREADS) {
        // output a random thread
        random = (int) (Math.random() * NUM_THREADS);
        outputQueue(random, queues[random]);
      } else {
        // a thred runs and prints a message
        output = String.format("[thread %d output #%d]", random, i);
        // TODO: add the output to the queue queues[random]
        queues[random].enqueue(output);
        System.out.printf("%d ", random);
      }
    }

    System.out.println("\nEnd of processing.");
  }

  public static void outputQueue(int num, StringQueue q) {
    System.out.printf("\n---Thread #%d\n", num);
    // TODO: Print all the strings in the queue:
     System.out.println(q.toString());
  }
}

interface StringQueue {
  void enqueue(String s);

  String dequeue();

  boolean isEmpty();
}

/* CODE MADE AND IMPLEMENTED BY OYEWUSI ITEOLUWAKISI */
class StringQueueLL implements StringQueue {
  // TODO: Implement the interface

  MyThirdNode head;// top Node
  MyThirdNode tail; // back end Node 

  public StringQueueLL() {
    //initialise  them as  null 
    head = null; 
    tail = null;
  }

  @Override
  public void enqueue(String s) {
    // TODO Auto-generated method stub
    MyThirdNode newNode = new MyThirdNode(s, null);
    if (head == null) {
      // if empty both first and last node become the newNode 
      head = newNode;
      tail = newNode;
    } else {
      tail.setNext(newNode);// the back end points to newNode 
      tail = newNode;// NewNode is the tail 
    }
  }

  @Override
  public String dequeue() {
    // TODO Auto-generated method stub

    //if empty return null 
    if (head == null) {
      return null;
    }
    MyThirdNode toRemove = head; //point the new Node towards the front of the queue 
    head = head.getNext(); // point head to the next in line 
    return toRemove.getData(); // return the data from toRemove 
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return (head == null);// check if node is empty 
  }

  public String toString() {
    String toReturn = ""; // create an empty string toReturn 
    MyThirdNode curr = head; //start at the top
    while(curr != null) {
        toReturn += curr.getData() + " " + "\n";// get and add data
        curr = curr.getNext(); //iterate through 
    }
    return toReturn + "";// return toReturn
}

}
