package org.vincent.dao.model;

import java.util.ArrayList;
import java.util.List;

public class BatchJobExecutionContextExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    public BatchJobExecutionContextExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
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
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
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
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
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
     * This class corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
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

        public Criteria andJobExecutionIdIsNull() {
            addCriterion("JOB_EXECUTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdIsNotNull() {
            addCriterion("JOB_EXECUTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdEqualTo(Long value) {
            addCriterion("JOB_EXECUTION_ID =", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdNotEqualTo(Long value) {
            addCriterion("JOB_EXECUTION_ID <>", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdGreaterThan(Long value) {
            addCriterion("JOB_EXECUTION_ID >", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("JOB_EXECUTION_ID >=", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdLessThan(Long value) {
            addCriterion("JOB_EXECUTION_ID <", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdLessThanOrEqualTo(Long value) {
            addCriterion("JOB_EXECUTION_ID <=", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdIn(List<Long> values) {
            addCriterion("JOB_EXECUTION_ID in", values, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdNotIn(List<Long> values) {
            addCriterion("JOB_EXECUTION_ID not in", values, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdBetween(Long value1, Long value2) {
            addCriterion("JOB_EXECUTION_ID between", value1, value2, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdNotBetween(Long value1, Long value2) {
            addCriterion("JOB_EXECUTION_ID not between", value1, value2, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andShortContextIsNull() {
            addCriterion("SHORT_CONTEXT is null");
            return (Criteria) this;
        }

        public Criteria andShortContextIsNotNull() {
            addCriterion("SHORT_CONTEXT is not null");
            return (Criteria) this;
        }

        public Criteria andShortContextEqualTo(String value) {
            addCriterion("SHORT_CONTEXT =", value, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextNotEqualTo(String value) {
            addCriterion("SHORT_CONTEXT <>", value, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextGreaterThan(String value) {
            addCriterion("SHORT_CONTEXT >", value, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextGreaterThanOrEqualTo(String value) {
            addCriterion("SHORT_CONTEXT >=", value, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextLessThan(String value) {
            addCriterion("SHORT_CONTEXT <", value, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextLessThanOrEqualTo(String value) {
            addCriterion("SHORT_CONTEXT <=", value, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextLike(String value) {
            addCriterion("SHORT_CONTEXT like", value, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextNotLike(String value) {
            addCriterion("SHORT_CONTEXT not like", value, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextIn(List<String> values) {
            addCriterion("SHORT_CONTEXT in", values, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextNotIn(List<String> values) {
            addCriterion("SHORT_CONTEXT not in", values, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextBetween(String value1, String value2) {
            addCriterion("SHORT_CONTEXT between", value1, value2, "shortContext");
            return (Criteria) this;
        }

        public Criteria andShortContextNotBetween(String value1, String value2) {
            addCriterion("SHORT_CONTEXT not between", value1, value2, "shortContext");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
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
     * This class corresponds to the database table BATCH_JOB_EXECUTION_CONTEXT
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