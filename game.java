package WEC;

public class game {
static int [] ar= new int [4];
	public static void main(String[] args) {
		boolean game=true;//used to start/stop loop
		GameBoard board= new GameBoard();//open object
		String data="";//would have stored data received from server (if we got websocket to work)
		int newpos=0;// decides which position to move to
		while (game) {
			board.updateBoard(data);//used to refresh the board
			if (safeSpace(board.board,board.currentPos[0],board.currentPos[1])>0) {
				int max=ar[0];
				int id=0;
				for (int i=0; i<4;i++) {//If there are safe space for ai to move, it decides which space has more safe spaces and thus is safer
					if (ar[i]>max) {
						max=ar[i];
						id=i;
					}
				}
				newpos=id;
			} else {
				newpos=(int) (Math.random() * (4-1+1) + 1);//if the ai is trapped (Has no safe space to move, it will move in a random direction)
			}
			switch (newpos) {//Would move the ai in one of the 4 directions if we had gotten websocket to work
			case 1://left
				//would have had the move left command
				break;
			case 2://right
				
				break;
			case 3://up
				
				break;
			case 4://down
				
				break;
			}
		}
	}

	static int safeSpace(String[][] array, int currentx, int currenty) {// Checks the 4 directions and sees which of them are the safe to move to.
		int positionsFree=0;
		for (int i=1; i<=4; i++){
			int x=currentx;
			int y=currenty;
			switch (i) {
			case 1://left
				x--;
				break;
			case 2://right
				x++;
				break;
			case 3://up
				y++;
				break;
			case 4://down
				y--;
				break;
			}
			//Determines if this position is a valid space for the ghost to move
			if (array[y][x].equals(".")){
				positionsFree++;
				betterSpace(array, x, y, i);
			}
		}
		
			return positionsFree;
	}
	
	static void betterSpace(String[][] array, int currentx, int currenty, int j) {//Checks how many safe spaces would be available from the new position and stores it in array ar 
		int positionsFree=0;
		for (int i=1; i<=4; i++){
			int x=currentx;
			int y=currenty;
			switch (i) {
			case 1://left
				x--;
				break;
			case 2://right
				x++;
				break;
			case 3://up
				y++;
				break;
			case 4://down
				y--;
				break;
			}
			if (array[y][x].equals(".")){
				positionsFree++;
			}
			ar[j]=positionsFree;
		}
	}
}
