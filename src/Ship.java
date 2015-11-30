import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Ship implements IShip {
	private String name;
	private double cost;
	public int ProductID;
	public int inStock = 0;
	public int QueueTime;
	private ArrayList<IObserver> observers = new ArrayList<IObserver>();
	
	//Default constructor
	public Ship(){
		this.ProductID = 999;
		this.name = "Default Ship";
		this.cost = 0.00;
		this.inStock = 0;
		this.QueueTime = 1000;
	}
	
	public Ship(int ProductId, String name, double cost, int inStock){
		this.ProductID = ProductId;
		this.name = name;
		this.cost = cost;
		this.inStock = inStock;
		this.QueueTime = (int) (Math.random() * 10000 + 1000);
	}
	
	//Getters and setters
	public String GetName() {
		return this.name;
	}
	
	public double GetCost() {
		return this.cost;
	}
	
	public void SetName(String newName) {
		this.name = newName;
	}
	
	public void SetCost(double newCost) {
		if(newCost > 0)
			this.cost = newCost;
		else
			throw new IllegalArgumentException("Cost cannot be less than 0");
	}

	//Returns the sum of each of the object's prices
	public double getTotalCost() {
		return this.cost * this.inStock;
	}
	
	public void SetTimer() {
		final Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			public void run() {
				if(inStock > 0)
					inStock--; 
				else{
					timer.cancel();
					timer.purge();
					return;
				}
				notifyListeners();
			}
		}, 0, QueueTime);
	}
	
	//Method Overrides
	public String toString() {
		NumberFormat formatter = new DecimalFormat("$0.00");
		return "Name: " + this.name + "\nCost per Unit: " + formatter.format(this.cost) + "\nIn Stock: " + inStock;
	}
	
	@Override
	public int compareTo(Ship other) {
		int compareNum = this.name.toUpperCase().compareTo(other.name.toUpperCase());
		return compareNum;
	}

	//Observer pattern methods
	@Override
	public void addListener(IObserver obs) {
		this.observers.add(obs);
	}

	@Override
	public void removeListener(IObserver obs) {
		this.observers.remove(obs);
	}

	@Override
	public void notifyListeners() {
		for(IObserver obs : observers){
			obs.Update();
		}
	}
}
