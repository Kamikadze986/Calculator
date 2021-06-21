package com.example.calculator.ui.main;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Processing {
 static public int serchMinIndex(String item,int middleIndex){
  char i=item.charAt(middleIndex);
  do{
    middleIndex--;
    if(middleIndex<=0)
     return 0;
  }while(item.charAt(middleIndex)!=' ');
  return middleIndex;
 }
 static public int serchMaxIndex(String item,int middleIndex){
  char i=item.charAt(middleIndex);
  do{
   middleIndex++;
   if (middleIndex==item.length())
    return middleIndex;
  }while(item.charAt(middleIndex)!=' ');
  return middleIndex;
 }

 static public String processingExpression (String item,int middleIndex){
  int num1 = Integer.parseInt(item.substring(0,middleIndex-1).replaceAll("\\s+",""));
  int num2 = Integer.parseInt(item.substring(middleIndex+2));
  char sign = item.charAt(middleIndex);
  switch (sign){
   case '+':
    return " "+ (num1+num2);
   case '-':
    return " "+ (num1-num2);
   case '*':
    return " "+ num1*num2;
   case '/':
    return " "+ num1/num2;
   default:
    return item;
  }
 }

}
