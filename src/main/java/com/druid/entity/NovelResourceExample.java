package com.druid.entity;

import java.util.ArrayList;
import java.util.List;

public class NovelResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NovelResourceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLinkTxtIsNull() {
            addCriterion("link_txt is null");
            return (Criteria) this;
        }

        public Criteria andLinkTxtIsNotNull() {
            addCriterion("link_txt is not null");
            return (Criteria) this;
        }

        public Criteria andLinkTxtEqualTo(String value) {
            addCriterion("link_txt =", value, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtNotEqualTo(String value) {
            addCriterion("link_txt <>", value, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtGreaterThan(String value) {
            addCriterion("link_txt >", value, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtGreaterThanOrEqualTo(String value) {
            addCriterion("link_txt >=", value, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtLessThan(String value) {
            addCriterion("link_txt <", value, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtLessThanOrEqualTo(String value) {
            addCriterion("link_txt <=", value, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtLike(String value) {
            addCriterion("link_txt like", value, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtNotLike(String value) {
            addCriterion("link_txt not like", value, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtIn(List<String> values) {
            addCriterion("link_txt in", values, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtNotIn(List<String> values) {
            addCriterion("link_txt not in", values, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtBetween(String value1, String value2) {
            addCriterion("link_txt between", value1, value2, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andLinkTxtNotBetween(String value1, String value2) {
            addCriterion("link_txt not between", value1, value2, "linkTxt");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIntroIsNull() {
            addCriterion("intro is null");
            return (Criteria) this;
        }

        public Criteria andIntroIsNotNull() {
            addCriterion("intro is not null");
            return (Criteria) this;
        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("intro =", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("intro <>", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("intro >", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("intro >=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("intro <", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("intro <=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLike(String value) {
            addCriterion("intro like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("intro not like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroIn(List<String> values) {
            addCriterion("intro in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotIn(List<String> values) {
            addCriterion("intro not in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("intro between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("intro not between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressIsNull() {
            addCriterion("link_resource_adress is null");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressIsNotNull() {
            addCriterion("link_resource_adress is not null");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressEqualTo(String value) {
            addCriterion("link_resource_adress =", value, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressNotEqualTo(String value) {
            addCriterion("link_resource_adress <>", value, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressGreaterThan(String value) {
            addCriterion("link_resource_adress >", value, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressGreaterThanOrEqualTo(String value) {
            addCriterion("link_resource_adress >=", value, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressLessThan(String value) {
            addCriterion("link_resource_adress <", value, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressLessThanOrEqualTo(String value) {
            addCriterion("link_resource_adress <=", value, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressLike(String value) {
            addCriterion("link_resource_adress like", value, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressNotLike(String value) {
            addCriterion("link_resource_adress not like", value, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressIn(List<String> values) {
            addCriterion("link_resource_adress in", values, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressNotIn(List<String> values) {
            addCriterion("link_resource_adress not in", values, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressBetween(String value1, String value2) {
            addCriterion("link_resource_adress between", value1, value2, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andLinkResourceAdressNotBetween(String value1, String value2) {
            addCriterion("link_resource_adress not between", value1, value2, "linkResourceAdress");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Long value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Long value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Long value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Long value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Long value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Long> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Long> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Long value1, Long value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Long value1, Long value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andPopularIsNull() {
            addCriterion("popular is null");
            return (Criteria) this;
        }

        public Criteria andPopularIsNotNull() {
            addCriterion("popular is not null");
            return (Criteria) this;
        }

        public Criteria andPopularEqualTo(Long value) {
            addCriterion("popular =", value, "popular");
            return (Criteria) this;
        }

        public Criteria andPopularNotEqualTo(Long value) {
            addCriterion("popular <>", value, "popular");
            return (Criteria) this;
        }

        public Criteria andPopularGreaterThan(Long value) {
            addCriterion("popular >", value, "popular");
            return (Criteria) this;
        }

        public Criteria andPopularGreaterThanOrEqualTo(Long value) {
            addCriterion("popular >=", value, "popular");
            return (Criteria) this;
        }

        public Criteria andPopularLessThan(Long value) {
            addCriterion("popular <", value, "popular");
            return (Criteria) this;
        }

        public Criteria andPopularLessThanOrEqualTo(Long value) {
            addCriterion("popular <=", value, "popular");
            return (Criteria) this;
        }

        public Criteria andPopularIn(List<Long> values) {
            addCriterion("popular in", values, "popular");
            return (Criteria) this;
        }

        public Criteria andPopularNotIn(List<Long> values) {
            addCriterion("popular not in", values, "popular");
            return (Criteria) this;
        }

        public Criteria andPopularBetween(Long value1, Long value2) {
            addCriterion("popular between", value1, value2, "popular");
            return (Criteria) this;
        }

        public Criteria andPopularNotBetween(Long value1, Long value2) {
            addCriterion("popular not between", value1, value2, "popular");
            return (Criteria) this;
        }

        public Criteria andLinkZipIsNull() {
            addCriterion("link_zip is null");
            return (Criteria) this;
        }

        public Criteria andLinkZipIsNotNull() {
            addCriterion("link_zip is not null");
            return (Criteria) this;
        }

        public Criteria andLinkZipEqualTo(String value) {
            addCriterion("link_zip =", value, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipNotEqualTo(String value) {
            addCriterion("link_zip <>", value, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipGreaterThan(String value) {
            addCriterion("link_zip >", value, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipGreaterThanOrEqualTo(String value) {
            addCriterion("link_zip >=", value, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipLessThan(String value) {
            addCriterion("link_zip <", value, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipLessThanOrEqualTo(String value) {
            addCriterion("link_zip <=", value, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipLike(String value) {
            addCriterion("link_zip like", value, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipNotLike(String value) {
            addCriterion("link_zip not like", value, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipIn(List<String> values) {
            addCriterion("link_zip in", values, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipNotIn(List<String> values) {
            addCriterion("link_zip not in", values, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipBetween(String value1, String value2) {
            addCriterion("link_zip between", value1, value2, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkZipNotBetween(String value1, String value2) {
            addCriterion("link_zip not between", value1, value2, "linkZip");
            return (Criteria) this;
        }

        public Criteria andLinkOtherIsNull() {
            addCriterion("link_other is null");
            return (Criteria) this;
        }

        public Criteria andLinkOtherIsNotNull() {
            addCriterion("link_other is not null");
            return (Criteria) this;
        }

        public Criteria andLinkOtherEqualTo(String value) {
            addCriterion("link_other =", value, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherNotEqualTo(String value) {
            addCriterion("link_other <>", value, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherGreaterThan(String value) {
            addCriterion("link_other >", value, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherGreaterThanOrEqualTo(String value) {
            addCriterion("link_other >=", value, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherLessThan(String value) {
            addCriterion("link_other <", value, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherLessThanOrEqualTo(String value) {
            addCriterion("link_other <=", value, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherLike(String value) {
            addCriterion("link_other like", value, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherNotLike(String value) {
            addCriterion("link_other not like", value, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherIn(List<String> values) {
            addCriterion("link_other in", values, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherNotIn(List<String> values) {
            addCriterion("link_other not in", values, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherBetween(String value1, String value2) {
            addCriterion("link_other between", value1, value2, "linkOther");
            return (Criteria) this;
        }

        public Criteria andLinkOtherNotBetween(String value1, String value2) {
            addCriterion("link_other not between", value1, value2, "linkOther");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSiteAddressIsNull() {
            addCriterion("site_address is null");
            return (Criteria) this;
        }

        public Criteria andSiteAddressIsNotNull() {
            addCriterion("site_address is not null");
            return (Criteria) this;
        }

        public Criteria andSiteAddressEqualTo(String value) {
            addCriterion("site_address =", value, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressNotEqualTo(String value) {
            addCriterion("site_address <>", value, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressGreaterThan(String value) {
            addCriterion("site_address >", value, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressGreaterThanOrEqualTo(String value) {
            addCriterion("site_address >=", value, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressLessThan(String value) {
            addCriterion("site_address <", value, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressLessThanOrEqualTo(String value) {
            addCriterion("site_address <=", value, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressLike(String value) {
            addCriterion("site_address like", value, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressNotLike(String value) {
            addCriterion("site_address not like", value, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressIn(List<String> values) {
            addCriterion("site_address in", values, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressNotIn(List<String> values) {
            addCriterion("site_address not in", values, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressBetween(String value1, String value2) {
            addCriterion("site_address between", value1, value2, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andSiteAddressNotBetween(String value1, String value2) {
            addCriterion("site_address not between", value1, value2, "siteAddress");
            return (Criteria) this;
        }

        public Criteria andLinkSrcIsNull() {
            addCriterion("link_src is null");
            return (Criteria) this;
        }

        public Criteria andLinkSrcIsNotNull() {
            addCriterion("link_src is not null");
            return (Criteria) this;
        }

        public Criteria andLinkSrcEqualTo(String value) {
            addCriterion("link_src =", value, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcNotEqualTo(String value) {
            addCriterion("link_src <>", value, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcGreaterThan(String value) {
            addCriterion("link_src >", value, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcGreaterThanOrEqualTo(String value) {
            addCriterion("link_src >=", value, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcLessThan(String value) {
            addCriterion("link_src <", value, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcLessThanOrEqualTo(String value) {
            addCriterion("link_src <=", value, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcLike(String value) {
            addCriterion("link_src like", value, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcNotLike(String value) {
            addCriterion("link_src not like", value, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcIn(List<String> values) {
            addCriterion("link_src in", values, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcNotIn(List<String> values) {
            addCriterion("link_src not in", values, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcBetween(String value1, String value2) {
            addCriterion("link_src between", value1, value2, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andLinkSrcNotBetween(String value1, String value2) {
            addCriterion("link_src not between", value1, value2, "linkSrc");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Double value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Double value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Double value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Double value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Double value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Double> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Double> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Double value1, Double value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Double value1, Double value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeIsNull() {
            addCriterion("turn_over_time is null");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeIsNotNull() {
            addCriterion("turn_over_time is not null");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeEqualTo(Long value) {
            addCriterion("turn_over_time =", value, "turnOverTime");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeNotEqualTo(Long value) {
            addCriterion("turn_over_time <>", value, "turnOverTime");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeGreaterThan(Long value) {
            addCriterion("turn_over_time >", value, "turnOverTime");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("turn_over_time >=", value, "turnOverTime");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeLessThan(Long value) {
            addCriterion("turn_over_time <", value, "turnOverTime");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeLessThanOrEqualTo(Long value) {
            addCriterion("turn_over_time <=", value, "turnOverTime");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeIn(List<Long> values) {
            addCriterion("turn_over_time in", values, "turnOverTime");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeNotIn(List<Long> values) {
            addCriterion("turn_over_time not in", values, "turnOverTime");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeBetween(Long value1, Long value2) {
            addCriterion("turn_over_time between", value1, value2, "turnOverTime");
            return (Criteria) this;
        }

        public Criteria andTurnOverTimeNotBetween(Long value1, Long value2) {
            addCriterion("turn_over_time not between", value1, value2, "turnOverTime");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkIsNull() {
            addCriterion("crawl_start_link is null");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkIsNotNull() {
            addCriterion("crawl_start_link is not null");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkEqualTo(String value) {
            addCriterion("crawl_start_link =", value, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkNotEqualTo(String value) {
            addCriterion("crawl_start_link <>", value, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkGreaterThan(String value) {
            addCriterion("crawl_start_link >", value, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkGreaterThanOrEqualTo(String value) {
            addCriterion("crawl_start_link >=", value, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkLessThan(String value) {
            addCriterion("crawl_start_link <", value, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkLessThanOrEqualTo(String value) {
            addCriterion("crawl_start_link <=", value, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkLike(String value) {
            addCriterion("crawl_start_link like", value, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkNotLike(String value) {
            addCriterion("crawl_start_link not like", value, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkIn(List<String> values) {
            addCriterion("crawl_start_link in", values, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkNotIn(List<String> values) {
            addCriterion("crawl_start_link not in", values, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkBetween(String value1, String value2) {
            addCriterion("crawl_start_link between", value1, value2, "crawlStartLink");
            return (Criteria) this;
        }

        public Criteria andCrawlStartLinkNotBetween(String value1, String value2) {
            addCriterion("crawl_start_link not between", value1, value2, "crawlStartLink");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}