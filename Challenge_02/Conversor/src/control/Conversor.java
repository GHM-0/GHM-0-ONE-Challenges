package control;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import view.viewConversor;
import view.viewSeletor;    

abstract class Conversor {

	protected static viewConversor conversor; 
	protected DocumentFilter DF;
	
	public Conversor() {
		conversor= new viewConversor();
		setActionSair();
	}
	
	public void setVisible(Boolean b) {
		conversor.setVisible(b);
	}
	
	private static void setActionSair(){
	      conversor.getBtnSair().addActionListener(e->{
	  		System.exit(0);
	  	});
	}

	public static void setTitle(String TIPO) {
		conversor.setTitle(TIPO);
	}

	public void setValorRef(String s) {
		conversor.setTextValorRef(s);
	}

	public void setActionVoltar(viewSeletor s) {

			conversor.getBtnVoltar().addActionListener( ex->{
				conversor.setVisible(false);
				s.setVisible(true);
			});
	};
	
	public void setFildRestriction(JTextField txt) {
		replaceInput(txt);
		
		DF= new DocumentFilter(){

		public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException{
			StringBuilder sb = new StringBuilder();
				sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
				sb.replace(offset, offset + length, text);
				if(!containsOnlyNumbers(sb.toString())) return;
				fb.replace(offset, length, text, attr);
			}


			public boolean containsOnlyNumbers(String text){
				Pattern pattern = Pattern.compile("(^(\\-{0,1})"
												+ "?(\\d){0,3}"          
												+ "?((\\.|\\,){0,1})"   
												+ "?(\\d){0,3}?)$");
				Matcher matcher = pattern.matcher(text);
				boolean isMatch = matcher.matches();
				return isMatch;
			}
		};
		
		((AbstractDocument) txt.getDocument()).setDocumentFilter(DF);
	}
	
	private static void replaceInput(JTextField txt) {
		 txt.addKeyListener(new KeyAdapter() {
		      public void keyReleased(KeyEvent e) {
					txt.setText(txt.getText().replace(",","."));			
		      }
	});
		 
	}
	
	protected static void enabledActions(JTextField txt) {
		txt.addKeyListener(new KeyAdapter() {
			 public void keyReleased(KeyEvent e) {
				 	
				if(txt.getText().length()<=1 && txt.getText().endsWith("-")
						|| txt.getText().isEmpty()) {
						conversor.getBtnSelecionar().setEnabled(false);	
					}else {
						conversor.getBtnSelecionar().setEnabled(true);	
			        }
		     }		 
		 });
	}

	protected static void fillSeletor(JComboBox<String> combo,HashMap<String,?> map) {
		for(Map.Entry<String,?> entry: map.entrySet()) {
			Object Opcoes = entry.getKey();
			combo.addItem((String) Opcoes);
		}
	}
	

	protected void setCombo(JComboBox<String> combo,JComboBox<String> otherCombo, HashMap<String,?> map) {
		combo.setSelectedIndex(0);
		otherCombo.removeItem(combo.getSelectedItem());
		combo.addItemListener((e)->{
			if(combo.getSelectedItem()!=null) {
				otherCombo.removeAllItems();
				fillSeletor(conversor.getComboTipoRef(),map);
				otherCombo.removeItem(combo.getSelectedItem());
			}else {
				combo.setSelectedIndex(0);
				otherCombo.remove(0);
			}
	});
	}
}
