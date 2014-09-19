import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * With the expansion of the Internet across the world, the demand is growing for everyone to have an email address. Until everyone is ready to use international characters, you are now in charge of writing a converter that will take UTF-8 characters and bring them back to something DNS servers will be able to handle.

To do so, you must take an email string and break it into 3 pieces: first@second.third. Process each piece as follows:

Leave all characters that have ASCII codes between 33 and 126 as is, except convert uppercase letters to lowercase letters
Represent all other characters (referred to hereinafter as special characters) using the format +position?UTF-8_hexadecimal_representation 
The position is the 0-indexed position of the represented character
The UTF-8 hexadecimal representation must not contain spaces and must be finalized
If at least one special character was present in the string, append a ~ and each special character at the end of the address.

For example, the piece Pøpø would be processed to pp+1?C3B8+3?C3B8~øø

Clarifications

There shouldn’t be any spaces.
You will receive only characters contained within the UTF-8 standard
Input description/format

Each line will be an email address with Unicode characters.

Output description/format

<new email address composition>~<characters removed in order>

Example input

WoRlD_ReAdY@Microsoft.COM
Café@Chaud.tôt
Trinitŷ@߷.com
ա@մ.կ
😎@🚀.com
ep@ез.кom
Soup@🍚.com
🆍🆌@SAPA.com
ಠಠ@Look.com
ᱪ@Alien.invasion
Vikingoftheᛗ@North.ᛣ
ဩ@ဦ.com
Ⴭaჯ@Greorgian.letTer
Example output

world_ready@microsoft.com
caf+3?C3A9@chaud.tt+1?C3B4~éô
trinit+6?C5B7@+0?DFB7.com~ŷ߷
+0?D5A1@+1?D5B4.+0?D5AF~ամկ
+0?EFBFBD+1?EFBFBD@+1?EFBFBD+2?EFBFBD.com~😎🚀
ep@+0?D0B5+1?D0B7.om+0?D0BA~езк
soup@+0?EFBFBD+1?EFBFBD.com~🍚
+0?EFBFBD+1?EFBFBD+2?EFBFBD+3?EFBFBD@sapa.com~🆍🆌
+0?E0B2A0+1?E0B2A0@look.com~ಠಠ
+0?E1B1AA@alien.invasion~ᱪ
vikingofthe+14?E19B97@north.+0?E19BA3~ᛗᛣ
+0?E180A9@+0?E180A6.com~ဩဦ
a+0?E1838D+2?E183AF@greorgian.letter~Ⴭჯ
 * @author Ricky
 *
 */
public class unicodeStr {
	public static String emailAddressSplit(String input) throws UnsupportedEncodingException{
		StringBuffer output = new StringBuffer();
		String first, second, third;
		first = input.split("@")[0];
		String afterAt = input.split("@")[1];
		if (afterAt == null){
			second = null;
			third = null;
		}
		second = afterAt.split("\\.")[0];
		third = afterAt.split("\\.")[1];
		first = processUnicode(first);
		second = processUnicode(second);
		third = processUnicode(third);
		
		return output.append(first).append("@").append(second).append(".").append(third).toString();		
	}
	
	private static String processUnicode(String str) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		if (str == null)
			return null;
		
		Boolean flag = false;
		//the last component after "~"
		String unicodeSrc="~";
		
		StringBuffer outputBuffer = new StringBuffer();
		for (int i = 0; i<str.length();i++){
			char c = str.charAt(i);
			int ascii = (int) c;
			//step 1
			if (ascii >=65 && ascii<=90){
				c = (char) (ascii + 32);
				outputBuffer = outputBuffer.append(c);
			} else if (ascii <65 || ascii>90 && ascii<128){
				outputBuffer = outputBuffer.append(c);
			}
			//step 2
			else if (ascii>127){
				flag = true;
				
				String replace = "+"+i+"?"+charToHex(c);
				outputBuffer = outputBuffer.append(replace);
				unicodeSrc+=c;
			}
		}
		// "~" part
		if (flag){
			outputBuffer = outputBuffer.append(unicodeSrc);
		}
		return outputBuffer.toString();
	}
	static public String charToHex(char c) throws UnsupportedEncodingException {	
		String s = URLEncoder.encode(String.valueOf(c), "UTF-8");
		s = s.replaceAll("%", "");
	    return s.toUpperCase();
	  }
	public static void main(String[] args) throws UnsupportedEncodingException{
		String input = "Café@Chaud.tôt";
		System.out.println(input);
		System.out.println(emailAddressSplit(input));
	}
}
