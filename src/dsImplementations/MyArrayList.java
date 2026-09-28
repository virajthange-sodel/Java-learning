package dsImplementations;

import jdk.swing.interop.SwingInterOpUtils;

class ListImp {
    public int defaultsize = 16;
    public int SIZE;
    private int[] arr;
    private int current = 0;

    public ListImp(int size) {
        this.SIZE = size;
        arr = new int[size];
    }
    public ListImp() {
        arr = new int[defaultsize];
        SIZE = defaultsize;
    }

    public int get(int index) {
        if(index < 0 || index > current) {
            throw new RuntimeException("Index is invalid, check once");
        }
        return arr[index];
    }
    public void add(int element) {
        if(current >= arr.length ) {
            System.out.println("Array is full, reinitializing new array with double size...");
            SIZE = SIZE * 2;
            int[] newArray = new int[SIZE];
            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
        arr[current] = element;
        System.out.println("Current is: "+current);
        current++;
    }

    public int removeElement(int index) {
        if(index < 0 || index >= current) throw new RuntimeException("Invalid index");
        int value = arr[index];
//        arr[index] = 0;
        for (int i = index; i < arr.length -1; i++) {
            arr[index] = arr[++index];
        }
        arr[arr.length - 1] = 0;
        return value;
    }

    public int update(int index, int value) {
        if(index < 0 || index >= current) throw new RuntimeException("Index is invalid");
        int elem = arr[index];
        arr[index] = value;
        return elem;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < arr.length; i++) System.out.print(result + arr[i] + " ");

        result =  result + "[ "+SIZE+" ] ";
        return result;
    }
}

public class MyArrayList {
    public static void main(String[] args) {

        ListImp listImp = new ListImp(6);
        System.out.println(listImp.SIZE);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(64);
        listImp.add(90);
        listImp.add(34);
        listImp.add(86);
        listImp.add(14);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        listImp.add(3);
        System.out.println(listImp);
        System.out.println(listImp.removeElement(31));
        System.out.println(listImp.update(0, 45));
        System.out.println(listImp);
    }
}
