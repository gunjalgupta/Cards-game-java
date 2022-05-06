package org.example.core;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	Deck deck;
	@Before
	public void init(){
		deck= new Deck();
	}
	@Test
	public void testDeck() throws Exception {
		assertEquals(deck.getDeck(), 52);
	}

	@Test
	public void testDealCard() throws Exception {
		int prevRemCard = deck.getDeck();
		deck.dealCard();
		int newRemCard = deck.getDeck();
		assertEquals(prevRemCard- newRemCard, 1);
	}

}
