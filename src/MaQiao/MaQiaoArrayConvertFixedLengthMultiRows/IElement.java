package MaQiao.MaQiaoArrayConvertFixedLengthMultiRows;

/**
 * 单元接口
 * @author Sunjian
 * @version 1.0
 * @since 1.7
 */
public interface IElement {
	/**
	 * 单元长度
	 * @return int
	 */
	public int elementLength();

	/**
	 * 单元等级(数值越大，等级越高，排序越前)
	 * @return int
	 */
	public int elementLevel();

	/**
	 * 单元标识
	 * @return String
	 */
	public String elementString();
}
