public class A5Q2Starter {
  public static final char[][] MAZE = {
      "#######################################".toCharArray(),
      "# #         # #     # #   #   # #   # #".toCharArray(),
      "# ##### ### # # # ### ### ### # # ### #".toCharArray(),
      "#         # # # #         #   #       #".toCharArray(),
      "####### ### # ####### # # # # # # # # #".toCharArray(),
      "#     # # # #   # #   # # # #   # # # #".toCharArray(),
      "### ##### ##### # # ### # # # # #######".toCharArray(),
      "# #                   # # # # #       #".toCharArray(),
      "# # ##### ### # ####### # ##### # #####".toCharArray(),
      "#       # # # # #     # #       # # # #".toCharArray(),
      "# # ##### # # # # # ##### ##### # # # #".toCharArray(),
      "# #   #   #   #   # #   #   # # # # # #".toCharArray(),
      "# ########### # # ### ####### # ### # #".toCharArray(),
      "#       #   # # #           # # #     #".toCharArray(),
      "##### ##### ### # ##### # # # # # ### #".toCharArray(),
      "# #     #   # # # #   # # # #     #   #".toCharArray(),
      "# ### ### ### # # # ######### # ### # #".toCharArray(),
      "#       # #     #     #       # #   # #".toCharArray(),
      "# # # ### # # ######### ######### #####".toCharArray(),
      "# # #   #   # #   # # #   #   #       #".toCharArray(),
      "# # # ### # ### # # # # ##### # # ### #".toCharArray(),
      "# # #   # #     #     #       # # #   #".toCharArray(),
      "#######################################".toCharArray()
  };

  public static void main(String[] args) {
    char[][] maze;

    maze = copyMaze(MAZE);
    attemptSolution(maze, new RowCol(21, 1), new RowCol(1, 37), "Original maze, bottom left:");

    maze = copyMaze(MAZE);
    attemptSolution(maze, new RowCol(1, 1), new RowCol(1, 37), "\nOriginal maze, top left:");

    maze = copyMaze(MAZE);
    attemptSolution(maze, new RowCol(21, 35), new RowCol(7, 1), "\nOriginal maze, bottom right:");

    maze = copyMaze(MAZE);
    for (int r = 0; r < maze.length; r++) {
      maze[r][maze[0].length - 5] = '#';
    }
    attemptSolution(maze, new RowCol(21, 1), new RowCol(1, 37), "\nModified maze, bottom left:");

    System.out.println("\nEnd of processing.");
  }

  public static char[][] copyMaze(char[][] maze) {
    char[][] result = new char[maze.length][maze[0].length];
    for (int r = 0; r < maze.length; r++) {
      for (int c = 0; c < maze[r].length; c++) {
        result[r][c] = maze[r][c];
      }
    }
    return result;
  }

  public static void printMaze(char[][] maze) {
    for (int r = 0; r < maze.length; r++) {
      for (int c = 0; c < maze[r].length; c++) {
        System.out.print(maze[r][c]);
      }
      System.out.println();
    }
  }

  public static void attemptSolution(char[][] maze, RowCol start, RowCol goal, String name) {
    System.out.println(name);
    printMaze(maze);

    if (solveMaze(maze, start, goal)) {
      System.out.println("\nSolved maze:");
      printMaze(maze);
    } else {
      System.out.println("\nNo solution.");
    }
  }

  public static boolean solveMaze(char[][] maze, RowCol start, RowCol goal) {
    StackOfRowCol stack = new StackOfRowColLL(), path = new StackOfRowColLL();
    RowCol here, from, check;
    boolean pushed, solved = false;

    // TODO: Push start onto the stack
    stack.push(start);

    here = start;
    from = new RowCol(0, 0); // invalid position
    while (!stack.isEmpty() && !here.equals(goal)) {
      pushed = false;

      check = new RowCol(here.row() - 1, here.col());
      if (maze[check.row()][check.col()] == ' ' && !from.equals(check)) {
        pushed = true;
        // TODO: Push check onto the stack
        stack.push(check);
      }

      check = new RowCol(here.row() + 1, here.col());
      if (maze[check.row()][check.col()] == ' ' && !from.equals(check)) {
        pushed = true;
        // TODO: Push check onto the stack
        stack.push(check);

      }

      check = new RowCol(here.row(), here.col() - 1);
      if (maze[check.row()][check.col()] == ' ' && !from.equals(check)) {
        pushed = true;
        // TODO: Push check onto the stack
        stack.push(check);
      }

      check = new RowCol(here.row(), here.col() + 1);
      if (maze[check.row()][check.col()] == ' ' && !from.equals(check)) {
        pushed = true;
        // TODO: Push check onto the stack
        stack.push(check);
      }

      if (pushed) {
        // TODO: Push here onto the path
        path.push(here);
      } else {
        maze[here.row()][here.col()] = 'X';
      }

      from = here;
      // TODO: Pop here from the stack
      here = stack.pop();
    }

    if (here.equals(goal)) {
      // TODO: Place a "." on the maze at all the locations in path
      //MyNodeObj current = path.getTop();
      
      while (!path.isEmpty()) {
        RowCol a = path.pop();
        maze[a.row()][a.col()] = '.';
       // current = current.getNext();
      }

      solved = true;
    }

    return solved;
  }
}

interface StackOfRowCol {
  void push(RowCol rc);

  MyNodeObj getTop();

  RowCol pop();

  boolean isEmpty();
}

/* CODE MADE AND IMPLEMENTED BY OYEWUSI ITEOLUWAKISI */
class StackOfRowColLL implements StackOfRowCol {
  MyNodeObj top; // top of stack 
  int nodes; // amount of elemnts in the stack

  public StackOfRowColLL() {
    top = null; //start off empty 
    nodes = 0; // start off empty 
  }

  public MyNodeObj getTop() {
    return this.top; //return top element 
  }

  @Override
  //add an element by pushing 
  public void push(RowCol object) {
    // TODO Auto-generated method stub
    // if top is empty
    if (top == null) {
      MyNodeObj newNode = new MyNodeObj(object, null); // create a newNode thats null 
      top = newNode; // top becomes that node 
    } else {
      MyNodeObj newNode = new MyNodeObj(object, top); // create a newNode
      top = newNode; // top points to  that node 
    }
    nodes++; // add to node count 

  }

  @Override
  // remove through popping first element in the stack 
  public RowCol pop() {
    // TODO Auto-generated method stub
    // if not empty 
    if (top != null) {
      MyNodeObj returnNode = top;// node return is top 
      top = top.getNext(); // skip over top and continue link 
      nodes--; // reduce list size 
      return returnNode.getData();// return node 
    } else {
      return null; // return null 
    }
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return (top == null); //check if  top is null 
  }

  public RowCol peek() {
    // TODO Auto-generated method stub
    if (top != null) {
      return top.getData();
    }
    return null;
  }

}

class RowCol {
  private int row, col;

  public RowCol(int r, int c) {
    row = r;
    col = c;
  }

  public int row() {
    return row;
  }

  public int col() {
    return col;
  }

  public boolean equals(RowCol other) {
    return this.row == other.row && this.col == other.col;
  }

  public String toString() {
    return "(" + row + "," + col + ")";
  }
}


