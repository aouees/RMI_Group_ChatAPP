/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author new laptop
 */
public class ClientClass extends UnicastRemoteObject implements ClientInterface{
    
    
   ClientForm clientForm;
    public ClientClass(ClientForm clientForm) throws Exception
    {
        this.clientForm=clientForm;
    }

    @Override
    public void update_users(List<String> users) throws Exception {
        clientForm.update_Users(users);
    }

    @Override
    public void receive_message(String Message) throws Exception {
        clientForm.update_message(Message);
    }

    @Override
    public void close_client() throws Exception {
        clientForm.setVisible(false);
      clientForm.dispose();
     // clientForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    }
    
    
    
}
