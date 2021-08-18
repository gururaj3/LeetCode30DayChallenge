class Solution {
    public String addBoldTag(String s, String[] dict) {
        // find all the word occurances in the given string
        List<int[]> intervals = findIntervals(s, dict);
        // if no intervals found then return the same string
        // for(int[] i : intervals)
        // System.out.println("i[0]: "+i[0]+" i[1]: "+i[1]);
        if (intervals.size() == 0) return s;
		// merge the intervals as per the requirement
        List<int[]> merged = mergeIntervals(intervals);
        
        // final printing based on the merged intervals
        return stringFormatting(s, merged);
    }

    /**
     * method to find all the intervals (index range) of every word from the dictionary
     **/
    private List<int[]> findIntervals(String s, String[] dict) {
        List<int[]> intervals = new ArrayList<>();
        for (String word : dict) {
            int findIndex = s.indexOf(word);
            while(findIndex >= 0) {
                intervals.add(new int[]{findIndex, findIndex + word.length() - 1});
                findIndex = s.indexOf(word,findIndex+1);
            }
        }
        return intervals;
    }

    /**
     * method to merge the intervals
     **/
    private List<int[]> mergeIntervals(List<int[]> intervals) {
        Collections.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        
        List<int[]> mergerIntervals = new ArrayList<>();
        int[] prevInterval = intervals.get(0);
        mergerIntervals.add(prevInterval);
        
        for(int[] interval : intervals){
            //We do +1 to check if two substrings wrapped by bold tags are consecutive 
            if(prevInterval[1]+1 >= interval[0])
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            else{
                prevInterval = interval;
                mergerIntervals.add(prevInterval);
            }
        }
        return mergerIntervals;
    }

    /**
     * method to finally create the string with bold tags
     **/
       private String stringFormatting(String s, List<int[]> intervals) {
        StringBuilder sb = new StringBuilder();
        int prevIndex = 0;
        for (int[] interval : intervals) {
            // get the string before current interval
            sb.append(s.substring(prevIndex, interval[0]));
            // bold the interval
            sb.append("<b>");
            sb.append(s.substring(interval[0], interval[1] + 1));
            sb.append("</b>");
            // increment prevIndex
            prevIndex = interval[1] + 1;
        }

        // append any left over string
        if (prevIndex < s.length()) sb.append(s.substring(prevIndex));
        return sb.toString();
    }
}

/*
s = "abcxyz123", 
words = ["abc","123"]

"<b>abc</b>xyz<b>123</b>"


s = "aaabbcc", words = ["aaa","aab","bc"]

"<b>aaab</b><b>bc</b>c"



*/
