package main;

import java.util.Set;
import java.util.logging.Handler;

public class User {
    private String id;
    private boolean isCoordinator = false;

    public User(String id){
        this.id = id;
    }

    public void addToMembers(){
    }


    public void becomeCoordinator(){
        isCoordinator = true;
    }


}
