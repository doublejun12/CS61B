public class OffByN implements CharacterComparator {

    private int N;
    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff < 0) {
            diff = -diff;
        }

        return diff == this.N;
    }
}
