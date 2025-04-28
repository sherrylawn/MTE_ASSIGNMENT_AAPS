class TwoStacks {
    int[] arr;
    int top1, top2;
    int size;

    // Constructor to initialize the stacks
    public TwoStacks(int n) {
        size = n;
        arr = new int[size];
        top1 = -1; // Stack 1 starts from left
        top2 = size; // Stack 2 starts from right
    }

    // Push operation for stack 1
    public void push1(int value) {
        if (top1 + 1 == top2) {
            System.out.println("Overflow! Stack 1 is full.");
            return;
        }
        top1++;
        arr[top1] = value;
    }

    // Push operation for stack 2
    public void push2(int value) {
        if (top1 + 1 == top2) {
            System.out.println("Overflow! Stack 2 is full.");
            return;
        }
        top2--;
        arr[top2] = value;
    }

    // Pop operation for stack 1
    public int pop1() {
        if (top1 == -1) {
            System.out.println("Underflow! Stack 1 is empty.");
            return -1;
        }
        int value = arr[top1];
        top1--;
        return value;
    }

    // Pop operation for stack 2
    public int pop2() {
        if (top2 == size) {
            System.out.println("Underflow! Stack 2 is empty.");
            return -1;
        }
        int value = arr[top2];
        top2++;
        return value;
    }

    // Peek operation for stack 1
    public int peek1() {
        if (top1 == -1) {
            System.out.println("Stack 1 is empty.");
            return -1;
        }
        return arr[top1];
    }

    // Peek operation for stack 2
    public int peek2() {
        if (top2 == size) {
            System.out.println("Stack 2 is empty.");
            return -1;
        }
        return arr[top2];
    }

    public static void main(String[] args) {
        TwoStacks stacks = new TwoStacks(10);

        // Push elements into stack 1
        stacks.push1(5);
        stacks.push1(10);
        stacks.push1(15);

        // Push elements into stack 2
        stacks.push2(20);
        stacks.push2(25);
        stacks.push2(30);

        // Pop elements from stack 1
        System.out.println("Popped from stack 1: " + stacks.pop1());

        // Pop elements from stack 2
        System.out.println("Popped from stack 2: " + stacks.pop2());

        // Peek elements
        System.out.println("Top element of stack 1: " + stacks.peek1());
        System.out.println("Top element of stack 2: " + stacks.peek2());
    }
}
