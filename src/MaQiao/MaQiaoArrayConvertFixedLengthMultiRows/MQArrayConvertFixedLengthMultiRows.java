package MaQiao.MaQiaoArrayConvertFixedLengthMultiRows;

import java.util.ArrayList;
import java.util.List;

/**
 * 把单元组转换成多行单元组
 * @author Sunjian
 * @version 1.0
 * @since 1.7
 */
public final class MQArrayConvertFixedLengthMultiRows {
	/**
	 * 把单元组转换成多行单元 List
	 * @param elements IElement[]
	 * @param paramenter ElementParameter
	 * @return List < ArrayList < IElement > >
	 */
	public static final List<ArrayList<IElement>> convertList(final IElement[] elements, final ElementParameter paramenter) {
		if (elements.length == 0) return null;
		final IElement[] newElements = elementCompositor(elements, false);
		int len = newElements.length;
		List<ArrayList<IElement>> resultArray = new ArrayList<ArrayList<IElement>>(len);
		

		for (int point = 0; point < len; point++) {
			IElement p = newElements[point];
			if (paramenter.isAllowLowvolume) {
				continue;
			}
		}
		return resultArray;

	}
	/**
	 * 判断某行的长度 n个单元长度总和+(n-1)个间隔
	 * @param elementList
	 * @param paramenter
	 * @return
	 */
	public static final int checkLength(final ArrayList<IElement> elementList, final ElementParameter paramenter) {
		int sort = 0;
		int len = elementList.size();
		if (len == 0) return 0;
		IElement p = null;
		for (int i = 0; i < len; i++) {
			if ((p = elementList.get(i)) == null) continue;
			sort += p.elementLength();
			if (i > 0) sort += paramenter.intervalLength;
		}
		return sort;
	}

	/**
	 * 把单元组转换成多行单元组
	 * @param elements IElement[]
	 * @param paramenter ElementParameter
	 * @return IElement[][]
	 */
	public static final IElement[][] convertArray(final IElement[] elements, final ElementParameter paramenter) {
		return ListConvertArrays(convertList(elements, paramenter));
	}

	/**
	 * 检查源单元数组，如果发现有超长的单元，并参数里限制不允许出现超长，则删除此单元<br/>
	 * 注意：如果单元数组中含有null,则进行过滤<br/>
	 * @param elements IElement[]
	 * @param paramenter ElementParameter
	 * @return IElement[]
	 */
	public static final IElement[] checkElement(final IElement[] elements, final ElementParameter paramenter) {
		final int len = elements.length;
		int wellSort = 0, i;
		final int maxLength = paramenter.lengthMax();
		IElement p = null;
		for (i = 0; i < len; i++)
			if ((p = elements[i]) != null && ((!paramenter.isAllowOverflow) && p.elementLength() <= maxLength)) wellSort++;
		final IElement[] newElements = new IElement[wellSort];
		for (i = wellSort = 0; i < len; i++)
			if ((p = elements[i]) != null && ((!paramenter.isAllowOverflow) && p.elementLength() <= maxLength)) newElements[wellSort++] = elements[i];
		return newElements;
	}

	/**
	 * List < ArrayList < IElement > > 转成二维数组 IElement[][]<br/>
	 * @param listElement List< ArrayList < IElement > >
	 * @return IElement[][]
	 */
	public static final IElement[][] ListConvertArrays(final List<ArrayList<IElement>> listElement) {
		final int len = listElement.size();
		final IElement[][] newElementsArray = new IElement[len][];
		for (int i = 0; i < len; i++)
			newElementsArray[i] = (IElement[]) listElement.get(i).toArray();
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
