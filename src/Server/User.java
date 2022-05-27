/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Client.ClientInterface;

/**
 *
 * @author new laptop
 */
public class User {
    
    int id;
    String name;
    ClientInterface clientInterface;

    public User(int id, String name, ClientInterface clientInterface) {
        this.id = id;
        this.name = name;
        this.clientInterface = clientInterface;
    }

    public ClientInterface getClientInterface() {
        return clientInterface;
    }

    @Override
    public String toString() {
        return id+"___"+name;
    }
    
    
    
}
