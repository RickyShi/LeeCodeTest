package reverSerWordsInAString;

public class ReverseWordsInAString {
	/*
	 *	Using Regular Expression Matching
	 *	StringBuilder will be better 
	 */
	public String reverseWords(String s) {
	        String[] parts = s.trim().split("\\s+");
	        String out = "";
	        if (parts.length > 0) {
	            for (int i = parts.length - 1; i > 0; i--) {
	                out += parts[i] + " ";
	            }
	            out += parts[0];
	        }
	  return out; 
	  }
	  
	/*
	 * Using no advanced string method
	 */
	  public String reverseWordsNoAdvanced(String s) {
	        if(s == null || s.equals(""))
	            return s;
	        String ret = "", word = "";
	        boolean whitespace = true;
	        for(int i = 0 ; i < s.length() ; i ++)
	        {
	            if(s.charAt(i) == ' ' && whitespace == false)
	            {
	                whitespace = true;
	                ret = ret.equals("") ? word : word + " " + ret;
	                word = "";
	            }
	            if(s.charAt(i) != ' ')
	            {
	                word += String.valueOf(s.charAt(i));
	                if(whitespace)
	                    whitespace = false;
	            }
	        }
	        if(! word.equals(""))
	            ret = ret.equals("") ? word : word + " " + ret;
	        return ret;
	  }
}
