package cn.etl.dao.impl;

import org.springframework.stereotype.Repository;

import cn.etl.dao.UnitDao;
import cn.etl.entity.Unit;
@Repository("unitDaoImpl")
public class UnitDaoImpl extends BaseDaoImpl<Unit> implements UnitDao{

}
