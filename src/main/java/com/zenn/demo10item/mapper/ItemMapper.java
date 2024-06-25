package com.zenn.demo10item.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zenn.demo10item.entity.Item;

@Mapper
public interface ItemMapper {
	Item findById(int id);
    List<Item> findAll();
    int insert(Item item);
    int update(Item item);
    boolean delete(int id);
}
