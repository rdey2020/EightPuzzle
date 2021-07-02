package org;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {

  private int[] state;
  private int hDisplaced;
  private int hManhattan;
  private int gVal;
  private HashMap<String, Node> children = new HashMap<>();
  private Node parentNode;
  private String parentAction;

  private final static String RIGHT = "right";
  private final static String LEFT = "left";
  private final static String UP = "up";
  private final static String DOWN = "down";

  public Node() {
  }

  public Node(int[] state, int hDisplaced, int hManhattan, int gVal,
      HashMap<String, Node> children, Node parentNode, String parentAction) {
    this.state = state;
    this.hDisplaced = hDisplaced;
    this.hManhattan = hManhattan;
    this.gVal = gVal;
    this.children = children;
    this.parentNode = parentNode;
    this.parentAction = parentAction;
  }

  public Node(int[] state) {
    this.state = state;
    this.gVal = 0;
    this.parentNode = null;
    this.parentAction = null;
  }

  public int[] getState() {
    return state;
  }

  public void setState(int[] state) {
    this.state = state;
  }

  public int gethDisplaced() {
    return hDisplaced;
  }

  public void sethDisplaced(int hDisplaced) {
    this.hDisplaced = hDisplaced;
  }

  public int gethManhattan() {
    return hManhattan;
  }

  public void sethManhattan(int hManhattan) {
    this.hManhattan = hManhattan;
  }

  public int getgVal() {
    return gVal;
  }

  public void setgVal(int gVal) {
    this.gVal = gVal;
  }

  public HashMap<String, Node> getChildren() {
    return children;
  }

  public void setChildren(HashMap<String, Node> children) {
    this.children = children;
  }

  public Node getParentNode() {
    return parentNode;
  }

  public void setParentNode(Node parentNode) {
    this.parentNode = parentNode;
  }

  public String getParentAction() {
    return parentAction;
  }

  public void setParentAction(String parentAction) {
    this.parentAction = parentAction;
  }

  public boolean equalState(Node node1, Node node2) {
    if (node1.state == node2.state) {
      return true;
    } else {
      return false;
    }
  }

  public void expand() {

    int blankPosition = 0;
    for (int i = 0; i < state.length; i++) {
      if (state[i] == 0) {
        blankPosition = i;
      }
    }

    if (blankPosition == 0) {

      int[] rightState = this.state.clone();
      rightState[0] = rightState[1];
      rightState[1] = 0;

      Node right = new Node(rightState);
      setNodeValues(right, RIGHT, this);

      int[] downState = this.state.clone();
      downState[0] = downState[3];
      downState[3] = 0;

      Node down = new Node(downState);
      setNodeValues(down, DOWN, this);

      this.children.put(RIGHT, right);
      this.children.put(DOWN, down);
    } else if (blankPosition == 1) {

      int[] leftState = this.state.clone();
      leftState[1] = leftState[0];
      leftState[0] = 0;

      Node left = new Node(leftState);
      setNodeValues(left, LEFT, this);

      int[] rightState = this.state.clone();
      rightState[1] = rightState[2];
      rightState[2] = 0;

      Node right = new Node(rightState);
      setNodeValues(right, RIGHT, this);

      int[] downState = this.state.clone();
      downState[1] = downState[4];
      downState[4] = 0;

      Node down = new Node(downState);
      setNodeValues(down, DOWN, this);

      this.children.put(LEFT, left);
      this.children.put(RIGHT, right);
      this.children.put(DOWN, down);
    } else if (blankPosition == 2) {

      int[] leftState = this.state.clone();
      leftState[2] = leftState[1];
      leftState[1] = 0;

      Node left = new Node(leftState);
      setNodeValues(left, LEFT, this);

      int[] downState = this.state.clone();
      downState[2] = downState[5];
      downState[5] = 0;

      Node down = new Node(downState);
      setNodeValues(down, DOWN, this);

      this.children.put(LEFT, left);
      this.children.put(DOWN, down);
    } else if (blankPosition == 3) {

      int[] upState = this.state.clone();
      upState[3] = upState[0];
      upState[0] = 0;

      Node up = new Node(upState);
      setNodeValues(up, UP, this);

      int[] rightState = this.state.clone();
      rightState[3] = rightState[4];
      rightState[4] = 0;

      Node right = new Node(rightState);
      setNodeValues(right, RIGHT, this);

      int[] downState = this.state.clone();
      downState[3] = downState[6];
      downState[6] = 0;

      Node down = new Node(downState);
      setNodeValues(down, DOWN, this);

      this.children.put(UP, up);
      this.children.put(RIGHT, right);
      this.children.put(DOWN, down);
    } else if (blankPosition == 4) {

      int[] leftState = this.state.clone();
      leftState[4] = leftState[3];
      leftState[3] = 0;

      Node left = new Node(leftState);
      setNodeValues(left, LEFT, this);

      int[] upState = this.state.clone();
      upState[4] = upState[1];
      upState[1] = 0;

      Node up = new Node(upState);
      setNodeValues(up, UP, this);

      int[] rightState = this.state.clone();
      rightState[4] = rightState[5];
      rightState[5] = 0;

      Node right = new Node(rightState);
      setNodeValues(right, RIGHT, this);

      int[] downState = this.state.clone();
      downState[4] = downState[7];
      downState[7] = 0;

      Node down = new Node(downState);
      setNodeValues(down, DOWN, this);

      this.children.put(RIGHT, right);
      this.children.put(DOWN, down);
      this.children.put(UP, up);
      this.children.put(LEFT, left);
    } else if (blankPosition == 5) {

      int[] leftState = this.state.clone();
      leftState[5] = leftState[4];
      leftState[4] = 0;

      Node left = new Node(leftState);
      setNodeValues(left, LEFT, this);

      int[] upState = this.state.clone();
      upState[5] = upState[2];
      upState[2] = 0;

      Node up = new Node(upState);
      setNodeValues(up, UP, this);

      int[] downState = this.state.clone();
      downState[5] = downState[8];
      downState[8] = 0;

      Node down = new Node(downState);
      setNodeValues(down, DOWN, this);

      this.children.put(LEFT, left);
      this.children.put(UP, up);
      this.children.put(DOWN, down);
    } else if (blankPosition == 6) {

      int[] upState = this.state.clone();
      upState[6] = upState[3];
      upState[3] = 0;

      Node up = new Node(upState);
      setNodeValues(up, UP, this);

      int[] rightState = this.state.clone();
      rightState[6] = rightState[7];
      rightState[7] = 0;

      Node right = new Node(rightState);
      setNodeValues(right, RIGHT, this);

      this.children.put(UP, up);
      this.children.put(RIGHT, right);
    } else if (blankPosition == 7) {

      int[] leftState = this.state.clone();
      leftState[7] = leftState[6];
      leftState[6] = 0;

      Node left = new Node(leftState);
      setNodeValues(left, LEFT, this);

      int[] upState = this.state.clone();
      upState[7] = upState[4];
      upState[4] = 0;

      Node up = new Node(upState);
      setNodeValues(up, UP, up.getParentNode());

      int[] rightState = this.state.clone();
      rightState[7] = rightState[8];
      rightState[8] = 0;

      Node right = new Node(rightState);
      setNodeValues(right, RIGHT, this);

      this.children.put(LEFT, left);
      this.children.put(UP, up);
      this.children.put(RIGHT, right);
    } else if (blankPosition == 8) {

      int[] leftState = this.state.clone();
      leftState[8] = leftState[7];
      leftState[7] = 0;

      Node left = new Node(leftState);
      setNodeValues(left, LEFT, this);

      int[] upState = this.state.clone();
      upState[8] = upState[5];
      upState[5] = 0;

      Node up = new Node(upState);
      setNodeValues(up, UP, this);

      this.children.put(LEFT, left);
      this.children.put(UP, up);
    }


  }

  private void setNodeValues(Node right, String right2, Node parentNode) {
    right.setParentAction(right2);
    right.setParentNode(parentNode);
    right.sethDisplaced(findhDisplaced());
    right.sethManhattan(findhManhattan());
    right.setgVal(parentNode.gVal + 1);
  }

  public int findhDisplaced() {

    int sum = 0;

    if (this.state[0] != 1) {
      sum++;
    }

    if (this.state[1] != 2) {
      sum++;
    }

    if (this.state[2] != 3) {
      sum++;
    }

    if (this.state[3] != 8) {
      sum++;
    }
    if (this.state[5] != 4) {
      sum++;
    }
    if (this.state[6] != 7) {
      sum++;
    }
    if (this.state[7] != 6) {
      sum++;
    }
    if (this.state[8] != 5) {
      sum++;
    }
    return sum;
  }

  public int findhManhattan() {

    int manhattan = 0;

    if (this.state[0] != 1) {
      if (this.state[1] == 1 || this.state[3] == 1) {
        manhattan++;
      } else if (this.state[2] == 1 || this.state[4] == 1 || this.state[6] == 1) {
        manhattan = manhattan + 2;
      } else if (this.state[5] == 1 || this.state[7] == 1) {
        manhattan = manhattan + 3;
      } else if (this.state[8] == 1) {
        manhattan = manhattan + 4;
      }
    }
    if (this.state[1] != 2) {
      if (this.state[0] == 2 || this.state[4] == 2 || this.state[2] == 2) {
        manhattan++;
      } else if (this.state[3] == 2 || this.state[5] == 2 || this.state[6] == 2) {
        manhattan = manhattan + 2;
      } else if (this.state[6] == 2 || this.state[8] == 2) {
        manhattan = manhattan + 3;
      }
    }
    if (this.state[2] != 3) {
      if (this.state[1] == 3 || this.state[5] == 3) {
        manhattan++;
      } else if (this.state[0] == 3 || this.state[4] == 3 || this.state[8] == 3) {
        manhattan = manhattan + 2;
      } else if (this.state[3] == 3 || this.state[7] == 3) {
        manhattan = manhattan + 3;
      } else if (this.state[6] == 3) {
        manhattan = manhattan + 4;
      }
    }
    if (this.state[3] != 8) {
      if (this.state[0] == 8 || this.state[4] == 8 || this.state[6] == 8) {
        manhattan++;
      } else if (this.state[1] == 8 || this.state[5] == 8 || this.state[7] == 8) {
        manhattan = manhattan + 2;
      } else if (this.state[2] == 8 || this.state[8] == 8) {
        manhattan = manhattan + 3;
      }
    }
    if (this.state[4] != 0) {
      if (this.state[1] == 0 || this.state[3] == 0 || this.state[5] == 0 || this.state[7] == 0) {
        manhattan++;
      } else if (this.state[0] == 0 || this.state[2] == 0 || this.state[6] == 0
          || this.state[8] == 0) {
        manhattan = manhattan + 2;
      }
    }
    if (this.state[5] != 4) {
      if (this.state[2] == 4 || this.state[4] == 4 || this.state[8] == 4) {
        manhattan++;
      } else if (this.state[1] == 4 || this.state[3] == 4 || this.state[7] == 4) {
        manhattan = manhattan + 2;
      } else if (this.state[0] == 4 || this.state[6] == 4) {
        manhattan = manhattan + 3;
      }
    }
    if (this.state[6] != 7) {
      if (this.state[3] == 7 || this.state[7] == 7) {
        manhattan++;
      } else if (this.state[0] == 7 || this.state[4] == 7 || this.state[8] == 7) {
        manhattan = manhattan + 2;
      } else if (this.state[1] == 7 || this.state[5] == 7) {
        manhattan = manhattan + 3;
      } else if (this.state[2] == 7) {
        manhattan = manhattan + 4;
      }
    }

    if (this.state[7] != 6) {
      if (this.state[6] == 6 || this.state[4] == 6 || this.state[8] == 6) {
        manhattan++;
      } else if (this.state[1] == 6 || this.state[3] == 6 || this.state[5] == 6) {
        manhattan = manhattan + 2;
      } else if (this.state[0] == 6 || this.state[2] == 6) {
        manhattan = manhattan + 3;
      }
    }

    if (this.state[8] != 5) {
      if (this.state[5] == 5 || this.state[7] == 5) {
        manhattan++;
      } else if (this.state[2] == 5 || this.state[4] == 5 || this.state[6] == 5) {
        manhattan = manhattan + 2;
      } else if (this.state[1] == 5 || this.state[3] == 5) {
        manhattan = manhattan + 3;
      } else if (this.state[0] == 5) {
        manhattan = manhattan + 4;
      }
    }
    return manhattan;
  }


  public String displayState(int[] state) {
    String result = "";

    for (int i = 0; i < state.length; i++) {
      if(i == state.length - 1)
         result += state[i];
      else
        result += state[i] + ",";
    }
    return result;
  }


  public void displayChildren() {

    for (String key : this.children.keySet()) {
      System.out.println(key + ":" + displayState(this.children.get(key).getState()));
    }
  }

  public String displayOutFileHeuristic1() {
    String output = "";

    String problem = "PROBLEM :";
    for (int i = 0; i < state.length; i++) {
      if (i != this.state.length - 1) {
        problem = problem + this.state[i] + ",";
      } else {
        problem = problem + this.state[i];
      }
    }

    output = problem + "\n";

    ArrayList<Node> sortedArray = new ArrayList<>();

    for (String key : this.children.keySet()) {
      if (sortedArray.isEmpty()) {
        sortedArray.add(this.children.get(key));
      } else {
        boolean inserted = false;
        for (int i = 0; i < sortedArray.size(); i++) {
          Node childNode = this.children.get(key);
          if ((childNode.gethDisplaced() + childNode.getgVal()) <
              (sortedArray.get(i).gethDisplaced() + sortedArray.get(i).getgVal())) {
            sortedArray.add(i, childNode);
            inserted = true;
            break;
          }
        }
        if (!inserted) {
          sortedArray.add(this.children.get(key));
        }
      }
    }

    String sortedList = "Sorted List :";
    String nodes = "";

    for (int i = 0; i < sortedArray.size(); i++) {
      if (i == sortedArray.size() - 1) {
        sortedList += sortedArray.get(i).getParentAction();
      } else {
        sortedList += sortedArray.get(i).getParentAction() + ",";
      }

      String state = "";
      for (int j = 0; j < sortedArray.get(i).getState().length; j++) {
        if (j == sortedArray.get(i).getState().length - 1) {
          state += sortedArray.get(i).getState()[j];
        } else {
          state += sortedArray.get(i).getState()[j] + ",";
        }
      }

      nodes += "Node " + (i + 1) + "\tAction: " + sortedArray.get(i).getParentAction() + "\tState: "
          + state + "\tgVal: " + sortedArray.get(i).getgVal() + "\tManhattan: " + sortedArray.get(i)
          .gethManhattan()
          + "\tDisplaced: " + sortedArray.get(i).gethDisplaced() + "\n";
    }
    return output + sortedList + "\n" + nodes;
  }

  public String displayOutFileHeuristic2() {
    String output = "";

    String problem = "PROBLEM :";
    for (int i = 0; i < state.length; i++) {
      if (i != this.state.length - 1) {
        problem = problem + this.state[i] + ",";
      } else {
        problem = problem + this.state[i];
      }
    }

    output = problem + "\n";

    ArrayList<Node> sortedArray = new ArrayList<>();

    for (String key : this.children.keySet()) {
      if (sortedArray.isEmpty()) {
        sortedArray.add(this.children.get(key));
      } else {
        boolean inserted = false;
        for (int i = 0; i < sortedArray.size(); i++) {
          Node childNode = this.children.get(key);
          if ((childNode.gethManhattan() + childNode.getgVal()) <
              (sortedArray.get(i).gethManhattan() + sortedArray.get(i).getgVal())) {
            sortedArray.add(i, childNode);
            inserted = true;
            break;
          }
        }
        if (!inserted) {
          sortedArray.add(this.children.get(key));
        }
      }
    }

    String sortedList = "Sorted List :";
    String nodes = "";

    for (int i = 0; i < sortedArray.size(); i++) {
      if (i == sortedArray.size() - 1) {
        sortedList += sortedArray.get(i).getParentAction();
      } else {
        sortedList += sortedArray.get(i).getParentAction() + ",";
      }

      String state = "";
      for (int j = 0; j < sortedArray.get(i).getState().length; j++) {
        if (j == sortedArray.get(i).getState().length - 1) {
          state += sortedArray.get(i).getState()[j];
        } else {
          state += sortedArray.get(i).getState()[j] + ",";
        }
      }

      nodes += "Node " + (i + 1) + "\tAction: " + sortedArray.get(i).getParentAction() + "\tState: "
          + state + "\tgVal: " + sortedArray.get(i).getgVal() + "\tManhattan: " + sortedArray.get(i)
          .gethManhattan()
          + "\tDisplaced: " + sortedArray.get(i).gethDisplaced() + "\n";
    }
    return output + sortedList + "\n" + nodes;
  }

}
