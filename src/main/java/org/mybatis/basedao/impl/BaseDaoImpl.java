package org.mybatis.basedao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.basedao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 数据访问层操作实现
 * 
 * @author zhangkai
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	/**
	 * 
	 */
	@Autowired
	protected SqlSession session;

	/**
	 * 
	 */
	protected Class<T> clazz;

	/**
	 * 构造器
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = ((Class<T>) type.getActualTypeArguments()[0]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#delete(java.io.Serializable)
	 */
	public int delete(Serializable id) {
		return delete(id, "delete");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#delete(java.io.Serializable,
	 * java.lang.String)
	 */
	public int delete(Serializable id, String sqlId) {
		return session.delete(clazz.getName() + "." + sqlId, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getAll()
	 */
	public List<T> getAll() {
		return getAll("getAll");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getAll(java.lang.String)
	 */
	public List<T> getAll(String sqlId) {
		return session.selectList(clazz.getName() + "." + sqlId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getById(java.io.Serializable)
	 */
	public T getById(Serializable id) {
		return getById(id, "getById");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getById(java.io.Serializable,
	 * java.lang.String)
	 */
	public T getById(Serializable id, String sqlId) {
		return session.selectOne(clazz.getName() + "." + sqlId, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getCount()
	 */
	public Integer getCount() {
		return getCount("getCount");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getCount(java.lang.String)
	 */
	public Integer getCount(String sqlId) {
		return session.selectOne(clazz.getName() + "." + sqlId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getCountWithCondition(java.util.Map)
	 */
	public Integer getCountWithCondition(Map<String, ? extends Object> param) {
		return getCountWithCondition(param, "getCountWithCondition");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getCountWithCondition(java.util.Map,
	 * java.lang.String)
	 */
	public Integer getCountWithCondition(Map<String, ? extends Object> param, String sqlId) {
		return session.selectOne(clazz.getName() + "." + sqlId, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getCountWithCondition(java.lang.Object)
	 */
	public Integer getCountWithCondition(T entity) {
		return getCountWithCondition(entity, "getCountWithCondition");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getCountWithCondition(java.lang.Object,
	 * java.lang.String)
	 */
	public Integer getCountWithCondition(T entity, String sqlId) {
		return session.selectOne(clazz.getName() + "." + sqlId, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getWithCondition(java.util.Map)
	 */
	public List<T> getWithCondition(Map<String, ? extends Object> param) {
		return getWithCondition(param, "getWithCondition");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getWithCondition(java.util.Map,
	 * java.lang.String)
	 */
	public List<T> getWithCondition(Map<String, ? extends Object> param, String sqlId) {
		return session.selectList(clazz.getName() + "." + sqlId, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getWithCondition(java.lang.Object)
	 */
	public List<T> getWithCondition(T entity) {
		return getWithCondition(entity, "getWithCondition");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#getWithCondition(java.lang.Object,
	 * java.lang.String)
	 */
	public List<T> getWithCondition(T entity, String sqlId) {
		return session.selectList(clazz.getName() + "." + sqlId, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#save(java.lang.Object)
	 */
	public int save(T entity) {
		return save(entity, "save");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#save(java.lang.Object, java.lang.String)
	 */
	public int save(T entity, String sqlId) {
		return session.insert(clazz.getName() + "." + sqlId, entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#update(java.lang.Object)
	 */
	public int update(T entity) {
		return update(entity, "update");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mybatis.basedao.BaseDao#update(java.lang.Object,
	 * java.lang.String)
	 */
	public int update(T entity, String sqlId) {
		return session.update(clazz.getName() + "." + sqlId, entity);
	}
}
