package MaQiao.MaQiaoArrayConvertFixedLengthMultiRows;

import java.util.ArrayList;
import java.util.List;

public final class UtilTool {
	/**
	 * 重复字符串
	 * @param str String
	 * @param num int
	 * @return String
	 */
	public static final String repleat(final String str, final int num) {
		final int len = str.length();
		if (len <= 0 || num <= 0) return new String();
		String newString = new String(new char[len * num]);
		Object objSource = Consts.UNSAFE.getObject(str, Consts.StringArrayOffset);
		Object objDest = Consts.UNSAFE.getObject(newString, Consts.StringArrayOffset);
		for (int i = 0; i < num; i++)
			System.arraycopy(objSource, 0, objDest, len * i, len);
		return newString;
	}
	/**
	 * 计算String长度<br/>
	 * 其中汉字等非ascii字母占2位，ascii占1位，得到此字符串的长度(判断占1个字节还是2个字节)<br/>
	 * 注意：此方法与 String.getBytes().length 不同<br/>
	 * @param str String
	 * @return int
	 */
	public static final int getBytesLength(final String str) {
		long len = str.length();
		Object obj = Consts.UNSAFE.getObject(str, Consts.StringArrayOffset);
		int sort = 0;
		//System.out.println("len:" + len);
		for (long i = 0; i < len; i++) {
			char c = Consts.UNSAFE.getChar(obj, Consts.ArrayAddress + ((i) << 1));
			if ((c >> 8) == 0) {
				sort++;
				//System.out.println("ascii:"+c);
				continue;
			}
			//System.out.println("中文:"+c);
			sort += 2;
		}
		return sort;
	}

	/**
	 * 判断IElement[]数组是否为空，所有有一个单元为!=null，则返回false<br/>
	 * @param elements IElement[]
	 * @return boolean
	 */
	public static final boolean isClearElementsArray(final IElement[] elements) {
		final int len = elements.length;
		if (len == 0) return true;
		for (int i = 0; i < len; i++)
			if (elements[i] != null) return false;
		return true;
	}

	/**
	 * List < ArrayList < IElement > > 转成二维数组 IElement[][]<br/>
	 * @param listElement List< ArrayList < IElement > >
	 * @return IElement[][]
	 */
	public static final IElement[][] ListConvertArrays(final List<ArrayList<IElement>> listElement) {
		final int len = listElement.size();
		final IElement[][] newElementsArray = new IElement[len][];
		int ii;
		for (int i = 0; i < len; i++) {
			IElement[] p = new IElement[listElement.get(i).size()];
			for (ii = 0; ii < p.length; ii++) {
				p[ii] = listElement.get(i).get(ii);
			}
			newElementsArray[i] = p;
		}
		//newElementsArray[i] = (IElement[]) listElement.get(i).toArray();
		return newElementsArray;

	}

	/**
	 * 清除单元数组中的null单元<br/>
	 * @param elements IElement[]
	 * @return IElement[]
	 */
	public static final IElement[] checkoutElementNull(final IElement[] elements) {
		final int len = elements.length;
		int wellSort = 0, i;
		IElement p = null;
		for (i = 0; i < len; i++)
			if ((p = elements[i]) != null) wellSort++;
		final IElement[] newElements = new IElement[wellSort];
		for (i = wellSort = 0; i < len; i++)
			if ((p = elements[i]) != null) newElements[wellSort++] = p;
		return newElements;
	}

	/**
	 * 单元组排序[不改变源组，生成新组](过滤null单元)
	 * @param elements IElement[]
	 * @param reverse boolean 是否是倒序
	 * @return IElement[]
	 */
	public static final IElement[] elementCompositor(final IElement[] elements, final boolean reverse) {
		final int len = elements.length;
		final IElement[] newElements = checkoutElementNull(elements);
		//System.arraycopy(elements, 0, newElements, 0, len);
		IElement p = null;
		for (int i = 0, ii; i < (len - 1); i++)
			for (ii = i + 1; ii < len; ii++)
				if ((reverse && newElements[i].elementLength() < newElements[ii].elementLength()) || ((!reverse) && newElements[i].elementLength() > newElements[ii].elementLength())) {
					/* 进行交换 */
					p = newElements[i];
					newElements[i] = newElements[ii];
					newElements[ii] = p;
				}
		return newElements;
	}

}
