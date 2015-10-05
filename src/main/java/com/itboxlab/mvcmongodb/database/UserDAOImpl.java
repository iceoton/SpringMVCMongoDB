package com.itboxlab.mvcmongodb.database;

import com.itboxlab.mvcmongodb.medel.Station;
import com.itboxlab.mvcmongodb.medel.User;
import com.mongodb.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.UUID;

/**
 * Created by Tkaewkunha on 10/5/15 AD.
 */
public class UserDAOImpl implements UserDAO {

    private MongoOperations mongoOps;
    private static final String USERS_COLLECTION = "users";

    public UserDAOImpl(MongoOperations mongoOps) {
        this.mongoOps = mongoOps;
    }

    @Override
    public User getUser(String usrname) {
        Query query = new Query(Criteria.where("username").is(usrname));
        return this.mongoOps.findOne(query, User.class, USERS_COLLECTION);
    }

    @Override
    public User addUser(User usr) {
        String salt = UUID.randomUUID().toString();
        String pwdhash = MD5(usr.getPassword() + salt);

        usr.setPassword(pwdhash);
        usr.setSalt(salt);

        this.mongoOps.insert(usr, USERS_COLLECTION);
        return usr;

    }

    @Override
    public int deleteUser(String username) {
        Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
        Query query = new Query(Criteria.where("username").is(username));
        WriteResult result = this.mongoOps.remove(query, User.class, USERS_COLLECTION);
        return result.getN();
    }

    @Override
    public void updateUser(User usr) {
        this.mongoOps.save(usr, USERS_COLLECTION);
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
