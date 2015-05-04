import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Driver {

	public static void main(String[] args) throws IOException {
		
		generateRandomGraph();
		
//		generateLinearGraph();
		
		
		KruskalAlgorithm.run();
		
//		System.out.println("\n===========================================================================");
		System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
//		System.out.println("===========================================================================\n");
		
		PrimAlgorithm.run();
	}
	
	
	
	static void generateRandomGraph() throws IOException{
		File file = new File("input.txt");
		 
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		int Min=1;
		int Max=100;
		int vertices =Min + (int)(Math.random() * ((Max - Min) + 1));
		
		System.out.println("Generated Graph");
		System.out.println("=====================");
		
		bw.write(Integer.toString(vertices));
		bw.newLine();
		
		System.out.println(vertices);
		
		int edges = 0 + (int)(Math.random() * (( ( (vertices * (vertices-1))/2 ) - 0) + 1) );
		
		
		bw.write(Integer.toString(edges));
		bw.newLine();
		
		System.out.println(edges);
		
		int maxweight = 100;
		int first ,second ,weight;
		for (int i = 0; i <edges; i++) {
			
			first = 1 + (int)(Math.random() * ((vertices - 1) + 1));
			second = 1 + (int)(Math.random() * ((vertices - 1) + 1));
			
			weight = 0 + (int)(Math.random() * ((maxweight - 0) + 1));
			
			
			bw.write(first +","+second+","+weight);
			bw.newLine();
			
			System.out.println(first +", "+second+", "+weight);
		}
		
		
		System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		
		
		
		bw.close();
	}
	
	
	static void generateLinearGraph() throws IOException{
		File file = new File("input.txt");
		 
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		int Min=1;
		int Max=100;
		int vertices =Min + (int)(Math.random() * ((Max - Min) + 1));
		
		System.out.println("Generated Graph");
		System.out.println("=====================");
		
		bw.write(Integer.toString(vertices));
		bw.newLine();
		
		System.out.println(vertices);
		
		int edges =vertices-1;
		
		
		bw.write(Integer.toString(edges));
		bw.newLine();
		
		System.out.println(edges);
		
		int maxweight = 100;
		int first ,second ,weight;
		for (int i = 0; i <edges; i++) {
			
			first = i+1;
			second =i+2;
			
			weight = 0 + (int)(Math.random() * ((maxweight - 0) + 1));
			
			
			bw.write(first +","+second+","+weight);
			bw.newLine();
			
			System.out.println(first +", "+second+", "+weight);
		}
		
		
		System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		
		
		
		bw.close();
	}

}
