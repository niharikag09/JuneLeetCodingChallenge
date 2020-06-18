/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
*/

class Solution {
     
    public void solve(char[][] board) {
        
        if(board.length==0 || board[0].length==2) return;
        
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        
        //add all border O to queue
        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board[0].length;j++){
                
                if((i==0 || j==0 || i==board.length-1 || j==board[0].length-1) && board[i][j]=='O')
                {
                   q.add(new Pair<Integer,Integer>(i,j));
                } 
            }
        }
        
        //traversing through all O and their neighbours and marking them visited to mark them not converted
        boolean[][] visited=new boolean[board.length][board[0].length];
        while(!q.isEmpty()){
            
            Pair<Integer,Integer> pair=q.poll();
            
            int i=pair.getKey();
            int j=pair.getValue();
            
            visited[i][j]=true;
            
            q.addAll(getNeighbors(pair,board,visited));
            
        }
        
        //if a pointer is not visited and is O then it should be converted to X
        for(int i=1;i<board.length-1;i++){
            
            for(int j=1;j<board[0].length-1;j++){
                
                if(visited[i][j]==false && board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    
    private List<Pair<Integer,Integer>> getNeighbors(Pair<Integer,Integer> currCell, char[][] board, boolean[][] visited){
        
            int i=currCell.getKey();
            int j=currCell.getValue();
            
            List<Pair<Integer,Integer>> list=new ArrayList<>();
           
            if(i-1>0 && visited[i-1][j]==false && board[i-1][j]=='O') 
                list.add(new Pair<Integer,Integer>(i-1,j));
            
            if(j-1>0 && visited[i][j-1]==false && board[i][j-1]=='O')
                list.add(new Pair<Integer,Integer>(i,j-1));
            
            if(i+1<board.length-1 && visited[i+1][j]==false && board[i+1][j]=='O') 
                list.add(new Pair<Integer,Integer>(i+1,j));
            
            if(j+1<board[0].length-1 && visited[i][j+1]==false && board[i][j+1]=='O')
                list.add(new Pair<Integer,Integer>(i,j+1));
        
        return list;
    }
}
