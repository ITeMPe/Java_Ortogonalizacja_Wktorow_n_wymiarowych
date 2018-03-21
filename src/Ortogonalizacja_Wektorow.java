import java.awt.Dimension;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.naming.event.ObjectChangeListener;

	
public class Ortogonalizacja_Wektorow
{

	static int dimensions=1;
	static float value=1;
	static float vectors [][];			// znany rozmiar po wisanu ilosci wymiarow
	static float ortogonalVectors [][];	// znany rozmiar po wisanu ilosci wymiarow
	
	static float tempVec[];				// ROZMIAR ZMIENNY W ZALEZNOSCI KTORY WEKTOR ORTOGONALIZUJEMY
	static float temp[][];
	static float normVecSquare[];   		// znany rozmiar po wisanu ilosci wymiarow
	static float scalarVec[];          	// ROZMIAR ZMIENNY W ZALEZNOSCI KTORY WEKTOR ORTOGONALIZUJEMY
	

	
	
	static Scanner read = new Scanner(System.in); //obiekt do odebrania danych od użytkownika
  
	public static void main(String[] args)
	{
	 System.out.println("Podaj liczbe wymiarów wektora:");
	 try
	 {
		 dimensions = read.nextInt();
		 vectors = new float [dimensions] [dimensions]; 
		 ortogonalVectors = new float [dimensions][dimensions];
		 normVecSquare = new float [dimensions];
		 tempVec = new float[dimensions];
		 temp = new float[dimensions][dimensions];
		 scalarVec = new float [dimensions]; 
	 }
	 catch (InputMismatchException e)
	 {
		 System.out.println("Źle wprowadzone dane wejściowe !!!");
		 System.exit(0);
	 }
	 
	 for(int i=0; i<dimensions; i++)
	 {
		 System.out.print("Wektor ");System.out.println(i);
		 try
		 {
			 for(int j=0; j<dimensions; j++)
			 {
				 System.out.print("Podaj "); System.out.print(j); System.out.println(" wartosc tego wektora");
				 value = read.nextFloat();
				 vectors[i][j] = value;
			 } 
		 }
		 catch (InputMismatchException e)
		 {
			 System.out.println("Źle wprowadzone dane wejściowe !!!");
			 System.exit(0);
		 } 
	 }
	 // WYSWIETLANIE PODANYCH WEKTOROW
	 System.out.print("Wektory ");System.out.println();
	 for(int i=0; i<dimensions; i++)
	 {
//		 System.out.println(i);
		 for(int j=0; j<dimensions; j++)
		 {
			System.out.print(vectors[i][j]);System.out.print("  ");
		 }System.out.println();
	 }
	 System.out.println();
	 //ORTOGONALIZACJA
	 for(int j=0; j<dimensions; j++)
	 {
		 ortogonalVectors[0][j] = vectors[0][j];
	 }
	 
	 for(int i=1; i<dimensions; i++)
	 {
		// 1) obliczenie normy z i-1 wektora ortogonalnego 
		 obliczanieNormy(i-1);		 
		// 2) obbliczenie iloczynu skalarnego i vektora z i-1 ortogonalnego wektora
		 obliczanieIloczynuSkalarnego(i);	 
		// 3) pomnozenie  przez i-1 wektor ortogonalny ilorazu wyników z pkt 1 i 2
		obliczanieSumy(i);
		for(int j=0; j<dimensions; j++)
		{
				ortogonalVectors[i][j] = vectors[i][j] - tempVec[j];
		}
	 }
	 
	
	 
	 
	 //WYSWIETLENIE WEKTOROW ORTOGONALNYCH 
	 System.out.print("Wektory ortogonalne ");System.out.println();
	 for(int i=0; i<dimensions; i++)
	 {
//		System.out.println(i);
		 for(int j=0; j<dimensions; j++)
		 {
			System.out.print(ortogonalVectors[i][j]);System.out.print("  ");
		 }System.out.println();
	 }
	 
	 
	}
	
	
	
	
	static void obliczanieNormy(int numberOfVec)
	{
		float temp=0;
		for(int i=0; i<dimensions; i++)
		{
			temp += (ortogonalVectors[numberOfVec][i]*ortogonalVectors[numberOfVec][i]);
		}
		normVecSquare[numberOfVec]=temp;
	}
	
	static void obliczanieIloczynuSkalarnego(int numberOfVec)
	{
		int temp = 0;
		
		for(int i=0; i<numberOfVec; i++)
		{
			for(int j=0; j<dimensions; j++)
			{
				temp += vectors[numberOfVec][j] *ortogonalVectors[i][j];
			}
			scalarVec[i] = temp;
			temp=0;
		}
	}
	
	static void obliczanieSumy(int numberOfVec)
	{
		for(int j=0 ; j<dimensions; j++)
		{
			tempVec[j] =0;
		}
		for(int i=0; i<numberOfVec; i++)
		{
			for(int j=0 ; j<dimensions; j++)
			{
				tempVec[j] =tempVec[j] + scalarVec[i]/normVecSquare[i] * ortogonalVectors[i][j];
			}
		}
	}
	
	static void sprOrtogonalnosc()
	{
		
	}
	
	
	
}







