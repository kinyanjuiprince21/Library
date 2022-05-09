package database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtils {
    public static ResultSet executeQuery(String sql, Object... pk) {
        ResultSet rst = null;

        try {
            PreparedStatement pst = DB.getConnection().prepareStatement(sql);

            for(int i = 0; i < pk.length; i++)
                pst.setObject(i + 1, pk[i]);

            rst = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rst;
    }

    public static int  executeUpdate(String sql, Object... parameters){
        int result = 0;

        try {
            PreparedStatement pst = DB.getConnection().prepareStatement(sql);

            for( int i = 0; i < parameters.length; i++) {
                pst.setObject(i + 1, parameters[i]);
            }

            result = pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
