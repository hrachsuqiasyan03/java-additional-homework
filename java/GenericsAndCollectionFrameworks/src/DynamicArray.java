
/**
 * Homework: Implement a Dynamic Array (simplified version of java.util.ArrayList).
 * Rules:
 * - Use a plain Object[] array internally to store elements.
 * - When the array is full, create a new array with double the capacity,
 *   copy all existing elements into it, and replace the old array.
 * - Keep track of the current number of elements (size) vs the array capacity.
 * Good luck!
 */
public class DynamicArray {

    private Object[] data;
    private int size;

    /**
     * Creates a DynamicArray with the given initial capacity.
     * The size should start at 0.
     */
    public DynamicArray(int initialCapacity) {
        Object[] data  = new Object[initialCapacity];
        this.data = data;
        this.size = 0;
    }

    /**
     * Creates a DynamicArray with a default initial capacity of 10.
     */
    public DynamicArray() {
        this(10);
    }

    /**
     * Returns the number of elements currently stored in the array.
     */

    public int size() {
        return this.size;
    }

    /**
     * Returns true if the array contains no elements.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    /**
     * Returns the element at the given index.
     * Should throw IndexOutOfBoundsException if index < 0 or index >= size.
     */

    public Object get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }
        checkIndex(index);
        return data[index];
    }

    /**
     * Replaces the element at the given index with the new value.
     * Should throw IndexOutOfBoundsException if index < 0 or index >= size.
     */

    public void set(int index, Object value) {
        if(index <0|| index>= size){
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }
        checkIndex(index);
        data[index] = value;

    }

    /**
     * Adds a new element to the end of the array.
     * If the internal array is full, it should grow (double its capacity)
     * before adding the element.
     */
    public void add(Object value) {
        if(size == data.length){
            Object[] newData = new Object[data.length*2];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size] = value;
        size++;
    }

    /**
     * Inserts a new element at the given index, shifting all elements
     * after that index one position to the right.
     * If the internal array is full, it should grow before inserting.
     * Should throw IndexOutOfBoundsException if index < 0 or index > size.
     */
    public void add(int index, Object value) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }
        if(size == data.length){
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        //changing that index position to the right
        for (int i = size; i > index ; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        size++;
    }

    /**
     * Removes the element at the given index and returns it.
     * All elements after the removed one should shift one position to the left.
     * Should throw IndexOutOfBoundsException if index < 0 or index >= size.
     */
    public Object remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }
        Object removedData = data[index];
        //changing that index position to the left
        for(int i = index; i< size - 1; i++){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
        return removedData;
    }

    /**
     * Returns true if the array contains the given value.
     * Use .equals() for comparison (handle null safely).
     */
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if(data[i] != null && data[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the given value,
     * or -1 if the value is not found.
     */
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if(value == null && data[i] == null){
                return i;
            }
            if(value != null && data[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes all elements from the array. Size becomes 0.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i]= null;
        }
        size = 0;
    }

    /**
     * Returns a string representation of the array.
     * Example format: [1, 2, 3]
     * Empty array: []
     */
    @Override
    public String toString() {

        if(size == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < size; i++) {
            builder.append(data[i]);

            if(i != size -1){
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    // ---- Private helper methods ----

    /**
     * Doubles the capacity of the internal array and copies all
     * existing elements into the new array.
     * (Hint: create a new Object[] with double length, copy elements, reassign)
     */
    private void grow() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * Checks whether the given index is valid (0 <= index < size).
     * If not, throws IndexOutOfBoundsException.
     */
    private void checkIndex(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }
    }
}