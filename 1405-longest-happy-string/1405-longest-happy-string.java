class Solution {

    class CharacterCount {
        int count;
        char ch;

        public CharacterCount(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharacterCount> maxHeap = new PriorityQueue<>((x, y) -> y.count - x.count);

        if (a > 0) {
            maxHeap.add(new CharacterCount(a, 'a'));
        }
        if (b > 0) {
            maxHeap.add(new CharacterCount(b, 'b'));
        }
        if (c > 0) {
            maxHeap.add(new CharacterCount(c, 'c'));
        }

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            CharacterCount maxEle = maxHeap.poll();

            int maxCount = maxEle.count;
            char _c = maxEle.ch;

            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == _c && sb.charAt(sb.length() - 2) == _c) {
                if (maxHeap.isEmpty()) break;

                CharacterCount secMaxEle = maxHeap.poll();
                int sCount = secMaxEle.count;
                char s_c = secMaxEle.ch;

                sb.append(s_c);
                sCount = sCount - 1;
                if (sCount > 0) maxHeap.add(new CharacterCount(sCount, s_c));
                if (maxCount > 0) maxHeap.add(new CharacterCount(maxCount, _c));
            } else {
                sb.append(_c);
                maxCount = maxCount - 1;
                if (maxCount > 0) maxHeap.add(new CharacterCount(maxCount, _c));
            }

        }
        return sb.toString();
    }
}