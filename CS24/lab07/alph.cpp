// alph.cpp - some recursive print functions
// QINGYUN ZHANG, TIM NINH, 11/24/2014

#include <iostream>
using namespace std;

// recursively prints letter sequence 'a'..c
void alph(char c) {
    if (islower(c)) {
        if (c > 'a')
            alph(c - 1);
        cout << c;
    }
}

// recursively prints letter sequence c..'a'
void ralph(char c) {
  if(islower(c))
    {cout<<c;
     if(c>'a')
       ralph(c-1);

    }
}

// recursively prints letter sequence c..'z'
void zalph(char c) {
  if(islower(c))
    {cout<<c;
     if(c<'z')
	zalph(c+1);
    }}

// recursively prints letter sequence 'z'..c
void zralph(char c) {
  if(islower(c))
    {if(c<'z')
	zralph(c+1);
     cout<<c; }
}

int main() {
    char letter;
    cout << "enter letter: ";
    cin >> letter;

    alph(letter);
    cout << endl;

    ralph(letter);
    cout << endl;

    zalph(letter);
    cout << endl;

    zralph(letter);
    cout << endl;
}
