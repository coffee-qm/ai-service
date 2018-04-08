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

import com.coffee.ai.service.sdm.model.TaskRelMo;
import com.coffee.common.db.dao.CommonDao;

@Repository
public class TaskRelDao {

	@Resource(name = "commonDao")
	private CommonDao<TaskRelMo> dao;

	public long cnt() {
		final String sql = "select count(1) from t_tasks_rel";
		return dao.queryCnt(sql, new Object[] {});
	}

	public List<TaskRelMo> query() {
		final StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("id, type, task_id, rel_id, description, create_time, user_ip");
		sql.append(" FROM t_tasks_rel");
		final List<Map<String, Object>> lst = dao.query(sql.toString(), new Object[] {});
		final List<TaskRelMo> data = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(lst)) {
			for (final Map<String, Object> r : lst) {
				final TaskRelMo mo = new TaskRelMo();
				mo.setId(Long.valueOf(String.valueOf(r.get("id"))));
				mo.setType(Integer.valueOf(String.valueOf(r.get("type"))));
				mo.setTaskId(Long.valueOf(String.valueOf(r.get("task_id"))));
				mo.setRelId(Long.valueOf(String.valueOf(r.get("rel_id"))));
				mo.setDescription(String.valueOf(r.get("description")));
				mo.setCreateTime(Long.valueOf(String.valueOf(r.get("create_time"))));
				mo.setUserIp(String.valueOf(r.get("user_ip")));
				data.add(mo);
			}
		}
		return data;
	}

	public TaskRelMo load(final long id) {
		final StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("id, type, task_id, rel_id, description, create_time, user_ip");
		sql.append(" FROM t_tasks_rel WHERE id=?");
		// 
		return dao.load(sql.toString(), new Object[] { id }, new ResultSetExtractor<TaskRelMo>() {
			@Override
			public TaskRelMo extractData(final ResultSet rs) throws SQLException,
					DataAccessException {
				final TaskRelMo mo = new TaskRelMo();
				mo.setId(rs.getLong("id"));
				mo.setType(rs.getInt("type"));
				mo.setTaskId(rs.getLong("task_id"));
				mo.setRelId(rs.getLong("rel_id"));
				mo.setDescription(rs.getString("description"));
				mo.setCreateTime(rs.getLong("create_time"));
				mo.setUserIp(rs.getString("user_ip"));
				return mo;
			}
		});
	}

	public void add(final TaskRelMo mo) {
		final StringBuffer sql = new StringBuffer();
		sql.append("insert into t_tasks_rel(");
		sql.append("create_time");
		sql.append(", type, task_id, rel_id, description, user_ip");
		sql.append(") values (");
		sql.append(Calendar.getInstance().getTimeInMillis());
		sql.append(",?,?,?,?,?");
		sql.append(")");
		dao.update(
				sql.toString(),
				new Object[] { mo.getType(), mo.getTaskId(), mo.getRelId(), mo.getDescription(),
						mo.getUserIp() });
	}

	public void update(final TaskRelMo mo) {
		final StringBuffer sql = new StringBuffer();
		sql.append("UPDATE t_tasks_rel set ");
		sql.append("update_time=").append(Calendar.getInstance().getTimeInMillis());
		sql.append(", type=?, task_id=?, rel_id=?, description=?, user_ip=?");
		sql.append(" WHERE ");
		sql.append(" id=?");
		dao.update(
				sql.toString(),
				new Object[] { mo.getType(), mo.getTaskId(), mo.getRelId(), mo.getDescription(),
						mo.getUserIp(), mo.getId() });
	}

	public void delete(final long id) {
		dao.delete("t_tasks_rel", id);
	}

	public void deleteByTaskId(final long taskId) {
		dao.delete("t_tasks_rel", "task_id", taskId);
	}
}
