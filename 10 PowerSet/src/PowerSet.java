public class PowerSet {
  public int size;
  public int step;
  public String[] slots;
  public int count;

  public PowerSet() {
    size = 5;
    step = 3;
    count = 0;
    slots = new String[size];
    for (int i = 0; i < size; i++) {
      slots[i] = null;
    }
  }

  public int size() {
    return count;
  }

  public void put(String value) {
    if (get(value)) {
      return;
    }

    int slot;
    if (size() == size) {
      String[] temp = slots;
      size = size * 2;
      count = 0;
      slots = new String[size];
      for (String s : temp) {
        slot = seekSlot(s);
        slots[slot] = s;
        count++;
      }
    }
    slot = seekSlot(value);
    if (slot > -1) {
      slots[slot] = value;
      count++;
    }
  }

  public boolean get(String value) {
    int slot = hashFun(value);
    for (int i = 0; i < size; i++) {
      if (slots[slot] != null && slots[slot].equals(value)) {
        return true;
      }
      slot = slot + step;
      if (slot >= size) {
        slot = slot - size;
      }
    }
    return false;
  }

  public boolean remove(String value) {
    int slot = hashFun(value);
    if (get(value)) {
      for (int i = 0; i < size; i++) {
        if (slots[slot] != null && value.equals(slots[slot])) {
          slots[slot] = null;
          count--;
          return true;
        }
        slot = slot + step;
        if (slot >= size) {
          slot = slot - size;
        }
      }
    }
    return false;
  }

  public PowerSet intersection(PowerSet set2) {
    PowerSet set = new PowerSet();
    for (int i = 0; i < set2.size; i++) {
      if (set2.slots[i] != null && get(set2.slots[i])) {
        set.put(set2.slots[i]);
      }
    }
    return set;
  }

  public PowerSet union(PowerSet set2) {
    PowerSet set = new PowerSet();
    for (int i = 0; i < size; i++) {
      if (slots[i] != null) {
        set.put(slots[i]);
      }
    }
    for (int i = 0; i < set2.size; i++) {
      if (set2.slots[i] != null) {
        set.put(set2.slots[i]);
      }
    }
    return set;
  }

  public PowerSet difference(PowerSet set2) {
    PowerSet set = new PowerSet();
    for (int i = 0; i < size; i++) {
      if (slots[i] != null && !set2.get(slots[i])) {
        set.put(slots[i]);
      }
    }
    return set;
  }

  public boolean isSubset(PowerSet set2) {
    for (int i = 0; i < set2.size; i++) {
      if (set2.slots[i] != null && !get(set2.slots[i])) {
        return false;
      }
    }
    return true;
  }

  public int hashFun(String value) {
    return value.getBytes().length % size;
  }

  public int seekSlot(String value) {
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

}
