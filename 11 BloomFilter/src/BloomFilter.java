public class BloomFilter
{
  public int filter_len;
  private int array;

  public BloomFilter(int f_len)
  {
    filter_len = f_len;
    array = 0;
  }

  public int hash1(String str1) {
    int hash = 0;
    for (int i = 0; i < str1.length(); i++) {
      int code = (int) str1.charAt(i);
      hash = (hash * 17 + code) % filter_len;
    }
    return (1 << hash);
  }

  public int hash2(String str1) {
    int hash = 0;
    for (int i = 0; i < str1.length(); i++) {
      int code = (int) str1.charAt(i);
      hash = (hash * 223 + code) % filter_len;
    }
    return (1 << hash);
  }

  public void add(String str1) {
    array |= hash1(str1) | hash2(str1);
  }

  public boolean isValue(String str1) {
    int mask = hash1(str1) | hash2(str1);
    return (array & mask) == mask;
  }
}
