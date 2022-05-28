public class HashTable
{
  public int size;
  public int step;
  public String [] slots;

  public HashTable(int sz, int stp)
  {
    size = sz;
    step = stp;
    slots = new String[size];
    for(int i = 0; i < size; i++)
      slots[i] = null;
  }

  public int hashFun(String value)
  {
    return value.getBytes().length % size;
  }

  public int seekSlot(String value)
  {
    int slot = hashFun(value);
    for (int i = 0; i < size; i++) {
      if (slots[slot] == null) {
        return slot;
      }
      slot = slot + step;
      if (slot >= size) {
        slot = slot - size;
      }
    }
    return -1;
  }

  public int put(String value)
  {
    int slot = seekSlot(value);
    if (slot > -1) {
      slots[slot] = value;
      return slot;
    }
    return -1;
  }

  public int find(String value)
  {
    int slot = hashFun(value);
    for (int i = 0; i < size; i++) {
      if (slots[slot] == null) {
        return -1;
      }
      else if (slots[slot].equals(value)) {
        return slot;
      }
      slot = slot + step;
      if (slot >= size) {
        slot = slot - size;
      }
    }
    return -1;
  }
}
