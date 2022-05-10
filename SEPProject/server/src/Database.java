
//import org.apache.commons.dbutils.DbUtils;

import model.Client;
import model.Handyman;

import java.sql.*;

public class Database{


    private static String dataUrl = "jdbc:postgresql://abul.db.elephantsql.com:5432/kxbpghuf";
    private static String dataPassword = "yn6B1EMc4s4pB9QgbbpCzH-tNxFxTSTF";
    private static String dataUser = "kxbpghuf";

    public Database() {

    }

    /*
    public void close(ResultSet rs, Statement statement, Connection connection) {
        if (rs != null) {
            DbUtils.closeQuietly(rs);
        }
        DbUtils.closeQuietly(statement);
        DbUtils.closeQuietly(connection);
    }

     */

    //updates job status, checks every 10 minutes

    public Handyman logInHandyman(String CVR, String password)
            throws Exception {
        System.out.println("I am in Database - loginEmployer");
        Handyman tmpHandyman = new Handyman(null, null, null, null, null);
        String SQL = "SELECT * FROM client WHERE cvr=? AND password=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement("SELECT * FROM client WHERE cvr=? AND password=?");
            pstm.setString(1, CVR);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                process(rs, tmpHandyman);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }/* finally {
            close(rs, pstm, conn);
        }*/
        if (tmpHandyman.getCVR().equals("")) {
            throw new Exception("Account not found");
        } else
            return tmpHandyman;

    }

    @Override
    public Client loginClient(String CPR, String password)
            throws Exception {
        Client tmpClient = new Client(null, null, null, null, null, null, null,
                null, null, null, null);

        String SQL = "SELECT * FROM handyman WHERE cpr=? AND password=?";
        ResultSet rs = null;
        PreparedStatement pstm = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, CPR);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                process(rs, tmpClient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            close(rs, pstm, conn);
        }*/
        if (tmpClient.getCPR() == null) {
            throw new Exception("Account not found");
        } else
            return tmpClient;
    }

    public void createClientAccount(Client client,
                                      String password) throws Exception {
//        new Thread(() -> {

        String SQL =
                "INSERT INTO client(cvr,password,companyname,email,phone,address)"

                        + "VALUES(?,?,?,?,?,?)";
        PreparedStatement posted = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            posted = conn.prepareStatement(SQL);
            posted.setString(1, client.getCVR());
            posted.setString(2, password);
            posted.setString(3, client.getCompanyName());
            posted.setString(4, client.getEmail());
            posted.setString(5, client.getPhone());
            posted.setInt(6, insertAddress(client.getAddress()));
            posted.executeUpdate();

        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                throw new Exception("Account already exists!");
        }

//        }).start();
    }

    public void createHandymanAccount(Handyman handyman, String password) throws Exception {
//        new Thread(() -> {

        String SQL =
                "INSERT INTO handyman(cpr,password,firstname,lastname,taxcard,email,phone,languages,description,address,birthday,gender)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement posted = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataUrl, dataUser, dataPassword);
            posted = conn.prepareStatement(SQL);
            posted.setString(1, handyman.getCPR());
            posted.setString(2, password);
            posted.setString(3, handyman.getFirstName());
            posted.setString(4, handyman.getLastName());
            posted.setString(5, handyman.getTaxCard());
            posted.setString(6, handyman.getEmail());
            posted.setString(7, handyman.getPhone());
            posted.setString(8, handyman.getLanguages());
            posted.setString(9, handyman.getDescription());
            posted.setInt(10, insertAddress(handyman.getAddress()));
            posted.setDate(11, Date.valueOf(handyman.getBirthday()));
            posted.setString(12, handyman.getGender());
            posted.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("duplicate key value"))
                throw new Exception("Account already exists!");
        }

//        }).start();
    }



    private void process(ResultSet rs, Handyman handyman) throws SQLException {
        handyman.setCPR(rs.getString("cpr"));
        handyman.setFirstName(rs.getString("firstname"));
        handyman.setLastName(rs.getString("lastname"));
        handyman.setTaxCard(rs.getString("taxcard"));
        handyman.setEmail(rs.getString("email"));
        handyman.setPhone(rs.getString("phone"));
        handyman.setLanguages(rs.getString("languages"));
        handyman.setDescription(rs.getString("description"));
        handyman.setAddress(getAddressByID(rs.getInt("address")));
        handyman.setLicenses(getAllLicencesByCPR(rs.getString("cpr")));
        handyman.setGender(rs.getString("gender"));
        handyman.setBirthday(rs.getDate("birthday").toLocalDate());
    }



    private void process(ResultSet rs, Client client) throws SQLException {
        client.setCVR(rs.getString("cvr"));
        client.setCompanyName(rs.getString("companyname"));
        client.setEmail(rs.getString("email"));
        client.setPhone(rs.getString("phone"));
        client.setAddress(getAddressByID(rs.getInt("address")));
    }


}
