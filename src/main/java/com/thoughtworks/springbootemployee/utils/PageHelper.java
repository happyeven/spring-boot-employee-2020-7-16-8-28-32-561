package com.thoughtworks.springbootemployee.utils;

import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

public class PageHelper {
    public static <T> List<T> PageHelper(Integer page, Integer pageSize, List<T> list) {
        int startIndex = page * pageSize - pageSize;
        if (list.size() <= startIndex) {
            return null;
        }
        int endIndex = page * pageSize;
        if (list.size() < endIndex) {
            return list.subList(startIndex, list.size());
        }
        return list.subList(startIndex, endIndex);
    }
}
