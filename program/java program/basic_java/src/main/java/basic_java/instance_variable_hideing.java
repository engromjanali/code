package basic_java;
public class instance_variable_hideing {
    double height,width,depth; // this is instance vairable.
    instance_variable_hideing(double width,double  height,double depth){
        this.depth = depth ; // this is local variable //this use korar karon hoilo ai kan a local variable er pairoty base. tai doi pas er variable e local hesabe kaj kore. mane nejaka neja initialize kora.this use korla oita instanse variable hesabe kaj korba.
        this.height = height ;
        this.width = width;
    }
}