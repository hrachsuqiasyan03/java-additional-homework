/**
 * Homework: Implement a Stack data structure.
 * <p>
 * A Stack follows LIFO (Last-In, First-Out) order.
 * Think of it like a stack of plates — you add and remove from the top only.
 * <p>
 * Rules:
 * - Use a plain Object[] array internally.
 * - The field `tos` (top-of-stack) tracks how many elements are on the stack.
 * - Handle edge cases: popping/peeking an empty stack should throw an exception.
 * <p>
 * Good luck!
 */

/**
 Index:    [ 0 ]   [ 1 ]   [ 2 ]
 Array:    [  0  |   0   |   0  ]
 ↑
 tos = 0  (Stack-is empty)


 1) myStack.push(10);
 isFull() -> tos (0) == capacity (3) (False):
 stack[tos] = 10 -> stack[0] = 10:
 tos++ -> tos-ը  -> 1:

 Index:    [ 0 ]   [ 1 ]   [ 2 ]
 Array:    [ 10  |   0   |   0  ]
 ↑
 tos = 1


 2)myStack.pop();
 isEmpty() -> tos (2) == 0 (False):
 tos-- -> tos-ը -> 1:
 return stack[1] (20):

 Index:    [ 0 ]   [ 1 ]   [ 2 ]
 Array:    [ 10  |  20   |   0  ]  <-- 20-still in memory, but deleted»!
 tos = 1

 */

//Creating Stack---------------------------------------------------------------
public class Stack {
    private Object[] data;
    private int tos; // top-of-stack: points to the next free slot (also equals current size)

    /**
     * Creates a Stack with the given capacity.
     * The stack starts empty (tos = 0).
     */
    public Stack(int capacity) {
        this.data = new Object[capacity];
        this.tos =0;
    }
    /**
     * Creates a Stack with a default capacity of 10.
     */
    public Stack() {
        this(10);
    }
    /**
     * Pushes (adds) an element onto the top of the stack.
     * If the stack is full, throw a RuntimeException with message "Stack is full".
     */
    public void push(Object value) {
        if(tos == data.length){
            throw new RuntimeException("Stack is full");
        }
        data[tos++] = value;
        /**
         * myStack.push(10);
         *  isFull() -> tos (0) == capacity (3) (False):
         *  stack[tos] = 10 -> stack[0] = 10:
         *  tos++ -> tos-ը  -> 1:
         *
         *  Index:    [ 0 ]   [ 1 ]   [ 2 ]
         *  Array:    [ 10  |   0   |   0  ]
         *                      ↑
         *                   tos = 1
         *
         */
    }
    /**
     * Removes and returns the element at the top of the stack.
     * If the stack is empty, throw a RuntimeException with message "Stack is empty".
     */
    public Object pop() {
        if(tos == 0){
            throw new RuntimeException("Stack is empty");
        }
        return data[ tos--];
        /**
         *
         * myStack.pop();
         *  isEmpty() -> tos (2) == 0 (False):
         *  tos-- -> tos-ը -> 1:
         *  return stack[1] (20):
         *
         *  Index:    [ 0 ]   [ 1 ]   [ 2 ]
         *  Array:    [ 10  |  20   |   0  ]  <-- 20-still in memory, but deleted»!
         *                   tos = 1
         *
         */
    }

    //-----------------------------------------------------------------------------
    /**
     * Returns the element at the top of the stack WITHOUT removing it.
     * If the stack is empty, throw a RuntimeException with message "Stack is empty".
     */
    public Object peek() {
        if(tos == 0){
            throw new RuntimeException("Stack is empty");
        }
        return data[tos-1];
    }

    /**
     * Returns true if the stack has no elements.
     */
    public boolean isEmpty() {
        if(tos == 0){
            return true;
        }
        return false;
    }

    /**
     * Returns the number of elements currently on the stack.
     */
    public int size() {
        return tos;
    }

    /**
     * Returns true if the stack is full (no room to push more elements).
     */
    public boolean isFull() {
        if(tos == data.length){
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the stack from bottom to top.
     * Example format: [1, 2, 3]  (where 3 is the top)
     * Empty stack: []
     */
    @Override
    public String toString() {
        if(isEmpty()){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(data[i]);

            if(i != data.length-1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
