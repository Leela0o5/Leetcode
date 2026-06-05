import java.util.Stack;

class StockSpanner {
    Stack<int[]> st;
    int idx;
    
    public StockSpanner() {
        st = new Stack<>();
        idx = -1;
    }
    
    public int next(int price) {
        idx = idx + 1;

        while(!st.isEmpty() && st.peek()[0] <= price){
            st.pop();
        }
    
        int ans;
        if (st.isEmpty()) {
            ans = idx - (-1);
        } else {
            ans = idx - st.peek()[1]; 
        }
        // Push the current [price, index] onto the stack
        st.push(new int[]{price, idx});
        return ans;
    }
}
