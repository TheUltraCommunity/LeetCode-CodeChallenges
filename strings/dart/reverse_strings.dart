class Solution {
  String reverseWords(String s) {
    var word = "";
    var answer = "";
    for(int i = 0; i < s.length; i++){
        if(s[i] == " " || i == s.length - 1){
            if(s[i] != " "){
                word += s[i];
            }
            if(word != ""){
                if(answer != ""){
                    answer = "$word $answer";
                }else{
                    answer = "$word";
                }
            }
            word = "";
        }else{
            if(s[i] != " "){
                word += s[i];
            }
        }
    }
    return answer;
  }
}
