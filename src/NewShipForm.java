import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NewShipForm extends JFrame {
	NewShipForm thisForm;
	ProductForm parentForm;
	JPanel panel;
	JLabel lblShipID;
	JLabel lblShipCost;
	JLabel lblShipName;
	JLabel lblInStock;
	JTextField txtShipID;
	JTextField txtShipCost;
	JTextField txtShipName;
	JTextField txtInStock;
	JButton submitButton;
	
	public NewShipForm(ProductForm parent) {
		thisForm = this;
		parentForm = parent;
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Content Pane
		panel = new JPanel();
		
		//Settings
		this.setContentPane(panel);
		this.setResizable(false);
		this.setBounds(dim.width/2 - 100, dim.height/2 - 125, 200, 250);
		
		this.lblShipID = new JLabel("ID #: ");
		this.txtShipID = new JTextField();
		this.txtShipID.setColumns(15);
		
		this.lblShipName = new JLabel("Name: ");
		this.txtShipName = new JTextField();
		this.txtShipName.setColumns(15);
		
		this.lblShipCost = new JLabel("Cost: ");
		this.txtShipCost = new JTextField();
		this.txtShipCost.setColumns(15);
		
		this.lblInStock = new JLabel("In Stock: ");
		this.txtInStock = new JTextField();
		this.txtInStock.setColumns(15);
		
		//Adds the functionality for the button
		this.submitButton = new JButton("Submit");
		this.submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					Ship ship = new Ship(Integer.parseInt(txtShipID.getText()), txtShipName.getText(), Double.parseDouble(txtShipCost.getText()), Integer.parseInt(txtInStock.getText()));
					ship.addListener(parentForm);
					parentForm.Ships.add(ship);
					parentForm.Update();
					if(parentForm.running)
						ship.SetTimer();
					thisForm.setVisible(false);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "ERROR: Invalid Data");
				}
			}
		});
		
		//Adds all the fields
		this.panel.add(lblShipID);
		this.panel.add(txtShipID);
		this.panel.add(lblShipName);
		this.panel.add(txtShipName);
		this.panel.add(lblShipCost);
		this.panel.add(txtShipCost);
		this.panel.add(lblInStock);
		this.panel.add(txtInStock);
		this.panel.add(submitButton);
	}
}
