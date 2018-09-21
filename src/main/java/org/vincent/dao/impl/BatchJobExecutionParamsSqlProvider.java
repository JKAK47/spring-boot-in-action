package org.vincent.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.vincent.dao.model.BatchJobExecutionParams;
import org.vincent.dao.model.BatchJobExecutionParamsExample.Criteria;
import org.vincent.dao.model.BatchJobExecutionParamsExample.Criterion;
import org.vincent.dao.model.BatchJobExecutionParamsExample;

public class BatchJobExecutionParamsSqlProvider {

    public String countByExample(BatchJobExecutionParamsExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("BATCH_JOB_EXECUTION_PARAMS");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BatchJobExecutionParamsExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("BATCH_JOB_EXECUTION_PARAMS");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BatchJobExecutionParams record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("BATCH_JOB_EXECUTION_PARAMS");
        
        if (record.getJobExecutionId() != null) {
            sql.VALUES("JOB_EXECUTION_ID", "#{jobExecutionId,jdbcType=BIGINT}");
        }
        
        if (record.getTypeCd() != null) {
            sql.VALUES("TYPE_CD", "#{typeCd,jdbcType=VARCHAR}");
        }
        
        if (record.getKeyName() != null) {
            sql.VALUES("KEY_NAME", "#{keyName,jdbcType=VARCHAR}");
        }
        
        if (record.getStringVal() != null) {
            sql.VALUES("STRING_VAL", "#{stringVal,jdbcType=VARCHAR}");
        }
        
        if (record.getDateVal() != null) {
            sql.VALUES("DATE_VAL", "#{dateVal,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLongVal() != null) {
            sql.VALUES("LONG_VAL", "#{longVal,jdbcType=BIGINT}");
        }
        
        if (record.getDoubleVal() != null) {
            sql.VALUES("DOUBLE_VAL", "#{doubleVal,jdbcType=DOUBLE}");
        }
        
        if (record.getIdentifying() != null) {
            sql.VALUES("IDENTIFYING", "#{identifying,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BatchJobExecutionParamsExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("JOB_EXECUTION_ID");
        } else {
            sql.SELECT("JOB_EXECUTION_ID");
        }
        sql.SELECT("TYPE_CD");
        sql.SELECT("KEY_NAME");
        sql.SELECT("STRING_VAL");
        sql.SELECT("DATE_VAL");
        sql.SELECT("LONG_VAL");
        sql.SELECT("DOUBLE_VAL");
        sql.SELECT("IDENTIFYING");
        sql.FROM("BATCH_JOB_EXECUTION_PARAMS");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BatchJobExecutionParams record = (BatchJobExecutionParams) parameter.get("record");
        BatchJobExecutionParamsExample example = (BatchJobExecutionParamsExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("BATCH_JOB_EXECUTION_PARAMS");
        
        if (record.getJobExecutionId() != null) {
            sql.SET("JOB_EXECUTION_ID = #{record.jobExecutionId,jdbcType=BIGINT}");
        }
        
        if (record.getTypeCd() != null) {
            sql.SET("TYPE_CD = #{record.typeCd,jdbcType=VARCHAR}");
        }
        
        if (record.getKeyName() != null) {
            sql.SET("KEY_NAME = #{record.keyName,jdbcType=VARCHAR}");
        }
        
        if (record.getStringVal() != null) {
            sql.SET("STRING_VAL = #{record.stringVal,jdbcType=VARCHAR}");
        }
        
        if (record.getDateVal() != null) {
            sql.SET("DATE_VAL = #{record.dateVal,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLongVal() != null) {
            sql.SET("LONG_VAL = #{record.longVal,jdbcType=BIGINT}");
        }
        
        if (record.getDoubleVal() != null) {
            sql.SET("DOUBLE_VAL = #{record.doubleVal,jdbcType=DOUBLE}");
        }
        
        if (record.getIdentifying() != null) {
            sql.SET("IDENTIFYING = #{record.identifying,jdbcType=CHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("BATCH_JOB_EXECUTION_PARAMS");
        
        sql.SET("JOB_EXECUTION_ID = #{record.jobExecutionId,jdbcType=BIGINT}");
        sql.SET("TYPE_CD = #{record.typeCd,jdbcType=VARCHAR}");
        sql.SET("KEY_NAME = #{record.keyName,jdbcType=VARCHAR}");
        sql.SET("STRING_VAL = #{record.stringVal,jdbcType=VARCHAR}");
        sql.SET("DATE_VAL = #{record.dateVal,jdbcType=TIMESTAMP}");
        sql.SET("LONG_VAL = #{record.longVal,jdbcType=BIGINT}");
        sql.SET("DOUBLE_VAL = #{record.doubleVal,jdbcType=DOUBLE}");
        sql.SET("IDENTIFYING = #{record.identifying,jdbcType=CHAR}");
        
        BatchJobExecutionParamsExample example = (BatchJobExecutionParamsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BatchJobExecutionParamsExample example, boolean includeExamplePhrase) {
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