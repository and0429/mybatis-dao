package org.mybatis.basedao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 数据访问层操作接口,
 * 
 * ************************************<br/>
 * 如果你的SQL的Id和方法名称一样。那么请调用不带sqlId参数的方法，<br/>
 * 如果不一样，请传入你的SQLID<br/>
 * ************************************ <br/>
 * 
 * @author zhangkai
 *
 */
public interface BaseDao<T> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            要保存的实体
	 * @return 影响的行数
	 */
	int save(T entity, String sqlId);

	int save(T entity);

	/**
	 * 根据Id删除实体
	 * 
	 * @param id
	 *            主键
	 * @return 影响的行数
	 */
	int delete(Serializable id, String sqlId);

	int delete(Serializable id);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 *            待更新的实体
	 * @return 影响的行数
	 */
	int update(T entity, String sqlId);

	int update(T entity);

	/**
	 * 根据Id获取实体
	 * 
	 * @param id
	 * @return 实体或者null
	 */
	T getById(Serializable id, String sqlId);

	T getById(Serializable id);

	/**
	 * 获取所有的实体集合
	 * 
	 * @return 查询到的集合
	 */
	List<T> getAll(String sqlId);

	List<T> getAll();

	/**
	 * 获取记录的总条数
	 * 
	 * @return 总条数
	 */
	Integer getCount(String sqlId);

	Integer getCount();

	/**
	 * 根据条件查询所有的实体集合
	 * 
	 * @param entity
	 *            封装了条件
	 * @return 查询到的集合
	 */
	List<T> getWithCondition(T entity, String sqlId);

	List<T> getWithCondition(T entity);

	/**
	 * 根据条件查询实体集合的总数量
	 * 
	 * @param entity
	 *            封装条件
	 * @return 查询到的集合
	 */
	Integer getCountWithCondition(T entity, String sqlId);

	Integer getCountWithCondition(T entity);

	/**
	 * 根据条件查询实体集合
	 * 
	 * @param param
	 *            封装条件
	 * @return 查询到的集合
	 */
	List<T> getWithCondition(Map<String, ? extends Object> param, String sqlId);

	List<T> getWithCondition(Map<String, ? extends Object> param);

	/**
	 * 根据条件查询实体集合的总数量
	 * 
	 * @param param
	 *            封装条件
	 * @return 查询到的集合
	 */
	Integer getCountWithCondition(Map<String, ? extends Object> param, String sqlId);

	Integer getCountWithCondition(Map<String, ? extends Object> param);

}
