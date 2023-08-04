public class Main {

    private static String encodeDecode(String word) {
        String kata = word.substring(8);
        char[] chword = kata.toCharArray();
        if (word.contains("<encode>")) {
            for (int i = 0; i < kata.length(); i++) {
                int jarak = 2;

//            if melebihi Z
                if (jarak + (chword[i] - 'a') >= 26) {
                    jarak = (jarak + (chword[i] - 'a')) % 26;
                    chword[i] = (char) ('a' + jarak);
                }

                else {
                    chword[i] = (char) (chword[i] + jarak);
                }
            }
        }

        if (word.contains("<decode>")) {
            for (int i = 0; i < kata.length(); i++) {
                int jarak = -2;

//            if dibawah A
                if (jarak + (chword[i] - 'a') < 0) {
                    jarak = (jarak + (chword[i] - 'a')) + 26;
                    chword[i] = (char) ('a' + jarak);
                } else {
                    chword[i] = (char) (chword[i] + jarak);
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