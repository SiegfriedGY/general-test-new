package CardDeckGame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {

    private CardCategory category;
    private int number;

    public CardCategory getCategory() {
        return category;
    }

    public void setCategory(CardCategory category) {
        this.category = category;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.category.toString() + "-" + this.number;
    }
}
