package ${package};
import ${MyBasePackage}.${MyModuleName}.entity.${MyEntity};
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class  ${MyEntity}Vo extends ${MyEntity}{

}