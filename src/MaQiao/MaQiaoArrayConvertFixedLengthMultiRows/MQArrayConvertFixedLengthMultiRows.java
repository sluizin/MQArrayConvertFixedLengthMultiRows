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
	ElementParameter paramenter;

	/**
	 * 把单元组转换成多行单元 List
	 * @param elements IElement[]
	 * @return List < ArrayList < IElement > >
	 */
	public final List<ArrayList<IElement>> convertList(final IElement[] elements) {
		if (elements.length == 0) return null;
		final IElement[] newElements = UtilTool.elementCompositor(elements, true);
		final int len = newElements.length;
		List<ArrayList<IElement>> resultArray = new ArrayList<ArrayList<IElement>>(len);
		for (int i = 0; i < len; i++) {
			IElement p = newElements[i];
			//System.out.println("-->"+p.elementLength());
			elementInert(resultArray, p);
		}
		return resultArray;
	}

	private final void elementInert(final List<ArrayList<IElement>> elementList, final IElement e) {
		final int lenA = elementList.size();
		final int para_lengthMax = this.paramenter.lengthMax();
		final int para_lengthInterval = this.paramenter.intervalLength;
		int surplusLen = 0, e_len = e.elementLength();
		for (int i = 0; i < lenA; i++) {
			ArrayList<IElement> p = elementList.get(i);
			surplusLen = para_lengthMax - listElementLength(p);
			if (surplusLen <= 0) continue;
			/* 如果此行有空位置，则加入到此行中 */
			if (surplusLen >= (e_len + para_lengthInterval)) {
				p.add(e);
				return;
			}
		}
		/* 如果没有空位置，则新加一行 */
		final ArrayList<IElement> f = new ArrayList<IElement>(1);
		f.add(e);
		elementList.add(f);
	}

	/**
	 * 判断某行的长度 n个单元长度总和+(n-1)个间隔
	 * @param elementList ArrayList< IElement >
	 * @return int
	 */
	public final int listElementLength(final ArrayList<IElement> elementList) {
		int sort = 0;
		int len = elementList.size();
		if (len == 0) return 0;
		IElement p = null;
		for (int i = 0; i < len; i++) {
			if ((p = elementList.get(i)) == null) continue;
			sort += p.elementLength();
			if (i > 0) sort += this.paramenter.intervalLength;
		}
		return sort;
	}

	/**
	 * 把单元组转换成多行单元组
	 * @param elements IElement[]
	 * @return IElement[][]
	 */
	public final IElement[][] convertArray(final IElement[] elements) {
		return UtilTool.ListConvertArrays(convertList(elements));
	}

	/**
	 * 检查源单元数组，如果发现有超长的单元，并参数里限制不允许出现超长，则删除此单元<br/>
	 * 注意：如果单元数组中含有null,则进行过滤<br/>
	 * @param elements IElement[]
	 * @return IElement[]
	 */
	public final IElement[] checkElement(final IElement[] elements) {
		final int len = elements.length;
		int wellSort = 0, i;
		final int maxLength = this.paramenter.lengthMax();
		IElement p = null;
		for (i = 0; i < len; i++)
			if ((p = elements[i]) != null && ((!this.paramenter.isAllowOverflow) && p.elementLength() <= maxLength)) wellSort++;
		final IElement[] newElements = new IElement[wellSort];
		for (i = wellSort = 0; i < len; i++)
			if ((p = elements[i]) != null && ((!this.paramenter.isAllowOverflow) && p.elementLength() <= maxLength)) newElements[wellSort++] = elements[i];
		return newElements;
	}

	public final ElementParameter getParamenter() {
		return paramenter;
	}

	public final void setParamenter(final ElementParameter paramenter) {
		this.paramenter = paramenter;
	}

}
