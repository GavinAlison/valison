package com.demo1;

/**
 * 题目: 输入：12345,输出：壹万貳仟叁佰肆拾伍<br>
 * 输入: 10003,输出: 壹万零叁 思路: 算法题， 使用数据结构, 万仟佰拾个 零壹贰叁肆伍陆柒捌玖拾<br>
 * 
 * String是一个CharSequence字符序列，底层管理的是char[]数组， char类型如何转换成对应数值<br>
 * 
 * 定义：单位为： 万仟佰拾个.. <br>
 * 数值： 零壹贰叁肆伍陆柒捌玖拾<br>
 * 阿拉伯数字： 0-9
 * 
 * 数组： 遍历输入的数字<br>
 * "个", "拾", "佰", "仟", "万", "十万", "百万","千万", "亿" <br>
 * "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"
 * 
 * @author hy
 * 
 */
public class Demo {
	// 可变的单位
	public String[] arrDefine = new String[] { "个", "拾", "佰", "仟", "万", "十万",
			"百万", "千万", "亿", "十亿", "百亿", "千亿" };
	// 可变的中文字符
	public String[] arrValueChinese = new String[] { "零", "壹", "贰", "叁", "肆",
			"伍", "陆", "柒", "捌", "玖", "拾" };

	public String orginValue = "  92233720368547758";

	/**
	 * 将字符串转换
	 * 
	 * @return
	 * @throws Exception
	 */
	public String translate() throws Exception {
		StringBuffer sb = new StringBuffer("");
		// 转换原字符串
		String orgStr = chekcupStr(orginValue);
		char[] arrChar = orgStr.toCharArray();
		for (int i = 0; i < arrChar.length; i++) {
			// 个位， 单位不加， 遇到零，单位不加，都加数值
			// 0, 8, 10, 22, 103, 99, 1090, 10009002, 0001
			// 处理数值为0
			if (Long.valueOf(arrChar[i] - '0').longValue() == 0L) {
				// 加零
				if (i != 0
						&& Long.valueOf(arrChar[i - 1] - '0').longValue() != 0)
					sb.append(arrValueChinese[0]);
				continue;
			}
			// 排除单位个，处理单位长度超过2位
			if (i != 0) {
				if (arrDefine[i].length() > 1) {
					arrDefine[i] = new StringBuffer(arrDefine[i]).reverse()
							.toString();
				}
				sb.append(arrDefine[i]);
			}
			sb.append(arrValueChinese[arrChar[i] - '0']);
		}
		if (sb.toString().equals("")) {
			sb.append(arrValueChinese[0]);
		}
		return sb.reverse().toString();
	}

	// 检验字符串orgStr，并转换
	public String chekcupStr(String orgStr) throws Exception {
		try {
			orgStr = Long.valueOf(orginValue.trim()).toString();
			if (orgStr == null || orgStr.equals("")) {
				throw new java.lang.IllegalArgumentException("参数错误，请检查！");
			}
			if (orgStr.length() > arrDefine.length) {
				throw new java.lang.IllegalArgumentException(orginValue
						+ "长度大于最大单位的长度" + arrDefine.length + "，请检查后重试！");
			}
			orgStr = new StringBuffer(orgStr).reverse().toString();
		} catch (Exception e) {
			throw new java.lang.IllegalArgumentException("参数错误，请检查！"
					+ e.getMessage());
		}
		return orgStr;
	}

	public static void main(String[] args) {
		// 测试用例000, 00001, 1,9,10,101,1010, 12, 1000000, 100003, 123456
		String[] strArr = { "000", " 00001", " 1", "9", "10", "101", "1010",
				" 12", " 1000000", " 100003", " 123456" };
		Demo d = new Demo();
		for (String str : strArr) {
			try {
				d.orginValue = str;
				System.out.println(d.translate());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
