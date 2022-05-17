public class DequePalindrom {

    public static boolean isPalondrom(String str) {
        if (str.isEmpty() || str.isBlank())
            return false;

        Deque<Character> deque = new Deque<>();
        char [] array = str.replaceAll("\\s","").toLowerCase().toCharArray();
        for (char ch : array) {
            deque.addFront(ch);
        }
        while (deque.size() > 1) {
            if (!deque.removeFront().equals(deque.removeTail()))
                return false;
        }
        return true;
    }
}
