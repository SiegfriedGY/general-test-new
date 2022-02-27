package leetcode;

import java.util.LinkedList;
import java.util.List;

public class ZigZagConversion {

    public static void main(String[] args){
        System.out.println(convert("LEETCODEISHIRING", 3));
    }

    public static String convert(String src, int row) {

        int length = src.length();

        if ("".equals(src) || src == null) {
            return "";
        }

        if (length == 1){
            return src.substring(0,1);
        }
        if (row == 1){
            return src;
        }

        char[] chars = src.toCharArray();

        int xBench = 0;
        int xIncrement = 0;

        int yBench = 0;
        int yIncrement = 1;

        List<Cell> cells = new LinkedList<>();
        for (int i = 0; i < src.length(); i++) {

            Cell cell = new Cell(chars[i]);

            // calculate Y value
            int y = yBench + yIncrement;
            yBench = y;
            if (y >= row) {
                yIncrement = -1;
            } if (y <= 1){
                yIncrement = 1;
            }
            y = y-1;
            cell.setY(y);

            // calculate X value
            int x = xBench + xIncrement;
            xBench = x;
            if (yIncrement == 1) {
                xIncrement = 0;
            } else {
                xIncrement = 1;
            }

//            System.out.println("x = " + x +" , y = " + y);
            cell.setX(x);
            cells.add(cell);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (Cell cell: cells){
                if (cell.getY() == i){
                    sb.append(cell.getCharacter());
                }
            }
        }
        String result = sb.toString();
        return result;
    }
}

class Cell {

    private char character;
    private int x;
    private int y;

    public Cell(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
