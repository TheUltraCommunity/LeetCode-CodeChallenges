class Solution {
  bool arrayStringsAreEqual(List<String> word1, List<String> word2) {
    var iterativeIndex = word1.length >  word2.length ? word1.length : word2.length;
    String answer1 = "";
    String answer2 = "";
    for(int i =0; i < iterativeIndex; i++){
        if(i< word1.length){
            answer1 = "$answer1${word1[i]}";
        }
        if(i < word2.length){
            answer2 = "$answer2${word2[i]}";
        }
        if(!(answer1.contains(answer2) || answer2.contains(answer1))){
            return false;
        }
    }
    if(answer1 == answer2){
        return true;
    }
    return false;
  }
}
