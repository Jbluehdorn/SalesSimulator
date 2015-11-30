import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProductForm extends JPanel implements IObserver {
	ArrayList<Ship> Ships;
	TextArea txtShip;
	JButton newShipButton;
	JButton btnStartSimulation;
	JLabel lblCost;
	ProductForm thisPanel;
	boolean running = false;
	
	public ProductForm(final ArrayList<Ship> ships) {
		super();
		
		this.Ships = ships;
		final ProductForm thisForm = this;
		
		//Adds this as a listener for each object
		for(Ship ship : Ships) {
			ship.addListener(this);
		}
		
		this.thisPanel = this;
		
		//Creates the text area
		this.txtShip = new TextArea(30, 65);
		txtShip.setEditable(false);
		txtShip.setBackground(Color.WHITE);
		
		//Creates the new ship button
		this.newShipButton = new JButton("Add New Ship");
		newShipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JFrame newFrame = new NewShipForm(thisPanel);
				newFrame.setVisible(true);
			}
		});
		
		//Creates the start simulation button
		this.btnStartSimulation = new JButton("Start Sales Simulation");
		btnStartSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				for(Ship ship : ships){
					ship.SetTimer();
				}
				thisForm.running = true;
			}
		});
		
		//Creates the total amount label
		lblCost = new JLabel("Total Cost: 0");
		
		//Updates values
		Update();
		
		//Adds all components
		this.add(txtShip);
		this.add(newShipButton);
		this.add(btnStartSimulation);
		this.add(lblCost);
	}
	
	//Updates the textarea
	public void Update() {
		String shipInfo = "";
		
		Collections.sort(Ships);
		
		//Gets all the information for each ship
		for(Ship ship : Ships){
			shipInfo += ship.toString();
			shipInfo += "\n----------------------------\n";
		}
		
		//Updates the cost label
		lblCost.setText("Total Cost: " + getTotalCost(Ships));
		
		txtShip.setText(shipInfo);
	}
	
	//Calculates the total value of all ships
	public static String getTotalCost(ArrayList<Ship> ships) {
		double totalCost = 0;
		
		for(Ship i : ships) {
			totalCost += i.getTotalCost();
		}
		
		NumberFormat formatter = new DecimalFormat("$0.00");
		
		return formatter.format(totalCost);
	}
}
