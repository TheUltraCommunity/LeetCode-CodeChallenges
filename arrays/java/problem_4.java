package java;

public class problem_4 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();   
        StringBuilder s2 = new StringBuilder();   

        for(String w1 : word1){
            s1.append(w1);
        }

        for(String w2 : word2){
            s2.append(w2);
        }

        return s1.toString().equals(s2.toString());
    }
    
}
