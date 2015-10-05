package com.itboxlab.mvcmongodb.database;

import com.itboxlab.mvcmongodb.medel.User;

/**
 * Created by Tkaewkunha on 10/5/15 AD.
 */
public interface UserDAO {
    public User getUser(String usr);
    public User addUser(User usr);
    public int deleteUser(String username);
    public void updateUser(User usr);
}
