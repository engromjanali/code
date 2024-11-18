package basic_java;// Java Program to Illustrate Copy Constructor



// Class 2
// Main class
public class copy_constractor {

	// Main driver method
	public static void main(String[] args)
	{

		// Creating object of above class
		Complex c1 = new Complex(10, 15);

		// Following involves a copy constructor call
		Complex c2 = new Complex(c1);

	}
}


// Class 1
class Complex {

	// Class data members
	private double re, im;

	// Constructor 1
	// Parameterized constructor
	public Complex(double re, double im)
	{

		// this keyword refers to current instance itself
		this.re = re;
		this.im = im;
	}

	// Constructor 2
	// Copy constructor
	Complex(Complex x)
	{

		System.out.println("Copy constructor called");
        re = x.re;
        im = x.im;

	}

	// Overriding the toString() of Object class
	@Override public String toString()
	{

		return "(" + re + " + " + im + "i)";
	}
}