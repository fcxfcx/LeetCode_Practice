package Stack;

public class Problem_1047 {
    public String removeDuplicates(String S){
        StringBuilder sb = new StringBuilder();
        int top = -1;
        for(int i=0; i<S.length(); i++){
            char tempChar = S.charAt(i);
            if(top>=0 && sb.charAt(top)==tempChar){
                sb.deleteCharAt(top);
                top--;
            }else {
                sb.append(tempChar);
                top++;
            }
        }
        return sb.toString();
    }
}
