package de.infogk1.pacman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;


public class Menu implements ActionListener, ItemListener {

	public JMenuBar getMenuebar()
	{
		JMenuBar mainMenuBar;
		JMenu menu1, menu2, submenu;
		JMenuItem plainTextMenuItem, textIconMenuItem, iconMenuItem,   
                          subMenuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;
		mainMenuBar = new JMenuBar();
		menu1 = new JMenu("Menu");
		menu1.setMnemonic(KeyEvent.VK_M);
		mainMenuBar.add(menu1);
		
		plainTextMenuItem = new JMenuItem("START",
				KeyEvent.VK_S);
		
		plainTextMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menu1.add(plainTextMenuItem);
		menu1.addSeparator();
		
		
		
		
		
		submenu = new JMenu("OPTIONEN");
		submenu.setMnemonic(KeyEvent.VK_S);
		subMenuItem = new JMenuItem("Lautst�rke");
		subMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.CTRL_MASK));
		submenu.add(subMenuItem);
		subMenuItem = new JMenuItem("Cheats");
		submenu.add(subMenuItem);
		menu1.add(submenu);
		
		menu2 = new JMenu("Menu 2");
		menu2.setMnemonic(KeyEvent.VK_M);
		mainMenuBar.add(menu2);
		
		return mainMenuBar;
	}
	
	JTextArea jtAreaOutput;
	JScrollPane jspPane;
	public JMenuBar createJMenuBar() {
		JMenuBar mainMenuBar;
		JMenu menu1, menu2, submenu;
		JMenuItem plainTextMenuItem, textIconMenuItem, iconMenuItem,   
                          subMenuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;
		mainMenuBar = new JMenuBar();
		menu1 = new JMenu("Menu");
		
		mainMenuBar.add(menu1);
		
		plainTextMenuItem = new JMenuItem("START");
        plainTextMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Game.gestoppt = false;
				new Thread(new Game()).start();
			}
		});
		
		plainTextMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
		plainTextMenuItem.addActionListener(this);
		menu1.add(plainTextMenuItem);
		
	
		
		
		textIconMenuItem = new JMenuItem("BEENDEN");
		textIconMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.gestoppt = true;
			}
		});
		menu1.add(textIconMenuItem);
		
		textIconMenuItem = new  JMenuItem("PAUSE");
		
		menu1.add(textIconMenuItem);
		iconMenuItem = new JMenuItem("ICON");
		iconMenuItem.setMnemonic(KeyEvent.VK_D);
		iconMenuItem.addActionListener(this);
		iconMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Var.pausiert = true;
			}
		});
		menu1.add(iconMenuItem);
		
		
		
		
		
		
		menu1.addSeparator();
		
		
		
		
		
		submenu = new JMenu("OPTIONEN");
		
		subMenuItem = new JMenuItem("Lautstärke");
		subMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.CTRL_MASK));
		subMenuItem.addActionListener(this);
		submenu.add(subMenuItem);
		subMenuItem = new JMenuItem("Cheats");
		submenu.add(subMenuItem);
		subMenuItem.addActionListener(this);
		menu1.add(submenu);
		return mainMenuBar;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) (e.getSource());
		String s = "Menu Item source: " + source.getText()
				+ " (an instance of " + getClassName(source) + ")";
		jtAreaOutput.append(s + "\n");
		jtAreaOutput.setCaretPosition(jtAreaOutput.getDocument()
				.getLength());
	}
	public void itemStateChanged(ItemEvent e) {
		JMenuItem source = (JMenuItem) (e.getSource());
		String s = "Menu Item source: "
				+ source.getText()
				+ " (an instance of "
				+ getClassName(source)
				+ ")"
				+ "\n"
				+ "    State of check Box: "
				+ ((e.getStateChange() == ItemEvent.SELECTED) ?
                                   "selected" : "unselected");
		jtAreaOutput.append(s + "\n");
		jtAreaOutput.setCaretPosition(jtAreaOutput.getDocument()
				.getLength());
	}
	
	protected String getClassName(Object o) {
		String classString = o.getClass().getName();
		int dotIndex = classString.lastIndexOf(".");
		return classString.substring(dotIndex + 1); // Returns only Class name
	}
}
   
	
