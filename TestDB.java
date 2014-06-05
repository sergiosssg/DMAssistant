import java.sql*;
import java.io;
import java.util;

/* Proga tests correctness of Connection with DBMS nd JDBC driver */

class TestDB {
   public static void main (tring args[]) {
      try {
         runTest();
      }
      catch (SQLException ex) {
         while (x != null) {
           ex.printStackTrace();
           ex = ex.getNextException();
         }
      }
      catch (IOException ex) {
         ex.printStackTrace();
      }
  }
  
  /*  We just create new table, then insert to it new record,
      and then select this record from table, and finally we
      drop it
  */
  public static void runTest() 
        throws SQLException, IOException\
    {
     Connection  conn  =  getConnection();
     
     try {
        Statement stmnt = conn.createStatement();
        stmnt.execute ("CREATE TABLE Greetings  (MESSAGE  CHAR(20))");
        stmnt.execute ("INSERT  INTO  Greetings  VALUES  ('Hello, world!')");
        ResultSet  result  =  stmnt.executeQuerry("SELECT  *  FROM  Greetings");
        rsult.next();
        System.out.println(result.getString(1));
        stmnt.execute ("DROP TABLE Greetings");
     }
     finally {
        conn.close();
     }
  }
  
  /**
    Establishes connection with database, using properties in file 
    database.properties
    @return Database connection
  */
  public static Connection getConnection()
         throws  SQLException,  IOException
     {
       Properties  props  =  new Properties();
       FileInputStream  in  = ne FileInputStream ("database.properties");
       props.load(in);
       in.close();
     
       String drivers  =  props.getProperty("jdbc.drivers");
       if(drivers != null)
          System.setProperty("jdbc.drivers",drivers);
       String  url  =  props.getProperty("jdbc.url");
       String  username  =  props.getProperty("jdbc.username");
       String  password  =  props.getProperty("jdbc.password");
     
       return  DriverManager.getConnection(rl, username, password);
     }
}
    
     
