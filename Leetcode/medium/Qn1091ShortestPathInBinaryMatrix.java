package medium;
import java.util.*;

public class Qn1091ShortestPathInBinaryMatrix {

	// Time 62.14%, Space 100%
	private int dir[][] = new int[][]{
		{0, 1},
		{0, -1},
		{1, 0},
		{-1, 0},
		{1, 1},
		{-1, 1},
		{1, -1},
		{-1, -1}
	};

	public int shortestPathBinaryMatrix(int[][] grid) {
		int row = grid.length; // #elements in a row
		int col = grid[0].length;

		if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1){
			return -1;
		}

		boolean visited[][] = new boolean[row][col];
		visited[0][0] = true;

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{0, 0});

		int len = 0;
		while(!q.isEmpty()){
			int size = q.size();

			for(int i = 0; i < size; i++){

				int[] pop = q.remove();

				if(pop[0] == row - 1 && pop[1] == col - 1){
					return len + 1;
				}

				for(int k = 0; k < 8; k++){
					int nextX = dir[k][0] + pop[0];
					int nextY = dir[k][1] + pop[1];

					if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && !visited[nextX][nextY] && grid[nextX][nextY] == 0){
						q.add(new int[]{nextX, nextY});
						visited[nextX][nextY] = true;
					}
				}
			}
			len++;
		}

		return -1;
	}

}
