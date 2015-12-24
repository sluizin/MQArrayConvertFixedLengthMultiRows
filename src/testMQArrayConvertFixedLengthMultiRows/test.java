package testMQArrayConvertFixedLengthMultiRows;

import org.junit.Test;

import common.Rnd;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.IElement;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.MQArrayConvertFixedLengthMultiRows;

public class test {

	@Test
	public void test1() {
		int maxlength = 7;
		newclass[] newarray = new newclass[maxlength];
		for (int i = 0; i < maxlength; i++) {
			newarray[i] = new newclass("" + i, Rnd.getRndInt(1, maxlength));
		}
		to(newarray);
		IElement[] newarrays = MQArrayConvertFixedLengthMultiRows.elementCompositor(newarray, true);
		to(newarrays);
	}

	public final void to(IElement[] elements) {
		for (int i = 0; i < elements.length; i++)
			System.out.println(i + "\t:" + elements[i].toString());
		System.out.println("==============================================");

	}

	public class newclass implements IElement {
		String name = "";
		int value = 10;

		public newclass(String name, int value) {
			this.name = name;
			this.value = value;
		}

		public int elementLength() {
			return value;
		}

		@Override
		public String toString() {
			return "[name=" + name + "\t, value=" + value + "]";
		}

	}
}
