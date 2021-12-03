package fracCalc;

public class ExpressionHandler
{
  public Number numOne;

  public Number numTwo;

  public Operation operation;

  public ExpressionHandler(Number numOne, Number numTwo, Operation operation)
  {
    this.numOne = numOne;
    this.numTwo = numTwo;
    this.operation = operation;
    System.out.println("Number 1 decimal: "+numOne.getNumber());
    System.out.println("Number 2 decimal: "+numTwo.getNumber());
  }

  public double HandleOperation()
  {
    switch (operation)
    {
      case Add:
        return numOne.getNumber() + numTwo.getNumber();
      case Subtract:
        return numOne.getNumber() - numTwo.getNumber();
      case Multiply:
        return numOne.getNumber() * numTwo.getNumber();
      case Divide:
        return numOne.getNumber()/numTwo.getNumber();
      default:
        return -1;
    }
  }

  public String toString()
  {
    if ((int)HandleOperation() == HandleOperation()) return ""+(int)HandleOperation();
    return (int)HandleOperation()+"_"+convertDecimalToFraction(HandleOperation() - (int)HandleOperation());
  }

  private static String convertDecimalToFraction(double x){
    if (x < 0){
        return convertDecimalToFraction(-x);
    }
    double tolerance = 1.0E-9;
    double h1=1; 
    double h2=0;
    double k1=0; 
    double k2=1;
    double b = x;
    do {
        double a = Math.floor(b);
        double aux = h1; 
        h1 = a*h1+h2; 
        h2 = aux;
        aux = k1; 
        k1 = a*k1+k2; 
        k2 = aux;
        b = 1/(b-a);
    } while (Math.abs(x-h1/k1) > x*tolerance);

    return (int)h1+"/"+(int)k1;
  }
}