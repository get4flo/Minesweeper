import java.awt.Color;

public class Spielfeld{
	
	private int [][] Feld1, Feld2;
	private boolean click;
	private int x,y;
	
	public Spielfeld(int [][] rFeld) {
		Feld1 = rFeld;
		converte();
		x = Feld1[0].length;
		y = Feld1.length;
		/*Minesweeper3.print(Feld1);
		System.out.println();
		Minesweeper3.print(Feld2);*/
		startGraphics();
	}
	
	public void startGraphics() {
		StdDraw.setCanvasSize(720, 720);
		StdDraw.setXscale(0.0, x);
		StdDraw.setYscale(0.0, y);
		click = true;
		System.out.println();
		StdDraw.square(2, 2, 0.5);
		Color g = new Color(220, 220, 220);
		
		
		while(true) {
			if(click) {
				StdDraw.clear(StdDraw.LIGHT_GRAY);
				for(int i=0; i<x; i++) {
					StdDraw.line(i, 0, i, y);
					StdDraw.line(0, i, x, i);
					for (int j=0; j<y; j++) {
						StdDraw.text(i+.5, j+.5, Integer.toString(Feld2[i][j]));
					}
				}
				System.out.println("Clicked!");
				click = false;
				StdDraw.show(200);
			}
			click= StdDraw.mousePressed();
			
		}
	}
	
	public void converte() {
		
		Feld2 = new int[Feld1.length][Feld1[0].length];
		for(int i=0; i<Feld1.length; i++) {
			for(int j=0; j<Feld1[0].length; j++) {
				if(Feld1[i][j]==1) {
					add(i, j);
				}
			}
		}
	}
	
	public void add(int x, int y) {
		for(int i=-1; i<2; i++) {
			for(int j=-1; j<2; j++) {
				if(x+i<0 || x+i>=Feld2.length) continue;
				if(y+j<0 || y+j>=Feld2[0].length) continue;
				if(i==0 && j==0) {
					Feld2[x+i][y+j]=-1;
					continue;
				}
				if(Feld1[x+i][y+j]==1)continue;
				Feld2[x+i][y+j]+= 1;
			}
		}
	}
	
	public void run() {
		
	}
	
	
	

}