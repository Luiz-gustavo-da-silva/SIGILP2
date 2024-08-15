package br.ufrn.imd.Views;

import java.util.HashMap;

public class MockedCredentials {
    HashMap<String,String> credentials = new HashMap<String, String>();

    public MockedCredentials(){
        credentials.put("Nathalia", "123");
        credentials.put("Admin", "456");
    }

    public HashMap<String, String> getCredentials(){
        return credentials;
    }
}