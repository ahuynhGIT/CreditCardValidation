public class CreditCard // every java program needs a class
{
  private long CreditCardNumber = 0; //private instance variables are initialized here
  private int month = 0;
  private int year = 0;
  private int CID = 0;
  private String name = " ";
  private String status = " ";
  private String cardtype = " ";
  
  public CreditCard(long newNumber, int newMonth, int newYear, int newCID, String newName) //5 arg constructor creates objects we can access
  {
    CreditCardNumber = newNumber;
    month = newMonth;
    year = newYear;
    CID = newCID;
    name = newName;
    typeOfCard(); //gets the type of card
    isValid(); //calls the isValid method 
  }
  
  private void isValid() //void method with no return that executes the following methods
  {
    boolean numbValidity = checkCardNum(); //checks card number validity
    boolean monthValidity = checkCardMonth(month); //checks card month validity
    boolean yearValidity = checkCardYear(year); //checks card year validity
    boolean CIDValidity = checkCardCID(CID); //checks card CID validity
    setStatus("Valid card"); //sets the status of the card as valid by default
    
    if(numbValidity == false)
    {
      setStatus("Invalid card number"); //if the number is invalid, status will be set accordingly
    }
    if(monthValidity == false)
    {
      setStatus("Invalid expiration month"); //if the month is invalid, status will be set accordingly
    }
    if(yearValidity == false)
    {
      setStatus("Invalid expiration year"); //if the year is invalid, status will be set accordingly
    }
    if(CIDValidity == false) 
    {
      setStatus("Invalid CID code"); //if the CID is invalid, status will be set accordingly
    }
  }
  
  
  private boolean checkCardNum() //method to check the validity of the card number
  {
    boolean numbValidity;
    int a = sumOfEvenPlace(); //calls the sumofEvenPlace method to sum all of the even-space digits using Luhn's methodology
    int b = sumOfOddPlace(); //calls the sumofOddPlace method to sum all of the odd-space digits
    int sum = a + b; 
    if(sum % 10 == 0)
    {
      numbValidity = true; //if the sum of the even and odd digits are diviisible 
    }
    else
    {
      numbValidity = false; //otherwise, the card number validity is set to false
    }
    return numbValidity; //returns the variable as true (valid) or false (invalid)
  }
  
  private int[] makeArray(long CreditCardNumber) //Creates an array of the credit card number so we can manipulate its data
  {                                              
    String CreditCardNumber2 = String.valueOf(CreditCardNumber); 
    int[] temp =  new int [CreditCardNumber2.length()];
    for (int i = 0; i < CreditCardNumber2.length(); i++)
    {
      temp[i] = Character.getNumericValue(CreditCardNumber2.charAt(i)); //gets the numeric value of a string and inputs them into each array element
    }
    return temp; //returns the array
  }
  
  
  private int sumOfOddPlace() //method that sums the odd place digits 
  {
    int[] CreditCardArray = makeArray(CreditCardNumber);
    int oddSum = 0;
    int numb;
    for(int i = 1; i < CreditCardArray.length; i+=2)
    {
      oddSum += CreditCardArray[i];
    }
    return oddSum;
  }
  
  private int sumOfEvenPlace() //method that sums the even place digits
  {
    int[] CreditCardArray = makeArray(CreditCardNumber);
    int evenSum = 0;
    int numb;
    for(int j = 0; j < CreditCardArray.length; j+=2)
    {
      numb = CreditCardArray[j] * 2; //doubles the digit in the array element
      if (numb > 9) {
        numb = ((numb%10) + (numb/10)); //if the result is double digit, add each digit
      }
      evenSum += numb; //if not, add normally
    }
    return evenSum; //returns the even digit sums
  }
  
  
  private boolean checkCardMonth(int month) //checks the validity of the expiration month
  {
    boolean monthValidity = true;
    if(month < 1 || month > 12)
    {
      monthValidity = false;
    }
    return monthValidity;
  }
  
  private boolean checkCardYear(int year) //checks the validity of the expiration year
  {
    boolean yearValidity = true;
    if(year < 2012 || year > 2020)
    {
      yearValidity = false;
    }
    return yearValidity;
  }
  
  
  private boolean checkCardCID(int CID) //checks the validity of the CID code
  {
    boolean CIDValidity = true;
    if(CID < 0 || CID > 9999)
    {
      CIDValidity = false;
    }
    return CIDValidity;
  }
  
  
  
  public String typeOfCard() //checks to see what type of card it is based on its starting digit
  {
    int[] array = makeArray(CreditCardNumber);
    if(array[0] == 4)
    {
      setCardType("Visa");
    }
    else if(array[0] == 5)
    {
      setCardType("Mastercard");
    }
    else if(array[0] == 6)
    {
      setCardType("Discovercard");
    }
    else if(array[0] == 3 && array[1] == 7)
    {
      setCardType("American Express");
    }
    return getCardType();
  }
  
  
  public void setCardNumber(long newNumber) //mutator methods to manipulate data since they are private
  {
    CreditCardNumber = newNumber;
    isValid();
  }
  
  public void setMonth(int newMonth) 
  {
    month = newMonth;
    isValid();
  }
  
  public void setYear(int newYear)
  {
    year = newYear;
    isValid();
  }
  
  public void setCID(int newCID)
  {
    CID = newCID;
    isValid();
  }
  
  public void setCardType(String newCardType)
  {
    cardtype = newCardType;
    isValid();
  }
  
  public void setStatus(String newStatus)
  {
    this.status = newStatus;
  }
  
  public long getCardNumber() //accessor methods to access the information since it is private
  {
    return CreditCardNumber;
  }
  
  public int getMonth()
  {
    return month;
  }
  
  public int getYear()
  {
    return year;
  }
  
  public int getCID()
  {
    return CID;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public String getCardType()
  {
    return cardtype;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String toString() //toString method to print to console
  {
    String output = "Name: " + getName() + "\nNumber: " + getCardNumber() + "\nExpiration Date: " + getMonth() + "/" + getYear() +
      "\nCID: " + getCID() + "\nType of Card: " + getCardType() + "\nStatus: " + getStatus() + "\n";
    return output; //returns the string
  }
}



