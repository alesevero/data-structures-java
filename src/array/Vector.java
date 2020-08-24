package array;

public class Vector {

    private int bufferSize = 100;
    private Student[] array = new Student[bufferSize];
    private int size = 0;

    public void add(Student student) {
        if (needToGrow()) grow();
        this.array[size] = student;
        this.size++;
    }

    public void add(int position, Student student) {
        validatePosition(position);
        if (needToGrow()) grow();
        for (int i = size; i > position; i--) {
            array[i] = array[i-1];
        }
        array[position] = student;
        size++;
    }
    
    public void remove(int position) {
        validatePosition(position);
        for (int i = position; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        size--;
    }
    
    public Student get(int position) {
        validatePosition(position);
        return array[position];
    }
    
    public int size() {
        return size;
    }
    
    private void validatePosition(int position) {
        if (position >= size) throw new IllegalArgumentException("invalid position");
    }

    private boolean needToGrow() {
        return size == bufferSize;
    }

    private void grow() {
        bufferSize *= 2;
        Student[] newArray = new Student[bufferSize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
    
}