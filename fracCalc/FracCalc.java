package fracCalc;

public class FracCalc {

    public static void main(String[] args) 
    {
      String s = "-1 - 1/10";
        // TODO: Read the input from the user and call produceAnswer with an equation
      System.out.println(produceAnswer(s));

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        // String s = Parser.FindLastOperand(input);
        // System.out.println("Loas operand: "+s);
        if (RunDivideZeroCheck(input))
        {
          return Parser.FindExpressions(input).toString();          
        }
        else
        {
          return "Error: Cannot divide by zero.";
        }
    }

    public static boolean RunDivideZeroCheck(String input)
    {
      for(int i = 0; i < input.length(); i++)
      {
        if (input.charAt(i) == '/')
        {
          try
          {
            if (input.charAt(i + 1) == '0')
            {
              return false;
            }
            if (input.charAt(i + 2) == '0' && input.charAt(i + 1) == ' ')
            {
              return false;
            }
          }
          catch (Exception e)
          {
            continue;
          }
        }
      }
    return true;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
