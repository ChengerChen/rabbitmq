package com.example.rabbitmq.jpa;

import com.example.rabbitmq.jpa.template.FreeMarkerLoader;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chenger
 * @description
 * @date 2021/7/22 下午1:49
 */
public class JdbcUtils {

    public JdbcUtils() {
    }

    public static NamedParameterJdbcTemplate getJdbcTemplate() {
        return (NamedParameterJdbcTemplate)ApplicationContextHolder.getBean("namedParameterJdbcTemplate");
    }

    public static FreeMarkerLoader getTemplateLoader() {
        return (FreeMarkerLoader)ApplicationContextHolder.getBean("freeMarkerLoader");
    }

    public static String getSql(String vmFile) {
        try {
            Assert.notNull(vmFile, "传入的vmfile为null");
            String sql = getTemplateLoader().mergeTemplate(vmFile);
            return sql;
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static String getSql(String vmFile, Map<String, Object> param) {
        try {
            Assert.notNull(vmFile, "传入的vmfile为null");
            String sql = getTemplateLoader().mergeTemplate(vmFile, param);
            return sql;
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> queryForList(String sql, Map<String, Object> param, Class<T> elementType) {
        try {
            RowMapper<T> rowMapper = new BeanPropertyRowMapper(elementType);
            return getJdbcTemplate().query(sql, param, rowMapper);
        } catch (Exception var4) {
            var4.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<Map<String, Object>> queryForListMap(String sql, Map<String, Object> param) {
        try {
            ColumnMapRowMapper rowMapper = new ColumnMapRowMapper();
            return getJdbcTemplate().query(sql, param, rowMapper);
        } catch (Exception var3) {
            var3.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static <T> List<T> queryForListSingleColumn(String sql, Map<String, Object> param, Class<T> elementType) {
        try {
            SingleColumnRowMapper<T> rowMapper = new SingleColumnRowMapper(elementType);
            return getJdbcTemplate().query(sql, param, rowMapper);
        } catch (Exception var4) {
            var4.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static <T> T queryForObject(String sql, Map<String, Object> param, Class<T> elementType) {
        try {
            RowMapper<T> rowMapper = new BeanPropertyRowMapper(elementType);
            return getJdbcTemplate().queryForObject(sql, param, rowMapper);
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> queryForMap(String sql, Map<String, Object> param) {
        try {
            ColumnMapRowMapper rowMapper = new ColumnMapRowMapper();
            return (Map)getJdbcTemplate().queryForObject(sql, param, rowMapper);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static <T> T queryForSingleColumn(String sql, Map<String, Object> param, Class<T> elementType) {
        try {
            SingleColumnRowMapper<T> rowMapper = new SingleColumnRowMapper(elementType);
            return getJdbcTemplate().queryForObject(sql, param, rowMapper);
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static int update(String sql, Map<String, Object> param) {
        return getJdbcTemplate().update(sql, param);
    }

    public static Map<String, Object> pageable2Map(Pageable pageable) {
        Map<String, Object> param = new HashMap<>(8);
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        int startNumber = pageNumber * pageSize;
        param.put("startNumber", startNumber);
        param.put("pageSize", pageSize);
        return param;
    }
}
