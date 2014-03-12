package javax.management.remote.rmi;
public class RMIServerImplImpl extends javax.management.remote.rmi.RMIServerImpl {
    public RMIServerImplImpl(java.util.Map arg0) {
        super(arg0);
    }

    @Override
    protected java.lang.String getProtocol(){
        return null;
    }

    @Override
    protected void closeClient(javax.management.remote.rmi.RMIConnection arg0) throws java.io.IOException{
        return ;
    }

    @Override
    protected void closeServer() throws java.io.IOException{
        return ;
    }

    @Override
    protected void export() throws java.io.IOException{
        return ;
    }

    @Override
    protected javax.management.remote.rmi.RMIConnection makeClient(java.lang.String arg0, javax.security.auth.Subject arg1) throws java.io.IOException{
        return null;
    }

    @Override
    public java.rmi.Remote toStub() throws java.io.IOException{
        return null;
    }
}