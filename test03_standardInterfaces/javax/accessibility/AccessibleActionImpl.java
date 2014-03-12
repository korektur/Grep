package javax.accessibility;
public class AccessibleActionImpl implements javax.accessibility.AccessibleAction {

    @Override
    public boolean doAccessibleAction(int arg0){
        return true;
    }

    @Override
    public int getAccessibleActionCount(){
        return 1;
    }

    @Override
    public java.lang.String getAccessibleActionDescription(int arg0){
        return null;
    }
}