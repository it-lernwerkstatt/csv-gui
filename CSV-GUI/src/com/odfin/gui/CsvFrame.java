package com.odfin.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import layout.TableLayout;

public class CsvFrame extends JFrame{

	private JLabel lblArticleNumber = new JLabel("Artikelnummer:");
	private JTextField txtArticleNumber = new JTextField();
	
	private JLabel lblArticleName = new JLabel("Artikelname:");
	private JTextField txtArticleName = new JTextField();
	
	private JLabel lblDescription = new JLabel("Beschreibung:");
	private JTextField txtDescription = new JTextField();
	
	private JLabel lblPrice = new JLabel("Preis:");
	private JTextField txtPrice = new JTextField();
	
	public CsvFrame() {
		
		double[][] sizes = {
				{ 10, TableLayout.PREFERRED, 10, 150, 10 },
				{ 20, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, 10, TableLayout.PREFERRED, 20 }
		};
		
		this.setLayout(new TableLayout(sizes));
		this.add(lblArticleNumber, "1,1");
		this.add(lblArticleName, "1,3");
		this.add(lblDescription, "1,5");
		this.add(lblPrice, "1,7");
		this.add(txtArticleNumber, "3,1");
		this.add(txtArticleName, "3,3");
		this.add(txtDescription, "3,5");
		this.add(txtPrice, "3,7");
		
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}
