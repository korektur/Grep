package javax.naming.ldap;
public class LdapReferralExceptionImpl extends javax.naming.ldap.LdapReferralException {

    @Override
    public javax.naming.Context getReferralContext(java.util.Hashtable arg0) throws javax.naming.NamingException{
        return null;
    }

    @Override
    public javax.naming.Context getReferralContext(java.util.Hashtable arg0, javax.naming.ldap.Control[] arg1) throws javax.naming.NamingException{
        return null;
    }

    @Override
    public javax.naming.Context getReferralContext() throws javax.naming.NamingException{
        return null;
    }

    @Override
    public java.lang.Object getReferralInfo(){
        return null;
    }

    @Override
    public void retryReferral(){
        return ;
    }

    @Override
    public boolean skipReferral(){
        return true;
    }
}