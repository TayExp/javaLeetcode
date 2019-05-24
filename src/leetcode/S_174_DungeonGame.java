package leetcode;

public class S_174_DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0 || dungeon[0].length == 0) return 0;
    	int m = dungeon.length-1, n = dungeon[0].length-1;
        int[][] aux = new int[m+1][n+1];
        aux[m][n] = Math.max(1, 1 - dungeon[m][n]);
        for(int i = m-1; i >= 0; i--){
        	aux[i][n] = Math.max(aux[i+1][n]-dungeon[i][n], 1);
        }
        for(int i = n-1; i >= 0; i--){
        	aux[m][i] = Math.max(aux[m][i+1]-dungeon[m][i], 1);
        }
        	
        for(int i = m-1; i >= 0 ; i--)
        	for(int j = n-1; j >= 0;j--){
        		aux[i][j] = Math.max(Math.max(1, 1-dungeon[i][j]), Math.min(aux[i+1][j],aux[i][j+1])-dungeon[i][j]);
        	}
        return aux[0][0];
    }
    public static void main(String[] args) {
//		System.out.println(new S_174_DungeonGame().calculateMinimumHP(new int[][]{{1, -3, 3},{0, -2, 0}, {-3,-3,-3}}));
//		System.out.println(new S_174_DungeonGame().calculateMinimumHP(new int[][]{{3, -20, 30},{-3, 4, 0}}));
		System.out.println(new S_174_DungeonGame().calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
	}
}
