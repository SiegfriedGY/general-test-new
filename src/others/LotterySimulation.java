package others;

import java.util.*;

public class LotterySimulation {

    public static void main(String[] args) {
        List<Buyer> allBuyers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            allBuyers.add(new Buyer(i+1, "买家"+ (i+1)));
        }

        Set<Buyer> finalBuyers = new HashSet<>();
        Random random = new Random();
        while (finalBuyers.size()<5) {
            int index = random.nextInt(allBuyers.size());
            System.out.println("index: "+ index);
            finalBuyers.add(allBuyers.get(index));
        }
        System.out.println("中奖买家为：" + finalBuyers);
    }
}

class Buyer {

    private Integer id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(id, buyer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Buyer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Buyer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                '}';
    }
}
