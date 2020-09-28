package gfx;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import tools.Methods;
import javax.swing.JScrollPane;
import java.awt.Color;

public class CmdLineArguments extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JList list;
	private JScrollPane scrollPane;
	private JButton btnRemove;

	/**
	 * Launch the application.
	 */
	
	public CmdLineArguments() {
		try {
			setIconImage(ImageIO.read(getClass().getResource("/img/icon.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle("Command-line arguments");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 450, 342);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Methods.getTheme().bg);
	
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 21));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel dlm = new DefaultListModel();
				for(int i = 0;i<list.getModel().getSize();i++) {
					dlm.addElement(list.getModel().getElementAt(i));
				}
				dlm.addElement(e.getActionCommand());
				textField.setText(null);
				list.setModel(dlm);
			}
		});
		textField.setBackground(Methods.getTheme().editorBg);
		textField.setForeground(Methods.getTheme().labelFg);
		textField.setBounds(10, 180, 208, 43);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 352, 162);
		contentPanel.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Calibri", Font.PLAIN, 16));
		list.setBackground(Methods.getTheme().editorBg);
		list.setForeground(Methods.getTheme().labelFg);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(null);
		if(Methods.getCmdline() != null){
			DefaultListModel dlm = new DefaultListModel();
			for(String s : Methods.getCmdline()) {
				dlm.addElement(s);
			}
			list.setModel(dlm);
		}
		
		
		{
			
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setBackground(Methods.getTheme().buttonBg);
			btnNewButton.setForeground(Methods.getTheme().buttonTxt);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultListModel dlm = new DefaultListModel();
					for(int i = 0;i<list.getModel().getSize();i++) {
						dlm.addElement(list.getModel().getElementAt(i));
					}
					dlm.addElement(textField.getText());
					textField.setText(null);
					list.setModel(dlm);
				}
			});
			btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 25));
			btnNewButton.setBounds(10, 226, 68, 43);
			contentPanel.add(btnNewButton);
		}
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel dlm = new DefaultListModel();
				for(int i = 0;i<list.getModel().getSize();i++) {
					dlm.addElement(list.getModel().getElementAt(i));
				}
				if(list.getSelectedIndex() != -1) {
					dlm.remove(list.getSelectedIndex());
				}
				list.setModel(dlm);
				
			}
		});
		
		btnRemove.setForeground(Methods.getTheme().buttonTxt);
		btnRemove.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnRemove.setBackground(Methods.getTheme().buttonBg);
		btnRemove.setBounds(79, 226, 128, 43);
		contentPanel.add(btnRemove);
		
		JButton btnRemoveAll = new JButton("Remove All");
		btnRemoveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel dlm = new DefaultListModel();
				list.setModel(dlm);
			}
		});
		btnRemoveAll.setForeground(Methods.getTheme().buttonTxt);
		btnRemoveAll.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnRemoveAll.setBackground(Methods.getTheme().buttonBg);
		btnRemoveAll.setBounds(209, 226, 142, 43);
		contentPanel.add(btnRemoveAll);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Methods.getTheme().bg);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(Methods.getTheme().buttonBg);
				okButton.setForeground(Methods.getTheme().buttonTxt);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String[] str = new String[list.getModel().getSize()];
						for(int x = 0;x<list.getModel().getSize();x++)
						{
							str[x] = (String) list.getModel().getElementAt(x);
						}
						Methods.setCmdline(str);
						setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				cancelButton.setBackground(Methods.getTheme().buttonBg);
				cancelButton.setForeground(Methods.getTheme().buttonTxt);
				buttonPane.add(cancelButton);
			}
		}
	}
}
