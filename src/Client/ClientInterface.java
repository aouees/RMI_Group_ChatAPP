/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Client;

import java.rmi.Remote;
import java.util.List;

/**
 *
 * @author new laptop
 */
public interface ClientInterface extends Remote{
    
    public void update_users(List<String>users) throws Exception;
    
    public void receive_message(String Message) throws Exception;
    
    public void close_client()throws Exception;
    
}
