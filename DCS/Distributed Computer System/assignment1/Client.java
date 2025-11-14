import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class Client {
    private Client() {}
    public static void main(String[] args) {  
      try {  

        Registry registry = LocateRegistry.getRegistry(null); 

        Hello stub = (Hello) registry.lookup("Hello"); 
    
        stub.printMsg(); 

      } catch (NotBoundException | RemoteException e) {
        System.err.println("Client exception: " + e.toString()); 
      } 
   } 
    
}
