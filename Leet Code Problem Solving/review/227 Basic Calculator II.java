// https://leetcode.com/problems/basic-calculator-ii/
// Medium
// try to make it faster

import java.util.*;

class Solution{    
    public int calculate(String s) {
        ArrayList<String> str = new ArrayList<String>();
        Stack<String> opStack = new Stack<String>();

        
        int num = 0;
            
        for(int i = 0; i < s.length(); i++){
            char strChar = s.charAt(i);
            if(strChar >= '0' && strChar <= '9'){
            	num = num*10 + (int)(strChar - '0');
            }
            else if(strChar == '+' || strChar == '-' ||
                   strChar == '/' || strChar == '*'){
                str.add(String.valueOf(num));
                num = 0;
                char op = strChar;
                
                if(opStack.empty()){
                    opStack.push(op+"");
                }
                else{
                    switch(op){
                        case '*':
                        case '/':
                            if(opStack.peek().equals("*") || opStack.peek().equals("/")){
                                str.add(opStack.pop());
                                opStack.push(op+"");
                            }
                            else{
                                opStack.push(op+"");
                            }
                            break;
                        case '+':
                        case '-':
                        		while(!opStack.empty()) {
                        			str.add(opStack.pop());
                        		}
                                opStack.push(op+"");
                            break;
                        default:
                            break;   
                    }
                }
                
            }
            
            if( i == s.length()-1)
                str.add(String.valueOf(num));
        }
        
        while(!opStack.empty()){
            str.add(opStack.pop());
        }
        
        int num1 = -1;
        int num2 = -1;
        
        
        // 3*3+2 --> 33*2+
        // 3+3+2 --> 33+2+
        // 3+3*2 --> 332*+
        Stack<Integer> numStack = new Stack<Integer>();
        
        for(int i = 0; i < str.size(); i++){
            String parsedStr = str.get(i);
            if( !parsedStr.equals("+") && !parsedStr.equals("-") &&
              !parsedStr.equals("/") && !parsedStr.equals("*")){
                numStack.push(Integer.parseInt(parsedStr));
            }
            else{

                num2 = numStack.pop();
                num1 = numStack.pop();


                char op = parsedStr.charAt(0);
                switch(op){
                    case '+':
                        num2 = num1+num2;
                        break;
                    case '-':
                        num2 = num1-num2;
                        break;
                    case '*':
                        num2 = num1*num2;
                        break;
                    case '/':
                        num2 = num1/num2;
                        break;
                    default:
                        break;
                }
                numStack.push(num2);
            }

        }
        
        if(!numStack.empty()) {
        	return numStack.pop();
        }
        return num2;
    }
}


/*
import java.util.*;

class customStack{
    int top = 0;
    int size;
    char[] array;
    
    public customStack(int size){
        this.size = size;
        array = new char[size+1];
        array[0] = 'n';
    }
    
    public char pop(){
        char res;
        if(top > 0){
            res = array[top];
            top--;
        }
        else{
            res = 'n';
        }
        return res;
    }
    
    public void push(char a){
        if(top < size){
            array[top+1] = a;
            top++;
        }
    }
    
    public char peak(){
        if(top > 0)
            return array[top];
        else
            return 'n';
    }
    
    public int getSize(){
        return this.size;
    }
}


class Solution {
    int index = 0;
    
    public char[] postfix(String s){
        String[] str_char = s.split("");
        
        
        char[] res = new char[str_char.length];
        customStack stack = new customStack(str_char.length);
                
        for(int i = 0; i < str_char.length; i++){

        	if(str_char[i].compareTo("+") != 0 && str_char[i].compareTo("-") != 0 && 
               str_char[i].compareTo("*") != 0 && str_char[i].compareTo("/") != 0 &&
               str_char[i].compareTo(" ") != 0){
                res[index] = str_char[i].charAt(0);
                index++;
            }
            else{
                switch(str_char[i].charAt(0)){
                    case '*':
                    case '/':
                    	if(stack.peak() == 'n') {
                    		stack.push(str_char[i].charAt(0));
                    	}
                    	else if(stack.peak() == '*' || stack.peak() == '/'){
                            res[index] = stack.pop();
                            index++;
                            stack.push(str_char[i].charAt(0));
                        }
                        else if(stack.peak() == '+' || stack.peak() == '-'){
                            stack.push(str_char[i].charAt(0));
                        }
                        break;
                    case '+':
                    case '-':
                    	if(stack.peak() != 'n') {
                    		res[index] = stack.pop();
                    		index++;
                        }
                        stack.push(str_char[i].charAt(0));
                        break;
                }
            }
            
        }
        while(stack.peak() != 'n') {
        	res[index] = stack.pop();
        	index++;
        }
        
        return res;
    }
    
    public int calculate(String s) {
        char[] post_eq = postfix(s);
        int num1 = -1,num2 = -1;
        customStack stack = new customStack(index);
        
        for(int i = 0; i < index; i++){
            switch(post_eq[i]){
                case '+':
                	num2 = (int)(stack.pop() - '0');
                	num1 = (int)(stack.pop() - '0');
                    stack.push((char)(num1+num2+'0'));
                    break;
                case '-':
                	num2 = (int)(stack.pop() - '0');
                	num1 = (int)(stack.pop() - '0');
                    stack.push((char)(num1-num2+'0'));
                    break;
                case '*':
                	num2 = (int)(stack.pop() - '0');
                	num1 = (int)(stack.pop() - '0');
                    stack.push((char)(num1*num2+'0'));
                    break;
                case '/':
                	num2 = (int)(stack.pop() - '0');
                	num1 = (int)(stack.pop() - '0');
                    stack.push((char)(num1/num2+'0'));
                    break;
                default:
                	stack.push(post_eq[i]);
            }
        }
        
        return (int)(stack.pop()-'0');
        
    }
*/
}
