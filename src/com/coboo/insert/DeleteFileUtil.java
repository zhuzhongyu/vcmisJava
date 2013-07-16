package com.coboo.insert;

import java.io.File;      
import java.util.*;
    
/**    
* 删除指定文件或是目录
* 作者:
* @author rp19840604 RP 任鹏
*/     
public class DeleteFileUtil {            
   /**    
    * 删除文件，可以是单个文件或文件夹    
    * @param   fileName    待删除的文件名   
    * @author rp19840604 RP 任鹏
    * @return 文件删除成功返回true,否则返回false    
    */  
   public static boolean delete(String fileName){      
       File file = new File(fileName);      
       if(!file.exists()){      
    	   System.out.println("Delete File ：" + fileName + "not in!!!");   
           return false;      
       }else{      
           if(file.isFile())
               return deleteFile(fileName);      
           else
               return deleteDirectory(fileName); 
       }      
   }      
         
   /**    
    * 删除单个文件    
    * @param   fileName    被删除文件的文件名    
    * @author rp19840604 RP 任鹏
    * @return 单个文件删除成功返回true,否则返回false    
    */      
   public static boolean deleteFile(String fileName){      
       File file = new File(fileName);      
       if(file.isFile() && file.exists()){      
           file.delete();      
           System.out.println("Delete File: " + fileName + "is Succeed!!!");      
           return true;      
       }else{      
           System.out.println("Delete File: " + fileName + "is Failure!!!");   
           return false;      
       }      
   }      
         
   /**    
    * 删除目录（文件夹）以及目录下的文件    
    * @param   dir 被删除目录的文件路径    
    * @author rp19840604 RP 任鹏
    * @return  目录删除成功返回true,否则返回false    
    */     
   public static boolean deleteDirectory(String dir){         
       //如果dir不以文件分隔符结尾，自动添加文件分隔符  ָ��      
       if(!dir.endsWith(File.separator)){      
           dir = dir+File.separator.replace("\\", "/");      
       }      
       File dirFile = new File(dir);      
       //如果dir对应的文件不存在，或者不是一个目录，则退出  ��Ŀ¼�����˳�      
       if(!dirFile.exists() || !dirFile.isDirectory()){     
           System.out.println("Delete Directory: " + dir + " is noNentity!!!");    
           return false;      
       }      
       boolean flag = true;      
       //删除文件夹下的所有文件(包括子目录)  
       File[] files = dirFile.listFiles();      
       for(int i = 0; i < files.length; i++){
           if(files[i].isFile()){ //删除子文件          
               flag = deleteFile(files[i].getAbsolutePath().replace("\\", "/"));      
               if(!flag)     
                   break;   
           }else{       //删除子目录 
               flag = deleteDirectory(files[i].getAbsolutePath().replace("\\", "/"));      
               if(!flag)    
                   break;  
           }      
       }      
             
       if(!flag){      
           System.out.println("Delete Directory is noNentity!!!");    
           return false;      
       }      

       //删除当前目录 
       if(dirFile.delete()){      
           System.out.println("Delete Directory: " + dir + " is Succeed!!！");      
           return true;      
       }else{      
           System.out.println("Delete Directory: " + dir + " is noNentity!!!");  
           return false;      
       }      
   }   
   
   /**
    * 根据Jkda所在路径得到此目录下所有档案名称
    * @param JkdaPath Jkda所在路径
    * @return ArrayList
    * @author rp19840604 RP 任鹏
    */
   public static ArrayList getJkdaDirLength(String JkdaPath){         
	   ArrayList temp = new ArrayList();
	   if(!JkdaPath.endsWith(File.separator)){      
		   JkdaPath = JkdaPath+File.separator.replace("\\", "/");      
       }
	   File jkdafile = new File(JkdaPath);
	   //如果健康档案不是目录,或不存在时
	   if(!jkdafile.exists() || !jkdafile.isDirectory()){     
           System.out.println("Jkdafile Directory: " + jkdafile + " is noNentity!!!");    
           return temp;      
       }
	   //得到健康档案下的所在目录,不包括子目录
       File[] dir = jkdafile.listFiles();
       for(int i = 0; i < dir.length; i++){
    	   if(!dir[i].isFile()){//如果不是文件,是目录时
    		  // System.out.println(dir[i].getName());
    		   temp.add(dir[i].getName());
    	   }
       }
	   return temp;
   }    
}