package com.sinse.wms.inbound.view;

import java.awt.Color;

import javax.swing.JPanel;

import com.sinse.wms.common.view.Page;

public class InboundStatus extends JPanel {
	public InboundStatus(Page page) {
		page.add(this);
		
		
		setBackground(Color.WHITE);
		setBounds(495, 130, 900, 800);
		setVisible(true);
	}
	
	

}
