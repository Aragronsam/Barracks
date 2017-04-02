/**
 * GenericDAO.java
 * Create by Liyw -- 2014-5-6
 */
package com.binaryhunter.framework.dao;

import java.util.List;
import java.util.Map;

/**
 * 通用持久层接口
 * @author Liyw -- 2014-5-6
 */
public interface GenericDAO<B,K> {
	public B getById(K id);
	/**
	 * 新增
	 * @param bean
	 * Create by Liyw -- 2014-5-6
	 */
	public void create(B bean);
	/**
	 * 删除
	 * @param id
	 * Create by Liyw -- 2014-5-7
	 */
	public void deleteById(K id);
	/**
	 * 删除
	 * @param idIn 标识集字符串 以','号分割
	 * Create by Liyw -- 2014-9-5
	 */
	public void deleteByIds(String idIn);
	/**
	 * 修改
	 * @param bean
	 * Create by Liyw -- 2014-5-6
	 */
	public void update(B bean);
	/**
	 * 批量修改
	 * @param beans
	 * Create by Liyw -- 2014-5-6
	 */
	public void updateBatch(List<B> beans);
	
	/**
	 * 获取序列
	 * @return
	 * Create by Liyw -- 2014-5-6
	 */
	public K getSequence();
	
	/**
	 * 条件查询
	 * @param params
	 * @return
	 * Create by Liyw -- 2014-5-6
	 */
	public List<B> queryByArgs(Map<String, Object> params);
	
	/**
	 * 条件查询
	 * @param params
	 * @return
	 * Create by Liyw -- 2014-5-6
	 */
	public List<B> pageByArgs(Map<String, Object> params);
	
	/**
	 * 添加查询数量
	 * @param params
	 * @return
	 * Create by Liyw -- 2014-5-6
	 */
	public Long countByArgs(Map<String, Object> params);
}
