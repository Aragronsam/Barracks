/**
 * GenericService.java
 * Create by Liyw -- 2014-5-22
 */
package com.binaryhunter.framework.service;


import java.util.List;
import java.util.Map;

/**
 * 业务层泛型接口
 * @author Liyw -- 2014-5-22
 */
public interface GenericService<B,K> {
	public List<B> pageByArgs(Map<String, Object> params);
	
	public List<B> queryByArgs(Map<String, Object> params);
	
	public void deleteById(K id);
	
	public void update(B bean);
	
	public void updateBatch(List<B> beans);
	
	public void add(B bean);
	
	public B getById(K id);

	public long countByArgs(Map<String, Object> params);
}
