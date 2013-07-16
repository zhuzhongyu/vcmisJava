package com.coboo.base;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;

/**
 * 生出树
 * @author Administrator
 *
 */
public class Func_TreeXML 
{
	private String url;
	private String grda_url;
	private String grda_index_path;		
	/**
	 * 树结点名称(当时因为没有实现动态树而定义，生成动态树后以不用。解决新旧档案问题或者给新客户时可以省去)
	 */
	@SuppressWarnings("unused")
	private static final String JKDA = "健康档案";
	
	private static final String GRJBXX = "个人基本信息";
	
	private static final String TJXX = "体检信息";
	
	private static final String FNBJ = "妇女保健";
	
	private static final String FNJCJL = "妇女检查记录";
	private static final String FNBCZDJ = "妇女病查治登记";
	private static final String JHSYPC = "计划生育普查";
	private static final String JHSYDJ = "计划生育登记";
	
	private static final String YCFJKGL = "孕产妇健康管理";
	
	private static final String DYCCQSFFWJLB = "第1次产前随访服务记录表";
	private static final String DEDWCCSSFJLFWB = "第2~5次产前随访服务记录表";
	private static final String CHFSJLB = "产后访视记录表";
	private static final String CHSSETJKJCJLB = "产后42天健康检查记录表";
	
	private static final String ETBJ = "儿童保健";
	
	private static final String XSEJTFSJLB = "新生儿家庭访视记录表";
	private static final String YSYNETSFFWJLB = "1岁以内儿童随访服务记录表";
	private static final String YDESETSFFWJLB = "1~2岁儿童随访服务记录表";
	private static final String SSETSFFWJLB = "3岁儿童随访服务记录表";
	private static final String ETSZFYJCT = "儿童生长发育监测图";
	
	private static final String MXBGL = "慢性病管理";
	
	private static final String TNB = "糖尿病";
	private static final String GXY = "高血压";	
	private static final String GXB = "冠心病";
	private static final String NZZ = "脑卒中";
	private static final String ZL = "肿瘤";
	
	private static final String JHMY = "计划免疫";
	
	private static final String MYJZGL = "免疫接种管理";
	private static final String MYXXGL = "免疫信息管理";
	
	private static final String KFXXGL = "康复信息管理";
	
	private static final String CJRDJ = "残疾人登记";
	
	private static final String ZTKFXL = "肢体康复训练";
	
	private static final String ZCXLDJ = "肢残训练登记";
	private static final String ZCXLPG = "肢残训练评估";
	private static final String ZCXLJH = "肢残训练计划";
	private static final String ZCXLJL = "肢残训练记录";
	
	private static final String JSBGL = "精神病管理";
	
	private static final String JSBRDJB = "精神病人登记";
	private static final String JSBFSJL = "精神病访视记录";
	
	/**
	 * XML文件的节点名称及属性
	 */
	public static final String TREE_ROOT = "root"; 
	public static final String TREE_NODE_NODE = "node"; 
	public static final String TREE_ATTRIBUTE_NAME = "name";
	public static final String TREE_ATTRIBUTE_DIR = "dir";
	public static final String TREE_ATTRIBUTE_FILE = "file";
	public static final String TREE_ATTRIBUTE_FOLDER = "folder";
	
	public static final String TREE_ATTRIBUTE_LABEL = "label";
	public static final String TREE_ATTRIBUTE_FOLDERPATH = "folderpath";
	public static final String TREE_ATTRIBUTE_VISIBLE = "visible";
	
	@SuppressWarnings("unused")
	private static final String TREE_ATTRIBUTE_TEMPLATE = "template"; //模版路径，在程序中未使用
	

	public static final String INDEX_FILE_NAME = "index.xml";
	private static final String TEMPLATE_FILE_NAME = "template.xml";
	
	/**
	 * 以下各项在实现生成动态树算法后已经不用
	 */
	private String xml_path_jkda_index;  //健康档案
	private String xml_path_jkda;  //健康档案
	
	private String xml_path_grjbxx_index;  //个人基本信息
	private String xml_path_grjbxx;  //个人基本信息
	
	private String xml_path_tjxx_index;  //体检信息
	private String xml_path_tjxx;  //体检信息
	
	private String xml_path_etbj_index; //儿童保健
	private String xml_path_etbj; //儿童保健

	private String xml_path_xsejtfsjlb_index;//新生儿家庭访视记录表
	private String xml_path_xsejtfsjlb;//新生儿家庭访视记录表	
	private String xml_path_ysynetsffwjlb_index;//1岁以内儿童随访服务记录表
	private String xml_path_ysynetsffwjlb;//1岁以内儿童随访服务记录表	
	private String xml_path_ydesetsffwjlb_index;//1~2岁儿童随访服务记录表
	private String xml_path_ydesetsffwjlb;//1~2岁儿童随访服务记录表	
	private String xml_path_ssetsffwjlb_index;//3岁儿童随访服务记录表
	private String xml_path_ssetsffwjlb;//3岁儿童随访服务记录表	
	private String xml_path_etszfyjct_index;//儿童生长发育监测图
	private String xml_path_etszfyjct;//儿童生长发育监测图
	
	private String xml_path_fnbj_index; //妇女保健
	private String xml_path_fnbj; //妇女保健
	
	private String xml_path_fnjcjl_index; //妇女检查记录
	private String xml_path_fnjcjl; //妇女检查记录
	private String xml_path_fnbczdj_index; //妇女病查治登记
	private String xml_path_fnbczdj; //妇女病查治登记
	private String xml_path_jhsypc_index; //计划生育普查
	private String xml_path_jhsypc; //计划生育普查
	private String xml_path_jhsydj_index; //计划生育登记
	private String xml_path_jhsydj; //计划生育登记
	
	private String xml_path_ycfjkgl_index;//孕产妇健康管理
	private String xml_path_ycfjkgl;//孕产妇健康管理
	
	private String xml_path_dyccqsffwjlb_index; //第1次产前随访服务记录表
	private String xml_path_dyccqsffwjlb; //第1次产前随访服务记录表
	private String xml_path_dedwccqsffwjlb_index; //第2~5次产前随访服务记录表
	private String xml_path_dedwccqsffwjlb; //第2~5次产前随访服务记录表
	private String xml_path_chfsjlb_index; //产后访视记录
	private String xml_path_chfsjlb; //产后访视记录
	private String xml_path_chssetjkjcjlb_index; //产后42天健康检查记录表
	private String xml_path_chssetjkjcjlb; //产后42天健康检查记录表
	
	private String xml_path_mxbgl_index; //慢性病管理
	private String xml_path_mxbgl; //慢性病管理
	
	private String xml_path_gxy_index; //高血压
	private String xml_path_gxy; //高血压
	private String xml_path_tnb_index;//糖尿病
	private String xml_path_tnb;//糖尿病
	private String xml_path_gxb_index;//冠心病
	private String xml_path_gxb;//冠心病
	private String xml_path_nzz_index;//脑卒中
	private String xml_path_nzz;//脑卒中
	private String xml_path_zl_index; //肿瘤
	private String xml_path_zl; //肿瘤
	
	private String xml_path_jhmy_index; //计划免疫
	private String xml_path_jhmy; //计划免疫
	
	private String xml_path_myjzgl_index; //免疫接种管理
	private String xml_path_myjzgl; //免疫接种管理
	private String xml_path_myxxgl_index; //免疫信息管理
	private String xml_path_myxxgl; //免疫信息管理
	
	private String xml_path_kfxxgl_index; //康复信息管理
	private String xml_path_kfxxgl; //康复信息管理
	
	private String xml_path_cjrdj_index;//残疾人登记
	private String xml_path_cjrdj;//残疾人登记
	
	private String xml_path_ztkfxl_index;//肢体康复训练
	private String xml_path_ztkfxl;//肢体康复训练
	
	private String xml_path_zcxldj_index; //肢残训练登记
	private String xml_path_zcxldj; //肢残训练登记
	private String xml_path_zcxlpg_index; //肢残训练评估
	private String xml_path_zcxlpg; //肢残训练评估
	private String xml_path_zcxljh_index; //肢残训练计划
	private String xml_path_zcxljh; //肢残训练计划
	private String xml_path_zcxljl_index; //肢残训练记录
	private String xml_path_zcxljl; //肢残训练记录
	
	private String xml_path_jsbgl_index; //精神病管理
	private String xml_path_jsbgl; //精神病管理
	
	private String xml_path_jsbrdj_index; //精神病人登记
	private String xml_path_jsbrdj; //精神病人登记
	private String xml_path_jsbfsjl_index; //精神病访视记录
	private String xml_path_jsbfsjl; //精神病访视记录	
	
	//健康档案结点
	private static String JKDA_LABEL = "健康档案";
	/**
	 * 以下各项在实现生成动态树算法后已经不用
	 */
	//个人基本信息
	private String grjbxx;
	//体检信息
	private String tjxx;
	//妇女保健
	private String fnbj;
	//妇女检查记录
	private String fnjcjl;
	//妇女病查治登记
	private String fnbczdj;
	//计划生育普查
	private String jhsypc;
	//计划生育登记
	private String jhsydj;
	//孕产妇健康管理
	private String ycfjkgl;
	//第1次产前随访服务记录表
	private String dyccqsffwjlb;
	//第2~5次产前随访服务记录表
	private String dedwccqsffwjlb;
	//产后访视记录
	private String chfsjlb;
	//产后42天健康检查记录
	private String chssetjkjcjlb;
	//儿童保健
	private String etbj;	
	//新生儿家庭访视记录表
	private String xsejtfsjlb;
	//1岁以内儿童随访服务记录表
	private String ysynetsffwjlb;
	//1~2岁儿童随访服务记录表
	private String ydesetsffwjlb;
	//3岁儿童随访服务记录表
	private String ssetsffwjlb;
	//儿童生长发育监测图
	private String etszfyjct;
	//慢性病管理
	private String mxbgl;
	//高血压
	private String gxy;
	//糖尿病
	private String tnb;
	//冠心病
	private String gxb;
	//脑卒中
	private String nzz;
	//肿瘤
	private String zl;
	//计划免疫
	private String jhmy;
	//免疫接种管理
	private String myjzgl;
	//免疫信息管理
	private String myxxgl;
	//康复信息管理
	private String kfxxgl;
	//残疾人登记
	private String cjrdj;
	//肢体康复训练训练
	private String ztkfxl;
	//肢残训练登记
	private String zcxldj;
	//肢残训练评估
	private String zcxlpg;
	//残肢训练计划
	private String zcxljh;
	//肢残训练记录
	private String zcxljl;
	//精祔病管理
	private String jsbgl;
	//精神病人登记
	private String jsbrdj;
	//精神病访视记录
	private String jsbfsjl;
	
	//实现动态术后解析XML文件用到的对象
	DocumentBuilderFactory dbf;
	DocumentBuilder db;	
	
	private StringBuffer sb_tree = new StringBuffer();
	private StringBuffer sb_index = new StringBuffer();
	
	/**
	 * 为生成树初始化参数
	 * @param url //客户端catalog.xml中定义的coboodir
	 * @param grda_url //数据库Residents表中的个人档案路径
	 */
	public Func_TreeXML(String url,String grda_url)
	{
		this.url = url;
		this.grda_url = grda_url;
		this.grda_index_path = this.grda_url+ "/" +Func_TreeXML.INDEX_FILE_NAME;
		
		try
		{
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		ReadJkdaStr();
	}
	
	/**
	 * 添加日期:2010-03-02
	 * 设置健康档案树的根节点文本。
	 */
	public void ReadJkdaStr(){
		String path = Bean_BaseInfo.coboodir+Bean_BaseInfo.index+"index.xml";
		System.out.println("ReadJkdaStrPath:"+path);
		File f = new File(path);
		try{
			if(f.exists()){
				Document doc = db.parse(path);
				NodeList nl = doc.getElementsByTagName("node");
				Element e = (Element)nl.item(0);
				String label = e.getAttribute("name");
				System.out.println("name:" + label);
				JKDA_LABEL = label.substring(0, JKDA_LABEL.length());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据个人档案根目录的路径生成树
	 * @param path 个人档案根目录的路径
	 */
	private void parseIndexFile(String path)
	{
		try
		{
			Document doc = db.parse(path);
			
			NodeList nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDERPATH);
				String visible = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_VISIBLE);
				if(Boolean.parseBoolean(visible))
				{
					if(Boolean.parseBoolean(dir))
					{
						this.sb_tree.append("<node label='"+name+"' datapath='"+this.getRelativeURL(this.grda_url+folder)+"' indexpath='"+this.getRelativeURL(this.grda_url+folder+Func_TreeXML.INDEX_FILE_NAME)+"'>\n");
						this.parseIndexFile(this.grda_url+folder+Func_TreeXML.INDEX_FILE_NAME);
						this.sb_tree.append("</node>\n");
					}
					else
					{
						this.sb_tree.append("<node label='"+name+"' datapath='"+this.getRelativeURL(this.grda_url+folder)+"' indexpath='"+this.getRelativeURL(this.grda_url+folder+Func_TreeXML.INDEX_FILE_NAME)+"' />\n");
					}
				}				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}		
	
	/**
	 * 根据个人档案根目录的路径获取所有index.xml
	 * @param path 个人档案根目录的路径
	 */
	private void getIndexPath(String path)
	{
		try
		{
			Document doc = db.parse(path);
			
			NodeList nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String label = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_LABEL);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDERPATH);
				
				if(Boolean.parseBoolean(dir))
				{
					this.getIndexPath(this.grda_url+folder+Func_TreeXML.INDEX_FILE_NAME);
					this.sb_index.append("<"+label+">"+this.getRelativeURL(this.grda_url+folder+Func_TreeXML.INDEX_FILE_NAME)+"</"+label+">");
				}
				else
				{
					this.sb_index.append("<"+label+">"+this.getRelativeURL(this.grda_url+folder+Func_TreeXML.INDEX_FILE_NAME)+"</"+label+">");
				}
			
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}	
	
	/**
	 * 生成树
	 * @return
	 */
	public String getTreeXML2()
	{
		this.sb_tree.append("<root>\n");		
		this.sb_tree.append("<node label='"+Func_TreeXML.JKDA_LABEL+"' datapath='"+this.getRelativeURL(this.grda_url)+"' indexpath='"+this.getRelativeURL(this.grda_index_path)+"'>\n");
		this.parseIndexFile(this.grda_index_path);
		this.sb_tree.append("</node>\n");
		this.sb_tree.append("</root>\n");
		
		return this.sb_tree.toString();
	}
	
	/**
	 * 获取所有index.xml
	 * @return
	 */
	public String getAllIndexPath2()
	{
		this.sb_index.append("<urls>");
		this.sb_index.append("<jkda>"+this.getRelativeURL(this.grda_index_path)+"</jkda>");
		this.getIndexPath(this.grda_index_path);
		this.sb_index.append("</urls>");
		
		return this.sb_index.toString();
	}
	
	/**
	 * 获取所有index.xml路径(动态生成树后此方法已经不用)
	 */
	public void initAllURL()
	{
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = null;
			
			this.xml_path_jkda = this.grda_url + "/";
			File file = new File(this.xml_path_jkda);
			if(file.exists())
			{
				this.xml_path_jkda_index = this.xml_path_jkda + Func_TreeXML.INDEX_FILE_NAME;
				file = new File(xml_path_jkda_index);
				if(file.exists())
				{
					System.out.println(xml_path_jkda_index);
				}				
			}
			
			doc = db.parse(xml_path_jkda_index);			
			NodeList nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String f = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FILE);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDER);
				if(name.equals(Func_TreeXML.GRJBXX)&&f.equals("false"))
				{
					this.xml_path_grjbxx = this.xml_path_jkda + folder + "/";
					this.xml_path_grjbxx_index = this.xml_path_grjbxx + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_grjbxx_index);
					if(file.exists())
					{
						System.out.println(xml_path_grjbxx_index);
					}
				}
				else if(name.equals(Func_TreeXML.TJXX)&&f.equals("false"))
				{
					this.xml_path_tjxx = this.xml_path_jkda + folder + "/";
					this.xml_path_tjxx_index = this.xml_path_tjxx + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_tjxx_index);
					if(file.exists())
					{
						System.out.println(xml_path_tjxx_index);
					}
				}
				else if(name.equals(Func_TreeXML.FNBJ)&&f.equals("false"))
				{
					this.xml_path_fnbj = this.xml_path_jkda + folder + "/";
					this.xml_path_fnbj_index = this.xml_path_fnbj + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_fnbj_index);
					if(file.exists())
					{
						System.out.println(xml_path_fnbj_index);
					}
				}
				else if(name.equals(Func_TreeXML.ETBJ)&&f.equals("false"))
				{
					this.xml_path_etbj = this.xml_path_jkda + folder + "/";
					this.xml_path_etbj_index = this.xml_path_etbj + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_etbj_index);
					if(file.exists())
					{
						System.out.println(xml_path_etbj_index);
					}
				}
				else if(name.equals(Func_TreeXML.MXBGL)&&f.equals("false"))
				{
					this.xml_path_mxbgl = this.xml_path_jkda + folder + "/";
					this.xml_path_mxbgl_index = this.xml_path_mxbgl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_mxbgl_index);
					if(file.exists())
					{
						System.out.println(xml_path_mxbgl_index);
					}
				}
				else if(name.equals(Func_TreeXML.JHMY)&&f.equals("false"))
				{
					this.xml_path_jhmy = this.xml_path_jkda + folder + "/";
					this.xml_path_jhmy_index = this.xml_path_jhmy + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_jhmy_index);
					if(file.exists())
					{
						System.out.println(xml_path_jhmy_index);
					}
				}
				else if(name.equals(Func_TreeXML.KFXXGL)&&f.equals("false"))
				{
					this.xml_path_kfxxgl = this.xml_path_jkda + folder + "/";
					this.xml_path_kfxxgl_index = this.xml_path_kfxxgl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_kfxxgl_index);
					if(file.exists())
					{
						System.out.println(xml_path_kfxxgl_index);
					}
				}
			}
			
			doc = db.parse(xml_path_fnbj_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String f = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FILE);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDER);
				if(name.equals(Func_TreeXML.FNJCJL)&&f.equals("false"))
				{
					this.xml_path_fnjcjl = this.xml_path_fnbj + folder + "/";
					this.xml_path_fnjcjl_index = this.xml_path_fnjcjl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_fnjcjl_index);
					if(file.exists())
					{
						System.out.println(xml_path_fnjcjl_index);
					}
				}
				else if(name.equals(Func_TreeXML.FNBCZDJ)&&f.equals("false"))
				{
					this.xml_path_fnbczdj = this.xml_path_fnbj + folder + "/";
					this.xml_path_fnbczdj_index = this.xml_path_fnbczdj + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_fnbczdj_index);
					if(file.exists())
					{
						System.out.println(xml_path_fnbczdj_index);
					}
				}
				else if(name.equals(Func_TreeXML.JHSYPC)&&f.equals("false"))
				{
					this.xml_path_jhsypc = this.xml_path_fnbj + folder + "/";
					this.xml_path_jhsypc_index = this.xml_path_jhsypc + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_jhsypc_index);
					if(file.exists())
					{
						System.out.println(xml_path_jhsypc_index);
					}
				}
				else if(name.equals(Func_TreeXML.JHSYDJ)&&f.equals("false"))
				{
					this.xml_path_jhsydj = this.xml_path_fnbj + folder + "/";
					this.xml_path_jhsydj_index = this.xml_path_jhsydj + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_jhsydj_index);
					if(file.exists())
					{
						System.out.println(xml_path_jhsydj_index);
					}
				}
				else if(name.equals(Func_TreeXML.YCFJKGL)&&f.equals("false"))
				{
					this.xml_path_ycfjkgl = this.xml_path_fnbj + folder + "/";
					this.xml_path_ycfjkgl_index = this.xml_path_ycfjkgl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_ycfjkgl_index);
					if(file.exists())
					{
						System.out.println(xml_path_ycfjkgl_index);
					}
				}
			}
			
			doc = db.parse(xml_path_ycfjkgl_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String f = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FILE);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDER);
				if(name.equals(Func_TreeXML.DYCCQSFFWJLB)&&f.equals("false"))
				{
					this.xml_path_dyccqsffwjlb= this.xml_path_ycfjkgl + folder + "/";
					this.xml_path_dyccqsffwjlb_index = this.xml_path_dyccqsffwjlb + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_dyccqsffwjlb_index);
					if(file.exists())
					{
						System.out.println(xml_path_dyccqsffwjlb_index);
					}
				}
				else if(name.equals(Func_TreeXML.DEDWCCSSFJLFWB)&&f.equals("false"))
				{
					this.xml_path_dedwccqsffwjlb = this.xml_path_ycfjkgl + folder + "/";
					this.xml_path_dedwccqsffwjlb_index = this.xml_path_dedwccqsffwjlb + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_dedwccqsffwjlb_index);
					if(file.exists())
					{
						System.out.println(xml_path_dedwccqsffwjlb_index);
					}
				}
				else if(name.equals(Func_TreeXML.CHFSJLB)&&f.equals("false"))
				{
					this.xml_path_chfsjlb = this.xml_path_ycfjkgl + folder + "/";
					this.xml_path_chfsjlb_index = this.xml_path_chfsjlb + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_chfsjlb_index);
					if(file.exists())
					{
						System.out.println(xml_path_chfsjlb_index);
					}
				}
				else if(name.equals(Func_TreeXML.CHSSETJKJCJLB)&&f.equals("false"))
				{
					this.xml_path_chssetjkjcjlb = this.xml_path_ycfjkgl + folder + "/";
					this.xml_path_chssetjkjcjlb_index = this.xml_path_chssetjkjcjlb + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_chssetjkjcjlb_index);
					if(file.exists())
					{
						System.out.println(xml_path_chssetjkjcjlb_index);
					}
				}
			}
			
			doc = db.parse(xml_path_etbj_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String f = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FILE);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDER);
				if(name.equals(Func_TreeXML.XSEJTFSJLB)&&f.equals("false"))
				{
					this.xml_path_xsejtfsjlb = this.xml_path_etbj + folder + "/";
					this.xml_path_xsejtfsjlb_index = this.xml_path_xsejtfsjlb + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_xsejtfsjlb_index);
					if(file.exists())
					{
						System.out.println(xml_path_xsejtfsjlb_index);
					}
				}
				else if(name.equals(Func_TreeXML.YSYNETSFFWJLB)&&f.equals("false"))
				{
					this.xml_path_ysynetsffwjlb = this.xml_path_etbj + folder + "/";
					this.xml_path_ysynetsffwjlb_index = this.xml_path_ysynetsffwjlb + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_ysynetsffwjlb_index);
					if(file.exists())
					{
						System.out.println(xml_path_ysynetsffwjlb_index);
					}
				}
				else if(name.equals(Func_TreeXML.YDESETSFFWJLB)&&f.equals("false"))
				{
					this.xml_path_ydesetsffwjlb = this.xml_path_etbj + folder + "/";
					this.xml_path_ydesetsffwjlb_index = this.xml_path_ydesetsffwjlb + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_ydesetsffwjlb_index);
					if(file.exists())
					{
						System.out.println(xml_path_ydesetsffwjlb_index);
					}
				}
				else if(name.equals(Func_TreeXML.SSETSFFWJLB)&&f.equals("false"))
				{
					this.xml_path_ssetsffwjlb = this.xml_path_etbj + folder + "/";
					this.xml_path_ssetsffwjlb_index = this.xml_path_ssetsffwjlb + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_ssetsffwjlb_index);
					if(file.exists())
					{
						System.out.println(xml_path_ssetsffwjlb_index);
					}
				}
				else if(name.equals(Func_TreeXML.ETSZFYJCT)&&f.equals("false"))
				{
					this.xml_path_etszfyjct = this.xml_path_etbj + folder + "/";
					this.xml_path_etszfyjct_index = this.xml_path_etszfyjct + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_etszfyjct_index);
					if(file.exists())
					{
						System.out.println(xml_path_etszfyjct_index);
					}
				}
			}
			
			doc = db.parse(xml_path_mxbgl_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String f = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FILE);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDER);
				if(name.equals(Func_TreeXML.TNB)&&f.equals("false"))
				{
					this.xml_path_tnb = this.xml_path_mxbgl + folder + "/";
					this.xml_path_tnb_index = this.xml_path_tnb + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_tnb_index);
					if(file.exists())
					{
						System.out.println(xml_path_tnb_index);
					}
				}
				else if(name.equals(Func_TreeXML.GXY)&&f.equals("false"))
				{
					this.xml_path_gxy = this.xml_path_mxbgl + folder + "/";
					this.xml_path_gxy_index = this.xml_path_gxy + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_gxy_index);
					if(file.exists())
					{
						System.out.println(xml_path_gxy_index);
					}
				}
				else if(name.equals(Func_TreeXML.GXB)&&f.equals("false"))
				{
					this.xml_path_gxb = this.xml_path_mxbgl + folder + "/";
					this.xml_path_gxb_index = this.xml_path_gxb + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_gxb_index);
					if(file.exists())
					{
						System.out.println(xml_path_gxb_index);
					}
				}
				else if(name.equals(Func_TreeXML.NZZ)&&f.equals("false"))
				{
					this.xml_path_nzz = this.xml_path_mxbgl + folder + "/";
					this.xml_path_nzz_index = this.xml_path_nzz + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_nzz_index);
					if(file.exists())
					{
						System.out.println(xml_path_nzz_index);
					}
				}
				else if(name.equals(Func_TreeXML.ZL)&&f.equals("false"))
				{
					this.xml_path_zl = this.xml_path_mxbgl + folder + "/";
					this.xml_path_zl_index = this.xml_path_zl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_zl_index);
					if(file.exists())
					{
						System.out.println(xml_path_zl_index);
					}
				}
			}
			
			doc = db.parse(xml_path_jhmy_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String f = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FILE);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDER);
				if(name.equals(Func_TreeXML.MYJZGL)&&f.equals("false"))
				{
					this.xml_path_myjzgl = this.xml_path_jhmy + folder + "/";
					this.xml_path_myjzgl_index = this.xml_path_myjzgl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_myjzgl_index);
					if(file.exists())
					{
						System.out.println(xml_path_myjzgl_index);
					}
				}
				else if(name.equals(Func_TreeXML.MYXXGL)&&f.equals("false"))
				{
					this.xml_path_myxxgl = this.xml_path_jhmy + folder + "/";
					this.xml_path_myxxgl_index = this.xml_path_myxxgl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_myxxgl_index);
					if(file.exists())
					{
						System.out.println(xml_path_myxxgl_index);
					}
				}				
			}
			
			doc = db.parse(xml_path_kfxxgl_index);			
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String f = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FILE);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDER);
				if(name.equals(Func_TreeXML.CJRDJ)&&f.equals("false"))
				{
					this.xml_path_cjrdj = this.xml_path_kfxxgl + folder + "/";					
					this.xml_path_cjrdj_index = this.xml_path_cjrdj + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_cjrdj_index);
					if(file.exists())
					{
						System.out.println(xml_path_cjrdj_index);
					}
				}
				else if(name.equals(Func_TreeXML.ZTKFXL)&&f.equals("false"))
				{
					this.xml_path_ztkfxl = this.xml_path_kfxxgl + folder + "/";
					this.xml_path_ztkfxl_index = this.xml_path_ztkfxl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_ztkfxl_index);
					if(file.exists())
					{
						System.out.println(xml_path_ztkfxl_index);
					}
				}
				else if(name.equals(Func_TreeXML.JSBGL)&&f.equals("false"))
				{
					this.xml_path_jsbgl = this.xml_path_kfxxgl + folder + "/";
					this.xml_path_jsbgl_index = this.xml_path_jsbgl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_jsbgl_index);
					if(file.exists())
					{
						System.out.println(xml_path_jsbgl_index);
					}
				}				
			}
			
			doc = db.parse(xml_path_ztkfxl_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String f = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FILE);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDER);
				if(name.equals(Func_TreeXML.ZCXLDJ)&&f.equals("false"))
				{
					this.xml_path_zcxldj = this.xml_path_ztkfxl + folder + "/";					
					this.xml_path_zcxldj_index = this.xml_path_zcxldj + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_zcxldj_index);
					if(file.exists())
					{
						System.out.println(xml_path_zcxldj_index);
					}
				}
				else if(name.equals(Func_TreeXML.ZCXLPG)&&f.equals("false"))
				{
					this.xml_path_zcxlpg = this.xml_path_ztkfxl + folder + "/";
					this.xml_path_zcxlpg_index = this.xml_path_zcxlpg + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_zcxlpg_index);
					if(file.exists())
					{
						System.out.println(xml_path_zcxlpg_index);
					}
				}
				else if(name.equals(Func_TreeXML.ZCXLJH)&&f.equals("false"))
				{
					this.xml_path_zcxljh = this.xml_path_ztkfxl + folder + "/";
					this.xml_path_zcxljh_index = this.xml_path_zcxljh + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_zcxljh_index);
					if(file.exists())
					{
						System.out.println(xml_path_zcxljh_index);
					}
				}	
				else if(name.equals(Func_TreeXML.ZCXLJL)&&f.equals("false"))
				{
					this.xml_path_zcxljl = this.xml_path_ztkfxl + folder + "/";
					this.xml_path_zcxljl_index = this.xml_path_zcxljl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_zcxljl_index);
					if(file.exists())
					{
						System.out.println(xml_path_zcxljl_index);
					}
				}	
			}
			doc = db.parse(xml_path_jsbgl_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String f = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FILE);
				String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDER);
				if(name.equals(Func_TreeXML.JSBRDJB)&&f.equals("false"))
				{
					this.xml_path_jsbrdj = this.xml_path_jsbgl + folder + "/";					
					this.xml_path_jsbrdj_index = this.xml_path_jsbrdj + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_jsbrdj_index);
					if(file.exists())
					{
						System.out.println(xml_path_jsbrdj_index);
					}
				}
				else if(name.equals(Func_TreeXML.JSBFSJL)&&f.equals("false"))
				{
					this.xml_path_jsbfsjl = this.xml_path_jsbgl + folder + "/";
					this.xml_path_jsbfsjl_index = this.xml_path_jsbfsjl + Func_TreeXML.INDEX_FILE_NAME;
					file = new File(this.xml_path_jsbfsjl_index);
					if(file.exists())
					{
						System.out.println(xml_path_jsbfsjl_index);
					}
				}			
			}			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	/**
	 * 初始化树的各级节点标签
	 */
	public void initTree()
	{
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(this.xml_path_jkda_index);
			NodeList nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String visible = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_VISIBLE);
				if(name.equals(Func_TreeXML.GRJBXX)&&dir.equals("false")&&visible.equals("true"))
				{
					this.grjbxx = name;
				}
				else if(name.equals(Func_TreeXML.TJXX)&&dir.equals("false")&&visible.equals("true"))
				{
					this.tjxx = name;
				}
				else if(name.equals(Func_TreeXML.FNBJ)&&dir.equals("true")&&visible.equals("true"))
				{
					this.fnbj = name;					
				}
				else if(name.equals(Func_TreeXML.ETBJ)&&dir.equals("true")&&visible.equals("true"))
				{
					this.etbj = name;
				}
				else if(name.equals(Func_TreeXML.MXBGL)&&dir.equals("true")&&visible.equals("true"))
				{
					this.mxbgl = name;
				}
				else if(name.equals(Func_TreeXML.JHMY)&&dir.equals("true")&&visible.equals("true"))
				{
					this.jhmy = name;
				}
				else if(name.equals(Func_TreeXML.KFXXGL)&&dir.equals("true")&&visible.equals("true"))
				{
					this.kfxxgl = name;
				}
			}
			
			doc = db.parse(this.xml_path_fnbj_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String visible = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_VISIBLE);
				if(name.equals(Func_TreeXML.FNJCJL)&&dir.equals("false")&&visible.equals("true"))
				{
					this.fnjcjl = name;
				}
				else if(name.equals(Func_TreeXML.FNBCZDJ)&&dir.equals("false")&&visible.equals("true"))
				{
					this.fnbczdj = name;
				}
				else if(name.equals(Func_TreeXML.JHSYPC)&&dir.equals("false")&&visible.equals("true"))
				{
					this.jhsypc = name;
				}
				else if(name.equals(Func_TreeXML.JHSYDJ)&&dir.equals("false")&&visible.equals("true"))
				{
					this.jhsydj = name;
				}
				else if(name.equals(Func_TreeXML.YCFJKGL)&&dir.equals("true")&&visible.equals("true"))
				{
					this.ycfjkgl = name;
				}
			}
			
			doc = db.parse(this.xml_path_ycfjkgl_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String visible = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_VISIBLE);
				if(name.equals(Func_TreeXML.DYCCQSFFWJLB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.dyccqsffwjlb = name;
				}
				else if(name.equals(Func_TreeXML.DEDWCCSSFJLFWB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.dedwccqsffwjlb = name;
				}
				else if(name.equals(Func_TreeXML.CHFSJLB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.chfsjlb = name;
				}
				else if(name.equals(Func_TreeXML.CHSSETJKJCJLB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.chssetjkjcjlb = name;
				}
			}
			
			doc = db.parse(this.xml_path_etbj_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String visible = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_VISIBLE);
				if(name.equals(Func_TreeXML.XSEJTFSJLB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.xsejtfsjlb = name;
				}
				else if(name.equals(Func_TreeXML.YSYNETSFFWJLB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.ysynetsffwjlb = name;
				}
				else if(name.equals(Func_TreeXML.YDESETSFFWJLB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.ydesetsffwjlb = name;
				}
				else if(name.equals(Func_TreeXML.SSETSFFWJLB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.ssetsffwjlb = name;
				}
				else if(name.equals(Func_TreeXML.ETSZFYJCT)&&dir.equals("false")&&visible.equals("true"))
				{
					this.etszfyjct = name;
				}
			}
			
			doc = db.parse(this.xml_path_mxbgl_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String visible = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_VISIBLE);
				if(name.equals(Func_TreeXML.GXY)&&dir.equals("false")&&visible.equals("true"))
				{
					this.gxy = name;
				}
				else if(name.equals(Func_TreeXML.TNB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.tnb = name;
				}
				else if(name.equals(Func_TreeXML.NZZ)&&dir.equals("false")&&visible.equals("true"))
				{
					this.nzz = name;
				}
				else if(name.equals(Func_TreeXML.ZL)&&dir.equals("false")&&visible.equals("true"))
				{
					this.zl = name;
				}
				else if(name.equals(Func_TreeXML.GXB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.gxb = name;
				}
			}
			
			doc = db.parse(this.xml_path_jhmy_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String visible = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_VISIBLE);
				if(name.equals(Func_TreeXML.MYJZGL)&&dir.equals("false")&&visible.equals("true"))
				{
					this.myjzgl = name;
				}
				else if(name.equals(Func_TreeXML.MYXXGL)&&dir.equals("false")&&visible.equals("true"))
				{
					this.myxxgl = name;
				}
			}
			
			doc = db.parse(this.xml_path_kfxxgl_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String visible = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_VISIBLE);
				if(name.equals(Func_TreeXML.CJRDJ)&&dir.equals("false")&&visible.equals("true"))
				{
					this.cjrdj = name;
				}
				else if(name.equals(Func_TreeXML.ZTKFXL)&&dir.equals("true")&&visible.equals("true"))
				{
					this.ztkfxl = name;
				}
				else if(name.equals(Func_TreeXML.JSBGL)&&dir.equals("true")&&visible.equals("true"))
				{
					this.jsbgl = name;
				}
			}
			
			doc = db.parse(this.xml_path_ztkfxl_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String visible = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_VISIBLE);
				if(name.equals(Func_TreeXML.ZCXLDJ)&&dir.equals("false")&&visible.equals("true"))
				{
					this.zcxldj = name;
				}
				else if(name.equals(Func_TreeXML.ZCXLPG)&&dir.equals("false")&&visible.equals("true"))
				{
					this.zcxlpg = name;
				}
				else if(name.equals(Func_TreeXML.ZCXLJH)&&dir.equals("false")&&visible.equals("true"))
				{
					this.zcxljh = name;
				}
				else if(name.equals(Func_TreeXML.ZCXLJL)&&dir.equals("false")&&visible.equals("true"))
				{
					this.zcxljl = name;
				}
			}
			
			doc = db.parse(this.xml_path_jsbgl_index);
			nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			for(int i=0;i<nl.getLength();i++)
			{
				Element e = (Element)nl.item(i);
				String name = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_NAME);
				String dir = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_DIR);
				String visible = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_VISIBLE);
				if(name.equals(Func_TreeXML.JSBRDJB)&&dir.equals("false")&&visible.equals("true"))
				{
					this.jsbrdj = name;
				}
				else if(name.equals(Func_TreeXML.JSBFSJL)&&dir.equals("false")&&visible.equals("true"))
				{
					this.jsbfsjl = name;
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	
	/**
	 * 生成树的老算法
	 * @return
	 */
	public String getTreeXML1()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("<"+Func_TreeXML.TREE_ROOT+">\n");
		sb.append("<node label='"+Func_TreeXML.JKDA_LABEL+"' datapath='"+getRelativeURL(this.grda_url)+"' indexpath='"+getRelativeURL(this.xml_path_jkda_index)+"'>");
		if(this.grjbxx!=null)
		{
			sb.append("<node label='"+this.grjbxx+"' icon='jbxx' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_grjbxx)+"' indexpath='"+getRelativeURL(this.xml_path_grjbxx_index)+"' />\n");
		}
		if(this.tjxx!=null)
		{
			sb.append("<node label='"+this.tjxx+"' icon='jbxx' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_tjxx)+"' indexpath='"+getRelativeURL(this.xml_path_tjxx_index)+"' />\n");
		}
		if(this.fnbj!=null)
		{
			sb.append("<node label='"+this.fnbj+"' datapath='"+getRelativeURL(this.xml_path_fnbj)+"' indexpath='"+getRelativeURL(this.xml_path_fnbj_index)+"'>\n");

			if(this.fnjcjl!=null)
			{
				sb.append("<node label='"+this.fnjcjl+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_fnjcjl)+"' indexpath='"+getRelativeURL(this.xml_path_fnjcjl_index)+"' />\n");
			}
			if(this.fnbczdj!=null)
			{
				sb.append("<node label='"+this.fnbczdj+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_fnbczdj)+"' indexpath='"+getRelativeURL(this.xml_path_fnbczdj_index)+"' />\n");
			}
			if(this.jhsypc!=null)
			{
				sb.append("<node label='"+this.jhsypc+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_jhsypc)+"' indexpath='"+getRelativeURL(this.xml_path_jhsypc_index)+"' />\n");
			}
			if(this.jhsydj!=null)
			{
				sb.append("<node label='"+this.jhsydj+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_jhsydj)+"' indexpath='"+getRelativeURL(this.xml_path_jhsydj_index)+"' />\n");
			}
			if(this.ycfjkgl!=null)
			{
				sb.append("<node label='"+this.ycfjkgl+"' datapath='"+getRelativeURL(this.xml_path_ycfjkgl)+"' indexpath='"+getRelativeURL(this.xml_path_ycfjkgl_index)+"'>\n");
				if(this.dyccqsffwjlb!=null)
				{
					sb.append("<node label='"+this.dyccqsffwjlb+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_dyccqsffwjlb)+"' indexpath='"+getRelativeURL(this.xml_path_dyccqsffwjlb_index)+"' />\n");
				}
				if(this.dedwccqsffwjlb!=null)
				{
					sb.append("<node label='"+this.dedwccqsffwjlb+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_dedwccqsffwjlb)+"' indexpath='"+getRelativeURL(this.xml_path_dedwccqsffwjlb_index)+"' />\n");
				}
				if(this.chfsjlb!=null)
				{
					sb.append("<node label='"+this.chfsjlb+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_chfsjlb)+"' indexpath='"+getRelativeURL(this.xml_path_chfsjlb_index)+"' />\n");
				}
				if(this.chssetjkjcjlb!=null)
				{
					sb.append("<node label='"+this.chssetjkjcjlb+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_chssetjkjcjlb)+"' indexpath='"+getRelativeURL(this.xml_path_chssetjkjcjlb_index)+"' />\n");
				}
				sb.append("</node>\n");
			}
			sb.append("</node>\n");
		}
		if(this.etbj!=null)
		{
			sb.append("<node label='"+this.etbj+"' datapath='"+getRelativeURL(this.xml_path_etbj)+"' indexpath='"+getRelativeURL(this.xml_path_etbj_index)+"'>\n");
			
			if(this.xsejtfsjlb!=null)
			{
				sb.append("<node label='"+this.xsejtfsjlb+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_xsejtfsjlb)+"' indexpath='"+getRelativeURL(this.xml_path_xsejtfsjlb_index)+"' />\n");
			}
			if(this.ysynetsffwjlb!=null)
			{
				sb.append("<node label='"+this.ysynetsffwjlb+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_ysynetsffwjlb)+"' indexpath='"+getRelativeURL(this.xml_path_ysynetsffwjlb_index)+"' />\n");
			}
			if(this.ydesetsffwjlb!=null)
			{
				sb.append("<node label='"+this.ydesetsffwjlb+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_ydesetsffwjlb)+"' indexpath='"+getRelativeURL(this.xml_path_ydesetsffwjlb_index)+"' />\n");
			}
			if(this.ssetsffwjlb!=null)
			{
				sb.append("<node label='"+this.ssetsffwjlb+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_ssetsffwjlb)+"' indexpath='"+getRelativeURL(this.xml_path_ssetsffwjlb_index)+"' />\n");
			}
			if(this.etszfyjct!=null)
			{
				sb.append("<node label='"+this.etszfyjct+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_etszfyjct)+"' indexpath='"+getRelativeURL(this.xml_path_etszfyjct_index)+"' />\n");
			}
			sb.append("</node>\n");
		}
		if(this.mxbgl!=null)
		{
			sb.append("<node label='"+this.mxbgl+"' datapath='"+getRelativeURL(this.xml_path_mxbgl)+"' indexpath='"+getRelativeURL(this.xml_path_mxbgl_index)+"'>\n");
			if(this.tnb!=null)
			{
				sb.append("<node label='"+this.tnb+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_tnb)+"' indexpath='"+getRelativeURL(this.xml_path_tnb_index)+"' />\n");
			}
			if(this.gxy!=null)
			{
				sb.append("<node label='"+this.gxy+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_gxy)+"' indexpath='"+getRelativeURL(this.xml_path_gxy_index)+"' />\n");
			}
			if(this.gxb!=null)
			{
				sb.append("<node label='"+this.gxb+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_gxb)+"' indexpath='"+getRelativeURL(this.xml_path_gxb_index)+"' />\n");
			}
			if(this.nzz!=null)
			{
				sb.append("<node label='"+this.nzz+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_nzz)+"' indexpath='"+getRelativeURL(this.xml_path_nzz_index)+"' />\n");
			}
			if(this.zl!=null)
			{
				sb.append("<node label='"+this.zl+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_zl)+"' indexpath='"+getRelativeURL(this.xml_path_zl_index)+"' />\n");
			}
			sb.append("</node>\n");
		}
		if(this.jhmy!=null)
		{
			sb.append("<node label='"+this.jhmy+"' datapath='"+getRelativeURL(this.xml_path_jhmy)+"' indexpath='"+getRelativeURL(this.xml_path_jhmy_index)+"'>\n");
			if(this.myjzgl!=null)
			{
				sb.append("<node label='"+this.myjzgl+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_myjzgl)+"' indexpath='"+getRelativeURL(this.xml_path_myjzgl_index)+"' />\n");
			}	
			if(this.myxxgl!=null)
			{
				sb.append("<node label='"+this.myxxgl+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_myxxgl)+"' indexpath='"+getRelativeURL(this.xml_path_myxxgl_index)+"' />\n");
			}	
			sb.append("</node>\n");
		}
		if(this.kfxxgl!=null)
		{
			sb.append("<node label='"+this.kfxxgl+"' datapath='"+getRelativeURL(this.xml_path_kfxxgl)+"' indexpath='"+getRelativeURL(this.xml_path_kfxxgl_index)+"'>\n");

			if(this.cjrdj!=null)
			{
				sb.append("<node label='"+this.cjrdj+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_cjrdj)+"' indexpath='"+getRelativeURL(this.xml_path_cjrdj_index)+"' />\n");
			}
			if(this.ztkfxl!=null)
			{
				sb.append("<node label='"+this.ztkfxl+"' datapath='"+getRelativeURL(this.xml_path_ztkfxl)+"' indexpath='"+getRelativeURL(this.xml_path_ztkfxl_index)+"'>\n");
				if(this.zcxldj!=null)
				{
					sb.append("<node label='"+this.zcxldj+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_zcxldj)+"' indexpath='"+getRelativeURL(this.xml_path_zcxldj_index)+"' />\n");
				}
				if(this.zcxlpg!=null)
				{
					sb.append("<node label='"+this.zcxlpg+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_zcxlpg)+"' indexpath='"+getRelativeURL(this.xml_path_zcxlpg_index)+"' />\n");
				}
				if(this.zcxljh!=null)
				{
					sb.append("<node label='"+this.zcxljh+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_zcxljh)+"' indexpath='"+getRelativeURL(this.xml_path_zcxljh_index)+"' />\n");
				}
				if(this.zcxljl!=null)
				{
					sb.append("<node label='"+this.zcxljl+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_zcxljl)+"' indexpath='"+getRelativeURL(this.xml_path_zcxljl_index)+"' />\n");
				}
				sb.append("</node>\n");
			}
			if(this.jsbgl!=null)
			{
				sb.append("<node label='"+this.jsbgl+"' datapath='"+getRelativeURL(this.xml_path_jsbgl)+"' indexpath='"+getRelativeURL(this.xml_path_jsbgl_index)+"'>\n");
				if(this.jsbrdj!=null)
				{
					sb.append("<node label='"+this.jsbrdj+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_jsbrdj)+"' indexpath='"+getRelativeURL(this.xml_path_jsbrdj_index)+"' />\n");
				}
				if(this.jsbfsjl!=null)
				{
					sb.append("<node label='"+this.jsbfsjl+"' template='"+Func_TreeXML.TEMPLATE_FILE_NAME+"' datapath='"+getRelativeURL(this.xml_path_jsbfsjl)+"' indexpath='"+getRelativeURL(this.xml_path_jsbfsjl_index)+"' />\n");
				}
				sb.append("</node>\n");
			}
			sb.append("</node>\n");
		}		
		sb.append("</node>");
		sb.append("</"+Func_TreeXML.TREE_ROOT+">\n");
		
		return sb.toString();
	}
	
	/**
	 * 获取各级index.xml路径的老算法
	 * @return
	 */
	public String getAllIndexPath1()
	{
		StringBuffer sb = new StringBuffer();		
		sb.append("<urls>");
		sb.append("<jkda>"+getRelativeURL(this.xml_path_jkda_index)+"</jkda>");
		sb.append("<grjbxx>"+getRelativeURL(this.xml_path_grjbxx_index)+"</grjbxx>");
		sb.append("<tjxx>"+getRelativeURL(this.xml_path_tjxx_index)+"</tjxx>");
		sb.append("<fnbj>"+getRelativeURL(this.xml_path_fnbj_index)+"</fnbj>");
		sb.append("<fnjcjl>"+getRelativeURL(this.xml_path_fnjcjl_index)+"</fnjcjl>");
		sb.append("<fnbczdj>"+getRelativeURL(this.xml_path_fnbczdj_index)+"</fnbczdj>");
		sb.append("<jhsypc>"+getRelativeURL(this.xml_path_jhsypc_index)+"</jhsypc>");
		sb.append("<jhsydj>"+getRelativeURL(this.xml_path_jhsydj_index)+"</jhsydj>");
		sb.append("<ycfjkgl>"+getRelativeURL(this.xml_path_ycfjkgl_index)+"</ycfjkgl>");
		sb.append("<dyccqsffwjlb>"+getRelativeURL(this.xml_path_dyccqsffwjlb_index)+"</dyccqsffwjlb>");      
		sb.append("<dedwccqsffwjlb>"+getRelativeURL(this.xml_path_dedwccqsffwjlb_index)+"</dedwccqsffwjlb>");
		sb.append("<chfsjlb>"+getRelativeURL(this.xml_path_chfsjlb_index)+"</chfsjlb>");
		sb.append("<chssetjkjcjlb>"+getRelativeURL(this.xml_path_chssetjkjcjlb_index)+"</chssetjkjcjlb>");
		sb.append("<etbj>"+getRelativeURL(this.xml_path_etbj_index)+"</etbj>");
		sb.append("<xsejtfsjlb>"+getRelativeURL(this.xml_path_xsejtfsjlb_index)+"</xsejtfsjlb>");
		sb.append("<ysynetsffwjlb>"+getRelativeURL(this.xml_path_ysynetsffwjlb_index)+"</ysynetsffwjlb>");
		sb.append("<ydesetsffwjlb>"+getRelativeURL(this.xml_path_ydesetsffwjlb_index)+"</ydesetsffwjlb>");
		sb.append("<ssetsffwjlb>"+getRelativeURL(this.xml_path_ssetsffwjlb_index)+"</ssetsffwjlb>");
		sb.append("<etszfyjct>"+getRelativeURL(this.xml_path_etszfyjct_index)+"</etszfyjct>");
		sb.append("<mxbgl>"+getRelativeURL(this.xml_path_mxbgl_index)+"</mxbgl>");
		sb.append("<gxy>"+getRelativeURL(this.xml_path_gxy_index)+"</gxy>");
		sb.append("<tnb>"+getRelativeURL(this.xml_path_tnb_index)+"</tnb>");
		sb.append("<gxb>"+getRelativeURL(this.xml_path_gxb_index)+"</gxb>");
		sb.append("<nzz>"+getRelativeURL(this.xml_path_nzz_index)+"</nzz>");
		sb.append("<zl>"+getRelativeURL(this.xml_path_zl_index)+"</zl>");
		sb.append("<jhmy>"+getRelativeURL(this.xml_path_jhmy_index)+"</jhmy>");
		sb.append("<myjzgl>"+getRelativeURL(this.xml_path_myjzgl_index)+"</myjzgl>");
		sb.append("<myxxgl>"+getRelativeURL(this.xml_path_myxxgl_index)+"</myxxgl>");
		sb.append("<kfxxgl>"+getRelativeURL(this.xml_path_kfxxgl_index)+"</kfxxgl>");
		sb.append("<cjrdj>"+getRelativeURL(this.xml_path_cjrdj_index)+"</cjrdj>");
		sb.append("<ztkfxl>"+getRelativeURL(this.xml_path_ztkfxl_index)+"</ztkfxl>");
		sb.append("<zcxldj>"+getRelativeURL(this.xml_path_zcxldj_index)+"</zcxldj>");
		sb.append("<zcxlpg>"+getRelativeURL(this.xml_path_zcxlpg_index)+"</zcxlpg>");
		sb.append("<zcxljh>"+getRelativeURL(this.xml_path_zcxljh_index)+"</zcxljh>");
		sb.append("<zcxljl>"+getRelativeURL(this.xml_path_zcxljl_index)+"</zcxljl>");
		sb.append("<jsbgl>"+getRelativeURL(this.xml_path_jsbgl_index)+"</jsbgl>");
		sb.append("<jsbrdj>"+getRelativeURL(this.xml_path_jsbrdj_index)+"</jsbrdj>");
		sb.append("<jsbfsjl>"+getRelativeURL(this.xml_path_jsbfsjl_index)+"</jsbfsjl>");	
		sb.append("</urls>");
		
		return sb.toString();
	}
	
	/**
	 * 判断新旧档案
	 * @return 返回true为老档案，返回false为新档案
	 */
	private boolean isOld()
	{
		try
		{
			Document doc = db.parse(grda_index_path);			
			NodeList nl = doc.getElementsByTagName(Func_TreeXML.TREE_NODE_NODE);
			Element e = (Element)nl.item(0);
			String folder = e.getAttribute(Func_TreeXML.TREE_ATTRIBUTE_FOLDERPATH);
			OutString.out("-------------folderpath is "+folder+"------------");
			if(folder!=null&&folder.equals(""))
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			OutString.out("------------判断新旧出异常--------------");
			ex.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 生成树
	 * @return
	 */
	public String getTreeXML()
	{
		if(isOld())
		{
			OutString.out("------------old--------------");
			initAllURL();
			initTree();
			return getTreeXML1();
		}
	
		OutString.out("------------new--------------");
		return getTreeXML2();
	}
	
	/**
	 * 获取所有index.xml的路径
	 * @return
	 */
	public String getAllIndexPath()
	{
		if(isOld())
		{
			initAllURL();
			return getAllIndexPath1();
		}
		
		return getAllIndexPath2();
	}
	
	/**
	 * 根据文件的绝对路径返回URL
	 * @param fullURL 绝对路径
	 * @return URL
	 */
	private String getRelativeURL(String fullURL)
	{
		String r = fullURL.substring(url.length());
		String newPath = Bean_BaseInfo.httpUrl + r;
		return newPath;
	}
}
