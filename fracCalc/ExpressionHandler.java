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

    if ((int)HandleOperation() != 0)
    {
      return (int)HandleOperation()+"_"+convertDecimalToFraction(HandleOperation() - (int)HandleOperation());
    }

    if (HandleOperation() - (int)HandleOperation() < 0)
    {
      return "-"+convertDecimalToFraction(HandleOperation() - (int)HandleOperation());
    }
    return convertDecimalToFraction(HandleOperation() - (int)HandleOperation());
  }

  // https://jonisalonen.com/2012/converting-decimal-numbers-to-ratios/ 
  private static String convertDecimalToFraction(double x){
    if (x < 0){
      return convertDecimalToFraction(-x);
    }
    double tolerance = 1.0E-7;
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