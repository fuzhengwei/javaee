package com.aps.servlet;
/*
 * �ܹ�˾
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aps.db.conn.OracleConn;
import com.aps.db.dao.itfc.imp.CarDAO;
import com.aps.db.dao.itfc.imp.V_PdLoginDAO;
import com.aps.db.model.FenPage;
import com.aps.db.model.V_PdLogin;
import com.aps.db.model._Car;
import com.aps.log.imp.UserLog;
import com.aps.servlet.methods.AuthorityServlet;
import com.aps.servlet.methods.CapacityServlet;
import com.aps.servlet.methods.CustomerServlet;
import com.aps.servlet.methods.DpointServlet;
import com.aps.servlet.methods.DrangeServlet;
import com.aps.servlet.methods.EirServlet;
import com.aps.servlet.methods.EmpServlet;
import com.aps.servlet.methods.OlistServlet;
import com.aps.servlet.methods.RouteServlet;
import com.aps.servlet.methods.SparameterServlet;
import com.dhls.factory.control.Main;

public class Corporation extends HttpServlet {

	private V_PdLoginDAO vpdDAO;
	private CarDAO carDAO;
	private UserLog userLog;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ��ô�������typeֵ������ȷ���û�Ҫִ��ʲô����
		 * 0��ʾ��¼
		 * 1 1 ��ʾ car����
		 * 1 4 ��ʾ car�鿴
		 * 1 5 ���� car��ҳ
		 * 1 6����  car����
		 * 
		 * 2 1 ��ʾroute����
		 * 3 1 ��ʾdpoint����
		 * ....
		 * */
		int type = Integer.parseInt(request.getParameter("type"));
		
		try {
			
			switch (type) {
			
			//��֤��¼
			case 0:
				empLogin(request,response);
				break;
			
			//��������
			case 1:
				int key = Integer.valueOf(request.getParameter("key"));
				switch (key) {
				/*���ӳ���*/
				case 1:
					doAddCar(request,response);
					break;
				/*ɾ������*/
				case 2:
					
					break;
				/*�޸ĳ���*/	
				case 3:
					
					break;
				/*�鿴����*/
				case 4:
					doListCar(request,response);
					break;
				/*ÿ�ε����ҳִ��*/
				case 5:
					//���Ҫ��ת��ҳ
					doCarPage(request,response);
					break;
				/*��������*/
				case 6:
					doCarSelect(request,response);
					break;
				default:
					break;
				}
				break;
				
			//·�߹���
			case 2:
				int key2 = Integer.valueOf(request.getParameter("key"));
				switch (key2) {
				/*���*/
				case 1:
					RouteServlet.doAddRoute(request,response);
					break;
				/*ɾ��*/
				case 2:
					break;
				/*�޸�*/	
				case 3:
					break;
				/*�鿴*/
				case 4:
					RouteServlet.doListRoute(request, response);
					break;
				/*ִ�з�ҳ*/
				case 5:
					RouteServlet.doPageRoute(request, response);
					break;
				/*��·��������ݷ�װ�õ�·��;���㴦*/
				case 6:
					RouteServlet.doGetPointToRw(request,response);
					break;
				/*����·��;����*/
				case 7:
					RouteServlet.doInsertRw(request,response);
					break;
				default:
					break;
				}
				break;
				
			//���͵����
			case 3:
				int key3 = Integer.valueOf(request.getParameter("key"));
				switch (key3) {
				/*����*/
				case 1:
					DpointServlet.doAddRoute(request,response);
					break;
				/*ɾ��*/
				case 2:
					break;
				/*�޸�*/
				case 3:
					break;
				/*�鿴*/
				case 4:
					DpointServlet.doListRoute(request, response);
					break;
				/*��ҳ*/
				case 5:
					DpointServlet.doPageRoute(request, response);
					break;
				/*����*/
				case 6:
					break;
				/*������ͼ����Ϣ�鿴*/
				case 7:
					DpointServlet.doV_empDetail(request,response);
					break;
				default:
					break;
				}
				break;
			/*��������*/
			case 4:
				int key4 = Integer.valueOf(request.getParameter("key"));
				switch (key4) {
				/*��������*/
				case 1:
					CapacityServlet.doAddCapacity(request,response);
					break;
				/*ɾ������*/
				case 2:
					break;
				/*�޸�����*/
				case 3:
					break;
				/*�鿴����*/
				case 4:
					CapacityServlet.doSelectAllPage(request,response);
					break;
				/*��������*/
				case 5:
					break;
				/*Ϊ��������ҳ��װ����Ϣ*/	
				case 6:
					CapacityServlet.doGetMessageToCorPage(request,response);
					break;
				default:
					break;
				}
				break;
			/*ϵͳ��������*/
			case 5:
				int key5 = Integer.valueOf(request.getParameter("key"));
				switch (key5) {
				//����ϵͳ����
				case 1:
					SparameterServlet.doAddSparameter(request,response);
					break;

				default:
					break;
				}
				break;
			/*Ա������*/
			case 6:
				int key6 = Integer.valueOf(request.getParameter("key"));
				switch (key6) {
				//����Ա��
				case 1:
					EmpServlet.doAddEmp(request,response);
					break;
				//ɾ��
				case 2:
					break;
				//�޸�
				case 3:
					break;
				//�鿴
				case 4:
					break;
				//��ҳ
				case 5:
					EmpServlet.doPageRoute(request, response);
					break;
				//����
				case 6:
//					EmpServlet
					break;
				//������
				case 7:
					
					break;
					
				default:
					break;
				}
				break;
			/*���ͷ�Χ����*/
			case 7:
				int key7 = Integer.valueOf(request.getParameter("key"));
				switch (key7) {
				//����
				case 1:
					DrangeServlet.doAddDranger(request,response);
					break;
				//ɾ��
				case 2:
					break;
				//�޸�
				case 3:
					
					break;
				//�鿴-ֱ�ӷ�ҳ��ʽ�Ͳ鿴
				case 4:
					DrangeServlet.doPageDrange(request,response);
					break;
				//����-������������Ϣ
				case 5:
					
					break;
				//��װ��Ϣ���������͵㷶Χҳ��
				case 6:
					DrangeServlet.addDpointToPage(request,response);
					break;
				default:
					break;
				}
				
				break;
			case 8:
				break;
			case 9:
				break;
			/*��������*/
			case 10:
				int key10 = Integer.valueOf(request.getParameter("key"));
				switch (key10) {
				//���Ӷ���
				case 1:
					
					break;
				//ɾ������
				case 2:
					
					break;
				//�޸Ķ���
				case 3:
					
					break;
				//�鿴����
				case 4:
					OlistServlet.doSelectOnPage(request,response);
					break;
				//��������
				case 5:
					
					break;
				default:
					break;
				}
				break;
			/*���ӵ�����*/
			case 11:
				int key11 = Integer.valueOf(request.getParameter("key"));
				switch (key11) {
				//���ӽ��ӵ�
				case 1:
					
					break;
				//ɾ�����ӵ�
				case 2:
					
					break;
				//�޸Ľ��ӵ�
				case 3:
					
					break;
				//�鿴���ӵ�
				case 4:
					EirServlet.doSelectOnPage(request,response);
					break;
				default:
					break;
				}
				break;
			case 12:
				Main.doDownHtml(request,response);
				break;
			/*Ȩ�޹���*/
			case 13:
				int key13 = Integer.valueOf(request.getParameter("key"));
				switch (key13) {
				/*����Ȩ��*/
				case 1:
					AuthorityServlet.doAddAuthority(request,response);
					break;
				/*ɾ��*/
				case 2:
					break;
				/*�޸�*/
				case 3:
					break;
				/*�鿴�Է�ҳ��ʽ*/
				case 4:
					AuthorityServlet.doSelect(request,response);
					break;
				/*��Ȩ*/
				case 5:
					AuthorityServlet.doGrantTo(request,response);
					break;
				/*�鿴��Ϣ����Ȩҳ��*/
				case 6:
					AuthorityServlet.doSelectAll(request,response);
					break;
				default:
					break;
				}
				break;
			/*�ͻ�����*/
			case 14:
				int key14 = Integer.valueOf(request.getParameter("key"));
				switch (key14) {
				//���ӿͻ�
				case 1:
					CustomerServlet.doAddCustomer(request,response);
					break;
				//ɾ��
				case 2:
					CustomerServlet.doDeleteCustomerById(request,response);
					break;
				//�޸�
				case 3:
					CustomerServlet.doUpdateCustomer(request,response);
					break;
				//�鿴
				case 4:
					CustomerServlet.doSelectOnPage(request,response);
					break;
				//����	
				case 5:
					break;
				default:
					break;
				}
				break;
			case 15:
				break;
			case 16:
				break;
			default:
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * �����������в�ѯ
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doCarSelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * �������ݹ���������Ϣ
		 * ����Ӧ���������
		 * */
		String str = request.getParameter("sosotext");
		String regex = "([\u4E00-\u9FA5]{2,5})[��](.*?)��";
		Matcher mc = Pattern.compile(regex).matcher(str);
		_Car carsoso = new _Car();
		
		if(str.matches(regex)){
			//�߼�����
			carsoso.setStype(true);
			while(mc.find()){
				
				if("���ƺ�".equals(mc.group(1))){
					carsoso.setCbrand(mc.group(2));
				}
				if("�ͺ�".equals(mc.group(1))){
					carsoso.setCmodel(mc.group(2));
				}
				if("����".equals(mc.group(1))){
					carsoso.setCorigin(mc.group(2));
				}
				if("����ʱ��".equals(mc.group(1))){
					carsoso.setCpripal(mc.group(2));
				}
				if("����ʱ��".equals(mc.group(1))){
					carsoso.setCbuy(mc.group(2));
				}
				if("����������".equals(mc.group(1))){
					carsoso.setCpripal(mc.group(2));
				}
				if("���".equals(mc.group(1))){
					carsoso.setCvolume(mc.group(2));
				}
				if("����".equals(mc.group(1))){
					carsoso.setCapac(mc.group(2));
				}
			}
		}else{
			//��ͨ����
			str = str.replace("��", "");
			carsoso.setStype(false);
			carsoso.setCbrand(str);
			carsoso.setCmodel(str);
			carsoso.setCorigin(str);
			carsoso.setCproduce(str);
			carsoso.setCbuy(str);
			carsoso.setCpripal(str);
			carsoso.setCvolume(str);
			carsoso.setCapac(str);
		}
	
		/*������������*/
		request.setAttribute("alcar", carDAO.doSelect(carsoso));
		request.getRequestDispatcher("ZzCorporation/car/car_list.jsp").forward(request, response);
	}
	/****************************
	 * ��ѯ�������ҷ�ҳ�ֳ���
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 ****************************/
	private void doCarPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FenPage fpage = new FenPage();
		fpage.setPageNow(request.getParameter("pageNow"));
		request.setAttribute("alcar", carDAO.doSelectPage(fpage));
		request.getRequestDispatcher("ZzCorporation/car/car_list.jsp").forward(request, response);
	}
	/*****************
	 * �鿴����
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 *****************/
	private void doListCar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("alcar", carDAO.doSelect());
		request.getRequestDispatcher("ZzCorporation/car/car_list.jsp").forward(request, response);
		
	}

	/*******************
	 * ���ӳ�����һ������
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 *******************/
	private void doAddCar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		_Car car = new _Car();
		car.setCbrand(request.getParameter("cbrand"));
		car.setCmodel(request.getParameter("cmodel"));
		car.setCorigin(request.getParameter("tid1")+request.getParameter("tid2")+request.getParameter("tid3"));
		car.setCproduce(request.getParameter("cproduce"));
		car.setCbuy(request.getParameter("cbuy"));
		car.setCpripal(request.getParameter("cpripal"));
		car.setCvolume(request.getParameter("cvolume"));
		car.setCapac(request.getParameter("capac"));
		
		ArrayList<_Car> alc = new ArrayList<_Car>();
		alc.add(car);
		
		/*ִ�в��뺯��������֤�����Ƿ���ȷ*/
		if(carDAO.doInster(alc)){
			//����ɹ�
			System.out.println("ok");
			//��ת����ѯҳ��
			doListCar(request,response);
		}else{
			//����ʧ��
			System.out.println("error");
			//����ʧ�ܾͽ�����ʾҳ��
		}
	}

	/***************
	 * ��֤Ա����¼
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ServletException 
	 ***************/
	private void empLogin(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		V_PdLogin vpl = new V_PdLogin();
		
		vpl.setEid(request.getParameter("vid"));
		vpl.setEname(request.getParameter("vname"));
		/*ִ�е�¼��֤����*/
		vpl = vpdDAO.doLogin(vpl);
		
		if(!vpl.getDpid().equals("0")){
			System.out.println("��¼�ɹ�");
			//���Ȩ��Ϊ2˵�����ܹ�˾����Ա
			if("2".equals(vpl.getAuno())){
				request.getSession().setAttribute("vpl", vpl);
				response.sendRedirect("ZzCorporation/index.jsp");
				//д����־
				userLog.doSaveLog("��¼�ˣ�"+vpl.getEname());
		
				//���Ȩ��Ϊ3��˵�������͵����Ա
			}else if("3".equals(vpl.getAuno())){
				request.getSession().setAttribute("vpl", vpl);
				response.sendRedirect("ZzBranch/index.jsp");
				
				//д����־
				userLog.doSaveLog("��¼�ˣ�"+vpl.getEname());
			}
			
		}else{
			System.out.println("��¼ʧ��");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void destroy() {
		/*
		 * ���ٺ󣬹ر����ݿ���Դ
		 * */
		OracleConn.CloseConn();
	}
	/*��ʼ��*/
	public void init() throws ServletException {
		vpdDAO = new V_PdLoginDAO();
		carDAO = new CarDAO();
		userLog = UserLog.getUserLogSingleton();
	}
}
