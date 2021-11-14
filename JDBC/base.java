/**
 * @author Chris Spartz
 */
package JDBC;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class base {
	/**
	 * Inserts a new actor in to the databse
	 * 
	 * @param conn Valid database connection first_name: the first name of the actor
	 *             last_name: the last name of the actor
	 */
	private static void insertUser(Connection conn, String screen_name, String name, int numFollowers, int numFollowed,
			String category, String subcategory, String state) {

		if (conn == null || screen_name == null)
			throw new NullPointerException();
		try {

			conn.setAutoCommit(false);

			PreparedStatement inststmt = conn.prepareStatement(
					" insert into user (screen_name,name,numFollowers,numFollowing,category,subcategory,state) values(?,?,?,?,?,?,?) ");

			// first column has the new actor_id that is unique
			inststmt.setString(1, screen_name);
			// second ? has the first name
			inststmt.setString(2, name);
			// third ? has the number of followers of this account
			inststmt.setInt(3, numFollowers);
			// fourth ? has the number of accounts they follow
			inststmt.setInt(4, numFollowed);
			// fifth ? has the category
			inststmt.setString(5, category);
			// sixth ? has the subcategory
			inststmt.setString(6, subcategory);
			// seventh ? has the state
			inststmt.setString(7, state);

			int rowcount = inststmt.executeUpdate();

			System.out.println("Number of rows updated:" + rowcount);
			inststmt.close();
			// confirm that these are the changes you want to make
			conn.commit();
		} catch (SQLException e) {
		}

	}

	/**
	 * Method to delete a customer from the database given an id
	 * 
	 * @param conn:   a valid connection to the database
	 * @param custId: the id of the customer the user wants to delete
	 */
	private static void deleteUser(Connection conn, String userName) {

		if (conn == null || userName == null)
			throw new NullPointerException();
		try {

			conn.setAutoCommit(false);
			String q1 = "delete from user where screen_name=?";
			PreparedStatement prepStmt = conn.prepareStatement(q1);
			prepStmt.setString(1, userName);
			prepStmt.executeUpdate();

			// System.out.println("Rows updated: "+rows);
			conn.commit();

		} catch (SQLException e) {
		}

	}

	/**
	 * @param stmt
	 * @param sqlQuery
	 * @throws SQLException
	 */
	private static ResultSet runQuery(Statement stmt, String sqlQuery) throws SQLException {
		ResultSet rs;
		rs = stmt.executeQuery(sqlQuery);
		return rs;
	}

	public static void main(String[] args) {
		String dbServer = "jdbc:mysql://127.0.0.1:3306/group50?useSSL=false";
		String userName = "cs363";
		String password = "cs363Password";

		Connection conn;
		Statement stmt;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbServer, userName, password);
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			String sqlQuery = "";

			// Main menu for the user
			String option = "";
			String instruction = "Enter 1: Find the hashtags that appeared in the most states" + "\n"
					+ "Enter 2: Find the users that used a hashtag in a state in a given month"
					+ "\nEnter 3: Find most followed users in a party"
					+ "\nEnter 4: Find users and their most retweeted tweet"
					+ "\nEnter 5: Find user mentioned most in a party in a month"
					+ "\nEnter 6: Find most used hashtag by a sub-category in a given month" + "\nEnter 7: Add a user"
					+ "\nEnter 8: Delete a user and all their tweets" + "\nEnter 9: Exit the program";

			while (true) {
				option = JOptionPane.showInputDialog(instruction);
				if (option.equalsIgnoreCase("1")) {
					String[] res = Dialogs.query1Dialog();
					sqlQuery = "SELECT count(DISTINCT u.state) as numStates, group_concat(DISTINCT u.state) as listOfStates, h.name "
							+ "FROM tweet as t " + "JOIN user as u on t.posterName = u.screen_name "
							+ "JOIN hashtag as h on t.tid = h.tweet_id "
							+ "WHERE year(t.createdTime) = ? and u.state not in (SELECT state FROM user WHERE state='na') "
							+ "GROUP BY h.name " + "ORDER BY count(DISTINCT u.state) DESC " + "LIMIT ?;";
					PreparedStatement pStmnt = conn.prepareStatement(sqlQuery);
					pStmnt.setString(1, res[1]);
					pStmnt.setInt(2, Integer.parseInt(res[0]));
					ResultSet rs = pStmnt.executeQuery();
					String toShow = "";
					while (rs.next()) {
						toShow += "numStates: " + rs.getString("numStates");
						toShow += " listOfStates: " + rs.getString("listOfStates");
						toShow += " name: " + rs.getString("h.name") + "\n";
					}
					JOptionPane.showMessageDialog(null, toShow);
				} else if (option.equalsIgnoreCase("2")) {
					String[] res = Dialogs.query2Dialog();
					sqlQuery = " SELECT count(h.tweet_id) as tweetCount, u.screen_name, u.category "
							+ "FROM hashtag as h " + "JOIN tweet as t on h.tweet_id = t.tid "
							+ "JOIN user as u on t.posterName = u.screen_name "
							+ "WHERE h.name = ? and u.state = ? and month(t.createdTime) = ? "
							+ "GROUP BY u.screen_name " + "ORDER BY count(h.tweet_id) DESC " + "LIMIT ?;";
					PreparedStatement pStmnt = conn.prepareStatement(sqlQuery);
					pStmnt.setString(1, res[0]);
					pStmnt.setString(2, res[3]);
					pStmnt.setInt(3, Integer.parseInt(res[2]));
					pStmnt.setInt(4, Integer.parseInt(res[1]));
					ResultSet rs = pStmnt.executeQuery();
					String toShow = "";
					while (rs.next()) {
						toShow += "tweetCount: " + rs.getString("tweetCount");
						toShow += " screen_name: " + rs.getString("u.screen_name");
						toShow += " category: " + rs.getString("u.category") + "\n";
					}
					JOptionPane.showMessageDialog(null, toShow);
				} else if (option.equalsIgnoreCase("3")) {
					String[] res = Dialogs.query3Dialog();
					sqlQuery = "SELECT screen_name, subcategory, numFollowers " + "FROM user "
							+ "WHERE subcategory = ? " + "ORDER BY numFollowers DESC " + "LIMIT ?;";
					PreparedStatement pStmnt = conn.prepareStatement(sqlQuery);
					pStmnt.setString(1, res[1]);
					pStmnt.setInt(2, Integer.parseInt(res[0]));
					ResultSet rs = pStmnt.executeQuery();
					String toShow = "";
					while (rs.next()) {
						toShow += "screen_name: " + rs.getString("screen_name");
						toShow += " subcategory: " + rs.getString("subcategory");
						toShow += " numFollowers: " + rs.getString("numFollowers") + "\n";
					}
					JOptionPane.showMessageDialog(null, toShow);
				} else if (option.equalsIgnoreCase("4")) {
					String[] res = Dialogs.query4Dialog();
					sqlQuery = "SELECT u.name, u.category, t.textbody, t.retweet_count, ur.address "
							+ "FROM tweet as t " + "JOIN user as u on t.posterName = u.screen_name "
							+ "JOIN url as ur on t.tid = ur.tweet_id "
							+ "WHERE month(t.createdTime) = ? and year(t.createdTime) = ? "
							+ "ORDER BY t.retweet_count DESC " + "LIMIT ?;";
					PreparedStatement pStmnt = conn.prepareStatement(sqlQuery);
					pStmnt.setInt(1, Integer.parseInt(res[1]));
					pStmnt.setInt(3, Integer.parseInt(res[2]));
					pStmnt.setInt(4, Integer.parseInt(res[0]));
					ResultSet rs = pStmnt.executeQuery();
					String toShow = "";
					while (rs.next()) {
						toShow += "name: " + rs.getString("u.name");
						toShow += " category: " + rs.getString("u.category");
						toShow += " textbody: " + rs.getString("t.textbody");
						toShow += " retweet_count: " + rs.getString("t.retweet_count");
						toShow += " address: " + rs.getString("ur.address") + "\n";
					}
					JOptionPane.showMessageDialog(null, toShow);
				} else if (option.equalsIgnoreCase("5")) {
					ResultSet rs = null;
					String[] res = Dialogs.query5Dialog();
					sqlQuery = "SELECT m.mention_name, u2.state, group_concat(DISTINCT t.posterName) as postingUser"
							+ "    FROM tweet as t " + "    JOIN user as u on t.posterName = u.screen_name"
							+ "    JOIN mention as m on t.tid = m.tweet_id"
							+ "    JOIN user as u2 on m.mention_name = u2.screen_name"
							+ "    WHERE u.subcategory = ? and month(t.createdTime) = ? and year(t.createdTime) = ?"
							+ "    GROUP BY m.mention_name" + "    ORDER BY count(m.mention_name) DESC"
							+ "    LIMIT ?;";

					PreparedStatement pStmnt = conn.prepareStatement(sqlQuery);
					pStmnt.setString(1, res[1]);
					pStmnt.setInt(2, Integer.parseInt(res[2]));
					pStmnt.setInt(3, Integer.parseInt(res[3]));
					pStmnt.setInt(4, Integer.parseInt(res[0]));
					rs = pStmnt.executeQuery();

					String output = "";
					while (rs.next()) {
						output += "Mention: " + rs.getString("m.mention_name") + " State: " + rs.getString("u2.state")
								+ " Posting users: " + rs.getString("postingUser") + "\n";
					}
					JOptionPane.showMessageDialog(null, output);
				} else if (option.equalsIgnoreCase("6")) {
					ResultSet rs = null;
					String[] res = Dialogs.query6Dialog();
					String[] items = res[2].replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "")
							.split(",");
					sqlQuery = "SELECT h.name, count(h.tweet_id) as num_uses" + "    FROM hashtag as h"
							+ "    JOIN tweet as t on h.tweet_id = t.tid"
							+ "    JOIN user as u on t.posterName = u.screen_name" + "    WHERE u.subcategory = ? and year(t.createdTime) = ? and (";
					for (int i = 0; i < items.length; i++) {
						if (i == (items.length - 1))
							sqlQuery += "month(t.createdTime) = ?)";
						else
							sqlQuery += "month(t.createdTime) = ? or ";
					}
					sqlQuery += "    GROUP BY name" + "    ORDER BY count(h.tweet_id) DESC" + "    LIMIT ?;";
					
					PreparedStatement pStmnt = conn.prepareStatement(sqlQuery);
					pStmnt.setString(1, res[1]);
					pStmnt.setInt(2, Integer.parseInt(res[3]));
					int paramIndex = 3;
					for(int i = 0; i < items.length; i++) {
						pStmnt.setInt(paramIndex, Integer.parseInt(items[i]));
						paramIndex++;
					}
					pStmnt.setInt(paramIndex, Integer.parseInt(res[0]));
					rs = pStmnt.executeQuery();
					String output = "";
					while (rs.next()) {
						output += "Hashtag: " + rs.getString("h.name") + " Usage of Hashtag: "
								+ rs.getString("num_uses") + "\n";
					}
					JOptionPane.showMessageDialog(null, output);
				} else if (option.equalsIgnoreCase("7")) {
					// insert a new actor option
					String[] res = Dialogs.userDialog();
					insertUser(conn, res[0], res[1], Integer.parseInt(res[2]), Integer.parseInt(res[3]), res[4], res[5],
							res[6]);
				} else if (option.equalsIgnoreCase("8")) {
					// Deletes a customer and relevant rows in other tables
					String screen_name = JOptionPane.showInputDialog("Enter the users Screen name to delete:");
					String yN = JOptionPane.showInputDialog("Are you sure you want to delete the user with screen: "
							+ screen_name + "\nYes(y) or No(n):");
					if (yN.equalsIgnoreCase("y")) {
						deleteUser(conn, screen_name);
					}
				} else {
					break;
				}
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Program terminates due to errors");
			e.printStackTrace(); // for debugging
		}
	}

}
