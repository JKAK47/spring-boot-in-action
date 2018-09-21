package org.vincent.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.vincent.dao.model.BatchJobInstance;
import org.vincent.dao.model.BatchJobInstanceExample.Criteria;
import org.vincent.dao.model.BatchJobInstanceExample.Criterion;
import org.vincent.dao.model.BatchJobInstanceExample;

public class BatchJobInstanceSqlProvider {

    public String countByExample(BatchJobInstanceExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("BATCH_JOB_INSTANCE");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BatchJobInstanceExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("BATCH_JOB_INSTANCE");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BatchJobInstance record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("BATCH_JOB_INSTANCE");
        
        if (record.getJobInstanceId() != null) {
            sql.VALUES("JOB_INSTANCE_ID", "#{jobInstanceId,jdbcType=BIGINT}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("VERSION", "#{version,jdbcType=BIGINT}");
        }
        
        if (record.getJobName() != null) {
            sql.VALUES("JOB_NAME", "#{jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobKey() != null) {
            sql.VALUES("JOB_KEY", "#{jobKey,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BatchJobInstanceExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("JOB_INSTANCE_ID");
        } else {
            sql.SELECT("JOB_INSTANCE_ID");
        }
        sql.SELECT("VERSION");
        sql.SELECT("JOB_NAME");
        sql.SELECT("JOB_KEY");
        sql.FROM("BATCH_JOB_INSTANCE");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BatchJobInstance record = (BatchJobInstance) parameter.get("record");
        BatchJobInstanceExample example = (BatchJobInstanceExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("BATCH_JOB_INSTANCE");
        
        if (record.getJobInstanceId() != null) {
            sql.SET("JOB_INSTANCE_ID = #{record.jobInstanceId,jdbcType=BIGINT}");
        }
        
        if (record.getVersion() != null) {
            sql.SET("VERSION = #{record.version,jdbcType=BIGINT}");
        }
        
        if (record.getJobName() != null) {
            sql.SET("JOB_NAME = #{record.jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobKey() != null) {
            sql.SET("JOB_KEY = #{record.jobKey,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("BATCH_JOB_INSTANCE");
        
        sql.SET("JOB_INSTANCE_ID = #{record.jobInstanceId,jdbcType=BIGINT}");
        sql.SET("VERSION = #{record.version,jdbcType=BIGINT}");
        sql.SET("JOB_NAME = #{record.jobName,jdbcType=VARCHAR}");
        sql.SET("JOB_KEY = #{record.jobKey,jdbcType=VARCHAR}");
        
        BatchJobInstanceExample example = (BatchJobInstanceExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BatchJobInstance record) {
        SQL sql = new SQL();
        sql.UPDATE("BATCH_JOB_INSTANCE");
        
        if (record.getVersion() != null) {
            sql.SET("VERSION = #{version,jdbcType=BIGINT}");
        }
        
        if (record.getJobName() != null) {
            sql.SET("JOB_NAME = #{jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobKey() != null) {
            sql.SET("JOB_KEY = #{jobKey,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("JOB_INSTANCE_ID = #{jobInstanceId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BatchJobInstanceExample example, boolean includeExamplePhrase) {
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