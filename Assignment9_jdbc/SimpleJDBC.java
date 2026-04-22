// Simple JDBC CRUD operations for Restaurant and MenuItem tables
// Make sure to add MySQL JDBC driver to your classpath
import java.sql.*;

public class SimpleJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/simplejdbc_db";
    static final String USER = "root";
    static final String PASS = "";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String serverUrl = "jdbc:mysql://localhost:3306/";
        try (Connection serverCon = DriverManager.getConnection(serverUrl, USER, PASS);
             Statement st = serverCon.createStatement()) {
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS simplejdbc_db");
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void createTables(Connection con) throws Exception {
        try (Statement st = con.createStatement()) {
            String createRestaurant = "CREATE TABLE IF NOT EXISTS Restaurant (" +
                    "Id INT PRIMARY KEY, " +
                    "Name VARCHAR(100), " +
                    "Address VARCHAR(200))";
            st.executeUpdate(createRestaurant);
            String createMenuItem = "CREATE TABLE IF NOT EXISTS MenuItem (" +
                    "Id INT PRIMARY KEY, " +
                    "Name VARCHAR(100), " +
                    "Price DOUBLE, " +
                    "ResId INT, " +
                    "FOREIGN KEY (ResId) REFERENCES Restaurant(Id))";
            st.executeUpdate(createMenuItem);
        }
    }

    public static void insertData(Connection con) throws Exception {
        String insertRestaurant = "INSERT INTO Restaurant VALUES (?, ?, ?)";
        String insertMenu = "INSERT INTO MenuItem VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps1 = con.prepareStatement(insertRestaurant);
             PreparedStatement ps2 = con.prepareStatement(insertMenu)) {

            Object[][] restaurants = {
                {1, "Spice Villa", "12 Ocean Drive"},
                {2, "Green Leaf", "34 Forest Lane"},
                {3, "Urban Bites", "56 City Center"},
                {4, "Sunset Grill", "78 Riverside"},
                {5, "Blue Lagoon", "90 Lakeview"},
                {6, "Golden Spoon", "21 Hilltop"},
                {7, "Red Chilli", "43 Market Road"},
                {8, "Olive Tree", "65 Olive Ave"},
                {9, "Curry House", "87 Spice Street"},
                {10, "Baker's Den", "109 Baker St"}
            };

            for (Object[] r : restaurants) {
                ps1.setInt(1, (Integer) r[0]);
                ps1.setString(2, (String) r[1]);
                ps1.setString(3, (String) r[2]);
                ps1.executeUpdate();
            }

            Object[][] menuItems = {
                {201, "Paneer Tikka", 180.0, 1},
                {202, "Veg Biryani", 120.0, 1},
                {203, "Caesar Salad", 90.0, 2},
                {204, "Grilled Chicken", 250.0, 4},
                {205, "Pasta Alfredo", 160.0, 3},
                {206, "Fish Fry", 220.0, 5},
                {207, "Veg Burger", 80.0, 3},
                {208, "Garlic Bread", 60.0, 10},
                {209, "Mango Lassi", 70.0, 9},
                {210, "Chocolate Cake", 150.0, 10}
            };

            for (Object[] m : menuItems) {
                ps2.setInt(1, (Integer) m[0]);
                ps2.setString(2, (String) m[1]);
                ps2.setDouble(3, (Double) m[2]);
                ps2.setInt(4, (Integer) m[3]);
                ps2.executeUpdate();
            }

            System.out.println("Inserted 10 specific records in each table.");
        }
    }

    public static void displayAllRestaurants(Connection con) throws Exception {
        String query = "SELECT * FROM Restaurant";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            System.out.println("\nAll Restaurants After Insert:");
            System.out.printf("%-5s %-20s %-30s\n", "ID", "Name", "Address");
            System.out.println("---------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-30s\n",
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("Address"));
            }
        }
    }

    public static void displayAllMenuAfterInsert(Connection con) throws Exception {
        String query = "SELECT * FROM MenuItem";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            System.out.println("\nAll Menu Items After Insert:");
            printMenu(rs);
        }
    }

    public static void selectPriceLessThan100(Connection con) throws Exception {
        String query = "SELECT * FROM MenuItem WHERE Price <= 100";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            System.out.println("\nMenu Items with Price <= 100:");
            printMenu(rs);
        }
    }

    public static void selectSpiceVillaItems(Connection con) throws Exception {
        String query = "SELECT m.* FROM MenuItem m " +
                "JOIN Restaurant r ON m.ResId = r.Id " +
                "WHERE r.Name = 'Spice Villa'";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            System.out.println("\nItems from Spice Villa:");
            printMenu(rs);
        }
    }

    public static void updatePrice(Connection con) throws Exception {
        String query = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";
        try (Statement st = con.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println("\nUpdated rows (Price <= 100 to 200): " + rows);
        }
        // Display menu items after update
        String selectQuery = "SELECT * FROM MenuItem ORDER BY Id";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(selectQuery)) {
            System.out.println("\nMenu Items After Update:");
            printMenu(rs);
        }
    }

    public static void deleteItems(Connection con) throws Exception {
        String query = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
        try (Statement st = con.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println("\nDeleted rows (Name starting with 'P'): " + rows);
        }
        String selectQuery = "SELECT * FROM MenuItem ORDER BY Id";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(selectQuery)) {
            System.out.println("\nMenu Items After Deletion:");
            printMenu(rs);
        }
    }

    public static void selectAllItems(Connection con) throws Exception {
        String query = "SELECT * FROM MenuItem";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            System.out.println("\nFinal Menu Items Data:");
            printMenu(rs);
        }
    }

    public static void printMenu(ResultSet rs) throws Exception {
        System.out.printf("%-5s %-20s %-10s %-10s\n", "ID", "Name", "Price", "ResId");
        boolean hasRows = false;
        while (rs.next()) {
            hasRows = true;
            System.out.printf("%-5d %-20s %-10.2f %-10d\n",
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getDouble("Price"),
                    rs.getInt("ResId"));
        }
        if (!hasRows) {
            System.out.println("(No records found)");
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting SimpleJDBC Application...");
        try {
            System.out.println("Connecting to MySQL database...");
            Connection con = getConnection();
            System.out.println(" Connected successfully!\n");

            System.out.println("Creating tables...");
            createTables(con);
            System.out.println();

            System.out.println("Inserting data...");
            insertData(con);
            System.out.println();

            System.out.println("Displaying all restaurants...");
            displayAllRestaurants(con);
            System.out.println();

            System.out.println("Displaying all menu items after insert...");
            displayAllMenuAfterInsert(con);
            System.out.println();

            System.out.println("Selecting items with Price <= 100...");
            selectPriceLessThan100(con);
            System.out.println();

            System.out.println("Selecting items from Spice Villa...");
            selectSpiceVillaItems(con);
            System.out.println();

            System.out.println("Updating prices (Price <= 100 to 200)...");
            updatePrice(con);
            System.out.println();

            System.out.println("Deleting items starting with 'P'...");
            deleteItems(con);
            System.out.println();

            System.out.println("FINAL TABLE DATA AFTER ALL OPERATIONS");
            selectAllItems(con);
            System.out.println("\n Program completed successfully!\n");

            con.close();

        } catch (Exception e) {
            System.err.println("ERROR: An unexpected error occurred!");
            e.printStackTrace();
        }
    }
}
