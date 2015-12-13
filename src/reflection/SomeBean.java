package reflection;

public class SomeBean {
  
   @AutoInjectable
   private SomeInterface someField;
   @AutoInjectable
   private SomeOtherInterface otherField;
   
   
   public void doSome(){
       someField.doSome();
       otherField.doSome();
   }
    
    
}
