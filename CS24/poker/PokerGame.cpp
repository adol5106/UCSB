// PokerGame.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include "Player.h"
#include "Deck.h"


int main()
{
	srand(time(NULL));
	Player Players[10];
	while(true){
		Deck newDeck;
		newDeck.shuffle();	
		int totalPlayers;
		char ch=' '; 
		cout<<"Do you wish to play poker or quit (p or q)?: ";
		cin>>ch;
		if(ch=='q'){
			exit(0);
		}
		cout<<"How many players are playing?: ";
		cin>>totalPlayers;
		string name;
		for(int i=0;i<totalPlayers;i++){
			cout<<"Enter player name: ";
			cin>>name;
			Players[i].setName(name);
			//get car from deck
			for(int c=0;c<5;c++){
				Players[i].addCard(newDeck.dealCard());
				newDeck.deleteCardFromDeck();
			}
		}
		for(int i=0;i<totalPlayers;i++){
			Players[i].showHand();
		}

		//check winner
		int maxRang=Players[0].getRank();
		int indexMax=0;
		for(int i=0;i<totalPlayers;i++){
			if(Players[i].getRank()>maxRang){
				maxRang=Players[i].getRank();
				indexMax=i;
			}
		}
		cout<<"Do you wish to discard one card (y or n)?: ";
		cin>>ch;
		int card=-1;
		if(ch=='y'){
			card=rand()%5;
			for(int i=0;i<totalPlayers;i++){
				Players[i].deleteCard(card);
				Players[i].addCard(newDeck.dealCard());
				newDeck.deleteCardFromDeck();
			}
			for(int i=0;i<totalPlayers;i++){
				Players[i].showHand();
			}
		}
		
		cout<<"\n\n"<<Players[indexMax].getName()<<" is the winner!!!!!\n\n\n";
		for(int i=0;i<totalPlayers;i++){
			Players[i].clearHand();
		}
		//clear deck
		newDeck.clearDeck();
	}
	system("pause");
	return 0;
}

