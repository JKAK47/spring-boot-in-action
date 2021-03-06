package org.vincent.dao.model;

import java.util.ArrayList;
import java.util.List;

public class BatchJobInstanceExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    public BatchJobInstanceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
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

        public Criteria andJobInstanceIdIsNull() {
            addCriterion("JOB_INSTANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdIsNotNull() {
            addCriterion("JOB_INSTANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdEqualTo(Long value) {
            addCriterion("JOB_INSTANCE_ID =", value, "jobInstanceId");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdNotEqualTo(Long value) {
            addCriterion("JOB_INSTANCE_ID <>", value, "jobInstanceId");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdGreaterThan(Long value) {
            addCriterion("JOB_INSTANCE_ID >", value, "jobInstanceId");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("JOB_INSTANCE_ID >=", value, "jobInstanceId");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdLessThan(Long value) {
            addCriterion("JOB_INSTANCE_ID <", value, "jobInstanceId");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdLessThanOrEqualTo(Long value) {
            addCriterion("JOB_INSTANCE_ID <=", value, "jobInstanceId");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdIn(List<Long> values) {
            addCriterion("JOB_INSTANCE_ID in", values, "jobInstanceId");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdNotIn(List<Long> values) {
            addCriterion("JOB_INSTANCE_ID not in", values, "jobInstanceId");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdBetween(Long value1, Long value2) {
            addCriterion("JOB_INSTANCE_ID between", value1, value2, "jobInstanceId");
            return (Criteria) this;
        }

        public Criteria andJobInstanceIdNotBetween(Long value1, Long value2) {
            addCriterion("JOB_INSTANCE_ID not between", value1, value2, "jobInstanceId");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("JOB_NAME is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("JOB_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("JOB_NAME =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("JOB_NAME <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("JOB_NAME >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_NAME >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("JOB_NAME <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("JOB_NAME <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("JOB_NAME like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("JOB_NAME not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("JOB_NAME in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("JOB_NAME not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("JOB_NAME between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("JOB_NAME not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobKeyIsNull() {
            addCriterion("JOB_KEY is null");
            return (Criteria) this;
        }

        public Criteria andJobKeyIsNotNull() {
            addCriterion("JOB_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andJobKeyEqualTo(String value) {
            addCriterion("JOB_KEY =", value, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyNotEqualTo(String value) {
            addCriterion("JOB_KEY <>", value, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyGreaterThan(String value) {
            addCriterion("JOB_KEY >", value, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_KEY >=", value, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyLessThan(String value) {
            addCriterion("JOB_KEY <", value, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyLessThanOrEqualTo(String value) {
            addCriterion("JOB_KEY <=", value, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyLike(String value) {
            addCriterion("JOB_KEY like", value, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyNotLike(String value) {
            addCriterion("JOB_KEY not like", value, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyIn(List<String> values) {
            addCriterion("JOB_KEY in", values, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyNotIn(List<String> values) {
            addCriterion("JOB_KEY not in", values, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyBetween(String value1, String value2) {
            addCriterion("JOB_KEY between", value1, value2, "jobKey");
            return (Criteria) this;
        }

        public Criteria andJobKeyNotBetween(String value1, String value2) {
            addCriterion("JOB_KEY not between", value1, value2, "jobKey");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BATCH_JOB_INSTANCE
     *
     * @mbg.generated
     */
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