package mycodes;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.*;
//import com.mashape.unirest.http.Unirest.http.exception.UnirestExpection;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;



public class myClient
{
    public static String admin_login (String email,String pass)
    {
     String ans="";
        try {
            HttpResponse<String> res=Unirest.get("http://localhost:9000/admin_login")
                    .queryString("email", email)
                    .queryString("pass", pass)
                    .asString();
            ans=res.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(myClient.class.getName()).log(Level.SEVERE, null, ex);
        }
            return ans;
    }
    public static String add_cat(File ph,String name)
    {
        String ans="";
        try {
           
            HttpResponse<String> res = Unirest.post("http://localhost:9000/add_cat")
                    .queryString("category", name)
                    .field("photo", ph)
                    .asString();
            if(res.getStatus()==200){
            ans=res.getBody();
            return ans;
            }
            else
            {
            return "server error";
            }
        }
        catch (UnirestException ex) {
            ex.printStackTrace();
          return ex.toString();
        }
      
    }
    
    public static String fetch_cat()
    {
    try
    {
    HttpResponse<String> res=Unirest.get("http://localhost:9000/fetch_cat").asString();
    if(res.getStatus()==200)
    {
    String ans=res.getBody();
    return ans;
    }
    else
    {
    return "server error";
    }
    }
    catch(Exception ex)
    {
    ex.printStackTrace();
    return ex.toString();
    }
    }
    public static String add_courses(File ph,String name, String description, String category)
    {
        String ans="";
        try {
           
            HttpResponse<String> res = Unirest.post("http://localhost:9000/add_courses")
                    .queryString("courses", name)
                    .queryString("description", description)
                    .queryString("category", category)
                    .field("photo", ph)
                    .asString();
            if(res.getStatus()==200){
            ans=res.getBody();
            return ans;
            }
            else
            {
            return "server error";
            }
        }
        catch (UnirestException ex) {
            ex.printStackTrace();
          return ex.toString();
        }
      
    }
    public static String fetch_courses(String name)
    {
    try
    {
    HttpResponse<String> res=Unirest.get("http://localhost:9000/fetch_courses").queryString("name",name).asString();
    if(res.getStatus()==200)
    {
    String ans=res.getBody();
    return ans;
    }
    else
    {
    return "server error";
    }
    }
    catch(Exception ex)
    {
    ex.printStackTrace();
    return ex.toString();
    }
    }
    
    public static String add_lectures(File ph,String name, String description,String trailer,File vd, String selectedCategory,String selectedCourse)
    {
        String ans="";
        try {
           
            HttpResponse<String> res = Unirest.post("http://localhost:9000/add_lectures")
                    .queryString("lectures", name)
                    .queryString("description", description)
                    .queryString("courses", selectedCourse)
                    .queryString("category", selectedCategory)
                    .queryString("trailer", trailer)
                    .field("photo", ph)
                    .field("video", vd)
                    .asString();
            if(res.getStatus()==200){
            ans=res.getBody();
            return ans;
            }
            else
            {
            return "server error";
            }
        }
        catch (UnirestException ex) {
            ex.printStackTrace();
          return ex.toString();
        }
      
    }
    public static String fetch_lectures(String coursename)
    {
    try
    {
    HttpResponse<String> res=Unirest.get("http://localhost:9000/fetch_lectures").queryString("course",coursename).asString();
    if(res.getStatus()==200)
    {
    String ans=res.getBody();
    return ans;
    }
    else
    {
    return "server error";
    }
    }
    catch(Exception ex)
    {
    ex.printStackTrace();
    return ex.toString();
    }
    }
    public static String user_signup (File ph,String name,String age,String department,String contact,String email,String password)
    {
      String ans="";
        try {
           
            HttpResponse<String> res = Unirest.post("http://localhost:9000/user_signup")
                    .queryString("name", name)
                    .queryString("age", age)
                    .queryString("department", department)
                    .queryString("contact", contact)
                    .queryString("email", email)
                    .queryString("password", password)
                    .field("photo", ph)
                    .asString();
            if(res.getStatus()==200){
            ans=res.getBody();
            return ans;
            }
            else
            {
            return "server error";
            }
        }
        catch (UnirestException ex) {
            ex.printStackTrace();
          return ex.toString();
        }
      
    }
    public static String user_login(String email, String password)
    {
     {
     String ans="";
        try {
            HttpResponse<String> res=Unirest.get("http://localhost:9000/user_login")
                    .queryString("email", email)
                    .queryString("password", password)
                    .asString();
            ans=res.getBody();
        } 
        catch (UnirestException ex) {
            Logger.getLogger(myClient.class.getName()).log(Level.SEVERE, null, ex);
        }
            return ans;
    }
    }
    public static String editprofile(String name,String age,String department,File photo,String contact,String email) 
    {
        String ans="";
      try{
        HttpResponse<String> res = Unirest.post("http://localhost:9000/editprofile")
                    .queryString("name", name)
                    .queryString("age", age)
                    .queryString("dept", department)
                    .queryString("contact", contact)
                    .queryString("email",email)
                    .field("photo", photo)
                    .asString();
             ans=res.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(myClient.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ans;
    }

 public static String manage_pass(String password,String new_password,String confirm) 
    {
        String ans="";
        try {
                  HttpResponse<String> res= Unirest.post("http://localhost:9000/manage_pass")
                    .queryString("password", password)
                    .queryString("new password", new_password)
                    .queryString("confirm new password", confirm)
                    .asString();
             //ans=res.getBody();
       if (res.getStatus() == 200) {
            ans = res.getBody();
        } else {
            ans= "Error: " + res.getStatus() + " - " + res.getStatusText();
        }
    } catch (UnirestException ex) {
        Logger.getLogger(myClient.class.getName()).log(Level.SEVERE, "Error during password change request", ex);
        ans = "An error occurred while processing the request.";
    }
    return ans;
}
 
 public static String change_pass(String password,String new_password,String confirm) 
    {
        String ans="";
        try {
                    HttpResponse<String> res = Unirest.post("http://localhost:9000/change_pass")
                    .queryString("password", password)
                    .queryString("new password", new_password)
                    .queryString("confirm new password", confirm)
                    .asString();
             ans=res.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(myClient.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ans;
    }

}