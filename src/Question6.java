import java.util.ArrayList;
import java.util.List;

public class Question6 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(p.length()>s.length()) return list;
        int[] pcount = new int[26];
        int[] scount = new int[26];
        for(int i=0;i<p.length();i++){
            pcount[(int)p.charAt(i)-(int)'a']++;
            scount[(int)s.charAt(i)-(int)'a']++;
        }
        int matches=0;
        for(int j=0;j<26;j++){
           if(pcount[j]==scount[j]) {
               matches++;
           }
        }
        int l=0;
        if(matches==26) list.add(l);
        int index;
        for(int r=p.length();r<s.length();r++){

            index=(int)s.charAt(r)-(int)'a';
            scount[index]++;
            if(pcount[index]==scount[index]) matches++;
            else if(pcount[index]+1==scount[index]) matches--;

            index=(int)s.charAt(l)-(int)'a';
            scount[index]--;
            if(pcount[index]==scount[index]) matches++;
            else if(pcount[index]-1==scount[index]) matches--;
            l++;
            if(matches==26) list.add(l);
        }
        return list;
    }
}
