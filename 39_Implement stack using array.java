/* Problem Statement :-
Write a program to implement a Stack using Array. Your task is to use the class as shown in the comments in the code editor and complete the functions push() and pop() to implement a stack. 
*/

// Answer :-

class MyStack {
    int top;
    int arr[] = new int[1000];

    MyStack() {
        top = -1;
    }

    // Function to push an integer into the stack.
    void push(int a) {
        if (top == 999) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = a;
    }

    // Function to remove an item from the top of the stack.
    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
}
