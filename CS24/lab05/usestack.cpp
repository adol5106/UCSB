// usestack.cpp - for CS 24 Lab05 practice using stacks
// Timothy Hinh, QingYun Zhang, 11/10/14

#include "intstack.h"
#include <iostream>
using namespace std;

int main() {
// evaluating "9 8 10 15 + * +"

// start with an empty stack
Stack numbers;

// first three tokens all numbers to push "7 5 3":
numbers.push(9);
numbers.push(8);
numbers.push(10);
numbers.push(15);


// last token is another calculation "+":
int right = numbers.top();
numbers.pop();
int left = numbers.top();
numbers.pop();
numbers.push(left + right);

// fourth token is calculation to do "*":
right = numbers.top();
numbers.pop();
left = numbers.top();
numbers.pop();
numbers.push(left * right);

// last token is another calculation "+":
right = numbers.top();
numbers.pop();
left = numbers.top();
numbers.pop();
numbers.push(left + right);

// done - print result:
cout << numbers.top() << endl;

    return 0;
}
