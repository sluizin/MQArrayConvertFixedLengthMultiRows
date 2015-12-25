package testMQArrayConvertFixedLengthMultiRows;

import org.junit.Test;

import common.Rnd;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.ElementParameter;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.IElement;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.MQArrayConvertFixedLengthMultiRows;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.UtilTool;

public class test {

	@Test
	public void test1() {
		int maxlength = 10;
		newclass[] newarray = new newclass[maxlength];
		for (int i = 0; i < maxlength; i++) {
			newarray[i] = new newclass("" + i, Rnd.getRndInt(1, maxlength));
		}
		to(newarray);
		IElement[] newarrays = UtilTool.elementCompositor(newarray, true);
		//输出
		to(newarrays);
		
		MQArrayConvertFixedLengthMultiRows MQACFLMR=new MQArrayConvertFixedLengthMultiRows();
		ElementParameter paramenter = new ElementParameter();
		paramenter.setRowLength(10);
		paramenter.setIntervalLength(2);
		paramenter.setOffset(3);
		MQACFLMR.setParamenter(paramenter);
		IElement[][] convertArray=MQACFLMR.convertArray(newarrays);
		//输出
		to(convertArray);
	}

	public final void to(IElement[][] elements) {
		for (int i = 0; i < elements.length; i++){
			for (int ii = 0; ii < elements[i].length; ii++)
				System.out.println(i + "-"+ ii +"\t:" + elements[i][ii].toString());
			System.out.println("==============================================");
		}
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
