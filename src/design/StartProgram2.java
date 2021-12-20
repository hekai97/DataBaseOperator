package design;
import java.nio.channels.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import design.remoteapi.RemoteInterfaceSelect;
import design.remoteapiImp.RemoteInterfaceSelectImp;

public class StartProgram2 {
    public static void main(String[] args) throws java.rmi.AlreadyBoundException {
        RemoteInterfaceSelectImp remoteInterfaceSelectImp=new RemoteInterfaceSelectImp();
        
        try {
            RemoteInterfaceSelect remoteFunction2=(RemoteInterfaceSelect)UnicastRemoteObject.exportObject(remoteInterfaceSelectImp, 1227);
            Registry registry2=LocateRegistry.createRegistry(1227);
            registry2.bind("selectSql", remoteFunction2);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}