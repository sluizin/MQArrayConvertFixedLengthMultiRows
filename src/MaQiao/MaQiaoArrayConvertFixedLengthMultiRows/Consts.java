package MaQiao.MaQiaoArrayConvertFixedLengthMultiRows;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 常量池 <br/>
 * @author Sun.jian(孙.健) <br/>
 * @category 常量池
 */
public final class Consts {
	public static final Unsafe UNSAFE;
	/**
	 * String对象中value(char[])地址偏移量
	 */
	public static long StringArrayOffset = 0L;
	static {
		try {
			final Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			UNSAFE = (Unsafe) field.get(null);
			StringArrayOffset = UNSAFE.objectFieldOffset(String.class.getDeclaredField("value"));/*得到String对象中数组的偏移量*/
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * char[]数组地址偏移量
	 */
	public static final long ArrayAddress = UNSAFE.arrayBaseOffset(char[].class);

}
