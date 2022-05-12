package class03;

import java.util.HashMap;
import java.util.TreeMap;

public class Code05_HashMapTreeMap {

	public static class Node {
		public int value;

		public Node(int v) {
			value = v;
		}
	}

	// 可以理解为(K V)表  hash 表增删改查都是O(1)时间
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("zuochengyun", "我是左程云");
		System.out.println(map.containsKey("zuochengyun"));
		System.out.println(map.containsKey("zuo"));
		System.out.println(map.get("zuochengyun"));

		map.put("zuochengyun", "他是左程云");
		System.out.println(map.get("zuochengyun"));

//		map.remove("zuochengyun");
//		System.out.println(map.containsKey("zuochengyun"));
//		System.out.println(map.get("zuochengyun"));

		String test1 = "zuochengyun";
		String test2 = "zuochengyun";
		System.out.println(map.containsKey(test1));
		System.out.println(map.containsKey(test2));

		HashMap<Integer, String> map2 = new HashMap<>();
		map2.put(1234567, "我是1234567");

		Integer a = 1234567;
		Integer b = 1234567;

		System.out.println("------------------------");
		System.out.println(a == b);	// false  ==比较的是内存地址
		System.out.println(map2.containsKey(a));   // true
		System.out.println(map2.containsKey(b));   // true

		Node node1 = new Node(1);
		Node node2 = new Node(1);
		HashMap<Node, String> map3 = new HashMap<>();
		map3.put(node1, "我进来了！");
		System.out.println(map3.containsKey(node1));  // true
		System.out.println(map3.containsKey(node2));  // false

		System.out.println("===================");

		// 时间复杂度是logN
		TreeMap<Integer, String> treeMap1 = new TreeMap<>();

		// 0 2 3 5 7 9
		treeMap1.put(3, "我是3");
		treeMap1.put(0, "我是3");
		treeMap1.put(7, "我是3");
		treeMap1.put(2, "我是3");
		treeMap1.put(5, "我是3");
		treeMap1.put(9, "我是3");

		System.out.println(treeMap1.containsKey(7));   // true
		System.out.println(treeMap1.containsKey(6));   // false
		System.out.println(treeMap1.get(3));   // 我是3

		treeMap1.put(3, "他是3");
		System.out.println(treeMap1.get(3));  // 他是3

		treeMap1.remove(3);
		System.out.println(treeMap1.get(3));  // null

		System.out.println("firstKey:"+treeMap1.firstKey());   // 0
		System.out.println("lastKey:"+treeMap1.lastKey());     // 9

		//	如果key存在，则floorKey\ceilingKey 就是自身
		//	如果key不存在，则floorKey\ceilingKey 就是字面意思
		// <=5(小于等于5) 离5最近的key告诉我
		System.out.println(treeMap1.floorKey(5));    // 5
		// <=6 离6最近的key告诉我
		System.out.println(treeMap1.floorKey(6));   //  5
		// >=5 离5最近的key告诉我
		System.out.println(treeMap1.ceilingKey(5));  // 5
		// >=6 离6最近的key告诉我
		System.out.println(treeMap1.ceilingKey(6));  // 7

//	    TreeMap不可以放node类型  key一定是可以比较的
//		Node node3 = new Node(3);
//		Node node4 = new Node(4);
//		TreeMap<Node, String> treeMap2 = new TreeMap<>();
//		treeMap2.put(node3, "我是node3");
//		treeMap2.put(node4, "我是node4");

	}

}
