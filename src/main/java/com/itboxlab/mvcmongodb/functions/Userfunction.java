package com.itboxlab.mvcmongodb.functions;

import com.itboxlab.mvcmongodb.database.UserDAO;
import com.itboxlab.mvcmongodb.medel.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Tkaewkunha on 10/5/15 AD.
 */
public class Userfunction {

    public User registerUser(User usr){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO = ctx.getBean("userDAO",UserDAO.class);
        User newusr =  userDAO.addUser(usr);
        ctx.close();
        return  newusr;
    }

    public User checkLogin(String username,String password){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);
        User usr = userDAO.getUser(username);
        ctx.close();

        if(usr == null){
            return null;

        }
        else{
            String pwdhash = MD5(password + usr.getSalt());

            if(pwdhash.equals(usr.getPassword())){
                return usr;
            }else{
                return null;
            }
        }
    }
    public boolean removeUserByUsername(String username){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);
        int result = userDAO.deleteUser(username);
        ctx.close();
        if(result==0) {
            return false;
        }else{
            return true;
        }

    }
    public void updateUser(User usr){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);
        userDAO.updateUser(usr);
        ctx.close();
    }
    public User getUserByUsername(String username){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);
        User usr = userDAO.getUser(username);
        ctx.close();
        return usr;
    }



    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

}
