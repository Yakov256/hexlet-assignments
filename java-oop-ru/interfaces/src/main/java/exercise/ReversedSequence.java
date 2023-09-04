package exercise;

import java.util.Arrays;
import java.util.stream.IntStream;

// BEGIN
class ReversedSequence implements CharSequence{
    //private String charSequence;
    private char[] charSequence;

    @Override
    public boolean isEmpty() {
        return this.charSequence.length == 0;
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }

    @Override
    public int length() {
        return this.charSequence.length;
    }

    @Override
    public char charAt(int i) {
        return this.charSequence[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < i1; j++) {
            sb.append(this.charSequence[j]);
        }
        return sb.toString();
    }

    public ReversedSequence(String charSequence) {
        String reverse = new StringBuilder(charSequence).reverse().toString();
        this.charSequence = reverse.toCharArray();
    }

    @Override
    public String toString() {
        return String.valueOf(charSequence);
    }
}
// END
