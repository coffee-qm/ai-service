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

import com.coffee.ai.service.sdm.model.TaskProgressMo;
import com.coffee.common.db.dao.CommonDao;

@Repository
public class TaskProgressDao {

	@Resource(name = "commonDao")
	private CommonDao<TaskProgressMo> dao;

	public long cnt() {
		final String sql = "select count(1) from t_tasks_progress";
		return dao.queryCnt(sql, new Object[] {});
	}

	public List<TaskProgressMo> query() {
		final StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("id, task_id, rate, description, create_time, update_time, user_ip");
		sql.append(" FROM t_tasks_progress");
		final List<Map<String, Object>> lst = dao.query(sql.toString(), new Object[] {});
		final List<TaskProgressMo> data = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(lst)) {
			for (final Map<String, Object> r : lst) {
				final TaskProgressMo mo = new TaskProgressMo();
				mo.setId(Long.valueOf(String.valueOf(r.get("id"))));
				mo.setTaskId(Long.valueOf(String.valueOf(r.get("task_id"))));
				mo.setRate(Integer.valueOf(String.valueOf(r.get("rate"))));
				mo.setDescription(String.valueOf(r.get("description")));
				mo.setCreateTime(Long.valueOf(String.valueOf(r.get("create_time"))));
				mo.setUpdateTime(Long.valueOf(String.valueOf(r.get("update_time"))));
				mo.setUserIp(String.valueOf(r.get("user_ip")));
				data.add(mo);
			}
		}
		return data;
	}

	public TaskProgressMo load(final long id) {
		final StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("id, task_id, rate, description, create_time, update_time, user_ip");
		sql.append(" FROM t_tasks_progress WHERE id=?");
		// 
		return dao.load(sql.toString(), new Object[] { id },
				new ResultSetExtractor<TaskProgressMo>() {
					@Override
					public TaskProgressMo extractData(final ResultSet rs) throws SQLException,
							DataAccessException {
						final TaskProgressMo mo = new TaskProgressMo();
						mo.setId(rs.getLong("id"));
						mo.setTaskId(rs.getLong("task_id"));
						mo.setRate(rs.getInt("rate"));
						mo.setDescription(rs.getString("description"));
						mo.setCreateTime(rs.getLong("create_time"));
						mo.setUpdateTime(rs.getLong("update_time"));
						mo.setUserIp(rs.getString("user_ip"));
						return mo;
					}
				});
	}

	public void add(final TaskProgressMo mo) {
		final StringBuffer sql = new StringBuffer();
		sql.append("insert into t_tasks_progress(");
		sql.append("create_time");
		sql.append(", task_id, rate, description, user_ip");
		sql.append(") values (");
		sql.append(Calendar.getInstance().getTimeInMillis());
		sql.append(",?,?,?,?");
		sql.append(")");
		dao.update(sql.toString(), new Object[] { mo.getTaskId(), mo.getRate(),
				mo.getDescription(), mo.getUserIp() });
	}

	public void update(final TaskProgressMo mo) {
		final StringBuffer sql = new StringBuffer();
		sql.append("UPDATE t_tasks_progress set ");
		sql.append("update_time=").append(Calendar.getInstance().getTimeInMillis());
		sql.append(", task_id=?, rate=?, description=?, user_ip=?");
		sql.append(" WHERE ");
		sql.append(" id=?");
		dao.update(sql.toString(), new Object[] { mo.getTaskId(), mo.getRate(),
				mo.getDescription(), mo.getUserIp(), mo.getId() });
	}

	public void delete(final long id) {
		dao.delete("t_tasks_progress", id);
	}

	public void deleteByTaskId(final long taskId) {
		dao.delete("t_tasks_progress", "task_id", taskId);
	}
}
