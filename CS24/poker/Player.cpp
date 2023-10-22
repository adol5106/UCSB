#include "stdafx.h"
#include "Player.h"

#include <algorithm>
#include <functional>

Player::Player()
{
}


Player::~Player()
{
	
}

void Player::addCard(Card pCard)
{
	hand.push_back(pCard);
}

void Player::clearHand(){
	hand.clear();
}
Card Player::dealCard(int selectedCard){
	Card selected_Card = hand.at(selectedCard);
	return selected_Card;
}

void Player::deleteCard(int selectedCard){
	hand.erase(hand.begin() + selectedCard);
}
void Player::setName(string name){
	this->name=name;
}
string Player::getName(){
	return name;
}

int Player::getRank()const{
	return rank;
}


void Player::showHand()
{
	sort(hand.begin(), hand.end());

	cout << "\n"<<name<<"'s hand:\n";
	for (int card = 0; card < hand.size(); card++){
		cout << hand[card].toString() << "\n";
	}
	
	checkHand();
}


//is One Pair
int Player::isOnePair()const{
	if(hand[0].getFace()==hand[1].getFace() || hand[1].getFace()==hand[2].getFace() || hand[2].getFace()==hand[3].getFace() || hand[3].getFace()==hand[4].getFace()){
		
		return OnePair;
	}
	
	return NoPair;
}

int Player::isTwoPairs()const{
	if (hand[0].getFace() ==hand[1].getFace() && hand[2].getFace() == hand[3].getFace()){
	    return TwoPair;
	}else
	if (hand[4].getFace() ==hand[3].getFace() && hand[2].getFace() == hand[1].getFace()){
		return TwoPair;
	}
	return NoPair;
}
int Player::isThreeOfKind()const{
	if (hand[0].getFace() == hand[1].getFace() && hand[0].getFace()== hand[2].getFace()){
		return ThreeOfKind;
	}else if(hand[4].getFace() == hand[2].getFace() && hand[4].getFace() == hand[3].getFace()){
         return ThreeOfKind;
	}else if(hand[1].getFace() == hand[2].getFace() && hand[2].getFace() == hand[3].getFace()){
         return ThreeOfKind;
	}
	return NoPair;
}
int Player::isFullHouse()const{
	if(hand[0].getFace()==hand[1].getFace() &&hand[0].getFace()==hand[2].getFace() && hand[3].getFace()==hand[4].getFace()){
		return FullHouse;
	}else
	if(hand[4].getFace()==hand[2].getFace() &&hand[4].getFace()==hand[3].getFace() && hand[0].getFace()==hand[1].getFace()){
		return FullHouse;
	}
	return NoPair;
}
int Player::isFourofKind()const{
	if(hand[0].getFace()==hand[1].getFace() &&hand[0].getFace()==hand[2].getFace() && hand[0].getFace()==hand[3].getFace()){
		return FourOfKind;
	}else
	if(hand[4].getFace()==hand[1].getFace() &&hand[4].getFace()==hand[2].getFace() && hand[4].getFace()==hand[3].getFace()){
		return FourOfKind;
	}
	return NoPair;
}

int Player::isStraight()const{
	int counter=0;
	for (int c = 0; c < hand.size()-1; c++){
		if((hand[c].getFace()+1)==hand[c+1].getFace()){
			counter++;
		}
	}
	if(counter==4){
		return Straight;
	}
	return NoPair;
}
int Player::isFlush()const{
	int counter=0;
	for (int c = 0; c < hand.size(); c++){
		if(hand[0].getSuit()==hand[c].getSuit()){
			counter++;
		}
	}
	if(counter==5){
		return Flush;
	}
	return NoPair;
}

int Player::isRoyalFlush()const{	
	if(hand[0].getFace()==8 && hand[1].getFace()==9 && hand[2].getFace()==10 && hand[3].getFace()==11
	   && hand[4].getFace()==12 && isFlush()==Flush){
		return RoyalFlush;
	}
	return NoPair;
}

int Player::isStraightFlush()const{
	if(isStraight()==Straight && isFlush()==Flush){
		return StraightFlush;
	}
	return NoPair;
}	

void Player::checkHand(){
	if(isRoyalFlush()==RoyalFlush){
		cout<<name<<" has Royal Flush\n";
		rank=RoyalFlush;	
	}else
	if(isStraightFlush()==StraightFlush){
		cout<<name<<" has Straight Flush\n";
		rank=StraightFlush;
	}else
	if(isFlush()==Flush){
		cout<<name<<" has Flush\n";
		rank=Flush;
	}else
	if(isStraight()==Straight){
		cout<<name<<" has Straight\n";
		rank=Straight;
	}else
	if(isFourofKind()==FourOfKind){
		cout<<name<<" has Four of Kind\n";
		rank=FourOfKind;
	}else
	if(isFullHouse()==FullHouse){
		cout<<name<<" has Full House\n";
		rank=FullHouse;
	}else
	if(isThreeOfKind()==ThreeOfKind){
		cout<<name<<" has Three of Kind\n";
		rank=ThreeOfKind;
	}else
	if(isTwoPairs()==TwoPair){
		cout<<name<<" has Two pair\n";
		rank=TwoPair;
	}else
	if(isOnePair()==OnePair){
		cout<<name<<" has One pair\n";
		rank=OnePair;
	}else{
		cout<<name<<" no pair\n";
		rank=NoPair;
	}
}



