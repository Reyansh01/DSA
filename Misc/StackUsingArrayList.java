package Misc;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList {

    private List<String> myStack = new ArrayList<>();
    
    public static void main(String[] args) {
        StackUsingArrayList stackUsingArrayList = new StackUsingArrayList();
        System.out.println("Element pushed: " + stackUsingArrayList.push("Reyansh"));
        System.out.println("Element pushed: " + stackUsingArrayList.push("Mishra"));
        System.out.println("Peek elemented: " + stackUsingArrayList.peek());
        System.out.println("Pop element: " + stackUsingArrayList.pop());
        System.out.println("Peek element: " + stackUsingArrayList.peek());
        System.out.println("Size of stack: " + stackUsingArrayList.size());
    }

    private Integer size() {
        return myStack.size();
    }

    private Boolean isEmpty() {
        return myStack.size() == 0 ? true : false;
    }

    private String pop() {
        String poppedElement = peek();
        myStack.remove(myStack.size() - 1);
        return poppedElement;
    }

    private Boolean push(String val) {
        return myStack.add(val);
    }

    private String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty..");
        }
        return myStack.get(myStack.size() - 1);
    }

}
