package black.process;

public class NumberLabel {

    static int DOT = -1;
    static int EQUAL = 0;
    static int ADD = 1;

    static int MAX_LENGTH = 20;

    private int numberRecordCount = 0;

    private boolean pointFlag = false;
    private boolean numberInput = false;

    private double answerRegister = 0;
    private double numberDoubleArray;
    private String numberString = "0";
    private String operatedNumberString = "";

    private String[] numberRecord = new String[10];
    private String[] symbolRecord = new String[10];

    /**
     * operater
     * 
     * @param input
     */
    public void receiveInput(String input) {
        numberInput = false;
        switch (input) {
        case "C":
            initialData();
            break;
        case ".":
            if (numberString.length() < MAX_LENGTH && !pointFlag) {
                numberString = numberString + input;
                pointFlag = true;
            }
            break;
        case "+":
        case "-":
        case "*":
            storeNumberAndSymbol(input);
            operatedNumberString = operatedNumberString
                    + numberRecord[numberRecordCount - 1] + " "
                    + symbolRecord[numberRecordCount - 1] + " ";
            if (numberRecordCount > 1) {
                numberString = calculate();
            } else
                answerRegister = Double.parseDouble(numberString);
            pointFlag = false;
            break;
        case "=":
            storeNumberAndSymbol();
            if (numberRecordCount > 1) {
                numberString = calculate();
            }
            initialData(numberString);
            break;
        default:
            break;
        }
        System.out.println(answerRegister);
    }

    private String calculate() {
        System.out.println(symbolRecord[numberRecordCount - 2]);
        switch (symbolRecord[numberRecordCount - 2]) {
        case "+":
            answerRegister = answerRegister
                    + Double.parseDouble(numberRecord[numberRecordCount - 1]);
            break;
        case "-":
            answerRegister = answerRegister
                    - Double.parseDouble(numberRecord[numberRecordCount - 1]);
            break;
        case "*":
            answerRegister = answerRegister
                    * Double.parseDouble(numberRecord[numberRecordCount - 1]);
            break;
        default:
            break;
        }
        if (pointFlag) {
            return Double.toString(answerRegister);

        } else {
            return Double.toString(answerRegister).substring(0,
                    Double.toString(answerRegister).length() - 2);
        }
    }

    private void storeNumberAndSymbol(String inputSybol) {
        numberRecord[numberRecordCount] = numberString;
        symbolRecord[numberRecordCount] = inputSybol;
        numberRecordCount++;
    }

    private void storeNumberAndSymbol() {
        numberRecord[numberRecordCount] = numberString;
        symbolRecord[numberRecordCount] = symbolRecord[numberRecordCount - 1];
        numberRecordCount++;
    }

    /**
     * pure number
     * 
     * @param input
     */
    public void receiveInput(int input) {

        if (numberString.length() > MAX_LENGTH)
            ;
        else if (!numberInput || numberString.equals("0"))
            numberString = Integer.toString(input);
        else
            numberString = numberString + input;

        numberInput = true;

    }

    public String getNumberString() {
        return numberString;
    }

    public String getOperatedNumberString() {
        return operatedNumberString;
    }

    public void initialData() {
        numberRecordCount = 0;
        answerRegister = 0;
        pointFlag = false;
        numberInput = false;
        numberString = "0";
        operatedNumberString = "";
    }

    public void initialData(String answer) {
        numberRecordCount = 0;
        answerRegister = Double.parseDouble(answer);
        pointFlag = false;
        numberInput = false;
        numberString = answer;
        operatedNumberString = "";
    }

}
