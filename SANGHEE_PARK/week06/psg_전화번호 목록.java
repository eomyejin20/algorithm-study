package org.example.week06;

import java.util.Arrays;

public class PSG42587 {
    class Solution {
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);
            for (int i = 0; i < phone_book.length - 1; i++) {
                if (phone_book[i + 1].startsWith(phone_book[i])) {
                    return false;
                }
            }
            return true;
        }
    }
}
