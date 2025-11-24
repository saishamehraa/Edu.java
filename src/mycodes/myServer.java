
package mycodes;
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.util.Properties;
import com.mashape.unirest.http.*;
import java.sql.*;
import mycodes.DBLoader;

public class myServer extends JHTTPServer 
{

    public myServer(int portno) throws IOException 
    {
        super(portno);
    }
@Override
public Response serve(String uri, String method, Properties header, Properties parms, Properties files)
{
    Response res=null;
    if(uri.equals("/admin_login"))
    {
       String email=parms.getProperty("email");
       String pass=parms.getProperty("pass");
    }
    else if(uri.equals("/add_cat"))
    {
        String name = parms.getProperty("category");

            String photo = saveFileOnServerWithRandomName(files, parms, "photo", "src/myuploads/");
            try {
                ResultSet rs = DBLoader.executeSql("select * from category where Name ='" + name + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                    return res;
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("Name", name);
                    rs.updateString("Photo", "src/myuploads/" + photo);
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                    return res;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                String error = ex.toString();
                res = new Response(HTTP_OK, "text/plain", error);
                return res;
            }
           
    }
    else if(uri.equals("/fetch_cat"))
       {
           String ans="";
           String name1=parms.getProperty("name");

          try
          {
          ResultSet rs=DBLoader.executeSql("select * from category");
          while(rs.next())
          {
          String name=rs.getString("Name");
          String photo=rs.getString("Photo");
          String row=name+"$"+photo;
          ans=ans+row+";;";
                 }
              res=new Response(HTTP_OK, "text/plain", ans);
              return res;
          }
          catch(Exception ex)
          {
          ex.printStackTrace();
          }
   
       }
     else if(uri.equals("/add_courses"))
    {
        String name = parms.getProperty("courses");
        String description = parms.getProperty("description");
        String category = parms.getProperty("category");
        String photo = saveFileOnServerWithRandomName(files, parms, "photo", "src/myuploads/");
            try {
                ResultSet rs = DBLoader.executeSql("select * from courses where Name ='" + name + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                    return res;
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("Name", name);
                    rs.updateString("Photo", "src/myuploads/" + photo);
                    rs.updateString("Description", description);
                    rs.updateString("Category", category);
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                    return res;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                String error = ex.toString();
                res = new Response(HTTP_OK, "text/plain", error);
                return res;
            }
           
    }
    else if(uri.equals("/fetch_courses"))
       {
           String ans="";
           String name1=parms.getProperty("name");
          try
          {
          ResultSet rs=DBLoader.executeSql("select * from courses where category='"+name1+"' ");
          while(rs.next())
          {
          String name=rs.getString("name");
          String photo=rs.getString("photo");
          String description=rs.getString("description");
          String category=rs.getString("category");
          String row=name+"$"+photo+"$"+description+"$"+category;
          ans=ans+row+";;";
              System.out.println(ans);
                 }
              res=new Response(HTTP_OK, "text/plain", ans);
              return res;
          }
          catch(Exception ex)
          {
          ex.printStackTrace();
          }
   
       }

 else if(uri.equals("/add_lectures"))
    {
        String name = parms.getProperty("lectures");
        String description = parms.getProperty("description");
        String category = parms.getProperty("category");
        String courses = parms.getProperty("courses");
        String trailer = parms.getProperty("trailer");
        String video = saveFileOnServerWithRandomName(files, parms, "video", "src/myuploads/");
        String photo = saveFileOnServerWithRandomName(files, parms, "photo", "src/myuploads/");
            try {
                ResultSet rs = DBLoader.executeSql("select * from lectures where Name ='" + name + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                    return res;
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("Name", name);
                    rs.updateString("Photo", "src/myuploads/" + photo);
                    rs.updateString("Trailer", trailer);
                    rs.updateString("Description", description);
                    rs.updateString("Category", category);
                    rs.updateString("Courses", courses);
                    rs.updateString("Video", "src/myuploads/" + video);
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                    return res;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                String error = ex.toString();
                res = new Response(HTTP_OK, "text/plain", error);
                return res;
            }
           
    }
    else if(uri.equals("/fetch_lectures"))
       {
           String ans="";
           String name1=parms.getProperty("course");
           String name2=parms.getProperty("cat");
          try
          {
          ResultSet rs=DBLoader.executeSql("select * from lectures where courses='"+name1+"'");
          while(rs.next())
          {
          String name=rs.getString("Name");
          String photo=rs.getString("Photo");
          String description=rs.getString("Description");
          String category=rs.getString("Category");
          String trailer=rs.getString("Trailer");
          String video=rs.getString("Video");
          String courses=rs.getString("Courses");
          String row=name+"$"+photo+"$"+description+"$"+trailer+"$"+video+"$"+category+"$"+courses;
          ans=ans+row+";;";
                 }
              res=new Response(HTTP_OK, "text/plain", ans);
              return res;
          }
          catch(Exception ex)
          {
          ex.printStackTrace();
          }
   
       }
    
        else if(uri.equals("/user_signup"))
    {
        String name = parms.getProperty("name");
        String age = parms.getProperty("age");
        String department = parms.getProperty("department");
        String contact = parms.getProperty("contact");
        String email = parms.getProperty("email");
        String password = parms.getProperty("password");
        String photo = saveFileOnServerWithRandomName(files, parms, "photo", "src/myuploads/");
            try {
                ResultSet rs = DBLoader.executeSql("select * from user where Email ='" + email + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                    return res;
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("Name", name);
                    rs.updateString("Age", age);
                    rs.updateString("Department", department);
                    rs.updateString("Photo", "src/myuploads/" + photo);
                    rs.updateString("Contact", contact);
                    rs.updateString("Email", email);
                    rs.updateString("Password", password);
   
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                    return res;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                String error = ex.toString();
                res = new Response(HTTP_OK, "text/plain", error);
                return res;
            }
           
    }
    
     else if(uri.equals("/user_login"))
       {
           String ans="";
           String email=parms.getProperty("email");
           String pass=parms.getProperty("password");
          try
          {
          ResultSet rs=DBLoader.executeSql("select * from user where email='"+email+"' and password='"+pass+"'");
          if(rs.next())
          {
       
             ans="pass"; 
//          String name=rs.getString("Name");
//          String age=rs.getString("Age"); 
//          String department=rs.getString("Department");
//          String photo=rs.getString("Photo");
//          String contact=rs.getString("Contact");
//          String email=rs.getString("Email");
//          String password=rs.getString("Password");
//          String row=name+"$"+age+"$"+department+"$"+photo+"$"+contact+"$"+email+"$"+password;
//          ans=ans+row+";;";
                 }
          else
          {
              ans="fail";
          }
              res=new Response(HTTP_OK, "text/plain", ans);
              return res;
          }
          catch(Exception ex)
          {
          ex.printStackTrace();
          }
   
       }
      else if(uri.equals("/editprofile"))
    {
        String name = parms.getProperty("name");
        String age = parms.getProperty("age");
        String department = parms.getProperty("department");
        String photo = saveFileOnServerWithRandomName(files, parms, "photo", "src/myuploads/");
        String contact = parms.getProperty("contact");
        String email = parms.getProperty("email");
        //String password = parms.getProperty("password");
            try {
                ResultSet rs = DBLoader.executeSql("select * from user where email ='" + email + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                    return res;
                } else {
                    //rs.moveToInsertRow();
                    rs.updateString("Name", name);
                    rs.updateString("Age", age);
                    rs.updateString("Department", department);
                    rs.updateString("Photo", "src/myuploads/" + photo);
                    rs.updateString("Contact", contact);
                    //rs.updateString("Email", email);
                    //rs.updateString("Password", password);
                    
   
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                    return res;
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                String error = ex.toString();
                res = new Response(HTTP_OK, "text/plain", error);
                return res;
            }
           
    }
    
    else if(uri.equals("/manage_pass"))
    {
        String password = parms.getProperty("Current Password");
        String new_password = parms.getProperty("New Password");
        String confirm = parms.getProperty("Confirm New Password");
        
            try {
                ResultSet rs = DBLoader.executeSql("select * from user where password ='" + password + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                    return res;
                } else {
                   // rs.moveToInsertRow();
                    rs.updateString("Current Password", password);
                    rs.updateString("New Password", new_password);
                    rs.updateString("Confirm New Password", confirm);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                    return res;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                String error = ex.toString();
                res = new Response(HTTP_OK, "text/plain", error);
                return res;
            }  
    }

    
      else if(uri.equals("/change_pass"))
    {
        String password = parms.getProperty("Current Password");
        String new_password = parms.getProperty("New Password");
        String confirm = parms.getProperty("Confirm New Password");
        
            try {
                ResultSet rs = DBLoader.executeSql("select * from admin where password ='" + password + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "fail");
                    return res;
                } else {
                   // rs.moveToInsertRow();
                    rs.updateString("Current Password", password);
                    rs.updateString("New Password", new_password);
                    rs.updateString("Confirm New Password", confirm);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                    return res;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                String error = ex.toString();
                res = new Response(HTTP_OK, "text/plain", error);
                return res;
            }
           
    }

     return null;
    }
}

    