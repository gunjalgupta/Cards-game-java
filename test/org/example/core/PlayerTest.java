package org.example.core;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class PlayerTest {
	Player player;
	@Before
	public void init(){
		player= new Player();
	}
	

	@Test
	public void testAddHand() throws Exception {
		List<Card> hand= player.getHand();
		Card c= new Card(1,Suite.CLUBS);
		int prevHandSize = player.getHandsize();
		player.addHand(c);
		int newHandSize = player.getHandsize();
		assertEquals(newHandSize- prevHandSize, 1);
	}

	@Test
	public void testGetHandsize() throws Exception {
		List<Card> hand= player.getHand();
		Card c= new Card(1,Suite.CLUBS);
		player.addHand(c);
		int handSize = player.getHandsize();
		// int newHandSize = player.getHandsize(hand);
		assertEquals(handSize, 1);
	}

}
