package org.leo.zeng.core.support;

import java.util.List;
import org.leo.zeng.core.pojo.BaseEntity;
import org.leo.zeng.core.pojo.BaseObject;
import org.leo.zeng.core.pojo.BaseQuery;
import org.leo.zeng.core.pojo.Paging;

/**
 * DAO层的基本操作接口
 * @param <Entity> Entity类
 */
public interface BaseDao<Entity extends BaseEntity> {

    /**
     * 插入数据
     * @param param 参数
     * @return 执行记录数
     */
    public int insert(Entity param);

    /**
     * 删除数据
     * @param param 参数
     * @return 执行记录数
     */
    public int delete(Entity param);

    /**
     * 更新数据
     * @param param 参数
     * @return 执行记录数
     */
    public int update(Entity param);

    /**
     * 单一结果查询
     * @param param 查询条件
     * @return 查询结果
     */
    public Entity selectSingle(BaseQuery param);

    /**
     * 按条件查询
     * @param param 查询条件
     * @return 查询结果
     */
    public List<Entity> select(BaseQuery param);

    /**
     * 分页查询
     * @param param 查询条件
     * @return 查询结果
     */
    public Paging<BaseObject> selectPaging(BaseQuery param);
}
