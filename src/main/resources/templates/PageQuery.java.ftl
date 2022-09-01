package ${package};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

/**
 * @Author ${author}
 * @Date ${date}
 * @Description ${comments!''}
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