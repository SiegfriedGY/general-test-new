package CardDeckGame;

import com.sun.org.apache.xpath.internal.objects.XBoolean;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Game {

    public static void main(String[] args) {
        List<Card> deck = prepare();
//        System.out.println(deck);
        Collections.shuffle(deck);
//        System.out.println(deck);
        Play play = new Play((LinkedList<Card>) deck);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(play::sendCardToA);
        executor.execute(play::sendCardToB);
        executor.execute(play::sendCardToC);
        while(play.isGameOver()){
            executor.shutdownNow();
        }

/*        new Thread(() -> {
//            while (!play.isGameOver()) {
                play.sendCardToA();
//            }
//            System.exit(0);
        }).start();
        new Thread(() -> {
//            while (!play.isGameOver()) {
                play.sendCardToB();
//            }
//            System.exit(0);
        }).start();
        new Thread(() -> {
//            while (!play.isGameOver()) {
                play.sendCardToC();
//            }
//            System.exit(0);
        }).start();*/
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(Thread.activeCount());
    }

    private static List<Card> prepare() {
        List<Card> result = new LinkedList<>();
        List<CardCategory> categories = Arrays.asList(CardCategory.FANGPIAN, CardCategory.HEITAO, CardCategory.HONGTAO, CardCategory.MEIHUA);
        for (CardCategory cardCategory : categories) {
            for (int i = 0; i < 13; i++) {
                Card card = new Card();
                card.setCategory(cardCategory);
                card.setNumber(i+1);
                result.add(card);
            }
        }
        Card major = new Card();
        major.setCategory(CardCategory.MAJOR_KING);
        major.setNumber(20);

        Card minor = new Card();
        minor.setCategory(CardCategory.MINOR_KING);
        minor.setNumber(20);

        result.add(major);
        result.add(minor);

        System.out.println(result.size());
        return result;
    }
}
