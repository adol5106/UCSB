// sudokusolver.cpp
// QINGYUN ZHANG  10/17/2014

#include <iostream>
using namespace std;

#include "sudokugrid.h"
#include "gridio.h"

// mandatory function to define below main:
void solve(SudokuGrid &);

// do not change main
int main() {
    int problem[9][9];

    if ( !getProblem(problem) ) {
        cout << "bad input grid; terminating" << endl;
        return 1;
    }

    try {
        SudokuGrid grid(problem); // object, not pointer this time

        cout << "Problem:" << endl;
        display(&grid);           // so pass address to display
        cout << endl;

        solve(grid);

        if (grid.isSolved())
            cout << "Success! Solution:" << endl;
        else
            cout << "Not successful. Best effort:" << endl;

        display(&grid);
    }

    catch(GridException e) {
        cout << "exception: " << e << endl;
    }

    return 0;
}

// attempt to solve the problem using simple logic rules
void solve(SudokuGrid &grid) {

  
  for(int s=0;s<=10;s++)  //To repeated solve the grid
    {//fill cells for which only one possible candidate exists
     for(int row=0;row<9;row++) 
    {for(int coloum=0;coloum<9;coloum++)
	{
	  if(grid.getNumber(row,coloum)==0)
	    {int count=0;//The counter to count how many candidates for that cell
	     int candid;//candidate number
            for (int number=1;number<=9;number++)
	       {if(grid.isCandidate(number,row,coloum))
                   {count++;
		     candid=number;
		     
                   }
               }
	        if(count==1)
		  grid.setNumber(candid,row,coloum);
	   }
	}
       
     
    }
     //place numbers for which only one cell is possible in a given row
     for(int row=0;row<9;row++)//Loop through all rows
  {int blank[9]={};//array to locate the blank cells
    for(int i=0;i<9;i++)
      {if(grid.getNumber(row,i)==0)
	  blank[i]=1;
      }
   
         
    for(int num=1;num<=9;num++)//Loop through numbers
       {
	    int count=0;
            int candidcolumn;
	   for(int j=0;j<9;j++)
	     {if (blank[j]==1&&grid.isCandidate(num,row,j))
		 { count++;
	           candidcolumn=j;
		 } }
           if (count==1)//if such a missing number can only fit into one cell of the row
             grid.setNumber(num,row,candidcolumn);
              
       }}

//Place numbers for which only one cell is possible in a given column
 for(int column=0;column<9;column++)//Loop through all columns
    {int blank[9]={};
      for(int i=0;i<9;i++)
	{
	  if(grid.getNumber(i,column)==0)
            blank[i]=1;
	}
      for(int num=1;num<=9;num++)//Loop through numbers
        {     int count=0;
              int candidrow;
              for(int j=0;j<9;j++)
		{if (blank[j]==1&&grid.isCandidate(num,j,column))
                  {count++;
		    candidrow=j;
                  }}
              if (count==1)//if such a missing number can only fit into one cell of the column
		grid.setNumber(num,candidrow,column);
	}}
    }}

