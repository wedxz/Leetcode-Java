package com.vvu.offer;

// https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
// 将一个字符串中的空格替换成 "%20"
public class _005_替换空格 {

    public String replaceSpace(StringBuffer str) {
    	int p1 = str.length();
    	for (int i = 0; i < p1; i++) {
			if (str.charAt(i) == ' ') {
				str.append("00");  // 比之前多两个占位符
			}
		}
    	int p2 = str.length() - 1;
    	for (int i = p1 - 1; i >= 0; i--) {
        	System.out.println(str);
			char c = str.charAt(i);
			if (c == ' ') {
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
			} else {
				str.setCharAt(p2--, c);
			}
		}
    	return str.toString();
    }
}


