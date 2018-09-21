package org.vincent.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.vincent.dao.model.BatchStepExecution;
import org.vincent.dao.model.BatchStepExecutionExample.Criteria;
import org.vincent.dao.model.BatchStepExecutionExample.Criterion;
import org.vincent.dao.model.BatchStepExecutionExample;

public class BatchStepExecutionSqlProvider {

    public String countByExample(BatchStepExecutionExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("BATCH_STEP_EXECUTION");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BatchStepExecutionExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("BATCH_STEP_EXECUTION");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BatchStepExecution record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("BATCH_STEP_EXECUTION");
        
        if (record.getStepExecutionId() != null) {
            sql.VALUES("STEP_EXECUTION_ID", "#{stepExecutionId,jdbcType=BIGINT}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("VERSION", "#{version,jdbcType=BIGINT}");
        }
        
        if (record.getStepName() != null) {
            sql.VALUES("STEP_NAME", "#{stepName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobExecutionId() != null) {
            sql.VALUES("JOB_EXECUTION_ID", "#{jobExecutionId,jdbcType=BIGINT}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("START_TIME", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("END_TIME", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("STATUS", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCommitCount() != null) {
            sql.VALUES("COMMIT_COUNT", "#{commitCount,jdbcType=BIGINT}");
        }
        
        if (record.getReadCount() != null) {
            sql.VALUES("READ_COUNT", "#{readCount,jdbcType=BIGINT}");
        }
        
        if (record.getFilterCount() != null) {
            sql.VALUES("FILTER_COUNT", "#{filterCount,jdbcType=BIGINT}");
        }
        
        if (record.getWriteCount() != null) {
            sql.VALUES("WRITE_COUNT", "#{writeCount,jdbcType=BIGINT}");
        }
        
        if (record.getReadSkipCount() != null) {
            sql.VALUES("READ_SKIP_COUNT", "#{readSkipCount,jdbcType=BIGINT}");
        }
        
        if (record.getWriteSkipCount() != null) {
            sql.VALUES("WRITE_SKIP_COUNT", "#{writeSkipCount,jdbcType=BIGINT}");
        }
        
        if (record.getProcessSkipCount() != null) {
            sql.VALUES("PROCESS_SKIP_COUNT", "#{processSkipCount,jdbcType=BIGINT}");
        }
        
        if (record.getRollbackCount() != null) {
            sql.VALUES("ROLLBACK_COUNT", "#{rollbackCount,jdbcType=BIGINT}");
        }
        
        if (record.getExitCode() != null) {
            sql.VALUES("EXIT_CODE", "#{exitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExitMessage() != null) {
            sql.VALUES("EXIT_MESSAGE", "#{exitMessage,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdated() != null) {
            sql.VALUES("LAST_UPDATED", "#{lastUpdated,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BatchStepExecutionExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("STEP_EXECUTION_ID");
        } else {
            sql.SELECT("STEP_EXECUTION_ID");
        }
        sql.SELECT("VERSION");
        sql.SELECT("STEP_NAME");
        sql.SELECT("JOB_EXECUTION_ID");
        sql.SELECT("START_TIME");
        sql.SELECT("END_TIME");
        sql.SELECT("STATUS");
        sql.SELECT("COMMIT_COUNT");
        sql.SELECT("READ_COUNT");
        sql.SELECT("FILTER_COUNT");
        sql.SELECT("WRITE_COUNT");
        sql.SELECT("READ_SKIP_COUNT");
        sql.SELECT("WRITE_SKIP_COUNT");
        sql.SELECT("PROCESS_SKIP_COUNT");
        sql.SELECT("ROLLBACK_COUNT");
        sql.SELECT("EXIT_CODE");
        sql.SELECT("EXIT_MESSAGE");
        sql.SELECT("LAST_UPDATED");
        sql.FROM("BATCH_STEP_EXECUTION");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BatchStepExecution record = (BatchStepExecution) parameter.get("record");
        BatchStepExecutionExample example = (BatchStepExecutionExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("BATCH_STEP_EXECUTION");
        
        if (record.getStepExecutionId() != null) {
            sql.SET("STEP_EXECUTION_ID = #{record.stepExecutionId,jdbcType=BIGINT}");
        }
        
        if (record.getVersion() != null) {
            sql.SET("VERSION = #{record.version,jdbcType=BIGINT}");
        }
        
        if (record.getStepName() != null) {
            sql.SET("STEP_NAME = #{record.stepName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobExecutionId() != null) {
            sql.SET("JOB_EXECUTION_ID = #{record.jobExecutionId,jdbcType=BIGINT}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("START_TIME = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("END_TIME = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getCommitCount() != null) {
            sql.SET("COMMIT_COUNT = #{record.commitCount,jdbcType=BIGINT}");
        }
        
        if (record.getReadCount() != null) {
            sql.SET("READ_COUNT = #{record.readCount,jdbcType=BIGINT}");
        }
        
        if (record.getFilterCount() != null) {
            sql.SET("FILTER_COUNT = #{record.filterCount,jdbcType=BIGINT}");
        }
        
        if (record.getWriteCount() != null) {
            sql.SET("WRITE_COUNT = #{record.writeCount,jdbcType=BIGINT}");
        }
        
        if (record.getReadSkipCount() != null) {
            sql.SET("READ_SKIP_COUNT = #{record.readSkipCount,jdbcType=BIGINT}");
        }
        
        if (record.getWriteSkipCount() != null) {
            sql.SET("WRITE_SKIP_COUNT = #{record.writeSkipCount,jdbcType=BIGINT}");
        }
        
        if (record.getProcessSkipCount() != null) {
            sql.SET("PROCESS_SKIP_COUNT = #{record.processSkipCount,jdbcType=BIGINT}");
        }
        
        if (record.getRollbackCount() != null) {
            sql.SET("ROLLBACK_COUNT = #{record.rollbackCount,jdbcType=BIGINT}");
        }
        
        if (record.getExitCode() != null) {
            sql.SET("EXIT_CODE = #{record.exitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExitMessage() != null) {
            sql.SET("EXIT_MESSAGE = #{record.exitMessage,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdated() != null) {
            sql.SET("LAST_UPDATED = #{record.lastUpdated,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("BATCH_STEP_EXECUTION");
        
        sql.SET("STEP_EXECUTION_ID = #{record.stepExecutionId,jdbcType=BIGINT}");
        sql.SET("VERSION = #{record.version,jdbcType=BIGINT}");
        sql.SET("STEP_NAME = #{record.stepName,jdbcType=VARCHAR}");
        sql.SET("JOB_EXECUTION_ID = #{record.jobExecutionId,jdbcType=BIGINT}");
        sql.SET("START_TIME = #{record.startTime,jdbcType=TIMESTAMP}");
        sql.SET("END_TIME = #{record.endTime,jdbcType=TIMESTAMP}");
        sql.SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        sql.SET("COMMIT_COUNT = #{record.commitCount,jdbcType=BIGINT}");
        sql.SET("READ_COUNT = #{record.readCount,jdbcType=BIGINT}");
        sql.SET("FILTER_COUNT = #{record.filterCount,jdbcType=BIGINT}");
        sql.SET("WRITE_COUNT = #{record.writeCount,jdbcType=BIGINT}");
        sql.SET("READ_SKIP_COUNT = #{record.readSkipCount,jdbcType=BIGINT}");
        sql.SET("WRITE_SKIP_COUNT = #{record.writeSkipCount,jdbcType=BIGINT}");
        sql.SET("PROCESS_SKIP_COUNT = #{record.processSkipCount,jdbcType=BIGINT}");
        sql.SET("ROLLBACK_COUNT = #{record.rollbackCount,jdbcType=BIGINT}");
        sql.SET("EXIT_CODE = #{record.exitCode,jdbcType=VARCHAR}");
        sql.SET("EXIT_MESSAGE = #{record.exitMessage,jdbcType=VARCHAR}");
        sql.SET("LAST_UPDATED = #{record.lastUpdated,jdbcType=TIMESTAMP}");
        
        BatchStepExecutionExample example = (BatchStepExecutionExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BatchStepExecution record) {
        SQL sql = new SQL();
        sql.UPDATE("BATCH_STEP_EXECUTION");
        
        if (record.getVersion() != null) {
            sql.SET("VERSION = #{version,jdbcType=BIGINT}");
        }
        
        if (record.getStepName() != null) {
            sql.SET("STEP_NAME = #{stepName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobExecutionId() != null) {
            sql.SET("JOB_EXECUTION_ID = #{jobExecutionId,jdbcType=BIGINT}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("START_TIME = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("END_TIME = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("STATUS = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCommitCount() != null) {
            sql.SET("COMMIT_COUNT = #{commitCount,jdbcType=BIGINT}");
        }
        
        if (record.getReadCount() != null) {
            sql.SET("READ_COUNT = #{readCount,jdbcType=BIGINT}");
        }
        
        if (record.getFilterCount() != null) {
            sql.SET("FILTER_COUNT = #{filterCount,jdbcType=BIGINT}");
        }
        
        if (record.getWriteCount() != null) {
            sql.SET("WRITE_COUNT = #{writeCount,jdbcType=BIGINT}");
        }
        
        if (record.getReadSkipCount() != null) {
            sql.SET("READ_SKIP_COUNT = #{readSkipCount,jdbcType=BIGINT}");
        }
        
        if (record.getWriteSkipCount() != null) {
            sql.SET("WRITE_SKIP_COUNT = #{writeSkipCount,jdbcType=BIGINT}");
        }
        
        if (record.getProcessSkipCount() != null) {
            sql.SET("PROCESS_SKIP_COUNT = #{processSkipCount,jdbcType=BIGINT}");
        }
        
        if (record.getRollbackCount() != null) {
            sql.SET("ROLLBACK_COUNT = #{rollbackCount,jdbcType=BIGINT}");
        }
        
        if (record.getExitCode() != null) {
            sql.SET("EXIT_CODE = #{exitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExitMessage() != null) {
            sql.SET("EXIT_MESSAGE = #{exitMessage,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdated() != null) {
            sql.SET("LAST_UPDATED = #{lastUpdated,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("STEP_EXECUTION_ID = #{stepExecutionId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BatchStepExecutionExample example, boolean includeExamplePhrase) {
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