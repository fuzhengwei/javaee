package com.aps.db.dao.itfc.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.aps.db.conn.OracleConn;
import com.aps.db.dao.itfc.Car;
import com.aps.db.model.FenPage;
import com.aps.db.model._Car;
import com.aps.db.tem.CopyLimit;
import com.aps.db.tem.GetSelectQurey;

/**
 * ��������
 * @author Administrator
 *
 */
public class CarDAO extends GetSelectQurey implements Car{
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean doDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 *Ϊ�˽�����չ�����Զ������ݲ��� 
	 **/
	@Override
	public boolean doInster(ArrayList<_Car> alobj) {
		
		boolean bool = false;
		String sql = "insert into aps_car values(" +
					 "sdii.nextval,?,?,?,to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),?,?,?)";
		
		try {
			conn = OracleConn.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			
			for(_Car c:alobj){
				ps.setString(1, c.getCbrand());
				ps.setString(2, c.getCmodel());
				ps.setString(3, c.getCorigin());
				ps.setString(4, c.getCproduce());
				ps.setString(5, c.getCbuy());
				ps.setString(6, c.getCpripal());
				ps.setString(7, c.getCvolume());
				ps.setString(8, c.getCapac());
				if(ps.executeUpdate()>0){
					bool = true;
				}
			}
			//�ύ
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				//����ع�
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return bool;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<_Car> doSelect() {
		ArrayList<_Car> alcar = new ArrayList<_Car>();
		/*�ж����Ե�һ��ȡ���ݿ���Ϣʱ��ѷ�ҳ��Ϣ���ؽ�ȥ*/
		boolean pdFp = false;
		
		try {
			/**
			 * Ĭ�Ϸ�ҳ
			 * cid	cbrand	cmodel	corigin	cproduce	cbuy	cpripal	cvolume	capac
			 * */
			CopyLimit limit = new CopyLimit();
			rs = limit.doLimit("aps_car", "cid", "1", "5");
			
			while(rs.next()){
				_Car car = new _Car();
				car.setCid(rs.getString(1));
				car.setCbrand(rs.getString(2));
				car.setCmodel(rs.getString(3));
				car.setCorigin(rs.getString(4));
				car.setCproduce(rs.getString(5));
				car.setCbuy(rs.getString(6));
				car.setCpripal(rs.getString(7));
				car.setCvolume(rs.getString(8));
				car.setCapac(rs.getString(9));
				
				if(!pdFp){
					limit.doCount();
					car.setPageCount(limit.doCount());	//��ʾһ���ж���������
					car.setPageNow("1");				//��ǰҳΪ��0ҳ
					car.setPageNum(limit.pageNum);		//ÿҳ��ʾ�� ����� ��������1 2 3 4 5
					car.setPageSize(limit.pageSize);	//ÿҳ��С��������ʾ����������
					car.setPageS(limit.doPageS());		//��ʾһ���ֳܷ�������ҳ
					pdFp = true;
				}
				
				alcar.add(car);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alcar;
	}
	
	/**
	 * ����������ѯ��Ϣ
	 */
	@Override
	public ArrayList<_Car> doSelect(_Car car) {
		
		ArrayList<_Car> alcar = new ArrayList<_Car>();
		CopyLimit limit = new CopyLimit();
		int setstart = 1;
		/**
		 *��������������Ϊtrue��ʾ��ģ����ѯ
		 *�������Ϊfalse��ʾ�Ǿ�ȷ��ѯ 
		 **/
		boolean pdstype = car.isStype();
		StringBuffer sbsql = new StringBuffer("select * from aps_car where ");
		if(pdstype){
			if(car.getCbrand() != null){
				sbsql.append("cbrand = ? and ") ;
			}
			if(car.getCmodel() != null){
				sbsql.append("cmodel = ? and ");
			}
			if(car.getCorigin() != null){
				sbsql.append("corigin = ? and ");
			}
			if(car.getCproduce() != null){
				sbsql.append("cproduce = ? and ");
			}
			if(car.getCbuy()!= null){
				sbsql.append("cbuy = ? and ");
			}
			if(car.getCpripal() != null){
				sbsql.append("cpripal = ? and ");
			}
			if(car.getCvolume() != null){
				sbsql.append("cvolume = ? and ");
			}
			if(car.getCapac() != null){
				sbsql.append("capac = ?");
			}else if(pdstype){
				sbsql.replace(sbsql.lastIndexOf("and"),sbsql.length()-1, "");
			}
		}else{
			sbsql.append("cbrand like ? or" +
					     " cmodel like ? or" +
					     " corigin like ? or" +
					     " cproduce like ? or" +
					     " cbuy like ? or" +
					     " cpripal like ? or" +
					     " cvolume like ? or" +
					     " capac like ?");
		}
		 System.out.println(sbsql.toString());
		try {
			ps = super.getPs(sbsql.toString());
			/**
			 *��������ֵ 
			 **/
			if(pdstype){
				if(car.getCbrand()!= null){
					ps.setString(setstart, car.getCbrand());
					setstart ++;
				}
				if(car.getCmodel() != null){
					ps.setString(setstart, car.getCmodel());
					setstart ++;
				}
				if(car.getCorigin() != null){
					ps.setString(setstart, car.getCorigin());
					setstart ++;
				}
				if(car.getCproduce() != null){
					ps.setString(setstart, car.getCproduce());
					setstart ++;
				}
				if(car.getCbuy()!= null){
					ps.setString(setstart, car.getCbuy());
					setstart ++;
				}
				if(car.getCpripal() != null){
					ps.setString(setstart, car.getCpripal());
					setstart ++;
				}
				if(car.getCvolume() != null){
					ps.setString(setstart, car.getCvolume());
					setstart ++;
				}
				if(car.getCapac() != null){
					ps.setString(setstart, car.getCapac());
					setstart ++;
				}
			}else{
				ps.setString(1, "%"+car.getCbrand()+"%");
				ps.setString(2, "%"+car.getCmodel()+"%");
				ps.setString(3, "%"+car.getCorigin()+"%");
				ps.setString(4, "%"+car.getCproduce()+"%");
				ps.setString(5, "%"+car.getCbuy()+"%");
				ps.setString(6, "%"+car.getCpripal()+"%");
				ps.setString(7, "%"+car.getCvolume()+"%");
				ps.setString(8, "%"+car.getCapac()+"%");
			}
			
			rs = ps.executeQuery();
			int rssum = 0;
			boolean pdFp = false;
			
			while(rs.next()){
				_Car cars = new _Car();
				cars.setCbrand(rs.getString(2));
				cars.setCmodel(rs.getString(3));
				cars.setCorigin(rs.getString(4));
				cars.setCproduce(rs.getString(5));
				cars.setCbuy(rs.getString(6));
				cars.setCpripal(rs.getString(7));
				cars.setCvolume(rs.getString(8));
				cars.setCapac(rs.getString(9));
				/*��ҳ��Ϣװ��ȥ*/
				if(!pdFp){
					limit.setTable("aps_car");
					cars.setPageCount(limit.doCount());	//��ʾһ���ж���������
					cars.setPageNow("1");				//��ǰҳΪ��0ҳ
					cars.setPageNum(limit.pageNum);		//ÿҳ��ʾ�� ����� ��������1 2 3 4 5
					cars.setPageSize(limit.pageSize);	//ÿҳ��С��������ʾ����������
					cars.setPageS(limit.doPageS());		//��ʾһ���ֳܷ�������ҳ
					pdFp = true;
				}
				alcar.add(cars);
				
				/**
				 * ���װ��ȥ10�������ˣ��Ͳ���װ��
				 */
				if(rssum >= 10){
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alcar;
	}

	@Override
	public boolean doUpdate(ArrayList<_Car> obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ��ҳЧ����ѯ
	 * */
	@SuppressWarnings("static-access")
	@Override
	public ArrayList<_Car> doSelectPage(FenPage fpage) {
		// TODO Auto-generated method stub
		ArrayList<_Car> alcar = new ArrayList<_Car>();
		/*�ж����Ե�һ��ȡ���ݿ���Ϣʱ��ѷ�ҳ��Ϣ���ؽ�ȥ*/
		boolean pdFp = false;
		
		try {
			/**
			 * Ĭ�Ϸ�ҳ
			 * cid	cbrand	cmodel	corigin	cproduce	cbuy	cpripal	cvolume	capac
			 * */
			CopyLimit limit = new CopyLimit();
			rs = limit.doLimit("aps_car", "cid", fpage.getPageNow(), CopyLimit.pageSize);
			
			while(rs.next()){
				_Car car = new _Car();
				car.setCid(rs.getString(1));
				car.setCbrand(rs.getString(2));
				car.setCmodel(rs.getString(3));
				car.setCorigin(rs.getString(4));
				car.setCproduce(rs.getString(5));
				car.setCbuy(rs.getString(6));
				car.setCpripal(rs.getString(7));
				car.setCvolume(rs.getString(8));
				car.setCapac(rs.getString(9));
				
				if(!pdFp){
					limit.doCount();
					car.setPageCount(limit.doCount());										//��ʾһ���ж���������
					car.setPageNow(String.valueOf(Integer.valueOf(fpage.getPageNow()) + 1));//��ǰҳΪ�ڼ�ҳ
					car.setPageNum(limit.pageNum);											//ÿҳ��ʾ�� ����� ��������1 2 3 4 5
					car.setPageSize(limit.pageSize);										//ÿҳ��С��������ʾ����������
					car.setPageS(limit.doPageS());											//��ʾһ���ֳܷ�������ҳ
					pdFp = true;
				}
				
				alcar.add(car);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alcar;
	}

}
