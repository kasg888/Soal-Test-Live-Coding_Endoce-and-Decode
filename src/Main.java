public class Main {

    private static String encodeDecode(String word) {
        String kata = word.substring(8);
        char[] chword = kata.toCharArray();
        if (word.contains("<encode>")) {
            for (int i = 0; i < kata.length(); i++) {
                int dist = 2;

//            if melebihi Z
                if (dist + (chword[i] - 'a') >= 26) {
                    dist = (dist + (chword[i] - 'a')) % 26;
                    chword[i] = (char) ('a' + dist);
                }

                else {
                    chword[i] = (char) (chword[i] + dist);
                }
            }
        }

        if (word.contains("<decode>")) {
            for (int i = 0; i < kata.length(); i++) {
                int dist = -2;

//            if dibawah A
                if (dist + (chword[i] - 'a') < 0) {
                    dist = (dist + (chword[i] - 'a')) + 26;
                    chword[i] = (char) ('a' + dist);
                } else {
                    chword[i] = (char) (chword[i] + dist);
                }
            }
        }

        String fin = new String(chword);
        return fin;
    }
    public static void main(String[] args) {
//        encode
        System.out.println(encodeDecode("<encode>abcd")); // cdef
        System.out.println(encodeDecode("<encode>xyz")); // zab

//        decode
        System.out.println(encodeDecode("<decode>cdef")); //abcd
        System.out.println(encodeDecode("<decode>zab")); // xyz
    }
}