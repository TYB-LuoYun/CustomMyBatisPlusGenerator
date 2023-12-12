package ${package};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ${author}
 * @Date ${date}
 * @Description ${comments!''}
 */

@Data
@NoArgsConstructor
public class PageQuery {
    Integer size = 20;
    Integer current = 1;
    public IPage Page(){
        //防止重写
        if(current==null){
            current = 1;
        }
        if(size==null){
            size = 20;
        }
        IPage page = new Page<>(current, size);
        return page;
    }

    public PageQuery(boolean isBig){
        if(isBig == true){
            size=999;
        }
    }
}