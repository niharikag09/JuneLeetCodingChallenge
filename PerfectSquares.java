/*Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.*/

class Solution {
    
     
    public int numSquares(int n) {
        
        ArrayList<Integer> squares=new ArrayList<>();
        
        for(int i=1;i*i<=n;i++){
            squares.add(i*i);
        }
        
        HashMap<Integer,Integer> map=new HashMap<>();
        return countSquares(n, squares,map);
    }
    
    public int countSquares(int n, ArrayList<Integer> squares,HashMap<Integer,Integer> map){
        
        if(n<0) return Integer.MAX_VALUE-1;
        if(n==0) return 0;
        
        if(map.containsKey(n)) return map.get(n);
        
        int min=Integer.MAX_VALUE;
        for(int i=squares.size()-1;i>=0;i--){
            min=Math.min(min,countSquares(n-squares.get(i),squares,map)+1);
        }
        
        map.put(n,min);
        return min;
    }
}
