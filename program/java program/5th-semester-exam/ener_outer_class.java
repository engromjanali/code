class OuterClass {
    // Outer class member
    private int outerField;
    
    // Constructor
    public OuterClass(int outerField) {
        this.outerField = outerField;
    }
    
    // Method
    public void outerMethod() {
        System.out.println("Outer method");
    }

    // Inner class
    public class InnerClass {
        // Inner class member
        private int innerField;
        
        // Constructor
        public InnerClass(int innerField) {
            this.innerField = innerField;
        }
        
        // Method accessing outer class member
        public void innerMethod() {
            System.out.println("Inner method");
            System.out.println("Accessing outer field: " + outerField);
        }
    }
}

public class ener_outer_class {
    public static void main(String[] args) {
        OuterClass outerObject = new OuterClass(10);
        
        // Creating an instance of inner class using outer class instance
        OuterClass.InnerClass innerObject = outerObject.new InnerClass(20);
        
        innerObject.innerMethod();
    }
}
