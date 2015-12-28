package MaQiao.MaQiaoArrayConvertFixedLengthMultiRows;

/**
 * 单元转换参数
 * @author Sunjian
 * @version 1.0
 * @since 1.7
 */
public final class ElementParameter {
	/**
	 * 每行长度 标准长度
	 */
	int rowLength = 100;
	/**
	 * 单元间隔 每个单元之间的长度
	 */
	int intervalLength = 0;
	/**
	 * 偏移量 (rowLength - offset) -- (rowLength + offset)
	 */
	int offset = 10;
	/**
	 * 是否允许溢出 是否 >(rowLength + offset) (在转换前过滤掉超出的单元)
	 */
	final boolean isAllowOverflow = false;
	/**
	 * 是否允许低量 是否 <(rowLength - offset) (暂未开发)
	 */
	final boolean isAllowLowvolume = true;

	/**
	 * 最小长度 rowLength - offset
	 * @return int
	 */
	public final int lengthMin() {
		return rowLength - offset;
	}

	/**
	 * 最大长度 rowLength + offset
	 * @return int
	 */
	public final int lengthMax() {
		return rowLength + offset;
	}

	/**
	 * 判断长度是允许 (暂未开发)<br/>
	 * 注意：不进行 (len >= lengthMin() && len <= lengthMax()) 区间判断 <br/>
	 * @param len int
	 * @return boolean
	 */
	@Deprecated
	public final boolean isAllow(final int len) {
		if (isAllowOverflow) return true;
		if (isAllowLowvolume && len < lengthMin()) return true;
		return false;
	}

	public final int getRowLength() {
		return rowLength;
	}

	/**
	 * 每行长度 标准长度
	 * @param rowLength int
	 */
	public final void setRowLength(final int rowLength) {
		this.rowLength = rowLength;
	}

	public final int getIntervalLength() {
		return intervalLength;
	}

	/**
	 * 单元间隔 每个单元之间的长度
	 * @param intervalLength int
	 */
	public final void setIntervalLength(final int intervalLength) {
		this.intervalLength = intervalLength;
	}

	public final int getOffset() {
		return offset;
	}

	/**
	 * 偏移量 (rowLength - offset) -- (rowLength + offset)
	 * @param offset int
	 */
	public final void setOffset(final int offset) {
		this.offset = offset;
	}

	public final boolean isAllowOverflow() {
		return isAllowOverflow;
	}

	public final boolean isAllowLowvolume() {
		return isAllowLowvolume;
	}

}
