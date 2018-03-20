/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherclient.dal;

import sharedclasses.be.Teacher;
import sharedclasses.dal.DALException;

/**
 *
 * @author janvanzetten
 */
public class DalManager {
    DB_DAO db;

    public DalManager() {
        this.db = new DB_DAO();
    }

    /**
     * login the Teacher if it exists return object
     * @param username
     * @param encryptedPassword
     * @return
     * @throws DALException if something went wrong like that the teacher is not in the database
     */
    public Teacher login(String username, String encryptedPassword) throws DALException{
        return db.login(username, encryptedPassword);
    }
    
}
