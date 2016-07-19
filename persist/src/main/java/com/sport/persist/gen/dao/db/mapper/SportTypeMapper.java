package com.sport.persist.gen.dao.db.mapper;

import com.sport.persist.gen.dao.db.model.SportType;
import com.sport.persist.gen.dao.db.model.SportTypeExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SportTypeMapper {
    @SelectProvider(type=SportTypeSqlProvider.class, method="countByExample")
    int countByExample(SportTypeExample example);

    @DeleteProvider(type=SportTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(SportTypeExample example);

    @Delete({
        "delete from sport_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sport_type (code, name, ",
        "icon, createTime, ",
        "updateTime, status)",
        "values (#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{icon,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{updatetime,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SportType record);

    @InsertProvider(type=SportTypeSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SportType record);

    @SelectProvider(type=SportTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<SportType> selectByExample(SportTypeExample example);

    @Select({
        "select",
        "id, code, name, icon, createTime, updateTime, status",
        "from sport_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    SportType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SportTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SportType record, @Param("example") SportTypeExample example);

    @UpdateProvider(type=SportTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SportType record, @Param("example") SportTypeExample example);

    @UpdateProvider(type=SportTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SportType record);

    @Update({
        "update sport_type",
        "set code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "updateTime = #{updatetime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SportType record);
}