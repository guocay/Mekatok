package mekatok.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 多路树 主要用在编码表
 * @author aCay
 * @since 2023.04.04
 */
@SuppressWarnings("rawtypes")
public class MultiwayTree<ELEMENT> {

	/**
	 * 父节点
	 */
	private final MultiwayTree parent;

    /**
     * 节点元素内容
     */
    private ELEMENT element;

    /**
     * 子节点
     */
    private List<MultiwayTree> subset;

	MultiwayTree(MultiwayTree parent) {
		this.parent = parent;
        this.subset = new ArrayList<>();
    }

	public static <ELEMENT> MultiwayTree<ELEMENT> root(ELEMENT element, List<MultiwayTree> subset){
		MultiwayTree<ELEMENT> mt = new MultiwayTree<>(null);
		if (element == null)
			throw new UnsupportedOperationException("element must is not null");
		mt.element = element;
		if (subset != null)
			mt.subset = subset;
		return mt;
	}

	public void link(MultiwayTree... subset){
		this.subset = Arrays.asList(subset);
	}

    /**
     * 添加
     * @param element 元素
     * @return 添加成功
     */
    public boolean put(MultiwayTree element){
        return this.subset.add(element);
    }

    /**
     * 添加
     * @param list 元素
     * @return 添加成功
     */
    public boolean putAll(List<MultiwayTree> list){
        return this.subset.addAll(list);
    }

    /**
     * 将自身从父节点删除
     * @return 是否删除成功
     */
    public boolean remove(){
        if (this.parent == null || this.parent.subset.size() < 1)
            return false;
        this.parent.subset.remove(this);
        return true;
    }

    /**
     * 将子节点从自身删除
     * @param tree 待删除的子节点
     * @return 是否删除成功
     */
    public boolean remove(MultiwayTree tree){
        if (this.subset.size() < 1)
            return false;
        return this.subset.remove(tree);
    }

    /**
     * 将全部子节点从自身删除
     */
    public void clear(){
        this.subset.clear();
    }


    // 修改子节点

    // 元素个数

    // 深度优先

    // 广度优先

}
