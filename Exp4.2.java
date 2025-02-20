import java.util.*;

class Card {
    String suit;
    String rank;

    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

public class CardCollectionSystem {
    private static final Set<String> cardSet = new HashSet<>();
    private static final Map<String, List<Card>> cardMap = new HashMap<>();

    public static void addCard(String rank, String suit) {
        String cardKey = rank + " of " + suit;
        if (cardSet.contains(cardKey)) {
            System.out.println("Error: Card \"" + cardKey + "\" already exists.");
            return;
        }
        Card card = new Card(rank, suit);
        cardSet.add(cardKey);
        cardMap.putIfAbsent(suit, new ArrayList<>());
        cardMap.get(suit).add(card);
        System.out.println("Card added: " + cardKey);
    }

    public static void findCardsBySuit(String suit) {
        if (!cardMap.containsKey(suit) || cardMap.get(suit).isEmpty()) {
            System.out.println("No cards found for " + suit + ".");
            return;
        }
        for (Card card : cardMap.get(suit)) {
            System.out.println(card);
        }
    }

    public static void displayAllCards() {
        if (cardSet.isEmpty()) {
            System.out.println("No cards found.");
            return;
        }
        for (List<Card> cards : cardMap.values()) {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }

    public static void removeCard(String rank, String suit) {
        String cardKey = rank + " of " + suit;
        if (!cardSet.contains(cardKey)) {
            System.out.println("Error: Card \"" + cardKey + "\" not found.");
            return;
        }
        cardSet.remove(cardKey);
        cardMap.get(suit).removeIf(card -> card.rank.equals(rank));
        if (cardMap.get(suit).isEmpty()) {
            cardMap.remove(suit);
        }
        System.out.println("Card removed: " + cardKey);
    }

    public static void main(String[] args) {
      
        displayAllCards(); 
        addCard("Ace", "Spades"); 
        
    }
}
