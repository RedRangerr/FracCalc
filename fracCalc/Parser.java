package fracCalc;
import java.util.*;

public class Parser
{
  private static String operands = "+-*/";

  public static String FindLastOperand(String expression)
  {
    return expression.substring(expression.indexOf(" ")+3, expression.length());
    // return expression.substring(0, expression.indexOf(" ")); first operand
  }

  public static ExpressionHandler FindExpressions(String expression)
  {

    for (int i = 0; i < expression.length(); i++)
    {
      if (expression.charAt(i) == '+')
      {
        Number numOne = ParseMixedNum(expression.substring(0, i-1));
        Number numTwo = ParseMixedNum(expression.substring(i+2, expression.length()));
        System.out.println("Num 1 string: "+numOne);
        System.out.println("Num 2 string: "+numTwo);
        return new ExpressionHandler(numOne, numTwo, Operation.Add);
      }

      if (expression.charAt(i) == '-')
      {
        if (i==0 ||!(expression.charAt(i-1) == ' ' && expression.charAt(i+1) == ' '))
        {
          continue;
        } 
        Number numOne = ParseMixedNum(expression.substring(0, i-1));
        Number numTwo = ParseMixedNum(expression.substring(i+2, expression.length()));
        return new ExpressionHandler(numOne, numTwo, Operation.Subtract);
      }

      if (expression.charAt(i) == '*')
      {
        Number numOne = ParseMixedNum(expression.substring(0, i-1));
        Number numTwo = ParseMixedNum(expression.substring(i+2, expression.length()));
        return new ExpressionHandler(numOne, numTwo, Operation.Multiply);
      }

      if (expression.charAt(i) == '/')
      {
        if (!(expression.charAt(i-1) == ' ' && expression.charAt(i+1) == ' '))
        {
          continue;
        } 
        Number numOne = ParseMixedNum(expression.substring(0, i-1));
        Number numTwo = ParseMixedNum(expression.substring(i+2, expression.length()));
        return new ExpressionHandler(numOne, numTwo, Operation.Divide);
      }
    }

    return new ExpressionHandler(new Number("","","",true), new Number("","","",true), Operation.None);
  }

  public static Number ParseMixedNum(String number)
  {
    if (number.indexOf("_") == -1)
    {
      if (number.indexOf("/") == -1)
      {
        return new Number(number, "0", "1", false);
      }
      else
      {
        return new Number("0", number.substring(0, number.indexOf("/")), number.substring(number.indexOf("/")+1), false);
      }
    }
    return new Number(number.substring(0, number.indexOf("_")), number.substring(number.indexOf("_")+1, number.indexOf("/")), number.substring(number.indexOf("/")+1), false);
  }


  public static double ParseNumber(String number)
  {
    if (number.indexOf("_") == -1)
    {
      if (number.indexOf("/") == -1)
      {
        return new Number(number, "0", "1", false).getNumber();
      }
      else
      {  
        return new Number("0", number.substring(0, number.indexOf("/")), number.substring(number.indexOf("/")+1), false).getNumber();
      }
    }
    
    return new Number(number.substring(0, number.indexOf("_")), number.substring(number.indexOf("_")+1, number.indexOf("/")), number.substring(number.indexOf("/")+1), false).getNumber();
  }
}