package testMQArrayConvertFixedLengthMultiRows;

import org.junit.Test;

import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.ElementParameter;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.IElement;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.MQArrayConvertFixedLengthMultiRows;
import MaQiao.MaQiaoArrayConvertFixedLengthMultiRows.UtilTool;

public class test {

	@Test
	public void test1() {
		//获取数据
		newclass[] newarray = getnewclass();
		//初步显示
		to(newarray);
		//单元组排序
		IElement[] newarrays = UtilTool.elementCompositor(newarray, true);
		//排序后的输出
		to(newarrays);
		//开始进行计算
		MQArrayConvertFixedLengthMultiRows MQACFLMR = new MQArrayConvertFixedLengthMultiRows();
		//设置参数
		ElementParameter paramenter = new ElementParameter();
		{
			paramenter.setRowLength(190);
			paramenter.setIntervalLength(2);
			paramenter.setOffset(3);
		}
		//参数导入
		MQACFLMR.setParamenter(paramenter);
		//得到结果
		IElement[][] convertArray = MQACFLMR.convertArray(newarrays);
		//显示长度范围
		{
			System.out.println("[" + paramenter.lengthMin() + "----" + paramenter.lengthMax() + "]");
			System.out.println("----------");
		}
		//to(convertArray);
		//输出结果
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

	/**
	 * 获取源数据
	 * @return newclass[]
	 */
	public final newclass[] getnewclass() {
		/*		
		 * String[] chaArray = { "壹读", "中华人民共和国教育部", "重庆晚报", "红网", "南海网", "内蒙古农业大学职业技术学院", "药草园", "中青在线", "中国教育在线", "健雄职业技术学院", "新华网", "焦作大学", "白求恩医科大学北京校友会", "北京晨报", "114团购网", "百度搜索", "万通公益基金会",
						"中国红十字基金会", "九江职业大学", "中国扶贫基金会", "中华慈善网", "大河网", "修正药业", "中国机械网", "中国家具网", "中国水泥网", "卓越网", "腾讯", "中国网库", "电影网", "壹基金", "腾讯公益网", "中国绿化基金会" };
				
				*/
		/**
		 * 99114官网友情链接
		 */
		final String[] chaArray = { "B2B", "单品网", "OFweek电子工程网", "酒代理", "网上轻纺城", "五金", "商路通", "日本亚马逊", "环球鞋网", "食品商务网", "爱喇叭网", "中国金属新闻网", "玻璃网", "维库仪器仪表网", "007商务站", "中关村商城", "项目加盟网", "食品代理", "商机网",
				"服装批发", "环球贸易网", "阿土伯交易网", "市场研究报告", "铁甲论坛", "中国企业黄页网", "中国供应商", "五金商机网", "创业贷款", "首商网", "大蒜价格", "报纸广告", "万贯五金机电网", "前瞻数据", "中亚商务网", "中国会展门户", "就是要仪器", "外汇投资", "跨国采购网", "中华企业录",
				"中国黄页网", "铝", "华侨路茶坊", "万国企业网", "全球采购网", "企业保险", "铝锭价格", "零度网", "工程机械", "女装批发", "志趣网", "网络电台", "中国ic网", "慧聪网", "云同盟", "商机网", "优质企商网", "搜房深圳二手房", "B2B电子商务", "中国企业链", "跨国采购网", "品牌特卖",
				"第一企业网", "园林", "物流", "火车票", "免费法律咨询", "装修网", "二手设备", "化妆品招商网" };
		final int maxlength = chaArray.length;
		//为简便计，把所有名称对应的等级，放在一个数值新组中。
		final int[] arrayLevel = new int[maxlength];
		arrayLevel[0] = 120;
		arrayLevel[1] = 100;
		arrayLevel[4] = 95;
		arrayLevel[7] = 27;
		arrayLevel[9] = 90;
		arrayLevel[14] = 10;
		arrayLevel[19] = 58;
		arrayLevel[28] = 66;
		arrayLevel[40] = 21;
		final newclass[] array = new newclass[maxlength];
		for (int i = 0; i < maxlength; i++)
			array[i] = new newclass(chaArray[i], arrayLevel[i]);
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
		private int Level = 0;

		public newclass(String name, int Level) {
			this.name = name;
			this.value = UtilTool.getBytesLength(name);
			this.Level = Level;
		}

		public int elementLength() {
			return this.value;
		}

		@Override
		public String toString() {
			return "newclass [value=" + value + "\t, Level=" + Level + "\t,name=" + name + " ]";
		}

		@Override
		public String elementString() {
			return this.name;
		}

		@Override
		public int elementLevel() {
			return this.Level;
		}

	}
}
