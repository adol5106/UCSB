#pragma once
#include<string>
using namespace std;

class Card
{
private:
	enum Suit { Diamonds, Hearts, Clubs, Spades };
	enum  Face {Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King,Ace};

	int intFace, intSuit;
	static string suit[4];
	static string face[13];
public:
	Card(int = 0, int = 0);
	string toString() const;
	char getSuit() const;
	int getFace()const;
	~Card(void);
	
};
bool operator<(const Card &Card1, const Card &Card2); 