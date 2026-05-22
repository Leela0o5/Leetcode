import java.util.Stack;

class Solution {
    public void sortStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        
        while (!st.isEmpty()) {
            int curr = st.pop();
            
    
            while (!temp.isEmpty() && temp.peek() < curr) {
                st.push(temp.pop());
            }
            
           
            temp.push(curr);
        }
        
    
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }
}
