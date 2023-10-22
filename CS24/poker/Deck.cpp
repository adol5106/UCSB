#include "StdAfx.h"
#include "Deck.h"
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
Deck::Deck() :currentCard(0)
{
	//add ards to deck
	for (int s = 0; s < 4; s++){
		for (int f = 0; f < 13; f++){
			{
				Card newCard(f, s);
				deck.push_back(newCard);
			}
		}
	}
}
//shuffle Deck of card
void Deck::shuffle()
{
	
	int randomCardPosition;
	for (int i = 0; i < 52; i++)
	{
		deck.push_back(deck[i]);
		randomCardPosition = rand() % 52;
		deck[i] = deck[randomCardPosition];
		deck[randomCardPosition] = deck.back();
		deck.pop_back();
	}
}
Card Deck::dealCard()
{
	currentCard++;
	return deck[currentCard];
}

void Deck::deleteCardFromDeck(){
	//deck.erase(deck.begin() + currentCard-1);
}
void Deck::clearDeck(){
	deck.clear();
}
//destructor
Deck::~Deck(void)
{
}