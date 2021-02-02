"# Numeral-System-Converter" 
Stage 1
  Implement a program that outputs a number in two systems: the first is decimal, and the second one is binary. This must be the same number represented in different systems; feel   free to choose any number you like.

Stage 2
  Implement a program that calculates the last digit of the given number converted to base 8. You don't need to convert the whole number, just print the last digit of the result.
 
Stage 3
  Now let's implement a simple converter. It will convert the given decimal number to the given radix. You should support three radices with prefixes:
    binary (0b);
    octal (0);
    hexadecimal (0x).
Stage 4
  In this stage, you should add support for reading the source number in the given base and converting it to another given base.
  
Stage 5
  Fractional numbers can also be converted from one base to another. Don't forget to round up the result to 5 decimal places! If there is no fractional part in the initial number,   you don't need to show the fractional part.
  
Stage 6
  In this final stage, we will make sure the program can handle errors like that. At this point, you can implement this without the try catch construction. Use the following rule   of thumb: if you can avoid exception-based logic, avoid it!
  So, the goal here is to implement error messages when the input is wrong.
