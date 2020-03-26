// https://leetcode.com/problems/basic-calculator-ii/
// Medium
// uncomplete. Recognize 42 as '4' and '2' <-- have to solve it

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
}
