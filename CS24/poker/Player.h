#pragma once
#include <iostream>
#include <vector>
#include <string>
#include "card.h"
using namespace std;
class Player
{
private:
	enum  Face {NoPair, OnePair,TwoPair, ThreeOfKind, Straight, Flush,FullHouse, FourOfKind, StraightFlush, RoyalFlush};
	vector<Card> hand;
	string name;
	int rank;
public:
	Player();
	~Player();
	void addCard(Card);
	void showHand();
	Card dealCard(int selectedCard);
	void deleteCard(int selectedCard);
	void setName(string name);
	string getName();
	vector<Card> getHand() const;
	int getRank()const;
	
	bool sortByFace();

	int isOnePair()const;
	int isTwoPairs()const;
	int isThreeOfKind()const;
	int isFullHouse()const;
	int isFourofKind()const;
	int isStraight()const;
	int isFlush()const;
	int isRoyalFlush()const;
	int isStraightFlush()const;
	void checkHand();
	void clearHand();
	
	
};

