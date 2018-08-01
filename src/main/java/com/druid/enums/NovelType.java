package com.druid.enums;

public enum NovelType {
/**
 * 武侠小说
 */
type1("武侠小说",1),
/**
 * 玄幻小说
 */
type2("玄幻小说",2),
/**
 * 都市言情
 */
type3("都市言情",3),
/**
 * 恐怖灵异
 */
type4("恐怖灵异",4),
/**
 * 现代文学
 */
type5("现代文学",5),
/**
 * 侦探推理
 */
type6("侦探推理",6),
/**
 * 科幻小说
 */
type7("科幻小说",7),
/**
 * 穿越架空
 */
type8("穿越架空",8),
/**
 * 古典名著
 */
type9("古典名著",9),
/**
 * 历史军事
 */
type10("历史军事",10),
/**
 * 网游小说
 */
type11("网游小说",11),
/**
 * 其他
 */
type12("其他",12);

private String name;
private Integer value;


private NovelType() {
}

private NovelType(String name, Integer value) {
	this.name = name;
	this.value = value;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getValue() {
	return value;
}
public void setValue(Integer value) {
	this.value = value;
}


}
