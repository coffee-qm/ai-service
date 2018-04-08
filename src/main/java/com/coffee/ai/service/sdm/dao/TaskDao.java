package com.coffee.ai.service.sdm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.coffee.ai.service.sdm.model.TaskMo;
import com.coffee.common.db.dao.CommonDao;

@Repository
public class TaskDao {

	@Resource(name = "commonDao")
	private CommonDao<TaskMo> dao;

	public long cnt() {
		final String sql = "select count(1) from t_tasks";
		return dao.queryCnt(sql, new Object[] {});
	}

	public List<TaskMo> query() {
		final StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("id, name, description, developer, status, codes_num");
		sql.append(", planed_start_time, planed_finish_time, actual_start_time, actual_finish_time");
		sql.append(" FROM t_tasks");
		final List<Map<String, Object>> lst = dao.query(sql.toString(), new Object[] {});
		final List<TaskMo> data = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(lst)) {
			for (final Map<String, Object> r : lst) {
				final TaskMo mo = new TaskMo();
				mo.setId(Long.valueOf(String.valueOf(r.get("id"))));
				mo.setName(String.valueOf(r.get("name")));
				data.add(mo);
			}
		}
		return data;
	}

	public TaskMo load(final long id) {
		final StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("name, description, developer, status, codes_num");
		sql.append(", planed_start_time, planed_finish_time, actual_start_time, actual_finish_time");
		sql.append(" FROM t_tasks WHERE id=?");
		// 
		return dao.load(sql.toString(), new Object[] { id }, new ResultSetExtractor<TaskMo>() {
			@Override
			public TaskMo extractData(final ResultSet rs) throws SQLException, DataAccessException {
				final TaskMo mo = new TaskMo();
				mo.setId(rs.getLong("id"));
				mo.setName(rs.getString("name"));
				mo.setDescription(rs.getString("description"));
				mo.setDeveloper(rs.getString("developer"));
				mo.setStatus(rs.getInt("status"));
				mo.setCodesNum(rs.getLong("codes_num"));
				mo.setPlanedStartTime(rs.getLong("planed_start_time"));
				mo.setPlanedFinishTime(rs.getLong("planed_finish_time"));
				mo.setActualStartTime(rs.getLong("actual_start_time"));
				mo.setActualFinishTime(rs.getLong("actual_finish_time"));
				return null;
			}
		});
	}

	public void add(final TaskMo mo) {
		final StringBuffer sql = new StringBuffer();
		sql.append("insert into t_tasks(");
		sql.append("create_time");
		sql.append(", name, description, developer, status, codes_num");
		sql.append(", planed_start_time, planed_finish_time, actual_start_time, actual_finish_time");
		sql.append(") values (");
		sql.append(Calendar.getInstance().getTimeInMillis());
		sql.append(",?,?,?,?,?");
		sql.append(",?,?,?,?");
		sql.append(")");
		dao.update(
				sql.toString(),
				new Object[] { mo.getName(), mo.getDescription(), mo.getDeveloper(),
						mo.getStatus(), mo.getCodesNum(), mo.getPlanedStartTime(),
						mo.getPlanedFinishTime(), mo.getActualStartTime(), mo.getActualFinishTime() });
	}

	public void update(final TaskMo mo) {
		final StringBuffer sql = new StringBuffer();
		sql.append("UPDATE t_tasks set ");
		sql.append("update_time=").append(Calendar.getInstance().getTimeInMillis());
		sql.append(", name=?, description=?, developer=?, status=?, codes_num=?");
		sql.append(", planed_start_time=?, planed_finish_time=?, actual_start_time=?, actual_finish_time=?");
		sql.append(" WHERE ");
		sql.append(" id=?");
		dao.update(
				sql.toString(),
				new Object[] { mo.getName(), mo.getDescription(), mo.getDeveloper(),
						mo.getStatus(), mo.getCodesNum(), mo.getPlanedStartTime(),
						mo.getPlanedFinishTime(), mo.getActualStartTime(),
						mo.getActualFinishTime(), mo.getId() });
	}

	public void delete(final long id) {
		dao.delete("t_tasks", id);
	}
}
