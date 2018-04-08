package com.coffee.common.db.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 * @author QM
 * @param <T>
 */
public class CommonDao<T> {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(final DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	public List<Map<String, Object>> query(final String sql, final Object[] args) {
		return jdbcTemplate.queryForList(sql, args);
	}

	public long queryCnt(final String sql, final Object[] objects) {
		return jdbcTemplate.queryForObject(sql, objects, Long.class).longValue();
	}

	public T load(final String sql, final Object[] objects, final ResultSetExtractor<T> rse) {
		return jdbcTemplate.query(sql, objects, rse);
	}

	public void update(final String sql, final Object[] objects) {
		jdbcTemplate.update(sql, objects);
	}

	public void delete(final String table, final long id) {
		this.delete(table, "id", id);
	}

	public void delete(final String table, final String col, final long id) {
		jdbcTemplate.update("delete from " + table + " where " + col + "=?", new Object[] { id },
				new int[] { java.sql.Types.BIGINT });
	}
}
