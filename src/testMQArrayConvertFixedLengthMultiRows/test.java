package testMQArrayConvertFixedLengthMultiRows;

import org.junit.Test;

import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.ElementParameter;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.IElement;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.MQArrayConvertFixedLengthMultiRows;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.UtilTool;

public class test {

	@Test
	public void test1() {
		newclass[] newarray = getnewclass();
		to(newarray);
		IElement[] newarrays = UtilTool.elementCompositor(newarray, true);
		//输出
		to(newarrays);
		MQArrayConvertFixedLengthMultiRows MQACFLMR = new MQArrayConvertFixedLengthMultiRows();
		ElementParameter paramenter = new ElementParameter();
		{
			paramenter.setRowLength(38);
			paramenter.setIntervalLength(2);
			paramenter.setOffset(3);
		}
		MQACFLMR.setParamenter(paramenter);
		IElement[][] convertArray = MQACFLMR.convertArray(newarrays);
		//输出
		System.out.println("[" + paramenter.lengthMin() + "----" + paramenter.lengthMax() + "]");
		System.out.println("----------");
		to(convertArray);
		to(convertArray, paramenter);
		/*		{
					String k1;
					k1="bc中国a";
					System.out.println(k1+"=="+UtilTool.getBytesLength(k1));
					k1="百度搜索";
					System.out.println(k1+"=="+UtilTool.getBytesLength(k1));
					
				}*/
	}

	public final void to(IElement[][] elements) {
		for (int i = 0; i < elements.length; i++) {
			int sort = 0;
			for (int ii = 0; ii < elements[i].length; ii++) {
				System.out.println(i + "-" + ii + "\t:" + elements[i][ii].toString());
				sort += elements[i][ii].elementLength();
			}
			System.out.println((sort + (elements[i].length - 1) * 2));
			System.out.println("==============================================");
		}
	}

	public final void to(IElement[][] elements, final ElementParameter paramenter) {
		int sort = 0;
		for (int i = 0; i < elements.length; i++) {
			System.out.print(i + ":\t");
			{
				System.out.print("|");
				System.out.print(UtilTool.repleat("-", paramenter.lengthMin() - 1));
				System.out.print("+");
				System.out.print(UtilTool.repleat("-", paramenter.lengthMax() - paramenter.lengthMin()));
				System.out.print("|");
				System.out.println("");
			}
			System.out.print(i + ":\t");
			System.out.print("|");
			for (int ii = sort = 0; ii < elements[i].length; ii++) {
				if (ii > 0) {
					System.out.print(UtilTool.repleat(" ", paramenter.getIntervalLength()));
					sort += paramenter.getIntervalLength();
				}
				System.out.print(elements[i][ii].elementString());
				sort += elements[i][ii].elementLength();
			}
			System.out.print(UtilTool.repleat(" ", paramenter.lengthMax() - sort));
			System.out.println("|");
			//System.out.println("========================================");
		}
	}

	public final void to(IElement[] elements) {
		for (int i = 0; i < elements.length; i++)
			System.out.println(i + "\t:" + elements[i].toString());
		System.out.println("==============================================");
	}

	public final newclass[] getnewclass() {
		String[] chaArray = { "壹读", "中华人民共和国教育部", "重庆晚报", "红网", "南海网", "内蒙古农业大学职业技术学院", "药草园", "中青在线", "中国教育在线", "健雄职业技术学院", "新华网", "焦作大学", "白求恩医科大学北京校友会", "北京晨报", "114团购网", "百度搜索", "万通公益基金会",
				"中国红十字基金会", "九江职业大学", "中国扶贫基金会", "中华慈善网", "大河网", "修正药业", "中国机械网", "中国家具网", "中国水泥网", "卓越网", "腾讯", "中国网库", "电影网", "壹基金", "腾讯公益网", "中国绿化基金会" };
		final int maxlength = chaArray.length;
		newclass[] array = new newclass[maxlength];
		for (int i = 0; i < maxlength; i++)
			array[i] = new newclass(chaArray[i]);
		/*		for (int i = 0; i < maxlength; i++) {
				newarray[i] = new newclass("a中c" + Rnd.getRndInt(1, maxlength));
				System.out.println("ByteUtil:" + UtilTool.getBytesLength(newarray[i].name));
				System.out.println("length:" + newarray[i].name.getBytes().length);
				}
		*/return array;
	}

	private class newclass implements IElement {
		private String name = "";
		private int value = 0;

		public newclass(String name) {
			this.name = name;
			this.value = UtilTool.getBytesLength(name);
		}

		public int elementLength() {
			return this.value;
		}

		@Override
		public String toString() {
			return "[name=" + name + "\t, value=" + this.value + "]";
		}

		@Override
		public String elementString() {
			return this.name;
		}

	}
}
