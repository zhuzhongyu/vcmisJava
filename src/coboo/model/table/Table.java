/*     */ package coboo.model.table;
/*     */ 
/*     */ import coboo.impl.DocDriver.meta.BirthDateMeta;
/*     */ import coboo.impl.DocDriver.meta.DocCodeMeta;
/*     */ import coboo.impl.DocDriver.meta.Meta;
/*     */ import coboo.impl.DocDriver.meta.PersonIdMeta;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.DocumentException;
/*     */ import org.dom4j.DocumentHelper;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.OutputFormat;
/*     */ import org.dom4j.io.SAXReader;
/*     */ import org.dom4j.io.XMLWriter;
/*     */ 
/*     */ public abstract class Table
/*     */ {
/*     */   String Userid;
/*     */   String persionDir;
/*  28 */   DocCodeMeta dah = new DocCodeMeta();
/*  29 */   BirthDateMeta birthdate = new BirthDateMeta();
/*  30 */   PersonIdMeta personId = new PersonIdMeta();
/*     */ 
/*     */   public String getUserid() {
/*  33 */     return this.Userid;
/*     */   }
/*     */ 
/*     */   public void setUserid(String userid) {
/*  37 */     this.Userid = userid;
/*     */   }
/*     */ 
/*     */   public String getPersionDir() {
/*  41 */     return this.persionDir;
/*     */   }
/*     */ 
/*     */   public void setPersionDir(String persionDir) {
/*  45 */     this.persionDir = persionDir;
/*     */   }
/*     */ 
/*     */   public DocCodeMeta getDah() {
/*  49 */     return this.dah;
/*     */   }
/*     */ 
/*     */   public void setDah(String dah) {
/*  53 */     this.dah.setHValue(dah);
/*     */   }
/*     */ 
/*     */   public BirthDateMeta getBirthdate() {
/*  57 */     return this.birthdate;
/*     */   }
/*     */ 
/*     */   public void setBirthdate(BirthDateMeta birthdate) {
/*  61 */     this.birthdate = birthdate;
/*     */   }
/*     */ 
/*     */   public PersonIdMeta getPersonId() {
/*  65 */     return this.personId;
/*     */   }
/*     */ 
/*     */   public void setPersonId(String personId) {
/*  69 */     this.personId.setHValue(personId);
/*  70 */     String birthYear = personId.substring(6, 10);
/*  71 */     String birthMonth = personId.substring(10, 12);
/*  72 */     String birthDay = personId.substring(12, 14);
/*  73 */     this.birthdate.setHValue(birthYear + "-" + birthMonth + "-" + birthDay); } 
/*     */   public abstract String getRpath();
/*     */ 
/*     */   public abstract Meta[] getMetas();
/*     */ 
/*     */   public abstract String[] getKeys();
/*     */ 
/*     */   public abstract String[] getValues();
/*     */ 
/*     */   public abstract void setMetas(Meta[] paramArrayOfMeta);
/*     */ 
/*     */   public abstract void save();
/*     */ 
/*     */   protected void newDocDir(File path) { try { String text = "<root><info/><dir></dir></root>";
/*  92 */       Document document = DocumentHelper.parseText(text);
/*  93 */       if (!path.exists())
/*  94 */         path.mkdirs();
/*  95 */       String indexFilePath = path.getAbsolutePath() + "/index.xml";
/*  96 */       XMLWriter writer = new XMLWriter(new FileWriter(indexFilePath));
/*  97 */       writer.write(document);
/*  98 */       writer.close();
/*     */     } catch (DocumentException e)
/*     */     {
/* 101 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 103 */       e.printStackTrace();
/*     */     } }
/*     */ 
/*     */   public void saveFile(Table t)
/*     */   {
/*     */     try
/*     */     {
/* 110 */       Date time = new Date();
/* 111 */       String date = new SimpleDateFormat("yyyyMMddHHmmss").format(time);
/* 112 */       String Idate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
/* 113 */       String sDir = t.getPersionDir() + "/" + t.getRpath();
/* 114 */       File dir = new File(sDir);
/* 115 */       if (!dir.exists()) {
/* 116 */         newDocDir(dir);
/*     */       }
/* 118 */       String simpleFileName = getClass().getSimpleName() + "_" + date + ".xml";
/* 119 */       String filename = sDir + "/" + simpleFileName;
/* 120 */       StringBuffer sb = new StringBuffer();
/* 121 */       sb.append("<" + t.getClass().getSimpleName() + ">");
/*     */ 
/* 123 */       Meta[] metas = t.getMetas();
/* 124 */       for (int i = 0; i < metas.length; i++)
/*     */       {
/* 126 */         sb.append("<" + metas[i].getClass().getSimpleName() + ">");
/* 127 */         String[] sValues = metas[i].getSValues();
/* 128 */         for (int j = 0; j < sValues.length; j++) {
/* 129 */           if (sValues[j] == null)
/* 130 */             sValues[j] = "";
/* 131 */           sb.append("<s" + j + ">" + sValues[j] + "</s" + j + ">");
/*     */         }
/* 133 */         sb.append("</" + metas[i].getClass().getSimpleName() + ">");
/*     */       }
/*     */ 
/* 136 */       sb.append("</" + t.getClass().getSimpleName() + ">");
/*     */ 
/* 139 */       Document d = DocumentHelper.parseText(new String(sb));
/* 140 */       OutputFormat format = OutputFormat.createPrettyPrint();
/* 141 */       format.setEncoding("utf-8");
/* 142 */       XMLWriter writer = new XMLWriter(new FileWriter(filename), format);
/* 143 */       writer.write(d);
/* 144 */       writer.close();
/* 145 */       String indexXmlFileName = sDir + "/index.xml";
/* 146 */       addNodeToIndexXmlFile(indexXmlFileName, simpleFileName, Idate, t.getUserid(), getClass().getSimpleName());
/*     */     } catch (DocumentException e) {
/* 148 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 150 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void addNodeToIndexXmlFile(String indexXmlFileName, String simpleFileName, String idate, String userid, String classname)
/*     */   {
/*     */     try
/*     */     {
/* 161 */       SAXReader reader = new SAXReader();
/*     */ 
/* 163 */       Document document = reader.read(new File(indexXmlFileName));
/* 164 */       Element root = document.getRootElement();
/* 165 */       Element dirElm = root.element("dir");
/* 166 */       Element nodeElm = dirElm.addElement("node");
/* 167 */       nodeElm.addAttribute("createTime", idate);
/* 168 */       nodeElm.addAttribute("createUser", userid);
/* 169 */       nodeElm.addAttribute("folder", simpleFileName);
/* 170 */       nodeElm.addAttribute("name", classname);
/* 171 */       XMLWriter writer = new XMLWriter(new FileWriter(indexXmlFileName));
/* 172 */       writer.write(document);
/* 173 */       writer.close();
/*     */     }
/*     */     catch (DocumentException e) {
/* 176 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e) {
/* 179 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\vcmisJava2012-1-2.jar
 * Qualified Name:     coboo.model.table.Table
 * JD-Core Version:    0.6.0
 */