package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.DataGridInfo;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public TbItem getItemById(Long id) {
		// TODO Auto-generated method stub
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
		return tbItem;
	}
	@Override
	public DataGridInfo getItem(int page, int rows) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);
		PageInfo<TbItem> pageList = new PageInfo<>(list);
		long total = pageList.getTotal();
		DataGridInfo dataGridInfo  =  new DataGridInfo();
		dataGridInfo.setTotal((int)total);
		dataGridInfo.setRows(list);
		return dataGridInfo;
	}

}
