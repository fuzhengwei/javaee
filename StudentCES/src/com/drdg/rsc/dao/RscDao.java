package com.drdg.rsc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.drdg.rsc.bean.RscBean;
import com.drdg.util.conndb.GetSelectQuery;

/*************************************************************************************************
 * ²éÑ¯×ÛºÏ³É¼¨sqlÓï¾ä
 * ******************************************************************
 * ***************************** select MAX(c.stu_id) rsc_id, c.stu_name
 * stu_name, d.cat_name cat_name, SUM(cast(a.res_fraction as int))
 * rsc_o_fraction, max(d.cat_weight) rsc_weight, SUM(cast(a.res_fraction as int)
 * )*max(d.cat_weight)/100.0 rsc_fraction, max(a.res_entrydate) rsc_date from
 * dbo.results a,dbo.course b,dbo.student c,dbo.category d where a.fk_cou_id =
 * b.cou_id and a.fk_stu_id = c.stu_id and b.fk_cat_id = d.cat_id group by
 * c.stu_name,d.cat_name order by c.stu_name desc
 ************************************************************************************************/
public class RscDao extends GetSelectQuery {

	public ArrayList<RscBean> doSelectRSC(String stu_name) {

		ArrayList<RscBean> modelList = new ArrayList<RscBean>();

		StringBuffer sbSql = new StringBuffer();

		sbSql
				.append("select MAX(c.stu_id) rsc_id,")
				.append("c.stu_name stu_name,")
				.append("d.cat_name cat_name,")
				.append("SUM(cast(a.res_fraction as int)) rsc_o_fraction,")
				.append("max(d.cat_weight) rsc_weight,")
				.append(
						"SUM(cast(a.res_fraction as int) )*max(d.cat_weight)/100.0 rsc_fraction,")
				.append("max(a.res_entrydate) rsc_date ")
				.append(
						"from dbo.results a,dbo.course b,dbo.student c,dbo.category d ");

		if ("".equals(stu_name)) {
			sbSql
					.append(
							"where a.fk_cou_id = b.cou_id and a.fk_stu_id = c.stu_id and b.fk_cat_id = d.cat_id and a.res_state = '1' ")
					.append(
							"group by c.stu_name,d.cat_name order by c.stu_name desc");
		} else {
			sbSql
					.append(
							"where a.fk_cou_id = b.cou_id and a.fk_stu_id = c.stu_id and b.fk_cat_id = d.cat_id and a.res_state = '1' and c.stu_name like '%")
					.append(stu_name)
					.append(
							"%' group by c.stu_name,d.cat_name order by c.stu_name desc");
		}

		try {
			ps = super.getPs(sbSql.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				RscBean model = new RscBean();
				model.setRsc_id(rs.getString("rsc_id"));
				model.setStu_name(rs.getString("stu_name"));
				model.setCat_name(rs.getString("cat_name"));
				model.setRsc_o_fraction(rs.getString("rsc_o_fraction"));
				model.setRsc_weight(rs.getString("rsc_weight"));
				model.setRsc_fraction(rs.getString("rsc_fraction"));
				model.setRsc_date(rs.getString("rsc_date"));

				modelList.add(model);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modelList;

	}

}
