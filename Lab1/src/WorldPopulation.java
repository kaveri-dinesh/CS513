import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.StringTokenizer;

public class WorldPopulation {

	SortStrategy sortStrategy;
	long[] population = new long[13484]; // Cheating because we know number of records!!
		
	// Lab Exercise:  After creating some strategy classes -- set the default strategy here.
	public WorldPopulation(){
		sortStrategy = new InsertionSort(); // Set the default strategy here.	
	}
	
	public void readInputFile(){
		population = readPopulationFile("src\\WorldPopulation.csv");
	}
	
	public void setStrategy(SortStrategy strategy){
		sortStrategy = strategy;
	}
	
	// Lab Exercise:  Read in the WorldPopulation.csv
	// Extract ONLY the numbers and store them into population[]
	public long[] readPopulationFile(String fileName){
		int counter = 0;
		try {
		FileReader inputFile = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(inputFile);
		String line;
		// read each line
		while((line = reader.readLine()) != null) {
		StringTokenizer tokenizer = new StringTokenizer(line, ",");
		String countryName = tokenizer.nextToken();
		String year = tokenizer.nextToken();
		String pop = tokenizer.nextToken();
		long popCount = Long.parseLong(pop);
		population[counter++]=popCount;
		}
		reader.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return population;
	}
	
	// Lab Exercise.  Complete this method.
	// Delegate sorting to the strategy object
	public void sortPopulation(){		
		sortStrategy.sort(population);
	}
	public void computeTotalPopulation(){
		System.out.println("dd");
	}
	public long getSortTime()
	{
		return sortStrategy.getSortTime();
	}
	
	// Experiment with various strategies.
	// Create 3 strategies -- Bubble, insertion, and selection sort.
	public static void main(String[] args) {
		WorldPopulation worldPopulation = new WorldPopulation();
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(new BubbleSort()); //  Currently no strategies.
		worldPopulation.sortPopulation();
		worldPopulation.getSortTime();	
		worldPopulation.setStrategy(new SelectionSort()); //  Currently no strategies.
		worldPopulation.sortPopulation();
		worldPopulation.getSortTime();
	}	
}
