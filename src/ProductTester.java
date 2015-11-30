import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;


public class ProductTester {
	public static void main(String[] args) {
		ArrayList<Ship> ships = new ArrayList<Ship>();
		//Creates six ship objects
		Ship ship1 = new Ship(1214, "BattleCruiser", 400, 9);
		Ship ship2 = new Ship(1337, "Wraith", 150, 13);
		Ship ship3 = new Ship(5533, "Medivac", 100, 50);
		Ship ship4 = new Ship(4295, "Viking", 150, 18);
		Ship ship5 = new Ship(8549, "Banshee", 100, 24);
		Ship ship6 = new Ship(7878, "Science Vessel", 100, 12);
		Ship ship7 = new AlienShip(9129, "Carrier", 350, 10, "Protoss");
		
		//Adds all ships to the list
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		ships.add(ship4);
		ships.add(ship5);
		ships.add(ship6);
		ships.add(ship7);
		
		JFrame frame = new JFrame("Jordan's Starport");
		frame.setContentPane(new ProductForm(ships));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(0, 0, 500, 540);
		
		//Makes the the frame opens dead center
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		frame.setVisible(true);
	}
}
