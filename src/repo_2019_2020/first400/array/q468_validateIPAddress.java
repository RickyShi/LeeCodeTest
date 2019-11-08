package repo_2019_2020.first400.array;

import java.util.Arrays;

public class q468_validateIPAddress {
    public class Solution {
        public String validIPAddress(String IP) {
            if (IP.equals("")) return "Neither";
            if (isIP4(IP)) return "IPv4";
            if (isIP6(IP)) return "IPv6";
            return "Neither";
        }

        public boolean isIP4(String IP) {
            if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') return false;
            String[] temp = IP.split("\\.");
            if (temp.length != 4) return false;
            for (int i = 0; i < 4; i++) {
                try {
                    if (temp[i].startsWith("0") && temp[i].length() > 1) return false;
                    if (Integer.parseInt(temp[i]) > 255 || temp[i].charAt(0) == '-' || temp[i].charAt(0) == '+')
                        return false;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR");
                    return false;
                }
            }
            return true;
        }

        public boolean isIP6(String IP) {
            if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') return false;
            String[] temp = IP.split(":");
            if (temp.length != 8) return false;
            for (int i = 0; i < 8; i++) {
                if (temp[i].length() > 4 || temp[i].length() == 0) return false;
                for (int j = 0; j < temp[i].length(); j++) {
                    if ((temp[i].charAt(j) >= '0' && temp[i].charAt(j) <= '9') || (temp[i].charAt(j) >= 'a' && temp[i].charAt(j) <= 'f') || (temp[i].charAt(j) >= 'A' && temp[i].charAt(j) <= 'F')) {
                    } else return false;
                }
            }
            return true;
        }
    }

    public String validIPAddress(String IP) {
        if (isIPV4(IP)) return "IPv4";
        if (isIPV6(IP)) return "IPv6";
        if (!isIPV4(IP) && !isIPV6(IP)) return "Neither";
        return "";
    }

    public boolean isIPV4(String IP) {
        if (IP == null) return false;
        if (IP.startsWith(".")) return false;
        if (IP.endsWith(".")) return false;
        String[] arr = IP.split("\\.");
        if (arr.length != 4) return false;
        for (String s : arr) {
            try {
                int i = Integer.valueOf(s);
                if (i < 0 || i > 255) return false;
                if (i <= 9) {
                    if (s.length() != 1)
                        return false;
                } else if (i < 100) {
                    if (s.length() != 2)
                        return false;
                } else if (s.length() != 3) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public boolean isIPV6(String IP) {
        if (IP == null) return false;
        if (IP.startsWith(":")) return false;
        if (IP.endsWith(":")) return false;
        String[] arr = IP.split(":");
        if (arr.length != 8) return false;
        for (String s : arr) {
            if (s.isEmpty()) return false;

            if (s.length() > 4) return false;
            for (char c : s.toCharArray()) {
                if (!((c >= 'a' && c <= 'e') || (c >= 'A') && (c <= 'E') || (c >= '0') && (c <= '9')))
                    return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        q468_validateIPAddress test = new q468_validateIPAddress();
//        System.out.println(test.isIPV4("172.16.254.1"));
//        System.out.println(test.isIPV4("172.16.254.-1"));
//        System.out.println(test.isIPV4("172.16.254.a"));
//        System.out.println(test.isIPV4("1..1.1"));
//        System.out.println((".1.1.1.1").startsWith("."));
//        Arrays.stream((".1.1.1.1").split("\\.", -1)).forEach(System.out::println);
        String[] a = (".1.1..1.1.").split("\\.", -1);
//        Arrays.stream((".1.1.1.1").split("\\.", 2)).forEach(System.out::println);
        String[] b = (".1..1.1.1.").split("\\.", 3);
        String[] b2 = (".1..1.1.1.").split("\\.", 0);
//        System.out.println(test.isIPV6("2001:0db8:85a3:0:0:8A2E:0370:7334"));//true
//        System.out.println(test.isIPV6("2001:db8:85a3:0:0:8A2E:0370:7334"));//true
//        System.out.println(test.isIPV6("02001:0db8:85a3:00000:0000:8a2e:0370:7334"));//false
//        System.out.println(test.isIPV6("2001:0db8:85a3:0:0:8A2E:0370:7334:"));//false
//        System.out.println(test.isIPV6("2001:0db8:85a3:0:0:8A2E:0370:7334::"));//false
        String s = ("02001:0db8:85a3:0000:0000:8a2e:0370:7334");
        System.out.println(s.substring(0, s.length() - 4));
    }
}
