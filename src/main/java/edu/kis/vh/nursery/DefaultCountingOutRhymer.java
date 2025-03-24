package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int CAPACITY = 12;
    private static final int FULL_INDEX = CAPACITY - 1;
    private static final int EMPTY_VALUE = -1;
    private static final int DEFAULT_RETURN_VALUE = -1;
    private final int[] numbers = new int[CAPACITY];

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int total = EMPTY_VALUE;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

        public boolean callCheck() {
            return total == EMPTY_VALUE;
        }
        
            public boolean isFull() {
                return total == FULL_INDEX;
            }
        
                protected int peekaboo() {
                    if (callCheck())
                        return DEFAULT_RETURN_VALUE;
                    return numbers[total];
                }
            
                    public int countOut() {
                        if (callCheck())
                            return DEFAULT_RETURN_VALUE;
                        return numbers[total--];
                    }

}
