package com.alison.base.class7;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEFUALT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	public ButtonFrame() {
		setSize(DEFUALT_WIDTH, DEFAULT_HEIGHT);

		// create buttons
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");

		buttonPanel = new JPanel();
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);

		// add panel to frame
		add(buttonPanel);

		// create button actions
		ColorAction yellowAction = new ColorAction(Color.yellow);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);

		// associate actions with buttons
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);

	}

	private class ColorAction implements ActionListener {

		private Color baackggroundColor;

		private ColorAction(Color c) {
			baackggroundColor = c;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			buttonPanel.setBackground(baackggroundColor);
		}
	}

}
