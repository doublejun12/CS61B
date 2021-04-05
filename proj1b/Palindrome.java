public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> L = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            L.addLast(word.charAt(i));
        }
        return L;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> D = this.wordToDeque(word);
        return isPalindrome(D);
    }

    private boolean isPalindrome(Deque<Character> D) {
        if (D.isEmpty() || D.size() == 1) {
            return true;
        } else if (D.removeLast() != D.removeFirst()) {
            return false;
        }
        return isPalindrome(D);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> D = this.wordToDeque(word);
        while (D.size() > 1) {
            if (!cc.equalChars(D.removeFirst(), D.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

