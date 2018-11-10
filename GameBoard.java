package WEC;

public class GameBoard{
	public String [][] board = new String [16][16];
	public int [] currentPos = {-1, -1};
	public int [] enemyPos = {-1, -1};
	
	public void updateBoard(String dataInput){
	    String [] data = dataInput.split("\", ");
	    int dataIndex = 0;
	    
	    for(int i = 0; i < 16; i++){
	        for(int j = 0; j < 16; j++){
	            board[i][j] = data[dataIndex].substring(8, data[dataIndex].length()-1);//takes the data from server and inserts into the array
	            
	            if(data[dataIndex].substring(8, data[dataIndex].length()-1).equals("8")){
	                currentPos[0] = i;//stores our current position
	                currentPos[1] = j;
	            } 
	            
	            //check for other id
	            try{
	                Integer.parseInt(data[dataIndex].substring(8, data[dataIndex].length()-1));
	                
	                enemyPos[0] = i;//stores enemy's current position
	                enemyPos[1] = j;
	            } 
	            catch(NumberFormatException e){}
	            
            }
	    }
	}
}