package main.java.com.rss.gfg.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaterOverflow {

	public static void main(String[] args) {
		int testCases, row, col;
		float x;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			testCases = Integer.parseInt(br.readLine());
			for(int i=0; i<testCases; i++) {
				x = Integer.parseInt(br.readLine());
				row = Integer.parseInt(br.readLine());
				col = Integer.parseInt(br.readLine());
				System.out.println(findWater(row, col, x));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static float findWater(int row, int col, float x) {
		float[][] glass = new float[row][];
		for(int i=0; i<row; i++)
			glass[i] = new float[i + 1];
		glass[0][0] = x;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++){
				x = glass[i][j];
				if(x > 1.0f) {
					glass[i][j] = 1.0f;
					if(i+1 < row) {
						glass[i+1][j] += (x - 1.0f) / 2;
						glass[i+1][j+1] += (x - 1.0f) / 2;
					}
				}
			}
		}
		return glass[row-1][col-1];
	}

}
