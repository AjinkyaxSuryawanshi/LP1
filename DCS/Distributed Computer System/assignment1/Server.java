
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server extends ImplExample {
    public Server() {}
    public static void main(String[] args){
        try {

            ImplExample obj = new ImplExample();

            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj,0);

            Registry  registry = LocateRegistry.getRegistry();

            registry.bind("Hello",stub);

            System.err.println("Server ready");
        } catch (AlreadyBoundException | RemoteException e) {
            System.err.println("Server exception: " + e.toString()); 
        }
    }
}
