class MyQueue {

    Stack<Integer> main;
    Stack<Integer> support;

    public MyQueue() {
        main = new Stack<Integer>();
        support = new Stack<Integer>();

    }

    public void push(int x) {
        main.push(x);
    }

    public int pop() {
        while (main.size() > 1) {
            support.push(main.pop());
        }
        Integer toPop = main.pop();
        while (support.size() > 0) {
            main.push(support.pop());
        }

        return toPop;
    }

    public int peek() {
        while (main.size() > 1) {
            support.push(main.pop());
        }
        Integer toPeek = main.peek();
        while (support.size() > 0) {
            main.push(support.pop());
        }

        return toPeek;

    }

    public boolean empty() {
        return main.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */