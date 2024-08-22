package top.siegel.usermanagement.dto;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @projectName: user-management
 * @package: top.siegel.usermanagement.dto
 * @className: BaseDTO
 * @author: Siegel
 * @createDate: 2024/8/22
 * @createTime: 18:58
 * @description: BaseDTO
 */
public class BaseDTO<T> {
    /**
     * 将数据拷贝到数据库模型
     *
     * @param t 数据库模型
     */
    public void copyDataTo(T t) {
        try {
            // 获取当前类的所有属性
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                // 获取属性名
                String fieldName = field.getName();
                if (getExcludeFields().contains(fieldName)) {
                    continue;
                }
                // 获取属性值
                field.setAccessible(true);
                Object fieldValue = field.get(this);
                // 获取数据库模型的属性
                Field tField = t.getClass().getDeclaredField(fieldName);
                tField.setAccessible(true);
                // 设置属性值
                tField.set(t, fieldValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否有修改
     *
     * @param t 数据库模型
     * @return 是否有修改
     */
    public boolean isNotModified(T t) {
        try {
            // 获取当前类的所有属性
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                // 获取属性名
                String fieldName = field.getName();
                if (getExcludeFields().contains(fieldName)) {
                    continue;
                }
                // 获取数据库模型的属性
                Field tField = t.getClass().getDeclaredField(fieldName);
                tField.setAccessible(true);
                // 获取数据库模型的属性值
                Object tFieldValue = tField.get(t);
                // 获取属性值
                field.setAccessible(true);
                Object fieldValue = field.get(this);
                // 判断是否有修改
                if (!Objects.equals(fieldValue, tFieldValue)) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 转换为对应的数据库模型
     *
     * @return 数据库模型
     */
    public T toEntity(Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            copyDataTo(t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected List<String> getExcludeFields() {
        return new ArrayList<>();
    }

}
