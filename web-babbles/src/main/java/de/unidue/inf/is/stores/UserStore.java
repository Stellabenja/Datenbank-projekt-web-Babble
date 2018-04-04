package de.unidue.inf.is.stores;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.Select;
import de.unidue.inf.is.Babble_details;
import de.unidue.inf.is.domain.Babble;
import de.unidue.inf.is.domain.Details_babbles;
import de.unidue.inf.is.domain.Likesbabble;
import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;



public final class UserStore implements Closeable {

    private Connection connection;
    private boolean complete;
public Babble_details babbleid;
 List<User> username=new ArrayList<>();
    public UserStore() throws StoreException {
        try {
            connection = DBUtil.getExternalConnection("DBP36");
            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new StoreException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


   /* public void listUsername(User usertoAdd) throws StoreException {
        try {
            PreparedStatement preparedStatement = connection
                            .prepareStatement("insert into user (firstname, lastname) values (?, ?)");
            preparedStatement.setString(1, userToAdd.getFirstname());
            preparedStatement.setString(2, userToAdd.getLastname());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }*/
   public void addlikes(){
       int babble= babbleobject(babbleid.getBabbleID()).getId();
       String user=babbleobject(babbleid.getBabbleID()).getCreator();
       Date created=babbleobject(babbleid.getBabbleID()).getCreated();

       try {
           PreparedStatement preparedStatement = connection
                   .prepareStatement("insert into likesbabble"+" (user,babble,type,created ) values (?,?,?,?)");
           preparedStatement.setString(1,user);
           preparedStatement.setInt(2,babble);
           preparedStatement.setString(3, "likes");
           preparedStatement.setString(4,String.valueOf(created));

           preparedStatement.executeUpdate();
           this.connection.commit();
       }
       catch (SQLException e) {
           throw new StoreException(e);
       }

   }
    public void dislikes(){
        int babble= babbleobject(babbleid.getBabbleID()).getId();
        String user=babbleobject(babbleid.getBabbleID()).getCreator();
        Date created=babbleobject(babbleid.getBabbleID()).getCreated();

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into likesbabble"+" (user,babble,type,created ) values (?,?,?,?)");
            preparedStatement.setString(1,user);
            preparedStatement.setInt(2,babble);
            preparedStatement.setString(3, "dislike");
            preparedStatement.setString(4,String.valueOf(created));

            preparedStatement.executeUpdate();
            this.connection.commit();
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }

    }
   public List<String> userlistquery() {
       List<String> userlist = new ArrayList<>();
       try{
           PreparedStatement preparedStatement= connection.prepareStatement("SELECT  username from dbp36.BabbleUser");
           ResultSet rs= preparedStatement.executeQuery();
           while (rs.next()){
               userlist.add(rs.getString(1));
           }
       }catch (SQLException e){ throw new StoreException(e);}

       return userlist;
   }
 public User userparameter(String username){
       User parameter =null;
       String name,photo,user,status;
     ResultSet rs;

     try{
         PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM dbp36.BabbleUser WHERE username = ?");
         preparedStatement.setString(1,username);
         rs=preparedStatement.executeQuery();
         name=rs.getString(2);
         user=rs.getString(1);
         photo=rs.getString(4);
         status=rs.getString(3);
         parameter=new User(user,name,status,photo);
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return parameter;
 }
 public Babble babbleobject(int babbleID){
     Babble babbleparameter=null;
     String text,creator;
     Date created;
     int id;
     try{
         PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM dbp36.Babble WHERE babble=?");
         preparedStatement.setInt(1,babbleID);
         ResultSet rs=preparedStatement.executeQuery();
         id=rs.getInt(1);
         text=rs.getString(2);
         created=rs.getDate(3);
         creator=rs.getString(4);
         babbleparameter=new Babble(id,text,created,creator);
     } catch (SQLException e) {
         e.printStackTrace();
     }
 return babbleparameter;
 }
 public List<Babble> babbletime (){
       List<Babble> babbleList= new ArrayList<>();
       Babble babbleparameter=null;
       String text,creator;
       Date created;
        int id;
       try{
           PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM dbp36.Babble");
           ResultSet rs=preparedStatement.executeQuery();
           id=rs.getInt(1);
           text=rs.getString(2);
           created=rs.getDate(3);
           creator=rs.getString(4);
           babbleparameter=new Babble(id,text,created,creator);
           while (rs.next()){
               babbleList.add(babbleparameter);
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }
     return babbleList;
 }
  public Details_babbles details(int babbleId){
       Details_babbles details_babbles=null;
       int likes = 0,dislike=0,rebabbles=0;
       String rebabbler;

       try{
           PreparedStatement preparedStatement=connection.prepareStatement("SELECT COUNT (type)as countlike FROM dbp36.likesbabble where types='like' AND Babble=?");
           preparedStatement.setInt(1,babbleId);
           ResultSet rs=preparedStatement.executeQuery();
           while (rs.next()){
           likes=rs.getInt(3);
           }
           PreparedStatement preparedStatement1=connection.prepareStatement("SELECT COUNT (type) FROM dbp36.likesbabble where types='dislike' AND Babble=?");
           preparedStatement1.setInt(1,babbleId);
           ResultSet rs1=preparedStatement1.executeQuery();
           while (rs1.next()){
               dislike=rs1.getInt(2);
           }
           PreparedStatement preparedStatement2=connection.prepareStatement("SELECT COUNT (babble) FROM dbp36.rebabble where Babble=?");
           preparedStatement2.setInt(1,babbleId);
           ResultSet rs2=preparedStatement2.executeQuery();
           while (rs2.next()){
               rebabbles=rs2.getInt(2);
           }
           details_babbles=new Details_babbles(likes,dislike,rebabbles);
       } catch (SQLException e) {
           e.printStackTrace();
       }



      return details_babbles;
  }
  public List<String> rebabblerquery(int babbleId){
       List<String> rebabbler=null;
      try {
          PreparedStatement preparedStatement3=connection.prepareStatement("SELECT user FROM dbp36.rebabble where Babble=?");
          preparedStatement3.setInt(1,babbleId);
          ResultSet rs3=preparedStatement3.executeQuery();
          while (rs3.next()){
              rebabbler.add(rs3.getString(1));
          }
      }catch (SQLException e) {
          e.printStackTrace();
      }
      return rebabbler;
  }

      public void complete() {
        complete = true;
    }



    @Override
    public void close() throws IOException {
        if (connection != null) {
            try {
                if (complete) {
                    connection.commit();
                }
                else {
                    connection.rollback();
                }
            }
            catch (SQLException e) {
                throw new StoreException(e);
            }
            finally {
                try {
                    connection.close();
                }
                catch (SQLException e) {
                    throw new StoreException(e);
                }
            }
        }
    }

}
