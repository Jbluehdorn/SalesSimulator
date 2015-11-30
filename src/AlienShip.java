
public class AlienShip extends Ship {
	String AlienRace; //Keeps track of which race of aliens created the ship
	
	public AlienShip(int ProductId, String name, double cost, int inStock, String AlienRace){
		super(ProductId, name, cost, inStock);
		this.AlienRace = AlienRace;
	}
	
	public double getTotalCost() {
		return super.getTotalCost() * 1.05;
	}
	
	public String toString() {
		return "Race: " + this.AlienRace + "\n" + super.toString();
	}
}
