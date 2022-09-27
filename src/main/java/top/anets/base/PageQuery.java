package top.anets.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

/**
 * @Author ftm
 * @Date 2022-09-13 15:09:40
 * @Description Query分页构造器
 */

@Data
public class PageQuery {
    Integer size;
    Integer current;
    public IPage Page(){
        IPage page = new Page<>(current, size);
        return page;
    }

    public IPage page(){
        IPage page = new Page<>(current, size);
        return page;
    }
}