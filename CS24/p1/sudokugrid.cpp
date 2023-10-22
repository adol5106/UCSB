// sudokugrid.cpp
// QINGYUN ZHANG 10/17/2014

#include "sudokugrid.h"
#include "gridio.h"
using namespace std;

// IMPLEMENT CONSTRUCTOR AND 7 MEMBER FUNCTIONS AS SPECIFIED IN "sudokugrid.h"

SudokuGrid::SudokuGrid(const int problem[9][9])
{
  
  for(int i=0;i<9;i++){
    for(int j=0;j<9;j++){
      if(problem[i][j]<0||problem[i][j]>9)
	throw GridException(DATA);
      array[i][j].number=problem[i][j];
      if(problem[i][j]!=0)
        array[i][j].fixed=true;
      else 
        array[i][j].fixed=false;
    }
  }
}
int SudokuGrid::getNumber(int row, int column) const //retrive the value from the cell
  {
    if(row<0||row>8||column<0||column>8)
      throw GridException(INDEX);
    return array[row][column].number;
  }
 
void SudokuGrid::setNumber(int number,int row, int column) //set the new number into a given cell
  {
    
    if(number<0||number>9)
      throw GridException(DATA);
    if(row<0||row>8||column<0||column>8)
      throw GridException(INDEX);
    if(array[row][column].fixed)
      throw GridException(RULE);
    array[row][column].number=number;
  }

bool SudokuGrid::occursInRow(int number,int row) const //To check that number whether or not in the given row
{
  bool exist=false;
  if(row>8||row<0)
    throw GridException(INDEX);
  for(int i=0;i<9;i++)
    { if(array[row][i].number==number)
	exist=true;
    }
  return exist;
}

bool SudokuGrid::occursInColumn(int number,int column) const //To check that number whether or not in the given column
{
  bool exist=false;
  if(column>8||column<0)
    throw GridException(INDEX);
  for(int i=0;i<9;i++)
    {if(array[i][column].number==number)
	exist=true;
    }
  return exist;
}

bool SudokuGrid::occursInBox(int number,int row,int column) const //To check that number whether or not in the box that the given cell located
{
  bool exist=false;
  if (row>8||row<0||column>8||column<0)
    throw GridException(INDEX);
  for(int i=0;i<3;i++)
    {for(int j=0;j<3;j++)
	{if(array[(row/3)*3+i][(column/3)*3+j].number==number)
            exist=true;
        }}
  return exist;
}

bool SudokuGrid::isCandidate(int number,int row,int column) const //To check the given number whether or not is candidate for that particular cell
{
  bool candid=true;
  if(row>8||row<0||column>8||column<0)
    throw GridException(INDEX);
  if(occursInRow(number,row)||occursInColumn(number,column)||occursInBox(number,row,column)||number>9||number<0)
    candid=false;
  return candid;
}

bool SudokuGrid::isSolved() const //To check the grid has or not been solved
{ 
  bool solve=true;
  for(int row=0;row<9;row++)
    {int ct[9]={};
    for(int i=0;i<9;i++)
    {for(int num=1;num<=9;num++)
	{if (array[row][i].number==num)
	    ct[num-1]++;
	}}
    for(int j=0;j<9;j++)
    {if (ct[j]!=1)
        solve=false;
    }}
  for(int column=0;column<9;column++)
    {int ct[9]={};
      for(int i=0;i<9;i++)
	{for(int num=1;num<=9;num++)
	    {if (array[i][column].number==num)
		ct[num-1]++;
            }}
      for(int j=0;j<9;j++)
	{if (ct[j]!=1)
	    solve=false;
        }}
  for(int box=0;box<3;box++)
    {int ct[9]={};
	  for(int row=0;row<3;row++)
	    {for(int column=0;column<3;column++)
		{for(int num=1;num<=9;num++)
		    {if (array[box*3+row][box*3+column].number==num)
                        ct[num-1]++;
		    }}}
	  for(int j=0;j<9;j++)
	    {if (ct[j]!=1)
		solve=false;
            }
    }
  return solve;
}  
  
