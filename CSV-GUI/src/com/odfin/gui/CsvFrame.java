package com.odfin.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.odfin.core.Article;
import com.odfin.core.IOUtility;

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
	
	private List<Article> articleList = null;
	private int currentArticle = 0;
	
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
		this.add(createControlPanel(), "1,9,3,9");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		
		articleList = IOUtility.readArticleFile(null);
		
		showArticle(0);
	}

	public void showArticle(int index) {
		if(articleList != null) {
			txtArticleNumber.setText(articleList.get(index).getArticleNumber());
			txtArticleName.setText(articleList.get(index).getArticleName());
			txtDescription.setText(articleList.get(index).getDescription());
			txtPrice.setText(String.valueOf(articleList.get(index).getPrice()));	
		}	
	}
	
	private JPanel createControlPanel() {
		
		ButtonListener buttonListener = new ButtonListener();
		
		JButton btnPrevious = new JButton("<");
		btnPrevious.addActionListener(buttonListener);
		btnPrevious.setActionCommand("previous");
		
		JButton btnNext = new JButton(">");
		btnNext.addActionListener(buttonListener);
		btnNext.setActionCommand("next");
		
		double[][] sizes = {
				{ 10, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, 10 },
				{ TableLayout.PREFERRED }
		};
		
		JPanel pnlControl = new JPanel();
		pnlControl.setLayout(new TableLayout(sizes));
		pnlControl.add(btnPrevious,"1,0");
		pnlControl.add(btnNext,"3,0");
		
		return pnlControl;
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("previous")) {
				if(currentArticle > 0) {
					showArticle(--currentArticle);
				}
			}else {
				if(currentArticle < articleList.size() - 1) {
					showArticle(++currentArticle);
				}
			}
		}
		
	}
}