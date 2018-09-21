package org.vincent.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.vincent.dao.model.BatchStepExecutionContext;
import org.vincent.dao.model.BatchStepExecutionContextExample.Criteria;
import org.vincent.dao.model.BatchStepExecutionContextExample.Criterion;
import org.vincent.dao.model.BatchStepExecutionContextExample;

public class BatchStepExecutionContextSqlProvider {

    public String countByExample(BatchStepExecutionContextExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("BATCH_STEP_EXECUTION_CONTEXT");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BatchStepExecutionContextExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("BATCH_STEP_EXECUTION_CONTEXT");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BatchStepExecutionContext record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("BATCH_STEP_EXECUTION_CONTEXT");
        
        if (record.getStepExecutionId() != null) {
            sql.VALUES("STEP_EXECUTION_ID", "#{stepExecutionId,jdbcType=BIGINT}");
        }
        
        if (record.getShortContext() != null) {
            sql.VALUES("SHORT_CONTEXT", "#{shortContext,jdbcType=VARCHAR}");
        }
        
        if (record.getSerializedContext() != null) {
            sql.VALUES("SERIALIZED_CONTEXT", "#{serializedContext,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(BatchStepExecutionContextExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("STEP_EXECUTION_ID");
        } else {
            sql.SELECT("STEP_EXECUTION_ID");
        }
        sql.SELECT("SHORT_CONTEXT");
        sql.SELECT("SERIALIZED_CONTEXT");
        sql.FROM("BATCH_STEP_EXECUTION_CONTEXT");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(BatchStepExecutionContextExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("STEP_EXECUTION_ID");
        } else {
            sql.SELECT("STEP_EXECUTION_ID");
        }
        sql.SELECT("SHORT_CONTEXT");
        sql.FROM("BATCH_STEP_EXECUTION_CONTEXT");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BatchStepExecutionContext record = (BatchStepExecutionContext) parameter.get("record");
        BatchStepExecutionContextExample example = (BatchStepExecutionContextExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("BATCH_STEP_EXECUTION_CONTEXT");
        
        if (record.getStepExecutionId() != null) {
            sql.SET("STEP_EXECUTION_ID = #{record.stepExecutionId,jdbcType=BIGINT}");
        }
        
        if (record.getShortContext() != null) {
            sql.SET("SHORT_CONTEXT = #{record.shortContext,jdbcType=VARCHAR}");
        }
        
        if (record.getSerializedContext() != null) {
            sql.SET("SERIALIZED_CONTEXT = #{record.serializedContext,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("BATCH_STEP_EXECUTION_CONTEXT");
        
        sql.SET("STEP_EXECUTION_ID = #{record.stepExecutionId,jdbcType=BIGINT}");
        sql.SET("SHORT_CONTEXT = #{record.shortContext,jdbcType=VARCHAR}");
        sql.SET("SERIALIZED_CONTEXT = #{record.serializedContext,jdbcType=LONGVARCHAR}");
        
        BatchStepExecutionContextExample example = (BatchStepExecutionContextExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("BATCH_STEP_EXECUTION_CONTEXT");
        
        sql.SET("STEP_EXECUTION_ID = #{record.stepExecutionId,jdbcType=BIGINT}");
        sql.SET("SHORT_CONTEXT = #{record.shortContext,jdbcType=VARCHAR}");
        
        BatchStepExecutionContextExample example = (BatchStepExecutionContextExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BatchStepExecutionContext record) {
        SQL sql = new SQL();
        sql.UPDATE("BATCH_STEP_EXECUTION_CONTEXT");
        
        if (record.getShortContext() != null) {
            sql.SET("SHORT_CONTEXT = #{shortContext,jdbcType=VARCHAR}");
        }
        
        if (record.getSerializedContext() != null) {
            sql.SET("SERIALIZED_CONTEXT = #{serializedContext,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("STEP_EXECUTION_ID = #{stepExecutionId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BatchStepExecutionContextExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}