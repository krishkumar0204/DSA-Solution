class Solution {
    public boolean backspaceCompare(String s, String t) {
        if(s.length() == 0 && t.length() == 0){
            return true;
        }else if(s.length() == 0 || t.length() == 0){
            return false;
        }

        StringBuilder sbS = new StringBuilder();
        StringBuilder sbT = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '#'){
                if(!sbS.isEmpty()){
                    sbS.deleteCharAt(sbS.length() - 1);
                }
            }else{
                sbS.append(c);
            }
        }

        for(char c : t.toCharArray()){
            if(c == '#'){
                if(!sbT.isEmpty()){
                    sbT.deleteCharAt(sbT.length() - 1);
                }
            }else{
                sbT.append(c);
            }
        }

        String newS = sbS.toString();
        String newT = sbT.toString();

        if(newS.equals(newT)){
            return true;
        }

        return false;
    }
}