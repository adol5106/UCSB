//NAME: QINGYUN ZHANG, TIM HINH 12/2/2014

#include "evaluator.h"

#include "token.h"
#include <math.h>
#include <queue>
#include <stack>
#include <string>
#include <iostream>

using namespace std;
using std::queue;
using std::stack;

queue<Token> infixToPostfix(queue<Token> infixExpression){
void printQueue(queue<Token>);
void printStack(stack<Token>);
stack<Token> s;
queue<Token> result;
 int numcount=0;
 int opercount=0;  
while (!infixExpression.empty())
     {
     Token n=infixExpression.front();
     //cout << "token: " << n << endl;
     //cout<<"Stack:";
     //printStack(s);
     //cout<<endl;
     //cout<<"infixExpression queue:";
     //printQueue(infixExpression);
     //cout<<endl;
     //cout<<"result queue:";
     //printQueue(result);
     //cout<<endl;
     infixExpression.pop();
     if (!n.isNumber()&& n.op()==leftParen)
       s.push(n);
     else if (n.isNumber())
       {result.push(n);
	 numcount++;}
     else if (n.op()==add||n.op()==subtract||n.op()==multiply||n.op()==divide||n.op()==power){
       while(!s.empty()){
	 Token a=s.top();
         if(a.op()==leftParen)
	   {s.push(n);
	    opercount++;
	    break;
           }
         else {
	   if((n.op()==power && (a.op()==multiply ||a.op()==divide ||a.op()==add ||a.op()==subtract))||((n.op()==multiply||n.op()==divide)&&(a.op()==add||a.op()==subtract))) {
	       s.push(n);
               opercount++;
               break;
	   }   else {opercount++;
                     result.push(s.top());
	             s.pop();
             }
	 }
        } 
       if(s.empty())
	 {opercount++; 
          s.push(n);
     }
     }
   	   
     else if (n.op()==rightParen)
       { bool foundleftParen=false;
         while(!s.empty())
	   { Token b=s.top();
             if (b.op()==leftParen)
               {s.pop();
		foundleftParen=true;
		break;
               }
        
	   result.push(s.top());
	   s.pop();
       }
	 if(foundleftParen==false)
         throw string("unbalanced");
       }
     //cout<<"loop back or not"<<endl; 
      }
     //cout<<"before final stack pop"<<endl;
     while(!s.empty())
       { if(s.top().op()==leftParen)
           throw string("unbalanced");
         result.push(s.top());
         s.pop();
       }
     if(numcount!=opercount+1)
       throw string("bad expression"); 
     //cout<<"result from the conversion: ";
     //printQueue(result);
     //cout<<endl;
     return result;       
}
  
double evaluatePostfix(queue<Token> expression){
  
  stack<double> s;
  double result;

  while (!expression.empty())
    {Token p=expression.front();
      expression.pop();
    if (p.isNumber())
      s.push(p.value());
    else {
      OpType optor = p.op();
      double a = s.top();
      s.pop();
      double b = s.top();
      s.pop();
      if (optor == add)
	s.push(b+a);
      else if (optor == subtract)
	s.push(b-a);
      else if (optor == multiply)
	s.push(b*a);
      else if (optor == divide)
        if(a==0)
	  throw string("divide by zero");
        else
	  s.push(b/a);
      else if (optor == power)
	s.push(pow(b,a));
    }}
  result = s.top();
  return result;
}

/*void printStack(stack<Token> s) {
  stack<Token> temp(s); // make a copy
  while (!temp.empty()) {
    cout << temp.top();
    temp.pop();
    if (!temp.empty())
      cout << " ";
  }
  }*/
