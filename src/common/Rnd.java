package common;

import java.util.Random;

/**
 * 随机数的生成
 * @author Sunjian
 */
public final class Rnd {

	/**
	 * 构造函数
	 */
	public Rnd() {
		rd1 = new Random();
	}

	static Random rd1 = new Random();

	/**
	 * 得到0-9随机数<br/>
	 * @return int
	 */
	public final static int getRndNum() {
		return rd1.nextInt(10);
	}

	/**
	 * 得到min-max之间的随机数
	 * @param min int
	 * @param max int
	 * @return int
	 */
	public final static int getRndInt(final int min, final int max) {
		return min + rd1.nextInt(max - min + 1);
	}

	/**
	 * outType:<br/>
	 * 1://随机一位数字 0 - 9<br/>
	 * 2://随机一位小写字母 a - z<br/>
	 * 3://随机一位大写字母 A - Z<br/>
	 * 4://随机一位数字或小写 0 - 9 a - z<br/>
	 * 5://随机一位大或小写字母 a - z A-Z<br/>
	 * default://随机一位数字、小写、大写字母 0 - 9 a - z A - Z<br/>
	 * @param type int
	 * @return String
	 */
	@Deprecated
	public final static String getRndChar(final int type) {
		switch (type) {
		case 1:// 随机一位数字 0 - 9
			return "" + getRndNum();
		case 2:// 随机一位小写字母 a - z
			return Character.toString((char) getRndInt(97, 122));
		case 3:// 随机一位大写字母 A - Z
			return Character.toString((char) getRndInt(97, 122)).toUpperCase();
		case 4:// 随机一位数字或小写 0 - 9 a - z
			if (getRndInt(1, 2) == 1) return "" + getRndNum();
			return Character.toString((char) getRndInt(97, 122));
		case 5:// 随机一位大或小写字母 a - z A-Z
			if (getRndInt(1, 2) == 1) return Character.toString((char) getRndInt(97, 122));
			return Character.toString((char) getRndInt(97, 122)).toUpperCase();
		case 6:// 随机一位数字或小写 A - Z 0 - 9
			if (getRndInt(1, 2) == 1) return "" + getRndNum();
			return Character.toString((char) getRndInt(97, 122)).toUpperCase();
		default:// 随机一位数字、小写、大写字母 0 - 9 a - z A - Z
			int i = getRndInt(1, 3);
			if (i == 1) return "" + getRndNum();
			if (i == 2) return Character.toString((char) getRndInt(97, 122));
			return Character.toString((char) getRndInt(97, 122)).toUpperCase();
		}
	}
	/**
	 * outType:<br/>
	 * 1://随机一位数字 0 - 9<br/>
	 * 2://随机一位小写字母 a - z<br/>
	 * 3://随机一位大写字母 A - Z<br/>
	 * 4://随机一位数字或小写 0 - 9 a - z<br/>
	 * 5://随机一位大或小写字母 a - z A-Z<br/>
	 * default://随机一位数字、小写、大写字母 0 - 9 a - z A - Z<br/>
	 * @param type int
	 * @return String
	 */
	public final static char getRndCharacter(final int type) {
		switch (type) {
		case 1:// 随机一位数字 0 - 9
			return (char) getRndNum();
		case 2:// 随机一位小写字母 a - z
			return (char) getRndInt(97, 122);
		case 3:// 随机一位大写字母 A - Z
			return (char) getRndInt(65, 90);
		case 4:// 随机一位数字或小写 0 - 9 a - z
			if (getRndInt(1, 2) == 1) return  (char) getRndNum();
			return (char) getRndInt(97, 122);
		case 5:// 随机一位大或小写字母 a - z A-Z
			if (getRndInt(1, 2) == 1) return (char) getRndInt(97, 122);
			return (char) getRndInt(97, 122);
		case 6:// 随机一位数字或小写 A - Z 0 - 9
			if (getRndInt(1, 2) == 1) return (char) getRndNum();
			return (char) getRndInt(97, 122);
		default:// 随机一位数字、小写、大写字母 0 - 9 a - z A - Z
			int i = getRndInt(1, 3);
			if (i == 1) return (char) getRndNum();
			if (i == 2) return (char) getRndInt(97, 122);
			return (char) getRndInt(97, 122);
		}
	}

	/**
	 * 
	 //====================================================================<br/>
	 * //<br/>
	 * // 得到一个多少位的字串(String)<br/>
	 * // 1:全是0-9<br/>
	 * // 2:全是a-z<br/>
	 * // 3:全是A-Z<br/>
	 * // 4:全是0-9 a-z<br/>
	 * // 5:全是a-z A-Z<br/>
	 * // 6:全是A-Z 0-9<br/>
	 * // 7:全是0-9 a-z A-Z<br/>
	 * //
	 * @param len int
	 * @param type int
	 * @return String
	 */
	@Deprecated
	public final static String getRndS(final int len, final int type) {
		if (len <= 0) return "";
		final StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(getRndCharacter(type));
		return sb.toString();
	}
	private static final char[] ArrayNull = new char[0];

	/**
	 * // 得到一个多少位的字串(String)<br/>
	 * // 1:全是0-9<br/>
	 * // 2:全是a-z<br/>
	 * // 3:全是A-Z<br/>
	 * // 4:全是0-9 a-z<br/>
	 * // 5:全是a-z A-Z<br/>
	 * // 6:全是A-Z 0-9<br/>
	 * // 7:全是0-9 a-z A-Z<br/>
	 * //
	 * @param len int
	 * @param type int
	 * @return char[]
	 */
	public final static char[] getRndCharacters(final int len, final int type) {
		if (len <= 0) return ArrayNull;
		final char[] newarray=new char[len];
		for (int i = 0; i < len; i++)
			newarray[i]=getRndCharacter(type);
		return newarray;
	}
	/**
	 * // 得到一个多少位的字串(String)<br/>
	 * // 1:全是0-9<br/>
	 * // 2:全是a-z<br/>
	 * // 3:全是A-Z<br/>
	 * // 4:全是0-9 a-z<br/>
	 * // 5:全是a-z A-Z<br/>
	 * // 6:全是A-Z 0-9<br/>
	 * // 7:全是0-9 a-z A-Z<br/>
	 * //
	 * @param len int
	 * @param type int
	 * @return String
	 */
	public final static String getRndString(final int len, final int type) {
		return new String(getRndCharacters(len,type));
	}

	/**
	 * 
	 //====================================================================<br/>
	 * //<br/>
	 * // 得到一个多少位的数值 以非0开头(int)<br/>
	 * //<br/>
	 * @param len int
	 * @return int
	 */
	public final static int getRndI(final int len) {
		if (len <= 0) return 0;
		return Integer.parseInt(getRndInt(1, 9) + "" + getRndS(len - 1, 1));
	}

}
