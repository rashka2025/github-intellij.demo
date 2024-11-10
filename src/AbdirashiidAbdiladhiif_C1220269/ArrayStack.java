package AbdirashiidAbdiladhiif_C1220269;

import java.util.EmptyStackException;
import java.util.Arrays;

public class ArrayStack <T> {
    int top;
    private final static int DEFAULT_CAPACITY = 2;
    private T[] stack;

    ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }

    ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return top;
    }

    T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    public T peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(T element) {
        if (isFull()) {
            stack = Arrays.copyOf(stack, stack.length * 2); // expanding Capacity
            System.out.println("Array was full and got expanded by 2");
        }
        stack[top] = element;
        top++;
    }

    public boolean isFull() {
        return stack.length == top;
    }

    public void display() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public int getLength() {
        return stack.length;
    }

    public T getElementByIndex(int i) {
        return stack[i];
    }

    private boolean isDuplicated(ArrayStack array, T element) {
        if (array.size() == 0) {
            return false;
        }
        for (int i = 0; i < array.size(); i++) {
            if (array.getElementByIndex(i) == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "top=" + top +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }

    public void mergan(ArrayStack<T> array1, ArrayStack<T> array2) {
        int newSize = array1.size() + array2.size();


        if (stack.length < newSize) {
            stack = Arrays.copyOf(stack, newSize);
        }

        for (int i = 0; i < array1.size(); i++) {
            boolean duplicated;
            duplicated = isDuplicated(this, array1.getElementByIndex(i));
            if (!duplicated)
                this.push(array1.stack[i]);
        }

        for (int i = 0; i < array2.size(); i++) {
            boolean duplicated;
            duplicated = isDuplicated(this, array2.getElementByIndex(i));
            if (!duplicated)
                this.push(array2.stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack<String> list1 = new ArrayStack<>();
        list1.push("rashka");
        list1.push("rashka");

        ArrayStack<String> list2 =new ArrayStack<>(10);
        list2.push("dhiifka");
        list2.push("dhiifka");
        list2.push("dhiifka");
        list2.push("rashka");


        ArrayStack<String> list3 = new ArrayStack<>();
        System.out.println(list3);
        list3.mergan(list1, list2);
        list3.display();
    }
}
