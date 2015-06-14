package black.process;

public class NumberProcess {
    
    static int DOT = -1;
    static int EQUAL = 0;
    static int ADD = 1;
    
    private int command;
    
    private boolean pointFlag = false; 
    
    private double numberDoubleArray;
    private String numberString = "0";
    private String operatedNumberString;

    public void receiveInput(String input) {
        switch (input) {
        case "C":
            pointFlag = false;
            
            numberDoubleArray = 0;
            numberString = "0";
            operatedNumberString = null; 
            break;
        case ".":
            if (numberString.length() < 20 && !pointFlag) {
                numberString = numberString + input;
                pointFlag = true;
            }
            numberDoubleArray = Double.parseDouble(numberString);
            break;
        case "+":
            operatedNumberString = numberString + " +";
            numberString = "0";
            numberDoubleArray = 0;
            pointFlag = false;
            break;
        case "=":
            String x, y;
            x = operatedNumberString.substring(0, operatedNumberString.length() - 2);
            numberDoubleArray = Double.parseDouble(x) + Double.parseDouble(numberString);              
            numberString = Double.toString(numberDoubleArray);
            if(!pointFlag)
                numberString = numberString.substring(0, numberString.length() - 2);
            operatedNumberString = null;
            pointFlag = false;
            break;
        default:
            break;
        }
    }
    
    public void receiveInput(int input) {
        if (numberString.length() > 20) 
            ;
        else if (numberString.equals("0"))
            numberString = Integer.toString(input);
        else
            numberString = numberString + input;

        numberDoubleArray = Double.parseDouble(numberString);
    }

    public String getNumberString() {
        return numberString;
    }
    
    public String getOperatedNumberString() {
        return operatedNumberString;
    }
    
    public void initialNumberString() {
        numberString = "0";
    }


}
