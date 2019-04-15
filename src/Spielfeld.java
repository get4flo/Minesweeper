import java.awt.Color;
import java.util.Arrays;

public class Spielfeld{
	
	private int [][] Feld1, Feld2;
	private boolean click;
	private boolean [][] mouse;
	private int x,y, iter;
	private long time;
	
	public Spielfeld(int [][] rFeld) {
		Feld1 = rFeld;
		converte();
		x = Feld1[0].length;
		y = Feld1.length;
		mouse= new boolean[x][y];
		startGraphics();
	}
	
	public void startGraphics() {
		StdDraw.setCanvasSize(720, 720);
		StdDraw.setXscale(0.0, x);
		StdDraw.setYscale(0.0, y);
		//click = false;
		
		System.out.println();
		Color g = new Color(220, 220, 220);
		time = System.currentTimeMillis();
		int xm=0, ym=0;
		
		
		while(true) {
			
			if((System.currentTimeMillis()-time)>10) {
				draw(xm, ym);
				time= System.currentTimeMillis();
			}
			click= StdDraw.mousePressed();
			if(click) {
				xm= (int)StdDraw.mouseX();
				ym= (int)StdDraw.mouseY();
			}
			
		}
	}
	
	public void draw(int xm, int ym) {
		
		StdDraw.clear(StdDraw.LIGHT_GRAY);
		if(click) {
			mouse[xm][ym]= true;
			if(Feld2[ym][xm]==0) clicked(xm, ym);
		}
		for(int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(i+.5, j+.5, Integer.toString(Feld2[i][j]));
				StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
				if(!mouse[i][j])StdDraw.filledSquare(i+.5, j+.5, .5);
			}
		}
		
        for(int i=0; i<x; i++) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(i, 0, i, y);
			StdDraw.line(0, i, x, i);
		}
        
		click = false;
		StdDraw.show(20);
	}
	
	public void clicked(int xm, int ym) {
		for(int i=-1; i<2; i++) {
			for(int j=-1; j<2; j++) {
				if(xm+i<0 || xm+i>=Feld2.length) continue;
				if(ym+j<0 || ym+j>=Feld2[0].length) continue;
				if(i==0 && j==0) continue;
				if(Feld2[xm+i][ym+j]==0) {
					mouse[ym+i][xm+j]= true;
					clicked(ym+i, xm+j);
				}
			}
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