package com.druid.enums;

public enum NovelType {
/**
 * ����С˵
 */
type1("����С˵",1),
/**
 * ����С˵
 */
type2("����С˵",2),
/**
 * ��������
 */
type3("��������",3),
/**
 * �ֲ�����
 */
type4("�ֲ�����",4),
/**
 * �ִ���ѧ
 */
type5("�ִ���ѧ",5),
/**
 * ��̽����
 */
type6("��̽����",6),
/**
 * �ƻ�С˵
 */
type7("�ƻ�С˵",7),
/**
 * ��Խ�ܿ�
 */
type8("��Խ�ܿ�",8),
/**
 * �ŵ�����
 */
type9("�ŵ�����",9),
/**
 * ��ʷ����
 */
type10("��ʷ����",10),
/**
 * ����С˵
 */
type11("����С˵",11),
/**
 * ����
 */
type12("����",12);

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
