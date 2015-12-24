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
	 * 是否允许溢出 是否 >(rowLength + offset)
	 */
	boolean isAllowOverflow = false;
	/**
	 * 是否允许低量 是否 <(rowLength - offset)
	 */
	boolean isAllowLowvolume = true;

	/**
	 * 最小长度
	 * @return int
	 */
	public final int lengthMin() {
		return rowLength - offset;
	}

	/**
	 * 最大长度
	 * @return int
	 */
	public final int lengthMax() {
		return rowLength + offset;
	}

	public final int getRowLength() {
		return rowLength;
	}

	public final void setRowLength(final int rowLength) {
		this.rowLength = rowLength;
	}

	public final int getIntervalLength() {
		return intervalLength;
	}

	public final void setIntervalLength(final int intervalLength) {
		this.intervalLength = intervalLength;
	}

	public final int getOffset() {
		return offset;
	}

	public final void setOffset(final int offset) {
		this.offset = offset;
	}

	public final boolean isAllowOverflow() {
		return isAllowOverflow;
	}

	public final void setAllowOverflow(final boolean isAllowOverflow) {
		this.isAllowOverflow = isAllowOverflow;
	}

	public final boolean isAllowLowvolume() {
		return isAllowLowvolume;
	}

	public final void setAllowLowvolume(final boolean isAllowLowvolume) {
		this.isAllowLowvolume = isAllowLowvolume;
	}

}
