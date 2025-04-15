package com.odfin.core;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class IOUtility {

	public static File open() {
		return open(null);
	}
	
	public static File open(Component parent) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("Textdateien", "txt"));
		chooser.setMultiSelectionEnabled(false);
		
		int state = chooser.showOpenDialog(parent);
		if(state == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		}
		
		return null;
	}
	
	public static ArrayList<Article> readArticleFile(File file) {
		
		file = new File("Artikel.csv");
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			
			ArrayList<Article> articleList = new ArrayList<Article>();
			String[] articleData = null;
			String line = br.readLine(); 
			while((line = br.readLine()) != null) {
				
				articleData = line.split(";");
				articleList.add(createArticle(articleData));
			}
			
			return articleList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
			
		return null;
	}
	
	private static Article createArticle(String[] articleData) {
		Article article = new Article();
		article.setArticleNumber(articleData[0]);
		article.setArticleName(articleData[1]);
		article.setDescription(articleData[2]);
		
		String price = articleData[3].replaceAll("[€$]", "").replaceAll(",", ".");
		article.setPrice(Double.parseDouble(price));
		
		return article;
	}

	public static File save() {
		return saveAs(null);
	}
	
	public static File saveAs(Component parent) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("Textdateien", "txt"));
		chooser.setMultiSelectionEnabled(false);
		
		int state = chooser.showSaveDialog(parent);
		if(state == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		}
		
		return null;
	}
	
	public static String writeFile(String content, File file) {
		
		StringBuilder sb = new StringBuilder();
		
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file))) {
			
			osw.write(content);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
			
		return sb.toString();
	}
	
}
