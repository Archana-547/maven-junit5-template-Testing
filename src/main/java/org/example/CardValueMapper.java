package org.example;


public class CardValueMapper {
    public static int getCardValue(String cardRank) {
        switch (cardRank.toUpperCase()) {

            case "JACK":
                return 10;
            case "QUEEN":
                return 10;
            case "KING":
                return 11;
        }

                return 0;
        }

    }
