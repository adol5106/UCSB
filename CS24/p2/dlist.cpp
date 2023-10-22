// dlist.cpp - implements class DList
// QingYun Zhang, Timothy Hinh, 11/2/14

#include <iostream>
#include "dlist.h"


void DList::clear() {
  DLNode *current=first;
  DLNode *temp;
  while(current!=0)
    { temp=current->next;
      delete current;
      current=0;
      current=temp;
    }
  first=last=0;
  
}

int DList::getSize() const {

return size; 
}

bool DList::isEmpty() const {
  if(first==0||last==0)
    return true;
  else
    return false; 
}

string DList::get(int index) const {
  DLNode *current=first;
  if(index>getSize()-1||index<0)
    throw BadIndex();
  else{
    for(int i=1;i<index;i++){
    current=current->next;
  }
    return current->info; 
  }
}

string DList::getFirst() const {
  if(isEmpty())
    throw EmptyList();
  else
    return first->info;
}

string DList::getLast() const {
  if(isEmpty())
    throw EmptyList();
  else
    return last->info; 
}

DList DList::head(int length) const {
    DList sublist;
    DLNode *current=first;
    sublist.addFirst(current->info);
    current=current->next;
    if (size>=length)
      { for(int i=1;i<length;i++)
	  {sublist.addLast(current->info);
        current=current->next;
	  }}
    else
	  { for(int i=1;i<size;i++)
	      {sublist.addLast(current->info);
		current=current->next;
	      }

      }
        
    return sublist;
}

DList DList::tail(int length) const {
    DList sublist;
    DLNode *current=last;
    sublist.addFirst(current->info);
    current=current->prev;
    if(size>=length){
    for(int i=1;i<length;i++)
      {sublist.addFirst(current->info);
       current=current->prev;
      }}
    else
      {for(int i=1;i<size;i++)
	  {sublist.addFirst(current->info);
	    current=current->prev;
          }
      }
    return sublist;
}

void DList::insert(int index,  string obj) {
  DLNode *current=first;
  DLNode *ins=new DLNode(obj);
  if(index<0||index>getSize())
    throw BadIndex();
  else
    {if(isEmpty())
	{first=last=ins;}
    else{
    for(int i=1;i<index;i++)
      { current=current->next;
      }
    DLNode *after = current->next;
    
    current->next=ins;
    ins->next=after;
    ins->prev=current;
    size++;
    } }
}

void DList::addFirst(string obj) {
  DLNode *ins = new DLNode(obj);
  if(isEmpty())
    { first = last = ins;
      size++;}
  else
    {
  first->prev = ins;
  ins->next=first;
  ins->prev=0;
  first = ins;
  size++;
    }}

void DList::addLast(string obj){
  DLNode *ins = new DLNode(obj);
  if (isEmpty())
    {first = last = ins;
      size++;}
  else {
    last->next = ins;
    ins->prev=last;
    ins->next=0;
    last = ins;
    size++;
  }
}

string DList::remove (int index) {
  DLNode *current = first;
  string temp;
  if(index<0||index>getSize()-1)
    throw BadIndex();
  else
    for(int i=0;i<index;i++)
      current=current->next;
  temp = current->info;
  current->prev->next=current->next;
  delete current;
  current = 0;
  size--;
  return temp;
}

string DList::removeFirst () {
  string temp;
  DLNode *current = first;
  if(isEmpty())
    throw EmptyList();
  else
    {
      temp = first->info;
      first = first->next;
      delete current;
      current = 0;
      size--;
      return temp;
    }
}

string DList::removeLast() {
  string temp;
  DLNode *current = last;
  if(isEmpty())
    throw EmptyList();
  else
    { 
      temp = last->info;
      last = last->prev;
      last->next=0;
      delete current;
      current = 0;
      size--;
      return temp;
    }
}

void DList::removeAllEqual(string obj) {
  DLNode *current = first;
  DLNode *after;
  DLNode *erase;
  if(getSize()==1&&first->info==obj)
    { delete current;
     
      first=0;
      last=0;
      size--;
    }
  else{
  while(current->next!=0)
    {
      if(first->info==obj)
	{ 
          first=first->next;
          first->prev=0;
          delete current;
          current=0;
          current=first;
         }
    if(first->info!=obj && current->next->info == obj)
      {
	if(current->next->next==0)
        {erase=current->next;
	current->next=0;
        delete erase;
        erase=0;}
        else
      {
      erase = current->next;
      after=erase->next;
      delete erase;
      erase=0;
      current->next=after;
      after->prev=current;
      size--;
      }}
    else
    current=current->next;
    }
  }}

void DList::reverse() {
  DLNode *back=last;
  DLNode *forward=last;
  DLNode *stay;
  if(getSize()!=1)  
    { back=back->prev;
      forward->prev=0;
  while(back!=0)
     {
      forward->next=back;
      stay=forward;
      back->next=0;
      forward=forward->next;
      back=back->prev;
      forward->prev=stay;      
    }
  first=last;
  last=forward;
    }}

bool DList::contains(string obj) const {
  DLNode *current = first;
  if(isEmpty())
    return false;
  else{
  while(current!=0)
    {
      if(current->info == obj)
	return true;
      current=current->next;
    }
 return false;
  }}


// DO NOT CHANGE ANYTHING BELOW THIS COMMENT.
// print and rprint are already done.

void DList::print() const {
    DLNode *n = first;
    while (n) {
        std::cout << n->info;
        if (n->next)
            std::cout << ", ";
        n = n->next;
    }
}

void DList::rprint() const {
    DLNode *n = last;
    while (n) {
        std::cout << n->info;
        if (n->prev)
            std::cout << ", ";
        n = n->prev;
    }
}
