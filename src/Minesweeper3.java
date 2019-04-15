/******************************************************************************
   Execution:    ./gradlew testen

   Eingabe: -
   Ausgabe: Ausgaben der Testfaelle aus Minesweeper3Testen.java

   Sie duerfen keine Funktionen aus StdRandom aufrufen, sonst schlagen die Tests
   fehl! Es lassen sich einige Code-Anteile aus der Loesung von Minesweeper1 fuer
   dieses Programm (angepasst) wiederverwenden.


  Sie muessen vier Methoden implementieren:
    makeRandomBoard(z,s,n) - Bekommt drei Parameter: Zeilen z, spalten s und
                             die Anzahl von Minen n. Erzeugt ein Spielfeld mit
                             z Zeilen und s Spalten und positioniert die Minen
                             Die Position der Minen bekommen Sie durch Aufruf
                             der vorgegebenen Methode selectRandomPosition.
                             Rufen Sie n mal selectRandomPosition auf und
                             positionieren Sie die Minen entsprechend. Sie muessen
                             dabei nicht ueberpruefen, ob auf dem Feld eine Mine
                             bereits gesetzt wurde.

   isMine - Bekommt drei Parameter: Ein Spielfeld und Zeile und Spalte. Gibt
            true zurueck, wenn sich auf der Position eine Mine befindet, ansonsten
            gibt die Methode false zurueck.

   countMines -  Bekommt drei Parameter: Ein Spielfeld und Zeile und Spalte. Gibt
                 die Anzahl der Minen auf den unmittelbaren Nachbarfeldern 
                 (links, rechts, oben und unten) zur√ºck, wenn sich an
                 der uebergebenen Position keine Mine befindet. Ansonsten gibt die
                 Methode -1 zurueck.

   boardToString - Bekommt das Spielfeld als Parameter uebergeben und gibt eine
                   String-Darstellung des Feldes zurueck. Felder mit einer Mine
                   werden durch ein *, Felder ohne Mine durch eine 0 dargestellt.
                   Die Ausgabe soll Zeilenweise erfolgen.



 ******************************************************************************/
import java.util.Scanner;

public class Minesweeper3 {

    /* Waehlt eine zufaellige Minen-Position aus, rufen Sie diese
       Methode in ihrer makeRandomBoard Methode auf */
	
    public static int[] selectRandomPosition(int height, int width) {
        int[] pos = new int[2];

        // Mit StdRandom.uniform(a, b) wird ein zufaelliger Wert aus dem
        // Interval [a, b) generiert
        pos[0] = StdRandom.uniform(0,width);
        pos[1] = StdRandom.uniform(0,height);

        return pos;
    }

    public static int[][] makeRandomBoard(int height, int width, int mines) {
        int Feld1 [][] = new int[height][width];
		
		for(int i=0; i<mines; i++){
			int tmp[] = new int[2];
			tmp = selectRandomPosition(height, width);
			Feld1[tmp[1]][tmp[0]]=1;
		}
        return Feld1;
    }

    public static boolean isMine(int[][] board, int i, int j) {
		
        if(board[i][j]==1) return true;
        return false;
    }

    public static int countMines(int[][] board, int z, int s) {
        
		if(board[z][s]==1) return -1;
		int Ergebnis=0;
		Ergebnis += board[z-1][s] + board[z+1][s]; //Addition y-Achse
		Ergebnis += board[z][s-1] + board[z][s+1]; //Addition x-Achse
		
        return Ergebnis;
    }

    public static String boardToString(int[][] board) {
        String SF="";
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(board[i][j]==1){
					SF += "*";
					continue;
				}
				SF += board[i][j];
			}
		}
	
        return SF;
    }
    
    public static void print(int [][] Feld) {
    	//Textausgabe Spielfeld
    	for(int i=0; i<Feld.length; i++) {
    		for (int j=0; j<Feld[0].length; j++) {
				System.out.print(Feld[i][j]);
			}
    		System.out.println();
    	}
    }
	
	public static void main(String[] args) {
		
		String size="";
		
		if(args.length<1) {
			/*System.out.println("Grˆﬂe eigeben(int):");
			Scanner leser = new Scanner (System.in);
			size = leser.nextLine();
			leser.close();*/
			size += 5;
		}
		else{
			size += args[0];
		}
		int z= Integer.parseInt(size);
		int s= Integer.parseInt(size);
		int n= (int)((Math.random()*1.0+1.0)*(Integer.parseInt(size)));
		int Feld1[][] = new int[z][s];
		//System.out.println(z+ " "+s+" "+n);
		
		Feld1= makeRandomBoard(z, s, n);
		
		//String Test = boardToString(Feld1);
		Spielfeld S = new Spielfeld(Feld1);
		
		
	}
}
			
			
		
		
	


