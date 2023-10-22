// swapvals.cpp - gets two values from user, swaps them
// QINGYUN ZHANG, 10/6/2014

#include <iostream>
using namespace std;

// function prototype for you to implement below main
void swap(int &a, int &b);

// change main where instructed in UPPER CASE below
int main() {
    
    int x, y;

    // USE cout << TO PROMPT USER TO ENTER x AND y
        cout<<"Enter x AND y: ";


    // USE cin >> TO GET VALUES OF x AND y FROM USER
        cin>>x>>y;


    // do not change these cout statements or call to swap
    cout << "Before swap: x = " << x << ", y = " << y << endl;
    swap(x, y);
    cout << "After swap: x = " << x << ", y = " << y << endl;

    return 0;
}

// WRITE THE COMPLETE swap FUNCTION BELOW
void swap(int &a, int &b)
{    int hold;
        hold=a;
        a=b;
        b=hold;
}
