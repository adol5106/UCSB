// listQ.cpp - implements queue as linked list
// QINGYUN ZHANG,TIM NINH, 11/16/2014

#include "listQ.h"

Queue::Queue()
{size=0;
 front=rear=0;
 }  

Queue::~Queue() {
    Node *n = front;
    while (n) {
        Node *garbage = n;
        n = n->next;
        delete garbage;
    }
}

void Queue::enqueue(int n) {
  
  Node *p=new Node(n);
  if(isEmpty())
    {front=rear=p;
     size++;}
  else if(getSize()==1)
    {front->next=p;
      rear=p;
      size++;}
  else
    {rear->next=p;
     rear=rear->next;
     size++;}
}

int Queue::dequeue() {
    int gab;
    if (isEmpty())
        throw EmptyQueue();
    else{
      Node *garbage=front;
      if(getSize()==1)
	{gab=garbage->data;
         delete garbage;
         garbage=0;
	 front=rear=0;
         size=0;
        } 
      else
	{gab=garbage->data;
         front=front->next;
         delete garbage;
         garbage=0;
         size--;}
    }
    return gab;
}

void Queue::clear() {
  if (!isEmpty())
    {Node *n=front;
     Node *garbage;
      while(n->next!=0)
  	{garbage=n;
         n=n->next;
	 delete garbage;
	 garbage=0;
         }
      front=rear=0;
      size=0;
    }
}

bool Queue::isEmpty() const {
  if(front==0||rear==0||getSize()==0)
    return true; 
  else
    return false;
}

bool Queue::isFull() const {  
    return false; 
}

int Queue::getSize() const {
    
  return size;
}
