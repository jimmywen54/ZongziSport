package com.sport.persist.gen.dao.db.mapper;

import com.sport.persist.gen.dao.db.model.SportType;
import com.sport.persist.gen.dao.db.model.SportTypeExample;
import com.sport.persist.gen.dao.db.model.SportTypeExample.Criteria;
import com.sport.persist.gen.dao.db.model.SportTypeExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class SportTypeSqlProvider {

    public String countByExample(SportTypeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sport_type");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(SportTypeExample example) {
        BEGIN();
        DELETE_FROM("sport_type");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(SportType record) {
        BEGIN();
        INSERT_INTO("sport_type");
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            VALUES("updateTime", "#{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        return SQL();
    }

    public String selectByExample(SportTypeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("code");
        SELECT("name");
        SELECT("icon");
        SELECT("createTime");
        SELECT("updateTime");
        SELECT("status");
        FROM("sport_type");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SportType record = (SportType) parameter.get("record");
        SportTypeExample example = (SportTypeExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sport_type");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{record.createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            SET("updateTime = #{record.updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sport_type");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("icon = #{record.icon,jdbcType=VARCHAR}");
        SET("createTime = #{record.createtime,jdbcType=TIMESTAMP}");
        SET("updateTime = #{record.updatetime,jdbcType=TIMESTAMP}");
        SET("status = #{record.status,jdbcType=TINYINT}");
        
        SportTypeExample example = (SportTypeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(SportType record) {
        BEGIN();
        UPDATE("sport_type");
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            SET("updateTime = #{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=TINYINT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(SportTypeExample example, boolean includeExamplePhrase) {
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
            WHERE(sb.toString());
        }
    }
}