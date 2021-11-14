/**
 * @author Chris Spartz, Ben Cohen
 */
package JDBC;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Dialogs {
	/**
	 * Method to ask the the user for the first and
	 * last name of the actor they want to add to the database
	 * @return string array containing the first and last name of the actor
	 */	
	public static String[] userDialog() {
		String result[] = new String[7];
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbSname = new JLabel("Screen Name: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbSname, cs);

		JTextField tfSname = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfSname, cs);

		JLabel lbName = new JLabel("Name: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbName, cs);

		JTextField tfName = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(tfName, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbFollowers = new JLabel("Num Followers: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		panel.add(lbFollowers, cs);

		JTextField tfFollowers = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(tfFollowers, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbFollowed = new JLabel("Num Followed: ");
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 1;
		panel.add(lbFollowed, cs);

		JTextField tfFollowed = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 3;
		cs.gridwidth = 2;
		panel.add(tfFollowed, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbCategory = new JLabel("Category: ");
		cs.gridx = 0;
		cs.gridy = 4;
		cs.gridwidth = 1;
		panel.add(lbCategory, cs);

		JTextField tfCategory = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 4;
		cs.gridwidth = 2;
		panel.add(tfCategory, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbSubCategory = new JLabel("Subcategory: ");
		cs.gridx = 0;
		cs.gridy = 5;
		cs.gridwidth = 1;
		panel.add(lbSubCategory, cs);

		JTextField tfSubCategory = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 5;
		cs.gridwidth = 2;
		panel.add(tfSubCategory, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbState = new JLabel("State: ");
		cs.gridx = 0;
		cs.gridy = 6;
		cs.gridwidth = 1;
		panel.add(lbState, cs);

		JTextField tfState = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 6;
		cs.gridwidth = 2;
		panel.add(tfState, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		String[] options = new String[] { "OK", "Cancel" };
		int ioption = JOptionPane.showOptionDialog(null, panel, "User", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (ioption == 0) // pressing OK button
		{
			result[0] = tfSname.getText();
			result[1] = tfName.getText();
			result[2] = tfFollowers.getText();
			result[3] = tfFollowed.getText();
			result[4] = tfCategory.getText();
			result[5] = tfSubCategory.getText();
			result[6] = tfState.getText();
		}
		return result;
	}
	
	public static String[] query1Dialog() {
		String result[] = new String[2];
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;


		JLabel lbNum = new JLabel("Number of Users: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbNum, cs);

		JTextField tfNum = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfNum, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbyear = new JLabel("year: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbyear, cs);

		JTextField tfyear = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(tfyear, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		String[] options = new String[] { "OK", "Cancel" };
		int ioption = JOptionPane.showOptionDialog(null, panel, "Query 1", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (ioption == 0) // pressing OK button
		{
			result[0] = tfNum.getText();
			result[1] = tfyear.getText();
		}
		return result;
	}
	
	public static String[] query2Dialog() {
		String result[] = new String[4];
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbHashtag = new JLabel("Hashtag: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbHashtag, cs);

		JTextField tfHashtag = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfHashtag, cs);

		JLabel lbNum = new JLabel("Number of Users: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbNum, cs);

		JTextField tfNum = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(tfNum, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbMonth = new JLabel("Month: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		panel.add(lbMonth, cs);

		JTextField tfMonth = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(tfMonth, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbState = new JLabel("State: ");
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 1;
		panel.add(lbState, cs);

		JTextField tfState = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 3;
		cs.gridwidth = 2;
		panel.add(tfState, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		String[] options = new String[] { "OK", "Cancel" };
		int ioption = JOptionPane.showOptionDialog(null, panel, "Query 2", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (ioption == 0) // pressing OK button
		{
			result[0] = tfHashtag.getText();
			result[1] = tfNum.getText();
			result[2] = tfMonth.getText();
			result[3] = tfState.getText();
		}
		return result;
	}
	
	public static String[] query3Dialog() {
		String result[] = new String[2];
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;


		JLabel lbNum = new JLabel("Number of Users: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbNum, cs);

		JTextField tfNum = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfNum, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbsubcategory = new JLabel("subcategory: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbsubcategory, cs);

		JTextField tfsubcategory = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(tfsubcategory, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		String[] options = new String[] { "OK", "Cancel" };
		int ioption = JOptionPane.showOptionDialog(null, panel, "Query 3", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (ioption == 0) // pressing OK button
		{
			result[0] = tfNum.getText();
			result[1] = tfsubcategory.getText();
		}
		return result;
	}
	
	public static String[] query4Dialog() {
		String result[] = new String[3];
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;


		JLabel lbNum = new JLabel("Number of Users: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbNum, cs);

		JTextField tfNum = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfNum, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbMonth = new JLabel("Month: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbMonth, cs);

		JTextField tfMonth = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(tfMonth, cs);
		panel.setBorder(new LineBorder(Color.GRAY));
		
		JLabel lbYear = new JLabel("Year: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		panel.add(lbYear, cs);

		JTextField tfYear = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(tfYear, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		String[] options = new String[] { "OK", "Cancel" };
		int ioption = JOptionPane.showOptionDialog(null, panel, "Query 4", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (ioption == 0) // pressing OK button
		{
			result[0] = tfNum.getText();
			result[1] = tfMonth.getText();
			result[2] = tfYear.getText();
		}
		return result;
	}
	
	public static String[] query5Dialog() {
		String result[] = new String[4];
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbNum = new JLabel("Number of Users: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbNum, cs);

		JTextField tfNum = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfNum, cs);

		JLabel lbSubcategory = new JLabel("Subcategory: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbSubcategory, cs);

		JTextField tfSubcategory = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(tfSubcategory, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbMonth = new JLabel("Month: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		panel.add(lbMonth, cs);

		JTextField tfMonth = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(tfMonth, cs);
		panel.setBorder(new LineBorder(Color.GRAY));
		
		JLabel lbYear = new JLabel("Year: ");
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 1;
		panel.add(lbYear, cs);

		JTextField tfYear = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 3;
		cs.gridwidth = 2;
		panel.add(tfYear, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		String[] options = new String[] { "OK", "Cancel" };
		int ioption = JOptionPane.showOptionDialog(null, panel, "Query 5", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (ioption == 0) // pressing OK button
		{
			result[0] = tfNum.getText();
			result[1] = tfSubcategory.getText();
			result[2] = tfMonth.getText();
			result[3] = tfYear.getText(); 
		}
		return result;
	}
	
	public static String[] query6Dialog() {
		String result[] = new String[4];
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbHashtag = new JLabel("Number of Hashtags: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbHashtag, cs);

		JTextField tfHashtag = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfHashtag, cs);

		JLabel lbSubcategory = new JLabel("Subcategory: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbSubcategory, cs);

		JTextField tfSubcategory = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(tfSubcategory, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		JLabel lbMonth = new JLabel("List of Months: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		panel.add(lbMonth, cs);

		JTextField tfMonth = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(tfMonth, cs);
		panel.setBorder(new LineBorder(Color.GRAY));
		
		JLabel lbYear = new JLabel("Year: ");
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 1;
		panel.add(lbYear, cs);

		JTextField tfYear = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 3;
		cs.gridwidth = 2;
		panel.add(tfYear, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		String[] options = new String[] { "OK", "Cancel" };
		int ioption = JOptionPane.showOptionDialog(null, panel, "Query 6", JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (ioption == 0) // pressing OK button
		{
			result[0] = tfHashtag.getText();
			result[1] = tfSubcategory.getText();
			result[2] = tfMonth.getText();
			result[3] = tfYear.getText();
		}
		return result;
	}

}
