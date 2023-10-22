// params.cpp - illustrates C++ function parameter features
//              a. default argument values
//              b. difference call-by-value call-by-reference parameters
//              adapted from a Savitch C++ textbook examples
// cmc, 7/25/03

#include <iostream>
using namespace std;

// illustration a:
int volume(int, int = 1, int = 1);
// Returns the volume of a box.

// illustration b:
void change(int, int &);
// Tries to change the argument values.
// Note: first int is call-by-value parameter, and
//       second is a call-by-reference parameter.

int main() {
  cout << "Part a - same function called three ways:\n"
       << "   volume(4, 6, 2) = " << volume(4, 6, 2) << endl
       << "   volume(4, 6) = " << volume(4, 6) << endl
       << "   volume(4) = " << volume(4) << "\n\n";

  cout << "Part b - n1 is passed by value, n2 is passed by reference\n";
  int n1(1), n2(2);
  cout << "   before function: n1 = " << n1 << ", n2 = " << n2 << endl;
  change(n1, n2);
  cout << "   after function: n1 = " << n1 << ", n2 = " << n2 << endl;
}

int volume(int length, int width, int height) {
  return length * width * height;
}

void change(int param1, int &param2) {
  param1 = 111;
  param2 = 222;
  cout << "   in function: param1 = " << param1
       << ", param2 = " << param2 << endl;
}
