import java.util.*;

public class Demo1 {
//    格式化数组样式eg:[{k1=v1,k2=v2},{a1=v3,a2=v4}]，
//                     或者[{k1=v1,k2=v2},{a1=v3,a2=v4,a3=v5},{m1=n1}]
//    可以看出来每一个数组的值是<Map<String,String>类型，每一个map里面可以放任意个键值对
//    序列化后数组样式eg:k1=v1;k2=v2\na1=v3;a2=v4，
//                      或者k1=v1;k2=v2\na1=v3;a2=v4,a3=v5\nm1=n1
    public  String store(List<Map<String,String>> list){
        String str="";
        int size = list.size();
        int i=0;
        for(Map<String,String> map: list){
            i++;
            Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
            while (entries.hasNext()){
                Map.Entry<String, String> entry = entries.next();
                str+=(entry.getKey()+"="+entry.getValue()+";");
            }
            str = str.substring(0, str.length()-1);
            if(i<size){
                str = str+"\\n";
            }
        }
        return str;
    }

    public  List<Map<String,String>> load(String str){
        String[] strs1 = str.split("\n");
        List<Map<String,String>> list = new ArrayList<>();
        for (String string2 : strs1) {
            String[] strs2 = string2.split(";");
            Map<String,String> map= new HashMap<>();
            for (String string3 : strs2) {
                String[] strs3 = string3.split("=");
                map.put(strs3[0],strs3[1]);
            }
            list.add(map);
        }
        return list;
    }
    public static void main(String[] args){
        System.out.println("start");
        Demo1 demo1 = new Demo1();
        demo1.testStore();
        demo1.testLoad();
    }

    public  void testStore(){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("k1", "v1");
        map1.put("k2", "v2");
        Map<String,String> map2 = new HashMap<>();
        map2.put("a1", "v3");
        map2.put("a2", "v4");
        map2.put("a3", "v5");
        list.add(map1);
        list.add(map2);
        String result = store(list);
        System.out.println("序列化结果是"+result);
    }

    public   void testLoad(){
        String str = "k1=v1;k2=v2\na1=v3;a2=v4;a3=v5\nk1=v1;k2=v2\na1=v3;a2=v4;a3=v5";
        List<Map<String,String>> l = load(str);
        System.out.println("加载结果是:"+l.toString());
    }
}
