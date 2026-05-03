class Solution{

  public int celeb(int arr[][]){
    Stack<Integer> st = new Stack<>();
    for(int i=0;i<arr.length;i++){
      st.push(i);
    }
    while(st.size() >1){
       int j = 0;
      int i = 0;
      if(arr[i][j]==0) st.push(i);
      else st.push(j);
    }

    int celeb = s.peek();
    for(int i=0;i<arr.length;i++){
      if(i!=celeb && (arr[i][celeb] == 0 || arr[celeb][i] == 1)) return -1;
    }
    return celeb;
      
      
  }






  
}
