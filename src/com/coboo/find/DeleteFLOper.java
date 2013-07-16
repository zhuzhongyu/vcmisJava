package com.coboo.find;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.Common;
import com.datebase.HibernateSessionFactory;

public class DeleteFLOper {

	// ɾ��
	@SuppressWarnings("unchecked")
	public static boolean delete(String id, String flname) {
		String hql = "";
		if (flname.equals("dbh")) {
			hql = hql + "from MinimumGuarantees m where m.residents.id=" + id
					+ "";
		}
		if (flname.equals("yfry")) {
			hql = hql + "from ReliefReceivers r where r.residents.id=" + id
					+ "";
		}
		if (flname.equals("cjry")) {
			hql = hql + "from HandicapPersions h where h.residents.id=" + id
					+ "";
		}
		if (flname.equals("gzry")) {
			hql = hql + "from DisimprisonPeople d where d.residents.id=" + id
					+ "";
		}
		if (flname.equals("gglr")) {
			hql = hql + "from EmptyNester e where e.residents.id=" + id + "";
		}
		if (flname.equals("zjyry")) {
			hql = hql + "from ReemployedPeople r where r.residents.id=" + id
					+ "";
		}
		if (flname.equals("flgry")) {
			hql = hql + "from FalungongExerciser f where f.residents.id=" + id
					+ "";
		}
		if (flname.equals("xdry")) {
			hql = hql + "from DrugAddicts d where d.residents.id=" + id + "";
		}
		if (flname.equals("ldrk")) {
			hql = hql + "from Floating f where f.residents.id=" + id + "";
		}
		if (flname.equals("qiaoqing")) {
			hql = hql + "from Qiaoqing f where f.residents.id=" + id + "";
		}
		if (flname.equals("sfm")) {
			hql = hql + "from Sanfangmian f where f.residents.id=" + id
					+ "";
		}
		if (flname.equals("sqjz")) {
			hql = hql + "from Shequjiaozheng d where d.residents.id=" + id + "";
		}
		if (flname.equals("xfr")) {
			hql = hql + "from Xinfangren f where f.residents.id=" + id + "";
		}
		Session session = HibernateSessionFactory.getSession();
		List list = Common.select(hql);
		Object from = (Object) list.get(0);
		try {
			Transaction tr = session.beginTransaction();
			session.delete(from);
			tr.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}
}
