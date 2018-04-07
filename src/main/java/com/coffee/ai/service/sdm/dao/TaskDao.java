package com.coffee.ai.service.sdm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		sql.append("id,name,description,developer,status,codesNum");
		sql.append(",planedStartDate,planedFinishDate,actualStartDate,actualFinishDate");
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
		sql.append("name,description,developer,status,codesNum");
		sql.append(",planedStartDate,planedFinishDate,actualStartDate,actualFinishDate");
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
				mo.setCodesNum(rs.getLong("codesNum"));
				mo.setPlanedStartDate(rs.getDate("planedStartDate"));
				mo.setPlanedFinishDate(rs.getDate("planedFinishDate"));
				mo.setActualStartDate(rs.getDate("actualStartDate"));
				mo.setActualFinishDate(rs.getDate("actualFinishDate"));
				return null;
			}
		});
	}

	public void add(final TaskMo mo) {
		final StringBuffer sql = new StringBuffer();
		sql.append("insert into t_tasks(");
		sql.append("name,description,developer,status,codesNum");
		sql.append(",planedStartDate,planedFinishDate,actualStartDate,actualFinishDate");
		sql.append(") values (");
		sql.append("?,?,?,?,?");
		sql.append(",?,?,?,?");
		sql.append(")");
		dao.update(
				sql.toString(),
				new Object[] { mo.getName(), mo.getDescription(), mo.getDeveloper(),
						mo.getStatus(), mo.getCodesNum(), mo.getPlanedStartDate(),
						mo.getPlanedFinishDate(), mo.getActualStartDate(), mo.getActualFinishDate() });
	}

	public void update(final TaskMo mo) {
		final StringBuffer sql = new StringBuffer();
		sql.append("UPDATE t_tasks set");
		sql.append("name=?,description=?,developer=?,status=?,codesNum=?");
		sql.append(",planedStartDate=?,planedFinishDate=?,actualStartDate=?,actualFinishDate=?");
		sql.append(" WHERE ");
		sql.append(" id=?");
		dao.update(
				sql.toString(),
				new Object[] { mo.getName(), mo.getDescription(), mo.getDeveloper(),
						mo.getStatus(), mo.getCodesNum(), mo.getPlanedStartDate(),
						mo.getPlanedFinishDate(), mo.getActualStartDate(),
						mo.getActualFinishDate(), mo.getId() });
	}
}
