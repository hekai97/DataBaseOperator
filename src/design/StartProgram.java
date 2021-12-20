package design;

import java.nio.channels.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import design.remoteapi.RemoteInterface;
import design.remoteapiImp.RemoteInterfaceImp;

public class StartProgram {
    public static void main(String[] args) throws java.rmi.AlreadyBoundException {
        RemoteInterfaceImp remoteInterfaceImp=new RemoteInterfaceImp();
        
        try {
            RemoteInterface remoteFunction=(RemoteInterface)UnicastRemoteObject.exportObject(remoteInterfaceImp, 1226);
            Registry registry=LocateRegistry.createRegistry(1226);
            registry.bind("executeSql", remoteFunction);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

        // RemoteInterfaceSelectImp remoteInterfaceSelectImp=new RemoteInterfaceSelectImp();
        
        // try {
        //     RemoteInterfaceSelect remoteFunction2=(RemoteInterfaceSelect)UnicastRemoteObject.exportObject(remoteInterfaceSelectImp, 1227);
        //     Registry registry2=LocateRegistry.createRegistry(1227);
        //     registry2.bind("selectSql", remoteFunction2);

        // } catch (RemoteException e) {
        //     e.printStackTrace();
        // } catch (AlreadyBoundException e) {
        //     e.printStackTrace();
        // }
    }
}
