#pragma once
#include "Card.h"
#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
#include <ctime>
using namespace std;

class Deck
{
private:
	vector<Card>deck;
	int currentCard;
public:
	Deck();
	~Deck(void);
	void shuffle();
	Card dealCard();
	void clearDeck();
	void deleteCardFromDeck();
};