class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        int p=0;
        char[] carr1 = ransomNote.toCharArray();
        Arrays.sort(carr1);
        char[] carr2 = magazine.toCharArray();
        Arrays.sort(carr2);
        for(int i=0; i<carr1.length; i++){
            if(p>=carr2.length){
                return false;
            }
            if(carr1[i]==carr2[p]){
                //System.out.println(""+carr1[i]+"--"+ carr2[p]);
                p++;
                continue;
            }else{
                while(carr1[i]!=carr2[p]){
                    
                    p++;
                    if(p>=carr2.length){
                        return false;
                    }
                }
                //System.out.println(""+carr1[i]+"--"+ carr2[p]);
                p++;
                
            }
        }
        return true;
    }
}

class Solution2 {
    
    // Takes a String, and returns a HashMap with counts of
    // each character.
    private Map<Character, Integer> makeCountsMap(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            int currentCount = counts.getOrDefault(c, 0);
            counts.put(c, currentCount + 1);
        }
        return counts;
    }
    
    
    public boolean canConstruct(String ransomNote, String magazine) {
        
        // Check for obvious fail case.
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Make a counts map for the magazine.
        Map<Character, Integer> magazineCounts = makeCountsMap(magazine);
        
        // For each character in the ransom note:
        for (char c : ransomNote.toCharArray()) {
            // Get the current count for c in the magazine.
            int countInMagazine = magazineCounts.getOrDefault(c, 0);
            // If there are none of c left, return false.
            if (countInMagazine == 0) {
                return false;
            }
            // Put the updated count for c back into magazineCounts.
            magazineCounts.put(c, countInMagazine - 1);
        }
        
        // If we got this far, we can successfully build the note.
        return true;
    }
}