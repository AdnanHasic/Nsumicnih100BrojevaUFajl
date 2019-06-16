import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Nasumicnih100IzFajla {

	public static void main(String[] args) {

		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesite naziv fajla  : ");

		Path putanja = Paths.get(unos.nextLine().concat(".txt"));
		
		int broj = 0;
		
		List<Integer> listaInetegra = new ArrayList<>();
		
		if (!Files.exists(putanja)) {
			
			try {
				
				PrintWriter pw = new PrintWriter(
						
						Files.newBufferedWriter(putanja, StandardOpenOption.APPEND, StandardOpenOption.CREATE));
				
				for (int i = 0; i < 100; i++) {
					
					broj = (int) (Math.random() * 100);
					
					pw.print(broj + " ");
				}

				pw.flush();
				pw.close();

				unos = new Scanner(putanja);
				
				while (unos.hasNextInt()) {
					
					listaInetegra.add(unos.nextInt());
					
				}
				
				Collections.sort(listaInetegra);
				
				for(Integer prolazakKrozListu : listaInetegra) {
					
					System.out.print(prolazakKrozListu + " ");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Fajl sa tim nazivom je vec kreiran ! ");
		}

	}

}
