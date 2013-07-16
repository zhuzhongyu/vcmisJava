/**
 * 
 */
package coboo.service.client.vcmisServiceEvaluation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.compass.core.CompassHit;
import org.compass.core.CompassHits;
import org.compass.core.CompassQueryBuilder;
import org.compass.core.CompassSession;

import com.coboo.find.Communitydao;
import com.datebase.Community;
import com.datebase.CommunityRegion;

import coboo.cpsDatabases.vcmisServiceEvaluation.CobooCompass;
import coboo.cpsDatabases.vcmisServiceEvaluation.GxyService;
import coboo.cpsDatabases.vcmisServiceEvaluation.Person;
import coboo.cpsDatabases.vcmisServiceEvaluation.YearService;

/**
 * @author user
 * 
 */
public class Gxy {
	private String orgId;
	private String year;
	CompassSession session = new CobooCompass().getCompass().openSession();

	public Gxy(String orgId, String year) {
		this.orgId = orgId;
		this.year = year;
	}

	public Gxy() {

	}

	public String getBasicTable() {
		CompassQueryBuilder queryBuilder = session.queryBuilder();
		CompassHits hits = queryBuilder.bool()
				.addMust(queryBuilder.wildcard("dah", this.orgId))			
				.addMust(queryBuilder.term("year", this.year))
				.addMust(queryBuilder.wildcard("Person.gxyInfo.diagTime", "*"))
				.toQuery()
				.hits();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb = new StringBuffer();
		// ======================================================
		sb.append("<GxyBasicTable>");
		// ------------------------------------------------------
		for (int i = 0; i < hits.length(); i++) {
			CompassHit hit = hits.hit(i);
			Person person = (Person) hit.getData();
			sb.append("<person>");
			sb.append("<name>" + person.getName() + "</name>");
			sb.append("<address>" + person.getAddress() + "</address>");
			String qzTime;
			try {
				qzTime = dateFormat
						.format(person.getGxyInfo().getDiagTime());
				sb.append("<diagTime>" + qzTime + "</diagTime>");
			} catch (Exception e) {
				sb.append("<diagTime>" + "" + "</diagTime>");
			}
		

			YearService yearGxyservice = null;
			List<YearService> services = person.getGxyInfo()
					.getYearServices();
			for (YearService yearservice : services) {
				if (yearservice.getYear().equals(this.year)) {
					yearGxyservice = yearservice;
					break;
				}
			}
			GxyService[] gxyServices = yearGxyservice.getServicesOfYear();
			if (gxyServices != null) {
				sb.append("<servicesOfYear>");
				for (int j = 0; j < gxyServices.length; j++) {
					if (gxyServices[j] == null)
						continue;
					Date serviceTime = gxyServices[j].getServiceTime();
					String formatServiceTime = "";
					if (serviceTime != null) {
						formatServiceTime = dateFormat.format(serviceTime);
					}
					sb.append("<s" + j + ">" + formatServiceTime + "</s" + j
							+ ">");
				}

				sb.append("</servicesOfYear>");
				sb.append("<if_HealthCheck>" + person.isIf_HealthCheck()
						+ "</if_HealthCheck>");
				sb.append("<if_standardManage>"
						+ person.getGxyInfo().isIf_standardManage()
						+ "</if_standardManage>");
				sb.append("<Satisfies>");
				for (int j = 0; j < gxyServices.length; j++) {
					if (gxyServices[j] == null)
						continue;
					sb.append("<s" + j + ">" + gxyServices[j].isIf_BpOK()
							+ "</s" + j + ">");
				}
				sb.append("</Satisfies>");
			}
			sb.append("<otherDisease>");
			sb.append("<zl>" + person.getGxyInfo().isIf_zl() + "</zl>");
			sb.append("<cardio_vascular_disease>"
					+ person.getGxyInfo().isIf_cardio_vascular_disease()
					+ "</cardio_vascular_disease>");
			sb.append("<cerebral_vascular_disease>"
					+ person.getGxyInfo().isIf_cerebral_vascular_disease()
					+ "</cerebral_vascular_disease>");
			sb.append("<respiratoryDisease>"
					+ person.getGxyInfo().isIf_respiratoryDisease()
					+ "</respiratoryDisease>");
			sb.append("<tnb>" + person.getGxyInfo().isIf_tnb() + "</tnb>");
			sb.append("</otherDisease>");
			sb.append("</person>");
		}
		// ------------------------------------------------------
		sb.append("</GxyBasicTable>");
		// ======================================================
		return new String(sb);

		// 统计*************
	}

	public String getTownshipSummary(String orgnum) {

		Community currentcom = Communitydao.getcurrcom(orgnum);
		StringBuffer sb = new StringBuffer();

		// *******************
		// ======================================================
		sb.append("<Gxystat>");
		for (Community com : currentcom.getList()) {
			List<CommunityRegion> Regions = Communitydao.getRegion(com.getId());

			int countgxy = 0;
			int firstservice = 0;
			int secondservice = 0;
			int thirdservice = 0;
			int fourthservice = 0;

			int if_tnb = 0;
			int if_zl = 0;
			int if_respiratoryDisease = 0;
			int if_cerebral_vascular_disease = 0;
			int if_cardio_vascular_disease = 0;

			int if_HealthCheck = 0;
			int if_BpOK = 0;

			int gfgl = 0;
			float jkgll = 0;
			float gfgll = 0;
			float bp = 0;
			for (CommunityRegion cr : Regions) {
				CompassHits hits = null;
				CompassQueryBuilder cqb = session.queryBuilder();

				hits = cqb
						.bool()
						.addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(
								cqb.wildcard("Person.gxyInfo.doctor.DoctorId",
										"*")).addMust(cqb.term("year", year))
						.toQuery().hits();
				countgxy += hits.length();
				// **************************************************************************
				hits = cqb.bool().addMust(cqb.alias("GxyService"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(cqb.wildcard("setServiceTime", year))
						.addMust(cqb.term("serviceNumberInYear", "1"))
						.toQuery().hits();
				firstservice += hits.length();

				hits = cqb.bool().addMust(cqb.alias("GxyService"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(cqb.wildcard("setServiceTime", year))
						.addMust(cqb.term("serviceNumberInYear", "2"))
						.toQuery().hits();
				secondservice += hits.length();

				hits = cqb.bool().addMust(cqb.alias("GxyService"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(cqb.wildcard("setServiceTime", year))
						.addMust(cqb.term("serviceNumberInYear", "3"))
						.toQuery().hits();
				thirdservice += hits.length();
				hits = cqb.bool().addMust(cqb.alias("GxyService"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(cqb.wildcard("setServiceTime", year))
						.addMust(cqb.term("serviceNumberInYear", "4"))
						.toQuery().hits();
				fourthservice += hits.length();
				// ********************************************************
				hits = cqb
						.bool()
						.addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(
								cqb.wildcard("Person.gxyInfo.doctor.DoctorId",
										"*"))
						.addMust(cqb.term("Person.gxyInfo.if_tnb", "true"))
						.addMust(cqb.term("year", year)).toQuery().hits();
				if_tnb += hits.length();

				hits = cqb
						.bool()
						.addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(
								cqb.wildcard("Person.gxyInfo.doctor.DoctorId",
										"*"))
						.addMust(cqb.term("Person.gxyInfo.if_zl", "true"))
						.addMust(cqb.term("year", year)).toQuery().hits();
				if_zl += hits.length();

				hits = cqb
						.bool()
						.addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(
								cqb.wildcard("Person.gxyInfo.doctor.DoctorId",
										"*"))
						.addMust(
								cqb.term(
										"Person.gxyInfo.if_respiratoryDisease",
										"true"))
						.addMust(cqb.term("year", year)).toQuery().hits();
				if_respiratoryDisease += hits.length();

				hits = cqb
						.bool()
						.addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(
								cqb.wildcard("Person.gxyInfo.doctor.DoctorId",
										"*"))
						.addMust(
								cqb.term(
										"Person.gxyInfo.if_cerebral_vascular_disease",
										"true")).toQuery().hits();
				if_cerebral_vascular_disease += hits.length();

				hits = cqb
						.bool()
						.addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(
								cqb.wildcard("Person.gxyInfo.doctor.DoctorId",
										"*"))
						.addMust(
								cqb.term(
										"Person.gxyInfo.if_cardio_vascular_disease",
										"true"))
						.addMust(cqb.term("year", year)).toQuery().hits();
				if_cardio_vascular_disease += hits.length();
				// ******************************************************************
				hits = cqb
						.bool()
						.addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(
								cqb.wildcard("Person.gxyInfo.doctor.DoctorId",
										"*"))
						.addMust(cqb.term("if_HealthCheck", "true"))
						.addMust(cqb.term("year", year)).toQuery().hits();
				if_HealthCheck += hits.length();

				hits = cqb.bool().addMust(cqb.alias("GxyService"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(cqb.term("if_BpOK", "true")).toQuery().hits();
				if_BpOK += hits.length();
				// *************************************************************
				hits = cqb.bool().addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						// .addMust(cqb.wildcard("Person.gxyInfo.doctor.DoctorId","*"))
						.addMust(cqb.term("if_standardManage", "true"))
						.addMust(cqb.term("year", year)).toQuery().hits();
				gfgl += hits.length();
				// **************************************************************
				if (countgxy != 0) {

					jkgll = (float) firstservice / countgxy * 100;
					gfgll = (float) gfgl / countgxy * 100;
					bp = (float) if_BpOK / countgxy * 100;
				}

			}

			sb.append("<Community>");
			sb.append("<name>" + com.getNameOfCommunity() + "</name>");
			sb.append("<gxycount>" + countgxy + "</gxycount>");
			sb.append("<servers>" + firstservice + "</servers>");
			sb.append("<jkgll>" + jkgll + "</jkgll>");// ****************
														// 健康管理率需要修改
														// ***************
			sb.append("<notjkgl>" + jkgll + "</notjkgl>");// *****************
															// 非本单位完成的健康管理没有统计
															// ***********
			sb.append("<sffwfirst>" + firstservice + "</sffwfirst>");
			sb.append("<sffwsecond>" + secondservice + "</sffwsecond>");
			sb.append("<sffwthird>" + thirdservice + "</sffwthird>");
			sb.append("<sffwfourth>" + fourthservice + "</sffwfourth>");
			sb.append("<newsffw>" + jkgll + "</newsffw>");// ******* 新增的随访服务 未统计
															// ************

			sb.append("<gfgl>" + gfgl + "</gfgl>");// ************** 规范管理
													// ****************
			sb.append("<gfgll>" + gfgll + "</gfgll>");// ************** 规范管理率
														// ****************

			sb.append("<healthCheck>" + if_HealthCheck + "</healthCheck>");
			sb.append("<BpOK>" + if_BpOK + "</BpOK>");
			sb.append("<bpkzl>" + bp + "</bpkzl>");

			sb.append("<zl>" + if_zl + "</zl>");
			sb.append("<cardio>" + if_cardio_vascular_disease + "</cardio>");
			sb.append("<cerebral>" + if_cerebral_vascular_disease
					+ "</cerebral>");
			sb.append("<respiratory>" + if_respiratoryDisease
					+ "</respiratory>");
			sb.append("<tnb>" + if_tnb + "</tnb>");

			sb.append("</community>");
		}
		session.close();
		sb.append("</Gxystat>");
		// ======================================================
		return new String(sb);

	}

	/**
	 * 经费预算结算 orgnum 组织机构dirnum ，servicefee 随访管理(元/次)，
	 * standardManagefee规范管理(元/人)， HealthCheckfee健康体检(元/人) truefee 筛查确诊(元/人),
	 * notpassfee不达标服务质与量应扣报酬（元）, outfee辖区外服务应付报酬（元）, realfee实际拔付经费数（元）
	 * 
	 * @param orgnum
	 * @param servicefee
	 * @param standardManagefee
	 * @param HealthCheckfee
	 * @param truefee
	 * @param notpassfee
	 * @param outfee
	 * @param realfee
	 * @return
	 */

	public String getTownshipFinancialTable(String orgnum, float servicefee,
			float standardManagefee, float HealthCheckfee, float truefee,
			float notpassfee, float outfee, float realfee) {
		Community currentcom = Communitydao.getcurrcom(orgnum);
		StringBuffer sb = new StringBuffer();
		// ======================================================
		sb.append("<GxyFinancial>");
		for (Community com : currentcom.getList()) {
			List<CommunityRegion> Regions = Communitydao.getRegion(com.getId());
			int gxycount = 0;
			int firstservice = 0;
			int secondservice = 0;
			int thirdservice = 0;
			int fourthservice = 0;

			int if_HealthCheck = 0;
			int gfgl = 0;

			int services = 0;

			float servicessum = 0;
			float gfglsum = 0;
			float if_HealthChecksum = 0;
			float gxycountsum = 0;
			float sum = 0;

			for (CommunityRegion cr : Regions) {
				CompassHits hits = null;
				CompassQueryBuilder cqb = session.queryBuilder();
				hits = cqb
						.bool()
						.addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(
								cqb.wildcard("Person.gxyInfo.doctor.DoctorId",
										"*")).addMust(cqb.term("year", year))
						.toQuery().hits();
				gxycount += hits.length();

				// **************************************************************************
				hits = cqb.bool().addMust(cqb.alias("GxyService"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(cqb.wildcard("setServiceTime", year))
						.addMust(cqb.term("serviceNumberInYear", "1"))
						.toQuery().hits();
				firstservice += hits.length();

				hits = cqb.bool().addMust(cqb.alias("GxyService"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(cqb.wildcard("setServiceTime", year))
						.addMust(cqb.term("serviceNumberInYear", "2"))
						.toQuery().hits();
				secondservice += hits.length();

				hits = cqb.bool().addMust(cqb.alias("GxyService"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(cqb.wildcard("setServiceTime", year))
						.addMust(cqb.term("serviceNumberInYear", "3"))
						.toQuery().hits();
				thirdservice += hits.length();
				hits = cqb.bool().addMust(cqb.alias("GxyService"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(cqb.wildcard("setServiceTime", year))
						.addMust(cqb.term("serviceNumberInYear", "4"))
						.toQuery().hits();
				fourthservice += hits.length();

				// ******************************************************************
				hits = cqb
						.bool()
						.addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						.addMust(
								cqb.wildcard("Person.gxyInfo.doctor.DoctorId",
										"*"))
						.addMust(cqb.term("if_HealthCheck", "true"))
						.addMust(cqb.term("year", year)).toQuery().hits();
				if_HealthCheck += hits.length();

				// *************************************************************
				hits = cqb.bool().addMust(cqb.alias("Person"))
						.addMust(cqb.wildcard("dah", cr.getRegionId()))
						// .addMust(cqb.wildcard("Person.gxyInfo.doctor.DoctorId","*"))
						.addMust(cqb.term("if_standardManage", "true"))
						.addMust(cqb.term("year", year)).toQuery().hits();
				gfgl += hits.length();
				// **************************************************************
				services = firstservice + secondservice + thirdservice
						+ fourthservice;
				servicessum = servicefee * services;
				gfglsum = standardManagefee * gfgl;
				if_HealthChecksum = if_HealthCheck * HealthCheckfee;
				gxycountsum = gxycount * truefee;
				sum = servicessum + gfglsum + if_HealthChecksum + gxycountsum;

			}

			sb.append("<Community>");
			sb.append("<name>" + com.getNameOfCommunity() + "</name>");// 组织机构名字
			sb.append("<servicefee>" + servicefee + "</servicefee>");// 随访管理(元/次)
			sb.append("<standardManagefee>" + standardManagefee
					+ "</standardManagefee>");// 规范管理(元/人)
			sb.append("<healthCheckfee>" + HealthCheckfee + "</healthCheckfee>");// 健康体检(元/人)
			sb.append("<truefee>" + truefee + "</truefee>");// 筛查确诊(元/人)

			sb.append("<service>" + services + "</service>");// 合计随访次数
			sb.append("<standardManage>" + gfgl + "</standardManage>");// 规范管理人数
			sb.append("<healthCheck>" + if_HealthCheck + "</healthCheck>");// 健康体检人数
			sb.append("<trues>" + gxycount + "</trues>");// 筛查确诊人数

			sb.append("<servicessum>" + servicessum + "</servicessum>");// 随访管理(元)
			sb.append("<standardManagesum>" + gfglsum + "</standardManagesum>");// 规范管理(元)
			sb.append("<healthChecksum>" + if_HealthChecksum
					+ "</healthChecksum>");// 健康体检(元)
			sb.append("<truessum>" + gxycountsum + "</truessum>");// 筛查确诊(元)
			sb.append("<sum>" + sum + "</sum>");// 合计（元）

			sb.append("<notpassfee>" + notpassfee + "</notpassfee>");// 不达标服务质与量应扣报酬（元）
			sb.append("<outfee>" + outfee + "</outfee>");// 辖区外服务应付报酬（元）
			sb.append("<advance>" + sum + "</advance>");// 结算应拨经费数（元）
			sb.append("<realfee>" + realfee + "</realfee>");// 实际拔付经费数（元）

			sb.append("</community>");
		}
		session.close();
		sb.append("</GxyFinancial>");
		return new String(sb);

	}

	public String getCountyFinancialTable() {
		StringBuffer sb = new StringBuffer();
		// ======================================================
		sb.append("<GxyCountyFinancialTable>");
		// ------------------------------------------------------
		// ------------------------------------------------------
		sb.append("</GxyCountyFinancialTable>");
		// ======================================================
		return new String(sb);

	}

	public String getOutTownshipFinancial() {
		StringBuffer sb = new StringBuffer();
		// ======================================================
		sb.append("<GxyOutTownshipFinancial>");
		// ------------------------------------------------------
		// ------------------------------------------------------
		sb.append("</GxyOutTownshipFinancial>");
		// ======================================================
		return new String(sb);
	}

	public String getOutCountyFinancial() {
		StringBuffer sb = new StringBuffer();
		// ======================================================
		sb.append("<GxyOutCountyFinancial>");
		// ------------------------------------------------------
		// ------------------------------------------------------
		sb.append("</GxyOutCountyFinancial>");
		// ======================================================
		return new String(sb);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = new Gxy("2*", "2012").getBasicTable();
		System.out.print(s);

	}
}
