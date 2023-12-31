// ranges1.cpp - version 1 of preRanges function
// this version also has and uses a range function
// Timothy Hinh, QingYun Zhang, 11/3/14

#include <iostream>
#include <cstdlib> // to parse command line argument
using namespace std;

// range - returns range of first n values in array x;
// calculated as maximum - minimum value in that part of x;
// returns 0 if n is less than 1
float range(float x[], int n) {
    if (n <= 0)
        return 0;

    // IMPLEMENT HERE AND REPLACE THIS RETURN STATEMENT
    else {
      float max = x[0];
      float min = x[0];
      for (int i=0; i < n; i++)
	{
	if (x[i]>max)
	  max = x[i];
        if (x[i]<min)
	  min = x[i];
	}
      return max-min;
    }
}

// preRanges - fills result array with pre-ranges of array x;
// pre-conditions: n is greater than 0;
//                 sizes of both x and result are at least n
// post-condition: result[i] is the range of the values from x[0]
//                 through x[i], inclusive, for i=0 to n-1
void preRanges(float x[], int n, float result[]) {
    // DO NOT CHANGE THIS FIRST VERSION OF preRanges
    for (int i=0; i<n; i++)
        result[i] = range(x, i+1);
}

// main tests the preRanges function - DO NOT CHANGE main
int main(int argc, char *argv[]) {
    // small test data set
    float a[] = {67.5, 22.1, 45.0, 8.2, 70.5, 50};
    int aSize = 6;
    float ranges[aSize];

    cout << "Results of small test:" << endl;
    preRanges(a, aSize, ranges);
    cout << "i" << "\t" << "a[i]" << "\t" << "ranges[i]" << endl;
    for (int i=0; i<aSize; i++)
        cout << i << "\t" << a[i] << "\t" << ranges[i] << endl;


    // larger test data set
    int big(20000);
    if (argc > 1)
        big = atoi(argv[1]); // atoi is from <cstdlib>
        
    float b[big], bResult[big]; // just process random garbage
    cout << endl << "Starting larger test: size = " << big << endl;
    preRanges(b, big, bResult);
    cout << "...Done: total big range = " << bResult[big-1] << endl;

    return 0;
}
