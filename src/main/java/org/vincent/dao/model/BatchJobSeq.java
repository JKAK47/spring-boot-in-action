package org.vincent.dao.model;

public class BatchJobSeq {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BATCH_JOB_SEQ.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BATCH_JOB_SEQ.UNIQUE_KEY
     *
     * @mbg.generated
     */
    private String uniqueKey;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BATCH_JOB_SEQ.ID
     *
     * @return the value of BATCH_JOB_SEQ.ID
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BATCH_JOB_SEQ.ID
     *
     * @param id the value for BATCH_JOB_SEQ.ID
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BATCH_JOB_SEQ.UNIQUE_KEY
     *
     * @return the value of BATCH_JOB_SEQ.UNIQUE_KEY
     *
     * @mbg.generated
     */
    public String getUniqueKey() {
        return uniqueKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BATCH_JOB_SEQ.UNIQUE_KEY
     *
     * @param uniqueKey the value for BATCH_JOB_SEQ.UNIQUE_KEY
     *
     * @mbg.generated
     */
    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey == null ? null : uniqueKey.trim();
    }
}