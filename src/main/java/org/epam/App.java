package org.epam;
import java.util.Scanner;
interface addition
{
    abstract double add(double x,double y);
}
interface subtraction
{
    abstract double sub(double x,double y);
}
interface multiplication
{
    abstract double multiply(double x,double y);
}
interface division
{
    abstract double divide(double x,double y);
}
class Calculator implements addition,subtraction,multiplication,division
{
    public double add(double x, double y)
    {
        return x+y;
    }
    public double sub(double x, double y)
    {
        return x-y;
    }
    public double multiply(double x, double y)
    {
        return x*y;
    }
    public double divide(double x, double y)
    {
        return x/y;
    }
}
class MyMathException extends Exception
{
    @Override
    public String toString() {
        return "Division by zero not possible";
    }
}
public class App
{
    public static void main( String[] args )
    {
        int choice;
        double x,y,z;
        char c;
        Calculator C = new Calculator();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("* Calculator **");
            System.out.println(" 1.Add 2 Numbers");
            System.out.println(" 2.Subtract 2 Numbers");
            System.out.println(" 3.Multiply 2 Numbers");
            System.out.println(" 4.Divide 2 Numbers");
            System.out.println(" Enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the first number");
                    x = sc.nextDouble();
                    System.out.println("Enter the second number");
                    y = sc.nextDouble();
                    z = C.add(x, y);
                    System.out.println("Sum = " + z);
                    break;
                case 2:
                    System.out.println("Enter the first number");
                    x = sc.nextDouble();
                    System.out.println("Enter the second number");
                    y = sc.nextDouble();
                    z = C.sub(x, y);
                    System.out.println("Difference = " + z);
                    break;
                case 3:
                    System.out.println("Enter the first number");
                    x = sc.nextDouble();
                    System.out.println("Enter the second number");
                    y = sc.nextDouble();
                    z = C.multiply(x, y);
                    System.out.println("Product = " + z);
                    break;
                case 4:
                    try {
                        System.out.println("Enter the first number");
                        x = sc.nextDouble();
                        System.out.println("Enter the second number");
                        y = sc.nextDouble();
                        if (y == 0)
                            throw new MyMathException();
                        z = C.divide(x, y);
                        System.out.println("Sum = " + z);
                        break;
                    } catch (MyMathException mme) {
                        System.out.println(mme);
                    }
                    break;
                default:
                    System.out.println("Wrong Choice");
            }
            System.out.println("Do you want to continue");
            c = sc.next().charAt(0);
        }while (c!='n' && c!='N');
    }
}