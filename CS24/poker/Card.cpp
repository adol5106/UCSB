#include "stdafx.h"
#include "Card.h"

#include<iostream>
#include <string>
using namespace std;

string Card::suit[4] = {"Diamonds", "Hearts","Clubs", "Spades"};
string Card::face[13] = {"Two","Three","Four","Five","Six","Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King","Ace"};


Card::Card(int inFace, int inSuit) : intFace(inFace), intSuit(inSuit) {
	//cout<<inFace<<"\n";
}

string Card::toString() const
{
	string stringCard = face[intFace];
	stringCard +=" of "+suit[intSuit];
	return stringCard;
}

char Card::getSuit() const
{
	if (intSuit == Diamonds)
		return 'D';
	else if (intSuit == Hearts)
		return 'H';
	else if (intSuit == Clubs)
		return 'C';
	else if (intSuit == Spades)
		return 'S';
	else
		return 'X';
}
int Card::getFace() const{
	return intFace;
}
Card::~Card(void)
{
}

bool operator<(const Card &Card1, const Card &Card2){
	if(Card1.getFace()< Card2.getFace())
        return true;
    else
        return false;
}
