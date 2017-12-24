package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.pojo.TreeNode;

public interface ContentCatService {
	List<TreeNode> getContentCatList(Long parentId);
}
