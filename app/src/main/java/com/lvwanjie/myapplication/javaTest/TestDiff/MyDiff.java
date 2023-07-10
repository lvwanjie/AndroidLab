

import java.io.File;

public class MyDiff {

    public static void main(String str[]){
        if(str.length < 2){
            System.out.println("参数至少两个");
            return;
        }
        String path1 = str[0];
        String path2 = str[1];
        comm(path1,path2);

    }


    public static void comm(String dirPath1,String dirPath2){
        File dir1 = new File(dirPath1);
        File dir2 = new File(dirPath2);
        if(!dir1.exists()){
            System.out.println(dirPath1+"不存在");
            return;
        }
        if(!dir2.exists()){
            System.out.println(dirPath1+"不存在");
            return;
        }
        File files1[] = dir1.listFiles();
        File files2[] = dir2.listFiles();
        for(int i=0;i<files1.length;i++){
            File file1 = files1[i];
            for (int j=0;j<files2.length;j++){
                File file2 = files2[j];
                if(file1.getName().equals(file2.getName())){
                    System.out.println("SAME FILE:"+file1.getAbsolutePath());
                    break;
                }
            }
        }


    }
}
