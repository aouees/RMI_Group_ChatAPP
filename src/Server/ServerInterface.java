/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Server;

import java.rmi.Remote;

/**
 *
 * @author new laptop
 */
public interface ServerInterface extends Remote{

    /***
     * @param nameFile
     * @param dir
     * @return 
     * @throws java.lang.Exception
     */
    public String SearchFile(String nameFile, String dir) throws Exception;
    public void connect_to_server(String nameClient , int id , String clientInterfaceName ) throws Exception;
    public void send_msg(String name,String msg) throws Exception;
    public void leave_chat(int id, String name) throws Exception;
    public void Close_Client () throws Exception;
   
}
