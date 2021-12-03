package fracCalc;
import java.lang.Math;
import java.lang.Error;

public class Number
{

  private String wholeNumberString;

  private String numeratorString;

  private String denominatorString;

  public boolean isInvalid;

  public boolean isNegative;

  public Number(String wholeNumber, String numerator, String denominator, boolean isInvalid)
  {
    this.wholeNumberString = wholeNumber;
    this.numeratorString = numerator;
    this.denominatorString = denominator;
    this.isInvalid = isInvalid;
    //||  
    if (wholeNumberString.charAt(0) == '-')
    {
      isNegative = true;
      wholeNumberString = wholeNumber.substring(1);
    }

    if (numeratorString.charAt(0)=='-')
    {
      isNegative = true;
      numeratorString = numerator.substring(1);
    }
  }
  
  public String getWholeNumberString()
  {
    return wholeNumberString;
  }

  public String getNumeratorString()
  {
    return numeratorString;
  }

  public String getDenominatorString()
  {
    return denominatorString;
  }

  public String toString()
  {
    return "whole:" + getWholeNumberString()+ " numerator:"+getNumeratorString() + " denominator:"+getDenominatorString(); 
  }

  public int parseInteger(String num)
  {
    int finalNumber = 0;
    int power = num.length() - 1;
    for(int i = 0; i < num.length(); i++)
    {
      int number = stringToNumber(num.charAt(i));

      if (number == -1)
      {
        System.out.println("WARNING: invalid input for "+num.charAt(i));
      }

      finalNumber += number * Math.pow(10, power);
      power--;
    }
    return finalNumber;
  }

  private int stringToNumber(char num)
  {
    switch(num)
    {
      case '0':
        return 0;
      case '1':
        return 1;
      case '2':
        return 2;
      case '3':
        return 3;
      case '4':
        return 4;
      case '5':
        return 5;
      case '6':
        return 6;
      case '7':
        return 7;
      case '8':
        return 8;
      case '9':
        return 9;
      default:
       isInvalid = true;
       return -1;
    }
  }

  public double getNumber()
  {
    double finalNum = 0;
    finalNum += parseInteger(getWholeNumberString());
    finalNum += (double)parseInteger(getNumeratorString())/parseInteger(getDenominatorString());
    if (isNegative) return finalNum * -1;
    return finalNum;
  }
}