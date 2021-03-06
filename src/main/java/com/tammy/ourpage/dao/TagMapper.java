package com.tammy.ourpage.dao;

import com.tammy.ourpage.model.Tag;

import java.util.List;


public interface TagMapper {

    /**
     * 获得全部的标签
     * @return
     */
    List<Tag> selectAllTags();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    int deleteByPrimaryKey(Integer idtag);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    int insert(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    int insertSelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    Tag selectByPrimaryKey(Integer idtag);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Sat May 07 14:32:37 JST 2016
     */
    int updateByPrimaryKey(Tag record);

    List<Tag> selectTagsByID(List<Integer> list);
}