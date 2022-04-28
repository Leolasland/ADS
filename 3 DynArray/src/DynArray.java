import java.lang.reflect.Array;

public class DynArray<T> {
  public T [] array;
  public int count;
  public int capacity;
  Class clazz;

  public DynArray(Class clz)
  {
    clazz = clz; // нужен для безопасного приведения типов
    // new DynArray<Integer>(Integer.class);

    count = 0;
    makeArray(16);
  }

  public void makeArray(int new_capacity)
  {
    // array = (T[]) Array.newInstance(this.clazz, new_capacity);
    if (new_capacity < 16) {
      new_capacity = 16;
    }

    T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
    if (array != null) {
      System.arraycopy(this.array, 0, newArray, 0, count);
    }

    array = newArray;
    capacity = new_capacity;
  }

  public T getItem(int index)
  {
    if (index < 0 || index >= capacity) {
      throw new ArrayIndexOutOfBoundsException("Index out of bound");
    }

    return array[index];
  }

  public void append(T itm)
  {
    if (count == capacity) {
      makeArray(capacity * 2);
    }

    array[count] = itm;
    count++;
  }

  // O(n)
  public void insert(T itm, int index)
  {
    if (index < 0 || index > count) {
      throw new ArrayIndexOutOfBoundsException("Index out of bound");
    }

    if (count == capacity) {
      makeArray(capacity * 2);
    }

    System.arraycopy(array, index, array, index + 1, count - index);
    array[index] = itm;
    count++;
  }

  // O(n)
  public void remove(int index)
  {
    if (index < 0 || count == 0 || index >= count) {
      throw new ArrayIndexOutOfBoundsException("Index out of bound");
    }

    System.arraycopy(array, index + 1, array, index, capacity - index - 1);
    count--;

    if (count * 2 < capacity) {
      makeArray((int) (capacity / 1.5));
    }
  }
}
