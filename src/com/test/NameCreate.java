package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 起名器， 主要是起中文名字，包括2字，或者3字,或者4字
 * 
 * @version 1.0 2017-12-28
 * @author hy
 * 
 */
public class NameCreate {
	// 多少个名字
	private final static int nameCollectionCount = 10;

	private static String[] firstname = { "赵", "钱", "孙", "李", "周", "吴", "郑",
			"王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
			"何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚",
			"谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范",
			"彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁",
			"柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤",
			"滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮",
			"卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆",
			"萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明",
			"臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈",
			"项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾",
			"路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "锺", "徐",
			"邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支",
			"柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗",
			"丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔",
			"吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊",
			"於", "惠", "甄", "麴", "家", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜",
			"松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷",
			"车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁",
			"仇", "栾", "暴", "甘", "钭", "历", "戎", "祖", "武", "符", "刘", "景", "詹",
			"束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白",
			"怀", "蒲", "邰", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙",
			"池", "乔", "阳", "郁", "胥", "能", "苍", "双", "闻", "莘", "党", "翟", "谭",
			"贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却", "璩",
			"桑", "桂", "濮", "牛", "寿", "通", "边", "扈", "燕", "冀", "僪", "浦", "尚",
			"农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习",
			"宦", "艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨",
			"居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广", "禄",
			"阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍",
			"聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空",
			"曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查",
			"后", "荆", "红", "游", "竺", "权", "逮", "盍", "益", "桓", "公", "召", "有",
			"舜", "丛", "岳", "寸", "贰", "皇", "侨", "彤", "竭", "端", "赫", "实", "甫",
			"集", "象", "翠", "狂", "辟", "典", "良", "函", "芒", "苦", "其", "京", "中",
			"夕", "之", "冠", "宾", "香", "果", "蹇", "称", "诺", "来", "多", "繁", "戊",
			"朴", "回", "毓", "税", "荤", "靖", "绪", "愈", "硕", "牢", "买", "但", "巧",
			"枚", "撒", "泰", "秘", "亥", "绍", "以", "壬", "森", "斋", "释", "奕", "姒",
			"朋", "求", "羽", "用", "占", "真", "穰", "翦", "闾", "漆", "贵", "代", "贯",
			"旁", "崇", "栋", "告", "休", "褒", "谏", "锐", "皋", "闳", "在", "歧", "禾",
			"示", "是", "委", "钊", "频", "嬴", "呼", "大", "威", "昂", "律", "冒", "保",
			"系", "抄", "定", "化", "莱", "校", "么", "抗", "祢", "綦", "悟", "宏", "功",
			"庚", "务", "敏", "捷", "拱", "兆", "丑", "丙", "畅", "苟", "随", "类", "卯",
			"俟", "友", "答", "乙", "允", "甲", "留", "尾", "佼", "玄", "乘", "裔", "延",
			"植", "环", "矫", "赛", "昔", "侍", "度", "旷", "遇", "偶", "前", "由", "咎",
			"塞", "敛", "受", "泷", "袭", "衅", "叔", "圣", "御", "夫", "仆", "镇", "藩",
			"邸", "府", "掌", "首", "员", "焉", "戏", "可", "智", "尔", "凭", "悉", "进",
			"笃", "厚", "仁", "业", "肇", "资", "合", "仍", "九", "衷", "哀", "刑", "俎",
			"仵", "圭", "夷", "徭", "蛮", "汗", "孛", "乾", "帖", "罕", "洛", "淦", "洋",
			"邶", "郸", "郯", "邗", "邛", "剑", "虢", "隋", "蒿", "茆", "菅", "苌", "树",
			"桐", "锁", "钟", "机", "盘", "铎", "斛", "玉", "线", "针", "箕", "庹", "绳",
			"磨", "蒉", "瓮", "弭", "刀", "疏", "牵", "浑", "恽", "势", "世", "仝", "同",
			"蚁", "止", "戢", "睢", "冼", "种", "涂", "肖", "己", "泣", "潜", "卷", "脱",
			"谬", "蹉", "赧", "浮", "顿", "说", "次", "错", "念", "夙", "斯", "完", "丹",
			"表", "聊", "源", "姓", "吾", "寻", "展", "出", "不", "户", "闭", "才", "无",
			"书", "学", "愚", "本", "性", "雪", "霜", "烟", "寒", "少", "字", "桥", "板",
			"斐", "独", "千", "诗", "嘉", "扬", "善", "揭", "祈", "析", "赤", "紫", "青",
			"柔", "刚", "奇", "拜", "佛", "陀", "弥", "阿", "素", "长", "僧", "隐", "仙",
			"隽", "宇", "祭", "酒", "淡", "塔", "琦", "闪", "始", "星", "南", "天", "接",
			"波", "碧", "速", "禚", "腾", "潮", "镜", "似", "澄", "潭", "謇", "纵", "渠",
			"奈", "风", "春", "濯", "沐", "茂", "英", "兰", "檀", "藤", "枝", "检", "生",
			"折", "登", "驹", "骑", "貊", "虎", "肥", "鹿", "雀", "野", "禽", "飞", "节",
			"宜", "鲜", "粟", "栗", "豆", "帛", "官", "布", "衣", "藏", "宝", "钞", "银",
			"门", "盈", "庆", "喜", "及", "普", "建", "营", "巨", "望", "希", "道", "载",
			"声", "漫", "犁", "力", "贸", "勤", "革", "改", "兴", "亓", "睦", "修", "信",
			"闽", "北", "守", "坚", "勇", "汉", "练", "尉", "士", "旅", "五", "令", "将",
			"旗", "军", "行", "奉", "敬", "恭", "仪", "母", "堂", "丘", "义", "礼", "慈",
			"孝", "理", "伦", "卿", "问", "永", "辉", "位", "让", "尧", "依", "犹", "介",
			"承", "市", "所", "苑", "杞", "剧", "第", "零", "谌", "招", "续", "达", "忻",
			"六", "鄞", "战", "迟", "候", "宛", "励", "粘", "萨", "邝", "覃", "辜", "初",
			"楼", "城", "区", "局", "台", "原", "考", "妫", "纳", "泉", "老", "清", "德",
			"卑", "过", "麦", "曲", "竹", "百", "福", "言", "佟", "爱", "年", "笪", "谯",
			"哈", "墨", "赏", "伯", "佴", "佘", "牟", "商", "琴", "后", "况", "亢", "缑",
			"帅", "海", "归", "钦", "鄢", "汝", "法", "闫", "楚", "晋", "督", "仉", "盖",
			"逯", "库", "郏", "逢", "阴", "薄", "厉", "稽", "开", "光", "操", "瑞", "眭",
			"泥", "运", "摩", "伟", "铁", "迮" };
	/**
	 * 用于取一个2字的女性名
	 */
	private static String[] lastnameWomenOne = { "筠", "柔", "竹", "霭", "凝", "晓",
			"欢", "霄", "枫", "芸", "菲", "寒", "伊", "亚", "宜", "可", "姬", "舒", "影",
			"荔", "枝", "思", "丽", "秀", "娟", "英", "华", "慧", "巧", "美", "娜", "静",
			"淑", "惠", "珠", "翠", "雅", "芝", "玉", "萍", "红", "娥", "玲", "芬", "芳",
			"燕", "彩", "春", "菊", "勤", "珍", "贞", "莉", "兰", "凤", "洁", "梅", "琳",
			"素", "云", "莲", "真", "环", "雪", "荣", "爱", "妹", "霞", "香", "月", "莺",
			"媛", "艳", "瑞", "凡", "佳", "嘉", "琼", "桂", "娣", "叶", "璧", "璐", "娅",
			"琦", "晶", "妍", "茜", "秋", "珊", "莎", "锦", "黛", "青", "倩", "婷", "姣",
			"婉", "娴", "瑾", "颖", "露", "瑶", "怡", "婵", "雁", "蓓", "纨", "仪", "荷",
			"丹", "蓉", "眉", "君", "琴", "蕊", "薇", "菁", "梦", "岚", "苑", "婕", "馨",
			"瑗", "琰", "韵", "融", "园", "艺", "咏", "卿", "聪", "澜", "纯", "毓", "悦",
			"昭", "冰", "爽", "琬", "茗", "羽", "希", "宁", "欣", "飘", "育", "滢", "馥",
			"楠" };
	/**
	 * 用于取一个3字的女性名
	 */
	private static String[] lastnameWomenTwo = { "梦琪", "忆柳", "之桃", "慕青", "问兰",
			"尔岚", "元香", "初夏", "沛菡", "傲珊", "曼文", "乐菱", "痴珊", "恨玉", "惜文", "香寒",
			"新柔", "语蓉", "海安", "夜蓉", "涵柏", "水桃", "醉蓝", "春儿", "语琴", "从彤", "傲晴",
			"语兰", "又菱", "碧彤", "元霜", "怜梦", "紫寒", "妙彤", "曼易", "南莲", "紫翠", "雨寒",
			"易烟", "如萱", "若南", "寻真", "晓亦", "向珊", "慕灵", "以蕊", "寻雁", "映易", "雪柳",
			"孤岚", "笑霜", "海云", "凝天", "沛珊", "寒云", "冰旋", "宛儿", "绿真", "盼儿", "晓霜",
			"碧凡", "夏菡", "曼香", "若烟", "半梦", "雅绿", "冰蓝", "灵槐", "平安", "书翠", "紫山",
			"千琴", "恨天", "傲芙", "盼山", "怀蝶", "冰兰", "山柏", "翠萱", "恨松", "问旋", "从南",
			"白易", "问筠", "如霜", "半芹", "丹珍", "冰彤", "亦寒", "寒雁", "怜云", "寻文", "乐丹",
			"翠柔", "谷山", "之瑶", "冰露", "尔珍", "谷雪", "乐萱", "涵菡", "海莲", "傲蕾", "青槐",
			"冬儿", "易梦", "惜雪", "宛海", "之柔", "夏青", "亦瑶", "妙菡", "春竹", "痴梦", "紫蓝",
			"晓巧", "幻柏", "元风", "冰枫", "访蕊", "南春", "芷蕊", "凡蕾", "凡柔", "安蕾", "天荷",
			"含玉", "书兰", "雅琴", "书瑶", "听兰", "听蓉", "语芙", "夏彤", "凌瑶", "忆翠", "幻灵",
			"怜菡", "紫南", "依珊", "妙竹", "访烟", "怜蕾", "映寒", "友绿", "冰萍", "惜霜", "凌香",
			"芷蕾", "雁卉", "迎梦", "元柏", "代萱", "紫真", "千青", "凌寒", "紫安", "寒安", "怀蕊",
			"秋荷" };
	/**
	 * 用于取一个3字的男性名
	 */
	private static String[] lastnameManTwo = { "理", "颜", "生", "伦", "方", "曦",
			"蓝", "和", "荣", "亮", "岚", "晗", "畅", "晨", "昌", "绍", "略", "昭", "泓",
			"皓", "毅", "豪", "驰", "津", "威", "金", "刚", "沣", "臻", "雨", "欣", "鸿",
			"政", "达", "名", "川", "材", "成", "嘉", "立", "廷", "增", "济", "震", "钦",
			"韬", "璟", "竹", "文", "涛", "永", "翔", "洁", "利", "序", "谱", "海", "新",
			"景", "跃", "琪", "宏", "希", "俊", "功", "采", "风", "瀚", "耀", "双", "宝",
			"恒", "伟", "富", "大", "英", "智", "照", "怡", "学", "腾", "庆", "焘", "先",
			"晟", "亿", "凤", "盛", "帅", "亦", "乐", "锋", "铭", "罡", "亭", "凯", "仁",
			"靖", "辰", "悦", "栋", "群", "轩", "垒", "华", "誉", "备", "科", "珑", "建",
			"笑", "波", "益", "至", "易", "万", "诗", "元", "宣", "旭", "胜", "进", "才",
			"骁", "溓", "洪", "歌", "兴", "东", "峰", "章", "坤", "凡", "聪", "来", "贤",
			"阳", "韦", "言", "飞", "振", "钢", "奎", "宁", "丰", "广", "朔", "钧", "升",
			"超", "国", "珺", "选", "霖", "士", "锦", "霆", "映", "哲", "崇", "恩", "云",
			"泰", "崊", "淼", "诚", "高", "月", "健", "晔", "航", "庭", "雄", "之", "谦",
			"策", "咏", "鹏", "启", "彦", "冬", "时", "州", "牧", "堂", "奇", "彰", "福",
			"艺", "业", "义", "聚", "磊", "镇", "博", "连", "尧", "浩", "溪", "越", "宜",
			"家", "辉", "礼", "春", "函", "洲", "志", "星", "励", "锐", "禾", "蔚", "登",
			"丞", "强", "全", "传", "宇", "世", "纪", "然", "洋", "巩", "展", "佳", "敖",
			"顺", "鑫", "朋", "圣", "民", "瑞", "可", "睿", "齐", "岩", "晓", "森", "子",
			"影", "向", "望", "宪", "起", "充", "祥", "骅", "隆", "斌", "玉", "忠", "江",
			"滔", "涵", "维", "虹", "迎", "同", "与", "帆", "安", "议", "意", "儒", "卫",
			"梓", "迅", "舜", "德", "友", "佚", "瑜", "基", "衡", "韵", "良", "明", "泊",
			"骏", "山", "钊", "献", "清", "纶", "林", "蒙", "正", "琛", "为", "语", "军",
			"平", "勇", "昊", "兵", "谊", "源", "远", "朗", "邦", "奕", "祖", "泽", "中",
			"城", "蕾", "融", "谋", "冠", "信", "力", "灿", "炎", "灵", "灼", "炜", "炬",
			"烽", "煌", "焯", "烨", "琰", "日", "明", "晴", "昕", "明", "昀", "映", "旺",
			"晓", "昵", "昭", "晔", "晚", "暖", "晰", "曙", "曜", "晗", "旭", "昶", "阳",
			"早", "旦", "昆", "昊", "昇", "易", "昂", "昌", "晶", "炅", "景", "颢", "显",
			"昱", "晃", "晁", "晨", "曼", "晋", "智", "昔", "昙", "旻", "晟", "可", "叮",
			"吉", "合", "同", "君", "启", "呆", "叶", "嗯", "哼", "宝", "咚", "呱", "安",
			"宇", "宜", "宙", "宣", "密", "歌", "芸", "莫", "英", "竺", "迅", "彬", "茨",
			"荣", "莱", "莲", "莳", "莹", "莺" };

	private static class SEX {
		private static final String MAN = "1";
		private static final String WOMEN = "2";
	}

	private static class NAMELENG {
		private static final int TWO = 2;
		private static final int THREE = 3;
	}

	private NameCreate() {
	}

	private static NameCreate singleInstance;

	private static NameCreate getInstance() {
		if (singleInstance == null) {
			singleInstance = new NameCreate();
		}
		return singleInstance;
	}

	private static Random random = new java.util.Random();

	/**
	 * 起名器，可以取2字，3字,可能是男名，可能是女名
	 */
	@SuppressWarnings("unchecked")
	public List getUniqueName() {
		List<String> nameList = new ArrayList<String>(
				NameCreate.nameCollectionCount);
		try {
			// 起男孩名
			int manCount = random.nextInt(NameCreate.nameCollectionCount) + 1;
			nameList.addAll(getManName(manCount, NameCreate.SEX.MAN));
			// 起女孩名
			nameList.addAll(getManName(NameCreate.nameCollectionCount
					- manCount, NameCreate.SEX.WOMEN));
		} catch (Exception e) {
			System.out.println("发生异常，" + e.getMessage());
		}
		return nameList;
	}

	/**
	 * 取男名
	 * 
	 * @param manCount
	 * @return
	 */
	private static String nameValue = "";

	@SuppressWarnings("unchecked")
	public List getManName(int manCount, String sex) throws Exception {
		int twoCount = 0;
		List manList = new ArrayList(manCount);
		// 起3字中姓名的个数
		int threeManCount = random.nextInt(manCount + 1);
		twoCount = manCount - threeManCount;
		Name manName = new Name(threeManCount, NAMELENG.THREE, sex);
		getNameByCount(manList, manName);
		Name manName2 = new Name(twoCount, NAMELENG.TWO, sex);
		getNameByCount(manList, manName2);
		return manList;
	}

	/**
	 * 起名字，男女， 2字3字名
	 * 
	 * @param manList
	 * @param count
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List getNameByCount(List<Map<String, String>> manList, Name nameObj)
			throws Exception {
		int count = nameObj.getCount();
		int twoIndex = 0, threeIndex = 0;
		if (nameObj.getNameLength() != NameCreate.NAMELENG.TWO
				&& nameObj.getNameLength() != NameCreate.NAMELENG.THREE) {
			throw new java.lang.IllegalArgumentException(
					"发生错误，姓名的长度未设置，请设置，长度有2或者3.");
		}
		while (count > 0) {
			// 男
			if (nameObj.getSex().equals(NameCreate.SEX.MAN)) {
				nameValue = firstname[random.nextInt(firstname.length)];
				twoIndex = random.nextInt(lastnameManTwo.length);
				nameValue += lastnameManTwo[twoIndex];
				if (nameObj.getNameLength() == NameCreate.NAMELENG.THREE) {
					threeIndex = random.nextInt(lastnameManTwo.length);
					while (threeIndex == twoIndex) {
						threeIndex = random.nextInt(lastnameManTwo.length);
					}
					nameValue += lastnameManTwo[threeIndex];
				}
			} else { // 女
				nameValue = firstname[random.nextInt(firstname.length)];
				// 2字还是3字
				if (nameObj.getNameLength() == NameCreate.NAMELENG.TWO) {
					twoIndex = random.nextInt(lastnameWomenOne.length);
					nameValue += lastnameWomenOne[twoIndex];
				} else if (nameObj.getNameLength() == NameCreate.NAMELENG.THREE) {
					twoIndex = random.nextInt(lastnameWomenTwo.length);
					nameValue += lastnameWomenTwo[twoIndex];
				}
			}
			Name tempNameObj = new Name(nameObj.getSex(), nameValue);
			Map<String, String> nameMap = new HashMap<String, String>();
			nameMap.put("name", tempNameObj.getNameValue());
			nameMap.put("sex", tempNameObj.getSex());
			manList.add(nameMap);
			count--;
		}
		return manList;
	}

	public static void main(String[] args) {
		System.out.println(NameCreate.getInstance().getUniqueName());
	}

}
