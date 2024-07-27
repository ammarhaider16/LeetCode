class MinStack {

    private ArrayList<Integer> stackList;
    private ArrayList<Integer> minList;
    private int len;

    public MinStack() {
        stackList = new ArrayList<Integer>();
        minList = new ArrayList<Integer>();
        len = 0;
    }

    public void push(int val) {
        stackList.add(val);
        len++;
        if (minList.size() == 0 || val <= minList.get(minList.size() - 1))
            minList.add(val);

    }

    public void pop() {
        int val = stackList.remove(len - 1);
        len--;
        if (val == minList.get(minList.size() - 1)) {
            minList.remove(minList.size() - 1);
        }
    }

    public int top() {
        return stackList.get(len - 1);
    }

    public int getMin() {
        return minList.get(minList.size() - 1);
    }
}