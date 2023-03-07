import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RDBMS_JDBC_Swing implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6;
	JTextField t1, t2, t3, t4;
	JButton b1, b2, b3, b4, b5, b6;
	JRadioButton r1, r2;
	JScrollPane sp1;
	JTextArea ta1;
	ButtonGroup bg1;

	RDBMS_JDBC_Swing() {
		JFrame fr = new JFrame("Registration Form");
		fr.setVisible(true);
		fr.setSize(1300, 730);
		fr.setLayout(null);

		l1 = new JLabel("ID");
		l1.setBounds(150, 150, 100, 20);
		fr.add(l1);
		l2 = new JLabel("Name");
		l2.setBounds(150, 180, 100, 20);
		fr.add(l2);
		l3 = new JLabel("Gender");
		l3.setBounds(150, 210, 100, 20);
		fr.add(l3);
		l4 = new JLabel("Address");
		l4.setBounds(150, 240, 100, 20);
		fr.add(l4);
		l5 = new JLabel("Contact");
		l5.setBounds(150, 270, 100, 20);
		fr.add(l5);

		t1 = new JTextField();
		t1.setBounds(250, 150, 150, 20);
		fr.add(t1);
		t2 = new JTextField();
		t2.setBounds(250, 180, 150, 20);
		fr.add(t2);
		t3 = new JTextField();
		t3.setBounds(250, 240, 150, 20);
		fr.add(t3);
		t4 = new JTextField();
		t4.setBounds(250, 270, 150, 20);
		fr.add(t4);

		r1 = new JRadioButton("Male");
		r1.setBounds(250, 210, 70, 20);
		fr.add(r1);
		r2 = new JRadioButton("Female");
		r2.setBounds(320, 210, 100, 20);
		fr.add(r2);
		bg1 = new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);

		b1 = new JButton("Search");
		b1.setBounds(170, 320, 100, 20);
		fr.add(b1);
		b2 = new JButton("Register");
		b2.setBounds(280, 320, 100, 20);
		fr.add(b2);
		b3 = new JButton("Delete");
		b3.setBounds(170, 350, 100, 20);
		fr.add(b3);
		b4 = new JButton("Update");
		b4.setBounds(280, 350, 100, 20);
		fr.add(b4);
		b5 = new JButton("Reset");
		b5.setBounds(225, 380, 100, 20);
		fr.add(b5);
		b6 = new JButton("Refresh Table");
		b6.setBounds(600, 460, 200, 20);
		fr.add(b6);

		ta1 = new JTextArea(50, 50);
		sp1 = new JScrollPane(ta1);
		sp1.setBounds(500, 150, 400, 300);
		fr.add(sp1);
		sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
	}

	public static void main(String[] args) {
		new RDBMS_JDBC_Swing();
	}

	public static Connection createconnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rdbms_jdbc", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			System.err.println("Search Button Clicked.");
			int ID = Integer.parseInt(t1.getText());

			try {
				Connection connection = RDBMS_JDBC_Swing.createconnection();
				String sql = "select * from registration_form where ID=?";
				PreparedStatement pst = connection.prepareStatement(sql);

				pst.setInt(1, ID);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					t1.setText(String.valueOf(rs.getInt("ID")));
					t2.setText(rs.getString("Name"));
					t3.setText(rs.getString("Address"));
					t4.setText(String.valueOf(rs.getLong("Contact")));
				} else {
					System.out.println("Data Not Found.");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		else if (e.getSource() == b2) {
			System.out.println("Register Button Clicked.");
			int ID = Integer.parseInt(t1.getText());
			String Name = t2.getText();
			String Gender;
			if (r1.isSelected()) {
				Gender = "Male";
			} else {
				Gender = "Female";
			}
			String Address = t3.getText();
			long Contact = Long.parseLong(t4.getText());

			try {
				Connection connection = RDBMS_JDBC_Swing.createconnection();
				String sql = "insert into registration_form (ID,Name,Gender,Address,Contact) values (?,?,?,?,?)";
				PreparedStatement pst = connection.prepareStatement(sql);

				pst.setInt(1, ID);
				pst.setString(2, Name);
				pst.setString(3, Gender);
				pst.setString(4, Address);
				pst.setLong(5, Contact);
				pst.executeUpdate();

				System.out.println("Registered Succesfully.");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		else if (e.getSource() == b3) {
			System.out.println("Delete Button Clicked.");
			int ID = Integer.parseInt(t1.getText());

			try {
				Connection connection = RDBMS_JDBC_Swing.createconnection();
				String sql = "delete from registration_form where id = ?";
				PreparedStatement pst = connection.prepareStatement(sql);

				pst.setInt(1, ID);
				pst.executeUpdate();

				System.out.println("Data Deleted Succesfully.");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		else if (e.getSource() == b4) {
			System.out.println("Update Button Clickled.");
			int ID = Integer.parseInt(t1.getText());
			String Name = t2.getText();
			String Gender;
			if (r1.isSelected()) {
				Gender = "Male";
			} else {
				Gender = "Female";
			}
			String Address = t3.getText();
			long Contact = Long.parseLong(t4.getText());

			try {
				Connection connection = RDBMS_JDBC_Swing.createconnection();
				String sql = "update registration_form set Name=?, Gender=?, Address=?,Contact=? where ID=?";
				PreparedStatement pst = connection.prepareStatement(sql);

				pst.setString(1, Name);
				pst.setString(2, Gender);
				pst.setString(3, Address);
				pst.setLong(4, Contact);
				pst.setInt(5, ID);

				System.out.println("Data Updated Succesfully.");
				t1.setText("");
				t1.setText("");
				t1.setText("");
				t1.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		else if (e.getSource() == b5) {
			System.out.println("Reset Button Clicked.");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
		}

		else if (e.getSource() == b6) {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
