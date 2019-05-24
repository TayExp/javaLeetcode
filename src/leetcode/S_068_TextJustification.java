package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * greedy approach--pack as many words as you can in each line.
 * each line has exactly maxWidth characters.
 * fully (left and right) justified.
 * spaces distributed as evenly as possible.
 * the empty slots on the left more than right.
 * last line of text, left justified, no extra space 
 */
public class S_068_TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        int[] wordslen = new int[words.length];
        int row = 0, count = 0, currentWidth = 0, end = words.length;
        List<List<String>> ret = new ArrayList<>();
        if(end == 0) return toStringList(ret,maxWidth); // empty words
        for( int i = 0; i < end; i++){
        	wordslen[i] = words[i].length()+1;
        	if(words[i].length() > maxWidth) //maxWidth is less than the word's width.
        		return toStringList(ret,maxWidth);
        }
        ret.add(new ArrayList<String>());
        while(count < end){
        	currentWidth += wordslen[count];
        	if(currentWidth-1 > maxWidth){
        		row++;
        		ret.add(new ArrayList<String>());
        		currentWidth = wordslen[count];
        	}
        	if(count<end)
        		ret.get(row).add(words[count++]);
        }
        return toStringList(ret,maxWidth); //转换成合乎规定的字符串
    }
	

	private List<String> toStringList(List<List<String>> ret, int maxWidth) {
		List<String> result = new ArrayList<>();
		if (ret.isEmpty()) return result;
		int row = ret.size();
		for(int i = 0; i < row - 1; i++){
			List<String> list = ret.get(i);
			int len = 0, n = list.size();
			for(int j = 0; j < n; j++)
				len += list.get(j).length();
			int gapsum = maxWidth - len;
			StringBuilder sb = new StringBuilder();
			if(n == 1){
				sb.append(list.get(0));
				for (int j = 0; j < gapsum; j++)
					sb.append(" ");
				result.add(sb.toString());
				continue;
			}
			int gap = gapsum/(n-1);
			int pop = gapsum%(n-1);
			String gap2 = "";
			for (int j = 0; j < gap; j++)
				gap2 += " ";
			String gap1 = gap2 + " ";
			for(int j = 0; j < pop; j++)
				sb.append(list.get(j)).append(gap1);
			for(int j = pop; j< n-1; j++)
				sb.append(list.get(j)).append(gap2);
			result.add(sb.append(list.get(n-1)).toString());
		}
			
		//last line
		StringBuilder sb = new StringBuilder();
		for(String str : ret.get(row-1))
			sb.append(str).append(" ");
		while(sb.length()<maxWidth)
			sb.append(" ");
		result.add(sb.toString().substring(0, maxWidth));
		return result;
	}
	/*
	 * fully (left and right) justified.
	 * spaces distributed as evenly as possible.
	 * the empty slots on the left more than right.
	 * last line of text, left justified, no extra space 
	*/
	public static void main(String[] args){
		//new S_68_TextJustification().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
		System.out.println(new S_068_TextJustification().fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
		System.out.println(new S_068_TextJustification().fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
		         "to","a","computer.","Art","is","everything","else","we","do"}, 20));
	}
}
