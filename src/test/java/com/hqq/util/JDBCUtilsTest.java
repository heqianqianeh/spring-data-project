package com.hqq.util;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * JDBCUtilsTest
 * Created by heqianqian on 2017/6/17.
 */
public class JDBCUtilsTest {
    @Test
    public void testConnection() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        assertNotNull(connection);
    }
}