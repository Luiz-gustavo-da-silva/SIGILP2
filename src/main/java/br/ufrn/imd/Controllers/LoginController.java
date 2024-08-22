package br.ufrn.imd.Controllers;

import br.ufrn.imd.Dao.FileManager;

public class LoginController {

    public FileManager fm = new FileManager();
    public boolean Login(String username, String password){
       return fm.Login(username, password);
    }

    public boolean Logout(){
        return fm.Logout();
    }
}
