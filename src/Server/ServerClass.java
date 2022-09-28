/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.ClientInterface;
import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServerClass  extends UnicastRemoteObject implements ServerInterface{

    /**
     * @throws java.lang.Exception
     */
    List<User> users;
    Registry registry;
    ServerForm serverForm;
    public ServerClass(ServerForm serverForm) throws Exception{
       users =new ArrayList<>();
       registry =LocateRegistry.getRegistry(5555);
       this.serverForm=serverForm;
       
    }
     @Override
    public synchronized String SearchFile(String nameFile ,String dir) throws Exception {
        return SearchFilePath(dir,nameFile );
    }
 
    
    
    private String   SearchFilePath(String dir,String nameFile){
       
        File d=new File(dir);
        String [] c=d.list();
        if(c== null)
        {
            return "";
        }
        else
        {
            String res="";
            for (String c1 : c) {
                if (new File(dir+"\\" + c1).isDirectory()) {
                    res += SearchFilePath(dir+"\\" + c1, nameFile);
                } else {
                     if (c1.contains(nameFile)) {
                        res += dir+"\\" + c1 + "\n";
                    }
                }
            }
            return res;
        }     
    }

    @Override
    public void connect_to_server(String name, int id, String clientInterfaceName) throws Exception {
       ClientInterface  clientInterface=(ClientInterface)registry.lookup(clientInterfaceName);
        User user=new User(id,name,clientInterface);
        users.add(user);
        send_msg("SERVER", name+" joined to chat\n");
        user.clientInterface.receive_message("************** You Can Chat Now ******************\n");    
        update_users();
      
    }
    
    private void update_users() throws Exception{
       List<String> userss=users.stream().map( i -> i.toString() ).collect(Collectors.toList());
        
        serverForm.update_Users(userss);
        for(User u:users)
        {
            u.getClientInterface().update_users(userss);
        }
    }

    @Override
    public void send_msg(String name, String msg) throws Exception {
       String message="["+name+"] : "+msg+"\n";
       serverForm.update_message(message);
       for(User u:users)
        {
            u.clientInterface.receive_message(message);
        }
    }


    @Override
    public void leave_chat(int id, String name) throws Exception {
     
        for(User u:users ){
            if( u.name.equals(name) && u.id==id)
            {
                users.remove(u);
                break;
            }
        }
        update_users();
        
    }

    @Override
    public void Close_Client() throws Exception {

            for(User u:users ){
                u.getClientInterface().close_client();
        }
            Thread.sleep(5000);
    }

    
}
